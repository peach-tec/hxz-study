package com.hxz.gener;

import tk.mybatis.mapper.genid.GenId;

import java.util.UUID;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022/3/16-17:07
 * @address 成都
 */
public class UUIDSql implements GenId {
    /**
     * 使用uuid
     */
    @Override
    public Object genId(String table, String column) {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
