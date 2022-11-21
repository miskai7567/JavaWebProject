package com.itheima.test;

import com.alibaba.fastjson.JSON;
import com.itheima.bean.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author pzl
 * @Date 2022/11/12 16:07
 */
public class TestDemo {

    @Test
    public void test(){
        // json字符串-->java对象
        String jsonStr = "{\n" +
                "        \"username\":\"zhangsan\",\n" +
                "        \"age\":18\n" +
                "    }";

        User user = JSON.parseObject(jsonStr, User.class);
        System.out.println("user = " + user);// user = User{username='zhangsan', age=18}

        // java对象---->json字符串
        User u = new User("lisi",19);
        String jsonS = JSON.toJSONString(u);
        System.out.println("jsonS = " + jsonS);// jsonS = {"age":19,"username":"lisi"}

    }


    @Test
    public void test2(){
        // java对象---->json字符串
        User u1 = new User("lisi1",19);
        User u2 = new User("lisi2",29);
        User u3 = new User("lisi3",39);
        ArrayList<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        String jsonS = JSON.toJSONString(list);// [{},{},{}]
        System.out.println("jsonS = " + jsonS);

    }

    @Test
    public void test3(){
        // java对象---->json字符串
        User u1 = new User("lisi1",19);
        User u2 = new User("lisi2",29);
        User u3 = new User("lisi3",39);
        HashMap<String,User> map = new HashMap<>();
        map.put("u1",u1);
        map.put("u2",u2);
        map.put("u3",u3);
        String jsonS = JSON.toJSONString(map);// {"u1":{},"u2":{},"u3":{}}
        // {"u1":{"age":19,"username":"lisi1"},"u2":{"age":29,"username":"lisi2"},"u3":{"age":39,"username":"lisi3"}}
        System.out.println("jsonS = " + jsonS);

    }
}
