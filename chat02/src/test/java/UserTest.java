import com.chen.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author @Chenxc
 * @date 2022年05月05日 23:24
 */
@Slf4j
public class UserTest {
    private SqlSessionFactory sessionFactory;

    @Before
    public void before() throws IOException{
        //指定mybatis全局配置文件
        String resource = "mybatis-config.xml";
        //读取全局配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        this.sessionFactory = sessionFactory;
    }

    @Test
    public void sqlSession() {
        SqlSession sqlSession = this.sessionFactory.openSession();
        log.info("{}", sqlSession);
    }

    @Test
    public void insertUser(){
        try(SqlSession sqlSession = this.sessionFactory.openSession(false)){
            UserModel userModel = UserModel.builder().id(2l).name("cxc").age(24).salary(5000d).sex(1).build();
            int result = sqlSession.insert("com.chen.userMapper.insertuser", userModel);
            System.out.println(result);
            sqlSession.commit();
        }
    }

    @Test
    public void updateUser() {
        try (SqlSession sqlSession = this.sessionFactory.openSession(true);) {
//创建UserModel对象
            UserModel userModel = UserModel.builder().id(1L).name("路人甲Java，你好").age(18).salary(5000D).sex(0).build();
//执行更新操作
            int result =
                    sqlSession.update("com.chen.UserMapper.updateUser", userModel);
            log.info("影响行数：{}", result);
        }
    }

    @Test
    public void deleteUser() {
        try (SqlSession sqlSession = this.sessionFactory.openSession(true);) {
//定义需要删除的用户id
            Long userId = 1L;
//执行删除操作
            int result =
                    sqlSession.delete("com.chen.UserMapper.deleteUser", userId);
            log.info("影响行数：{}", result);
        }
    }

    @Test
    public void getUserList() {
        try (SqlSession sqlSession = this.sessionFactory.openSession(true);) {
//执行查询操作
            List<UserModel> userModelList =
                    sqlSession.selectList("com.chen.userMapper.getUserList");
            log.info("结果：{}", userModelList);
        }
    }


}
