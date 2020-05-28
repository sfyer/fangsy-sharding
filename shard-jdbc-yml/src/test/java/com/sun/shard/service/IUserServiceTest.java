package com.sun.shard.service;

import com.sun.eureka.DemoApplicationTests;
import com.sun.shard.bean.User;
import com.sun.shard.utils.SnowFlakeGenerator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @Title: IUserServiceTest
 * @Description:
 * @Team: 财务产品研发部
 * @Author fangsy
 * @Date 2020-05-28
 */
public class IUserServiceTest extends DemoApplicationTests {

    @Autowired
    private IUserService userService;

    @Test
    public void saveUser() {

        for (int i = 0; i < 10000; i++) {
            User user = new User();
            user.setCityId(i);
            user.setCreateTime(new Date());
            user.setEmail((1273707178 + i) + "@qq.com");
            user.setName("邓伟" + i);
            user.setPassword("123456");
            user.setPhone((1273707178 + i) + "");
            user.setSex(i % 2);
            userService.save(user);
        }
    }



}
