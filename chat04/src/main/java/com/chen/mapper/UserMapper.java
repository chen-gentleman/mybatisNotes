package com.chen.mapper;

import com.chen.bean.UserModel;

/**
 * @author @Chenxc
 * @date 2022年05月06日 22:54
 */
public interface UserMapper {
    /**
     * 插入用户信息，返回影响行数
     *
     * @param model
     * @return
     */
    int insertUser(UserModel model);
    /**
     * 更新用户信息，返回影响行数
     *
     * @param model
     * @return
     */
    long updateUser(UserModel model);
    /**
     * 根据用户id删除用户信息，返回删除是否成功
     *
     * @param userId
     * @return
     */
    boolean deleteUser(Long userId);


}
