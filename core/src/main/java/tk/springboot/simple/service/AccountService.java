package tk.springboot.simple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.springboot.simple.exceptions.BizException;
import tk.springboot.simple.mapper.AccountMapper;
import tk.springboot.simple.model.Account;
import tk.springboot.simple.model.enums.AccountStatus;

import java.util.Date;
import java.util.List;

/**
 * @author zhou
 * @Description:
 * @date 2016/12/26 15:05
 */
@Service
public class AccountService extends BaseService {
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private OrderService orderService;

    public List<Account> getAll(Account account) throws Exception {
        String sort = account.getSort(), order = account.getOrder(), orderNum = account.getOrderNum(), orderNumCondition = "";
        Integer dateRange = account.getDateRange();
        if (!StringUtils.isEmpty(orderNum)) {
            if (orderService.getOrderInfoByNum(orderNum) == null) throw new Exception("该订单不存在");
            orderNumCondition = String.format("order_num='%s'", orderNum);
        }

        return accountMapper.selectByExample(createDateRangeExample(Account.class, order, sort, dateRange, orderNumCondition));
    }

    public Account getById(Integer id) {
        return accountMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        accountMapper.deleteByPrimaryKey(id);
    }

    public void save(Account account) {
        Date date = new Date();
        Integer id = account.getId();
        if (id != null) {
            account.setUpdateDate(date);
            accountMapper.updateByPrimaryKey(account);
        } else {
            account.setCreateDate(date);
            account.setUpdateDate(date);
            if (StringUtils.isEmpty(account.getAccountStatus()))
                account.setAccountStatus(AccountStatus.可修改);
            accountMapper.insert(account);
        }
    }

    public void rejectAccountStatus(Account account) throws BizException {
        updateStatus(AccountStatus.不可修改, account, "不可重复拒绝");
    }

    private void updateStatus(AccountStatus exist, Account account, String message) throws BizException {
        Account existed = accountMapper.selectByPrimaryKey(account);
        if (existed != null && existed.getAccountStatus().equals(exist)) {
            accountMapper.updateByPrimaryKeySelective(account);
        } else {
            throw new BizException(message);
        }
    }
}
