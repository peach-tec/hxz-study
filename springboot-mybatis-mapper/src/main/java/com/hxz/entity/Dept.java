package com.hxz.entity;

import com.hxz.gener.UUIDSql;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

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
    //@KeySql(genSql = DefineSql.class, order = ORDER.BEFORE)
    @KeySql(genId = UUIDSql.class)
    private String id;

    /**
     * 部门名称
     */
    @Column(name = "`dept_name`")
    private String deptName;
}
