package com.networkDisk.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

// 用户实体类
@AllArgsConstructor
@Data
@Builder
public class User implements Serializable {
    // 用户ID
    private Integer userId;
    // 用户的openid
    private String openId;
    // 文件仓库ID
    private Integer fileStoreId;
    // 用户名
    private String userName;
    // 用户邮箱
    private String email;
    // 用户密码
    private String password;
    // 头像地址
    private String imagePath;
    // 用户角色，0管理员，1普通用户
    private Integer role;
}
