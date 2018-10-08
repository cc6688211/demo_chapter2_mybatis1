package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.taf.log.TAFLog;
import com.example.demo.test1.dao.UserMapper;
import com.example.demo.test1.pojo.User;

@RunWith(SpringRunner.class)
// 引入SpringBootTest并生成随机接口
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MybatisTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void test() {
        try {
            userMapper.insert("cc", (long) 18);
            User user = new User();
            user.setName("ccc");
            user.setAge(18);
            userMapper.insertByBean(user);
            TAFLog.info("反写id为：" + user.getId());
            Map < String, Object > map = new HashMap < String, Object >();
            map.put("name", "cccc");
            map.put("age", 18);
            userMapper.insertByMap(map);
            System.out.println("反写id为：" + map.get("id"));
            System.out.println("查询用户数量：" + userMapper.findAll().size());
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }
}
