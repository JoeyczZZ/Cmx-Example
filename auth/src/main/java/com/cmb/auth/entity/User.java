package com.cmb.auth.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDateTime;

@Data
@Builder
@FieldNameConstants
@AllArgsConstructor
@NoArgsConstructor
@TableName("auth_user")
public class User {

    @TableId
    private String id;

    private String account;

    private String password;

    private Integer deleted;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String updatedBy;

}
