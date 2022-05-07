package com.chen;

import com.chen.bean.OrderModel;
import com.chen.bean.UserModel;
import com.chen.mapper.OrderMapper;
import com.chen.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author @Chenxc
 * @Date 2022/5/7 14:38
 */
@Slf4j
public class Test {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void before() throws IOException {
//指定mybatis全局配置文件
        String resource = "mybatis-config.xml";
//读取全局配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
//构建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(inputStream);
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @org.junit.Test
    public void getById1() throws IOException {
        OrderModel orderModel = null;
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
            orderModel = mapper.getById1(1);
        }
        log.info("-------分割线--------");
        log.info("{}", orderModel.getUserModel());
    }

    @org.junit.Test
    public void getById2() throws IOException {
        OrderModel orderModel = null;
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
            orderModel = mapper.getById2(1);
        }
        log.info("-------分割线--------");
        log.info("{}", orderModel.getOrderDetailModelList());
    }

    @org.junit.Test
    public void update1() throws IOException {
        OrderModel orderModel = null;
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            UserModel userModel = UserModel.builder().name("cxc").build();
            Integer result = mapper.update1(userModel);
            log.info("-------分割线--------");
            log.info("{}", result);
        }
    }


}
