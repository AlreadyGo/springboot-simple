/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * SendInfo is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this sendInfo notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package tk.springboot.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.comm.model.SheetBean;
import tk.comm.model.UploadFile;
import tk.comm.utils.DownUploadUtil;
import tk.comm.utils.ExcelUtil;
import tk.springboot.simple.model.SendInfo;
import tk.springboot.simple.model.RespInfo;
import tk.springboot.simple.service.SendInfoService;
import tk.springboot.simple.util.Consts;
import tk.springboot.simple.util.UploadExcelRules;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/sendInfo")
public class SendInfoController {

    @Autowired
    private SendInfoService sendInfoService;

    @RequestMapping("/all")
    public List<SendInfo> getAll(SendInfo sendInfo) {
        return sendInfoService.getAll(sendInfo);
    }

    @RequestMapping(value = "/view/{id}")
    public RespInfo view(@PathVariable Integer id) {
        SendInfo sendInfo = sendInfoService.getById(id);
        return new RespInfo(Consts.SUCCESS_CODE,sendInfo);
    }

    @RequestMapping(value = "/delete/{id}")
    public RespInfo delete(@PathVariable Integer id) {
        sendInfoService.deleteById(id);
        return new RespInfo(Consts.SUCCESS_CODE,null,"删除成功");
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public RespInfo save(@RequestBody SendInfo sendInfo) {
        String msg = sendInfo.getId() == null ? "新增成功!" : "修改成功!";
        sendInfoService.save(sendInfo);
        return new RespInfo(Consts.SUCCESS_CODE,sendInfo,msg);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public RespInfo upload(HttpServletRequest request) {
        List<UploadFile> files= DownUploadUtil.upload(request);
        RespInfo respInfo=new RespInfo(Consts.SUCCESS_CODE,null,"上传成功");
        for(UploadFile file:files){
            try {
                String originalName=file.getOriginalFilename();
                List<SheetBean> sheetBeans= ExcelUtil.readExcel(file.getInputStream(),originalName.substring(originalName.lastIndexOf(".")+1));
                List<SendInfo> sendInfos=UploadExcelRules.parseSendInfos(sheetBeans);
                if(sendInfos.size()>0){
                    for(SendInfo sendInfo:sendInfos){
                        try{
                            sendInfoService.save(sendInfo);
                        } catch (Exception ex){

                        }
                    }
                }else{
                    respInfo.setStatus(Consts.ERROR_CODE);
                    respInfo.setMessage("上传失败");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return respInfo;
    }
}
