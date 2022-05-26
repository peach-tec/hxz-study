package com.hxz.id.autoid.process;


import com.hxz.id.autoid.Snowflake;

import java.lang.reflect.Field;

public class SnowFlakeAutoIdProcess extends BaseAutoIdProcess {

    private static final Snowflake snowflake = new Snowflake(0, 0);


    public SnowFlakeAutoIdProcess(Field field) {
        super(field);
    }

    @Override
    void setFieldValue(Object entity) throws Exception {
        long value = snowflake.nextId();
        field.set(entity, value);
    }
}
