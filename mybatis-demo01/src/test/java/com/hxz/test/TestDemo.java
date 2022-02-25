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
import java.util.List;

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
        int result = userMapper.insertUser(new User("user01", "123456", 20, "男", "78452@qq.com"));
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
}
