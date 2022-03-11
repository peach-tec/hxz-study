package com.hxz.entity;

import javax.persistence.*;

@Table(name = "`role`")
public class Role {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "`id`")
    private String id;

    /**
     * 角色名
     */
    @Column(name = "`role_name`")
    private String roleName;

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取角色名
     *
     * @return role_name - 角色名
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名
     *
     * @param roleName 角色名
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
