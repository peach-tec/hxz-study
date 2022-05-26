package com.hxz.id;

import com.hxz.id.user.entity.User;
import com.hxz.id.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Date;

@SpringBootTest
class SpringbootAutoIdApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    public void testSave() {
        User user = new User();
        user.setUserName("张三");
        user.setCreateTime(new Date());
        user.setDeptName("产品部");
        user.setDomain("lybgeek.com");
        user.setEmail("zhangsan@lybgeek.com");
        user.setMobile("18800000006");
        user.setSex("男");
        boolean isOk = userService.save(user);

        Assert.isTrue(isOk, "添加出错");
    }
}
