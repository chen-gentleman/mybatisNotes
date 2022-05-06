import com.chen.UserFindDto;
import com.chen.UserModel;
import com.chen.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.result.DefaultResultContext;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                    sqlSession.selectList("com.chen.mapper.userMapper.getUserList");
            log.info("结果：{}", userModelList);
        }
    }


    /*传参*/

    @Test
    public void testGetByName(){
        try (SqlSession sqlSession = this.sessionFactory.openSession(true);) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            UserModel userModel = mapper.getByName("路人甲Java");
            System.out.println(userModel);

        }
    }


    @Test
    public void testGetByMap(){
        try (SqlSession sqlSession = this.sessionFactory.openSession(true);) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Map<String,Object> map = new HashMap<>();
            map.put("id",3);
            map.put("name","cxc");
            List<UserModel> userModels = mapper.getByMap(map);
            System.out.println(userModels);

        }
    }


    @Test
    public void testGetListByUserFindDto(){
        try (SqlSession sqlSession = this.sessionFactory.openSession(true);) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            UserFindDto userFindDto = UserFindDto.builder().userId(3l).userName("张学友").build();
            List<UserModel> userModels = mapper.getListByUserFindDto(userFindDto);
            System.out.println(userModels);

        }
    }

    @Test
    public void testGetByIdOrName(){
        try (SqlSession sqlSession = this.sessionFactory.openSession(true);) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            UserModel userModel = mapper.getByIdOrName(3l, "cxc");
            System.out.println(userModel);
        }
    }


    @Test
    public void testGetListByIdCollection(){
        try (SqlSession sqlSession = this.sessionFactory.openSession(true);) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<Long> list = Arrays.asList(2l, 3l);
            List<UserModel> listByIdCollection = mapper.getListByIdCollection(list);
            listByIdCollection.forEach(item ->{
                System.out.println(item);
            });
        }
    }


    @Test
    public void testGetListByIdArray(){
        try (SqlSession sqlSession = this.sessionFactory.openSession(true);) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<Long> list = Arrays.asList(2l, 3l);
            Long[] arrays = (Long[])list.toArray();
            List<UserModel> listByIdArray = mapper.getListByIdArray(arrays);
            listByIdArray.forEach(item ->{
                System.out.println(item);
            });
        }
    }


    /**
     * getResultObject：获取当前行的结果
     * getResultCount：获取当前结果到第几行了
     * isStopped：判断是否需要停止遍历结果集
     * stop：停止遍历结果集
     * @author @Chenxc
     * @date 2022/5/6 22:44No such property: code for class: Script1
     */
    @Test
    public void testGetList(){
        try (SqlSession sqlSession = this.sessionFactory.openSession(true);) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.getList(context ->{
                ////将context参数转换为DefaultResultContext对象
                DefaultResultContext<UserModel> defaultResultContext = (DefaultResultContext)context;
                System.out.println(defaultResultContext.getResultObject());
                ////遍历到第二条之后停止
                if(defaultResultContext.getResultCount() == 2){
                    //调用stop方法停止遍历，stop方法会更新内部的一个标志，置为停止遍历
                    defaultResultContext.stop();
                }
            });
        }
    }

}
