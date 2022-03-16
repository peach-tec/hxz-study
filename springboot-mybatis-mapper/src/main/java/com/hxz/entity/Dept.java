package com.hxz.entity;

import com.hxz.DefineSql;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

import javax.persistence.*;

/**
 * 表名：dept
 */
@Data
@Table(name = "`dept`")
public class Dept {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "`id`")
    //@KeySql(sql = "select uuid()", order = ORDER.BEFORE)
    //@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select uuid()")
    @KeySql(genSql = DefineSql.class, order = ORDER.BEFORE)
    private String id;

    /**
     * 部门名称
     */
    @Column(name = "`dept_name`")
    private String deptName;
}
