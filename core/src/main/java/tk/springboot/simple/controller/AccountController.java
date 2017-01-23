package tk.springboot.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.springboot.simple.exceptions.BizException;
import tk.springboot.simple.model.Account;
import tk.springboot.simple.model.RespInfo;
import tk.springboot.simple.service.AccountService;
import tk.springboot.simple.util.Consts;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController extends BaseController{

    @Autowired
    private AccountService accountService;

    @RequestMapping("/all")
    public RespInfo getAll(Account account) throws Exception {
        return new RespInfo(Consts.SUCCESS_CODE,accountService.getAll(account));
    }

    @RequestMapping(value = "/view/{id}")
    public RespInfo view(@PathVariable Integer id) {
        Account account = accountService.getById(id);
        return new RespInfo(Consts.SUCCESS_CODE,account);
    }

    @RequestMapping(value = "/delete/{id}")
    public RespInfo delete(@PathVariable Integer id) {
        accountService.deleteById(id);
        return new RespInfo(Consts.SUCCESS_CODE,null,"删除成功");
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public RespInfo save(@RequestBody Account account) {
        String msg = account.getId() == null ? "新增成功!" : "修改成功!";
        accountService.save(account);
        return new RespInfo(Consts.SUCCESS_CODE,account,msg);
    }

    @RequestMapping(value = "/rejectAccountStatus", method = RequestMethod.POST)
    public RespInfo rejectAccountStatus(@RequestBody Account account) throws BizException {
        accountService.rejectAccountStatus(account);
        return new RespInfo(Consts.SUCCESS_CODE,account,"拒绝成功");
    }


}
