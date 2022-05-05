package com.javacode2018.mybatis.chat01;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author @Chenxc
 * @Date 2022/5/5 16:20
 */
@Slf4j
public class UserMapperTest {
    //动态插入
    @Test
    public void insert() throws Exception {
        UserModel userModel1 = UserModel.builder().name("路人甲Java").build();
        UserUtil.callMapper(UserMapper.class, mapper -> {
            mapper.insert(userModel1);
            return null;
        });
        log.info("插入结果：{}", this.getModelById(userModel1.getId()));
        log.info("---------------------");
        UserModel userModel2 = UserModel.builder().name("路 人").age(30).salary(50000.00).build();
                UserUtil.callMapper(UserMapper.class, mapper -> {
                    mapper.insert(userModel2);
                    return null;
                });
        log.info("插入结果：{}", this.getModelById(userModel2.getId()));
    }


    //按用户id查询
    public UserModel getModelById(Long userId) throws Exception {
//查询指定id的数据
        Map<String, Object> map = new HashMap<>();
        map.put("id", userId);
        return UserUtil.callMapper(UserMapper.class, mapper -> {
            List<UserModel> userModelList = mapper.getModelList(map);
            if (userModelList.size() == 1) {
                return userModelList.get(0);
            }
            return null;
        });
    }

}
