package com.chen.mapper;

import com.chen.bean.UserModel;

import java.util.List;

/**
 * @Author @Chenxc
 * @Date 2022/5/7 14:32
 */
public interface UserMapper {
 UserModel getById1(Integer id);

 List<UserModel> getList1(UserModel userModel);
 List<UserModel> getList2(UserModel userModel);

 Integer update1(UserModel userModel);
}
