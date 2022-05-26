package com.hxz.id.autoid.model;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandler;

import java.util.List;

public class BoundSqlHelper {

    private BoundSql boundSql;

    private String sql;

    private String primaryKey;

    private TypeHandler typeHandler;

    private Configuration configuration;

    private boolean isAleadyIncludePrimaryKey;

    //是否批量操作
    private boolean isInsertBatch;

    private List<String> primaryKeyList;

    public BoundSql getBoundSql() {
        return boundSql;
    }

    public void setBoundSql(BoundSql boundSql) {
        this.boundSql = boundSql;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public TypeHandler getTypeHandler() {
        return typeHandler;
    }

    public void setTypeHandler(TypeHandler typeHandler) {
        this.typeHandler = typeHandler;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public boolean isAleadyIncludePrimaryKey() {
        return isAleadyIncludePrimaryKey;
    }

    public void setAleadyIncludePrimaryKey(boolean aleadyIncludePrimaryKey) {
        isAleadyIncludePrimaryKey = aleadyIncludePrimaryKey;
    }

    public boolean isInsertBatch() {
        return isInsertBatch;
    }

    public void setInsertBatch(boolean insertBatch) {
        isInsertBatch = insertBatch;
    }

    public List<String> getPrimaryKeyList() {
        return primaryKeyList;
    }

    public void setPrimaryKeyList(List<String> primaryKeyList) {
        this.primaryKeyList = primaryKeyList;
    }
}
