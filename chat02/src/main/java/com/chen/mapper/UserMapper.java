package com.chen.mapper;

import com.chen.UserFindDto;
import com.chen.UserModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author @Chenxc
 * @Date 2022/5/6 9:18
 */
public interface UserMapper {
    int insertUser(UserModel model);
    int updateUser(UserModel model);
    int deleteUser(Long userId);
    List<UserModel> getUserList();



    /**
     * 通过name查询
     *
     * @param name
     * @return
     */
    UserModel getByName(String name);


    /**
     * 通过map查询
     * @param map
     * @return
     */

    List<UserModel> getByMap(Map<String,Object> map);


    /**
     * 通过UserFindDto进行查询
     * @param userFindDto
     * @return
     */
    List<UserModel> getListByUserFindDto(UserFindDto userFindDto);


    /**
     * 通过id或者name查询
     *
     * @param id
     * @param name
     * @return
     */
    UserModel getByIdOrName(@Param("userId") Long id, @Param("userName") String name);
}
