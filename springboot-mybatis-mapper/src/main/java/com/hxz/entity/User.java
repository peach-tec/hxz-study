package com.hxz.entity;

import javax.persistence.*;
import lombok.Data;

/**
 * 表名：user
*/
@Data
@Table(name = "`user`")
public class User {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "`id`")
    private String id;

    /**
     * 用户名
     */
    @Column(name = "`user_name`")
    private String userName;

    /**
     * 密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 邮箱
     */
    @Column(name = "`email`")
    private String email;

    /**
     * 角色ID
     */
    @Column(name = "`role_id`")
    private String roleId;
}