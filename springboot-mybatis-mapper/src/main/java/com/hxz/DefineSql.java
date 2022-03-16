package com.hxz;

import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.entity.EntityTable;
import tk.mybatis.mapper.gensql.GenSql;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022/3/16-15:54
 * @address 成都
 */
public class DefineSql implements GenSql {
    @Override
    public String genSql(EntityTable entityTable, EntityColumn entityColumn) {
        return "select uuid()";
    }
}
