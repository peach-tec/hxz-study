package com.hxz.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.*;

/**
 * 表名：role
 */
@Data
@Table(name = "`role`")
@NameStyle(value = Style.normal)
public class Role {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "`id`")
    //@KeySql(useGeneratedKeys = true, dialect = IdentityDialect.MYSQL)
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "JDBC")
    private String id;

    /**
     * 角色名
     */
    @Column(name = "`role_name`")
    private String roleName;
}
