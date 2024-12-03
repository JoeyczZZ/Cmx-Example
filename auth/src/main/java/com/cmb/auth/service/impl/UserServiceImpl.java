package com.cmb.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cmb.auth.dao.UserDao;
import com.cmb.auth.entity.User;
import com.cmb.auth.pojo.form.UserRegisterForm;
import com.cmb.auth.pojo.vo.UserRegisterVo;
import com.cmb.auth.service.UserService;
import com.cmb.common.util.IdUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public UserRegisterVo register(UserRegisterForm form, HttpServletRequest request, HttpServletResponse response) {

        long count = userDao.selectCount(new QueryWrapper<User>().lambda().eq(User::getAccount, form.getAccount()));
        if (count > 0) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "该用户名已存在");
        }


        String uid = IdUtil.genId();
        User entity = User.builder()
                .id(uid)
                .account(form.getAccount())
                .password(form.getPassword())
                .deleted(0)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .updatedBy(uid).build();
        long insertCount = userDao.insert(entity);
        log.info("用户{}注册 count:{}", form.getAccount(), insertCount);
        if (insertCount == 0) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "注册失败");
        }

        return UserRegisterVo.builder().uid(uid).build();
    }
}
