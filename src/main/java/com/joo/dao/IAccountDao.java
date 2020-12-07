package com.joo.dao;

import domain.Account;
import domain.User;

import java.util.List;

public interface IAccountDao {

    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有账户 和所属用户名称及地址(一对一)
     * @return
     */
    List<Account> findAccountAndUser();


}
