package com.hxz.gener;

import tk.mybatis.mapper.genid.GenId;

/**
 * 时间戳
 */
public class TimeStampSql implements GenId {
    private Long time;
    private Integer seq;

    @Override
    public synchronized Object genId(String table, String column) {
        long current = System.currentTimeMillis();
        if (time == null || time != current) {
            time = current;
            seq = 1;
        } else if (current == time) {
            seq++;
        }
        return ((time << 20) | seq) + "";
    }
}
