package com.sun.shard.service;

import com.sun.eureka.DemoApplicationTests;
import com.sun.shard.bean.User;
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
public class AloneUserServiceTest extends DemoApplicationTests {

    @Autowired
    private AloneUserService aloneUserService;

    @Test
    public void saveAloneUser() {

        // 此服务不走sharding分库分表策略
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setCityId(i);
            user.setCreateTime(new Date());
            user.setEmail((1273707178 + i) + "@qq.com");
            user.setName("邓伟" + i);
            user.setPassword("123456");
            user.setPhone((1273707178 + i) + "");
            user.setSex(i % 2);
            aloneUserService.save(user);
        }
    }



}
