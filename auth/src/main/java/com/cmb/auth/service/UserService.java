package com.cmb.auth.service;

import com.cmb.auth.pojo.form.UserRegisterForm;
import com.cmb.auth.pojo.vo.UserRegisterVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface UserService {

    UserRegisterVo register(UserRegisterForm form, HttpServletRequest request, HttpServletResponse response);
}
