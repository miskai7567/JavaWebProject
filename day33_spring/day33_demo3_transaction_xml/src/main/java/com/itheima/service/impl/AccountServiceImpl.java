package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
