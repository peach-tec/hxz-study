package com.hxz;


//import com.hxz.entity.User;
//import com.hxz.mapper.RoleMapper;
//import com.hxz.mapper.UserMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;

import com.hxz.entity.Dept;
import com.hxz.entity.Role;
import com.hxz.entity.User;
import com.hxz.mapper.DeptMapper;
import com.hxz.mapper.RoleMapper;
import com.hxz.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.junit.jupiter.api.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SpringbootMybatisMapperApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private DeptMapper deptMapper;

    /**
     * 新增部门测试主键
     */
    @Test
    public void addDept() {
        // 使用KeySql
        for (int i = 0; i < 10; i++) {
            Dept dept = new Dept();
            dept.setDeptName("部门" + i);
            deptMapper.insert(dept);
            System.out.println("部门" + i + "的ID为：" + dept.getId());
        }
    }

    @Test
    public void addDept01() {
        //使用GeneratedValue
        for (int i = 0; i < 10; i++) {
            Dept dept = new Dept();
            dept.setDeptName("部门" + i);
            deptMapper.insertDept(dept);
            System.out.println("部门" + i + "的ID为：" + dept.getId());
        }
    }
    @Test
    public void addDept02() {
        // 使用  @KeySql(genSql = DefineSql.class)
        for (int i = 0; i < 10; i++) {
            Dept dept = new Dept();
            dept.setDeptName("部门" + i);
            deptMapper.insertDept(dept);
            System.out.println("部门" + i + "的ID为：" + dept.getId());
        }
    }

    /**
     * 新增角色测试自增主键
     */
    @Test
    public void addRole() {
        for (int i = 0; i < 10; i++) {
            Role role = new Role();
            role.setRoleName("角色" + i + 1);
            roleMapper.insert(role);
            System.out.println("角色" + i + 1 + "的ID为：" + role.getId());
        }
    }


    @Test
    public void userList() {
        List<User> users = userMapper.selectAll();
        System.out.println(users);
    }

    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(Resources.getResourceAsStream("generatorConfig.xml"));
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}
