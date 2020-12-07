package com.joo.dao;

import domain.User;
import java.util.List;


/**
 * 用户的持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有操作
     * @return 所有user对象
     */
    List<User> findAll();

    /**
     * 根据id查询一条信息
     * @param userId
     * @return 一个user对象
     */
    User findById(Integer userId);

    /**
     * （一对多）查询用户 同时获取用户下所有账户信息
     * @return
     */
    List<User> findUserAndAccount();

}
