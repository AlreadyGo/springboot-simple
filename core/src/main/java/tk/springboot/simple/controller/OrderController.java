
package tk.springboot.simple.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.comm.model.SheetBean;
import tk.comm.model.UploadFile;
import tk.comm.utils.DownUploadUtil;
import tk.comm.utils.ExcelUtil;
import tk.springboot.simple.model.OrderInfo;
import tk.springboot.simple.model.RespInfo;
import tk.springboot.simple.model.SendInfo;
import tk.springboot.simple.model.UploadResult;
import tk.springboot.simple.model.enums.UploadType;
import tk.springboot.simple.service.OrderService;
import tk.springboot.simple.service.SendInfoService;
import tk.springboot.simple.service.UploadResultService;
import tk.springboot.simple.util.Consts;
import tk.springboot.simple.util.UploadExcelRules;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static tk.springboot.simple.util.Consts.STATUS_FAILURE;
import static tk.springboot.simple.util.Consts.STATUS_SUCCESS;

@RestController
@RequestMapping("/orderInfo")
public class OrderController extends BaseController{

    @Autowired
    private OrderService orderService;

    @Autowired
    private SendInfoService sendInfoService;

    @Autowired
    private UploadResultService uploadResultService;

    @RequestMapping("/all")
    public List<OrderInfo> getAll(OrderInfo orderInfo) {

        return orderService.getAll(orderInfo);

    }

    @RequestMapping(value = "/view/{id}")
    public RespInfo view(@PathVariable Integer id) {
        OrderInfo orderInfo = orderService.getById(id);
        return new RespInfo(Consts.SUCCESS_CODE,orderInfo);
    }

    @RequestMapping(value = "/delete/{id}")
    public RespInfo delete(@PathVariable Integer id){
        orderService.deleteById(id);
        return new RespInfo(Consts.SUCCESS_CODE,null,"删除成功");
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public RespInfo save(@RequestBody OrderInfo orderInfo) {
        String msg = orderInfo.getId() == null ? "添加成功" : "修改成功";
        orderService.save(orderInfo);
        return new RespInfo(Consts.SUCCESS_CODE,orderInfo,msg);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public RespInfo upload(HttpServletRequest request) throws IOException {
        List<UploadFile> files= DownUploadUtil.upload(request);
        RespInfo respInfo=new RespInfo(Consts.SUCCESS_CODE,null,"上传成功");
        boolean isPartFailed=false;
        JSONArray jsonArray=new JSONArray();
        for(UploadFile file:files){
                String originalName=file.getOriginalFilename();
                List<SheetBean> sheetBeans= ExcelUtil.readExcel(file.getInputStream(),originalName.substring(originalName.lastIndexOf(".")+1));
                List<OrderInfo> orders=UploadExcelRules.parseOrders(sheetBeans);
                if(orders.size()>0){
                    for(OrderInfo orderInfo:orders){
                        String status;
                        String code=orderInfo.getCustomerCode(),name=orderInfo.getSender();
                        try{
                            if(sendInfoService.get(new SendInfo(code,name))!=null){
                                orderService.save(orderInfo);
                                status=STATUS_SUCCESS;
                            }else{
                                throw new Exception(String.format("客户信息中不存在该客户编号 %s 和客户名称 %s ",code,name));
                            }

                        } catch (Exception ex){
                            if(!isPartFailed){
                                isPartFailed=true;
                            }
                            ex.printStackTrace();
                            status=STATUS_FAILURE;
                        }
                        saveUploadResult(jsonArray,orderInfo,status);
                    }
                    if(isPartFailed){
                        respInfo.setMessage("部分上传失败");
                        respInfo.setStatus(Consts.ERROR_CODE);
                    }
                }else{
                    respInfo.setStatus(Consts.ERROR_CODE);
                    respInfo.setMessage("上传失败");
                }

        }
        if(jsonArray.size()>0){
            uploadResultService.save(new UploadResult(new Date(),jsonArray.toJSONString(),UploadType.ORDER));
        }
        return respInfo;
    }

    public void saveUploadResult(JSONArray jsonArray, OrderInfo orderInfo, String result){
        JSONObject jsonObject= (JSONObject) JSON.toJSON(orderInfo);
        jsonObject.put("status",result);
        jsonArray.add(jsonObject);
    }
}
