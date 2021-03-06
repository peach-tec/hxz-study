package com.hxz.test;

import com.hxz.mybatis.entity.User;
import com.hxz.mybatis.mapper.UserMapper;
import com.hxz.mybatis.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022-02-24-20:53
 * @address 成都
 */
public class TestDemo {
    @Test
    public void test001() throws IOException {
        // 加载核心配置文件
        InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 获取SqlSessionFactory
        SqlSessionFactory build = builder.build(resource);
        // 获取数据库会话对象 SqlSession
        // SqlSession 不会自动提交事务，可以传入 “true” 设置自动提交：SqlSession sqlSession = build.openSession(true);
        SqlSession sqlSession = build.openSession();
        // 获取mapper接口对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int result = userMapper.saveUser(new User("user01", "123456", 20, "男", "78452@qq.com"));
        System.out.println("返回的结果：" + result);
        // 提交事务
        sqlSession.commit();
    }

    @Test
    public void test002() throws IOException {
        UserMapper mapper = getMapper();
        User user = mapper.getById(2);
        System.out.println(user.toString());
    }

    @Test
    public void test003() {
        UserMapper mapper = MybatisUtils.getMapper(UserMapper.class);
        List<User> users = mapper.listUsers();
        users.forEach(System.out::println);
    }

    @Test
    public void test004() {
        UserMapper mapper = MybatisUtils.getMapper(UserMapper.class);
        User user = mapper.getByUsername("testuser");
        System.out.println(user.toString());
    }

    @Test
    public void test005() {
        UserMapper mapper = MybatisUtils.getMapper(UserMapper.class);
        User user = mapper.getByUsernameAndPassword("testuser", "123456");
        System.out.println(user.toString());
    }

    @Test
    public void test006() {
        Map<String, Object> params = new HashMap<>();
        params.put("username", "testuser");
        params.put("password", "123456");
        UserMapper mapper = MybatisUtils.getMapper(UserMapper.class);
        User user = mapper.getByParams(params);
        System.out.println(user.toString());
    }

    @Test
    public void test007() {
        UserMapper mapper = MybatisUtils.getMapper(UserMapper.class);
        User user = mapper.getUser("testuser", "123456");
        System.out.println(user.toString());
    }

    @Test
    public void test008() {
        UserMapper mapper = MybatisUtils.getMapper(UserMapper.class);
        Map<String, Object> user = mapper.mapUser();
        System.out.println(user.toString());
    }

    @Test
    public void test009() {
        UserMapper mapper = MybatisUtils.getMapper(UserMapper.class);
        List<User> users = mapper.getUserByLike("test");
        System.out.println(users.toString());
    }

    @Test
    public void test010() {
        UserMapper mapper = MybatisUtils.getMapper(UserMapper.class);
        int count = mapper.deleteBatch("1,2,3");
        System.out.println("删除了 " + count + " 行数据");
    }

    @Test
    public void test011() {
        UserMapper mapper = MybatisUtils.getMapper(UserMapper.class);
        int count = mapper.deleteBatchByUsername("'test5','test6'");
        System.out.println("删除了 " + count + " 行数据");
    }

    @Test
    public void test012() {
        UserMapper mapper = MybatisUtils.getMapper(UserMapper.class);
        List<User> users = mapper.getUserByTableName("t_user");
        users.forEach(System.out::println);
    }

    @Test
    public void test013() {
        UserMapper mapper = MybatisUtils.getMapper(UserMapper.class);
        User user = new User("HXZ1", "123456", 28, "男", "184821@qq.com");
        Integer row = mapper.saveUser(user);
        System.out.println("执行的行数：" + row);
        System.out.println("执行后的用户：" + user.toString());
    }

    private UserMapper getMapper() throws IOException {
        // 加载核心配置文件
        InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 获取SqlSessionFactory
        SqlSessionFactory build = builder.build(resource);
        // 获取数据库会话对象 SqlSession
        // SqlSession 不会自动提交事务，可以传入 “true” 设置自动提交：SqlSession sqlSession = build.openSession(true);
        SqlSession sqlSession = build.openSession(true);
        // 获取mapper接口对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        return userMapper;
    }

    @Test
    public void addTestData() {
        UserMapper mapper = MybatisUtils.getMapper(UserMapper.class);
        for (int i = 1; i <= 100; i++) {
            User user = new User("test" + i, "123456" + i, i, i % 2 == 0 ? "男" : "女", "5236" + i + "qq.com");
            mapper.saveUser(user);
        }
    }


    @Test
    public void addTestData01() {
        long current = System.currentTimeMillis();
        UserMapper mapper = MybatisUtils.getMapper(UserMapper.class);
        for (int i = 1; i <= 10; i++) {
            mapper.insertSnow();
        }
        System.out.println(System.currentTimeMillis() - current);
    }
}
