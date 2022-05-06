package com.chen.mapper;

import com.chen.UserFindDto;
import com.chen.UserModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;

import java.util.Collection;
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

    /**
     * 查询用户id列表
     *
     * @param idCollection
     * @return
     */
    List<UserModel> getListByIdCollection(Collection<Long> idCollection);

    /**
     * 查询用户id列表
     *
     * @param idArray
     * @return
     */
    List<UserModel> getListByIdArray(Long[] idArray);


    /**
     * 我们遍历 t_user 表的所有记录，第2条遍历结束之后，停止遍历，
     * @author @Chenxc
     * @date 2022/5/6 22:40No such property: code for class: Script1
     */
    void getList(ResultHandler<UserMapper> resultHandler);

}
