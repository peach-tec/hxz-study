package com.hxz.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 工具类
 * @copyright &copy; DYH
 * @date 2022-02-25-20:52
 * @address 成都
 */
public class MybatisUtils {

    /**
     * @return org.apache.ibatis.session.SqlSession
     * @desc 数据库对象
     * @author 華小灼
     * @date 2022-02-25 20:56
     */
    public static SqlSession sqlSession() {
        return sqlSession("mybatis-config.xml");
    }

    public static SqlSession sqlSession(String mybatisConfig) {
        // 加载核心配置文件
        InputStream resource = null;
        try {
            resource = Resources.getResourceAsStream(mybatisConfig);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 获取SqlSessionFactory
        SqlSessionFactory build = builder.build(resource);
        // 获取数据库会话对象 SqlSession
        // SqlSession 不会自动提交事务，可以传入 “true” 设置自动提交：SqlSession sqlSession = build.openSession(true);
        return build.openSession(true);
    }

    /**
     * @param clazz 对象类型
     * @return T
     * @desc 获取mapper对象
     * @author 華小灼
     * @date 2022-02-25 20:55
     */
    public static <T> T getMapper(Class<T> clazz) {
        // 获取mapper接口对象
        return sqlSession().getMapper(clazz);
    }

    public static <T> T getMapper(Class<T> clazz, String mybatisConfig) {
        // 获取mapper接口对象
        return sqlSession(mybatisConfig).getMapper(clazz);
    }
}
