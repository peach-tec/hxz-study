package com.hxz.entity;

import javax.persistence.*;
import lombok.Data;

/**
 * 表名：role
*/
@Data
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
}