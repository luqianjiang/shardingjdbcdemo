package com.atguigu.shardingjdbcdemo;

import com.atguigu.shardingjdbcdemo.entity.Course;
import com.atguigu.shardingjdbcdemo.mapper.CourseMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ShardingjdbcdemoApplicationTests {

    //注入mapper
    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void addCourseDb() {
        for (int i = 0; i <10 ; i++) {
            Course course = new Course();
            course.setCname("java");
            //分库根据user_id
            course.setUserId(100L);
            course.setCstatus("Normal1"+i);
            courseMapper.insert(course);
        }

    }

    //查询操作
    @Test
    public void findCourseDb() {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        //设置userid值
        //设置cid值
        wrapper.eq("cid",898347185337270272L);
        Course course = courseMapper.selectOne(wrapper);
        System.out.println(course);
    }
}
