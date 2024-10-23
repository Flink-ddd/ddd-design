package com.rmpl.business.common.interceptor;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.SqlSource;

/**
 * @Description TODO
 * @Author lujingbo
 * @Date 2022-03-04 15:07
 **/
public class BoundSqlSource implements SqlSource {

    private BoundSql boundSql;

    public BoundSqlSource(BoundSql boundSql) {
        this.boundSql = boundSql;
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        return boundSql;
    }
}