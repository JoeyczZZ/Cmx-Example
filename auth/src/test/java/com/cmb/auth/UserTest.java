package com.cmb.auth;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.cmb.auth.dao.UserDao;
import com.cmb.auth.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@MybatisPlusTest
public class UserTest {

    @Autowired
    private UserDao userDao;

    @Test
    void insertTest() {
        User user = User.builder()
                .id("111")
                .account("111")
                .password("111")
                .deleted(0)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .updatedBy("111")
                .build();
        userDao.insert(user);
        assertThat(userDao.selectById("111")).isNotNull();
    }

}
