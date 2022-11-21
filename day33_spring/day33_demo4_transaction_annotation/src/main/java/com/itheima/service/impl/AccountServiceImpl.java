package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional // 打在类上，即表示类中的所有方法都用上事务的增强。
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    /**
     * 转账
     *
     * @param from
     * @param to
     * @param money
     */

    @Override
    public void transfer(String from, String to, int money) {

        //1. 扣钱
        accountDao.kouqian(from , money);

        int a = 1 / 0 ;

        //2. 加钱
        accountDao.jiaqian(to , money);
    }
}
