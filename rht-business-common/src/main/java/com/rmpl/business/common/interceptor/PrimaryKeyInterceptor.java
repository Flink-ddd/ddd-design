package com.rmpl.business.common.interceptor;

import com.rmpl.business.common.sequence.SequenceManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Properties;


/**
 * @Description TODO 拦截insert方法生成主键ID
 * @Author lujingbo
 * @Date 2022-02-11 13:32
 **/
@Slf4j
@Component
@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
})
public class PrimaryKeyInterceptor implements Interceptor {

    @Override
    @SuppressWarnings("unchecked")
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        for (Object o : args) {
            if (o instanceof MappedStatement) {
                MappedStatement mappedStatement = (MappedStatement) o;
                if (SqlCommandType.SELECT.equals(mappedStatement.getSqlCommandType())) {
                    String sql = getSqlByInvocation(invocation);
                    //将操作员可操作的渠道、用户id及营业部作通用字段放到sql中统一解析
//                    if (searchCount("where", sql.toLowerCase()) == 1) {
//                        int index = sql.toLowerCase().indexOf("where");
//                        sql = addPremissionParam(sql, index);
//                        resetSql2Invocation(invocation, sql);
//                        log.info("SELECT 拦截sql:{}", sql);
//                    }
                    return invocation.proceed();
                }
                if (!SqlCommandType.INSERT.equals(mappedStatement.getSqlCommandType())) {
                    return invocation.proceed();
                }
            } else {
                Field[] fields = o.getClass().getDeclaredFields();
                for (Field field : fields) {
                    if (field.getAnnotation(PrimaryKey.class) != null) {
                        // 主键已设置不再生成
                        field.setAccessible(true);
                        if (field.get(o) != null) {
                            return invocation.proceed();
                        }
                        // 生成并设置主键
                        String name = field.getName();
                        String setName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                        Long primaryKey = SequenceManager.singleton().getNextSequence();
                        o.getClass().getMethod(setName, Long.class).invoke(o, primaryKey);
                        return invocation.proceed();
                    }
                }
            }
        }
        return invocation.proceed();
    }


    /**
     * 统计一个子串在指定字符串中出现的次数
     *
     * @param shortStr
     * @param longStr
     * @return
     */
    public static int searchCount(String shortStr, String longStr) {
        int count = 0;
        while (longStr.indexOf(shortStr) != -1) {
            count++;
            longStr = longStr.substring(longStr.indexOf(shortStr)
                    + shortStr.length());
        }
        return count;
    }

    /**
     * 获取当前sql
     *
     * @param invocation
     * @return
     */
    private String getSqlByInvocation(Invocation invocation) {
        final Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        Object parameterObject = args[1];
        BoundSql boundSql = ms.getBoundSql(parameterObject);
        return boundSql.getSql();
    }

    /**
     * 将sql重新设置到invocation中
     *
     * @param invocation
     * @param sql
     * @throws SQLException
     */
    private void resetSql2Invocation(Invocation invocation, String sql) throws SQLException {
        final Object[] args = invocation.getArgs();
        MappedStatement statement = (MappedStatement) args[0];
        Object parameterObject = args[1];
        BoundSql boundSql = statement.getBoundSql(parameterObject);
        MappedStatement newStatement = newMappedStatement(statement, new BoundSqlSource(boundSql));
        MetaObject msObject = MetaObject.forObject(newStatement, new DefaultObjectFactory(), new DefaultObjectWrapperFactory(), new DefaultReflectorFactory());
        msObject.setValue("sqlSource.boundSql.sql", sql);
        args[0] = newStatement;
    }

    private MappedStatement newMappedStatement(MappedStatement ms, SqlSource newSqlSource) {
        MappedStatement.Builder builder =
                new MappedStatement.Builder(ms.getConfiguration(), ms.getId(), newSqlSource, ms.getSqlCommandType());
        builder.resource(ms.getResource());
        builder.fetchSize(ms.getFetchSize());
        builder.statementType(ms.getStatementType());
        builder.keyGenerator(ms.getKeyGenerator());
        if (ms.getKeyProperties() != null && ms.getKeyProperties().length != 0) {
            StringBuilder keyProperties = new StringBuilder();
            for (String keyProperty : ms.getKeyProperties()) {
                keyProperties.append(keyProperty).append(",");
            }
            keyProperties.delete(keyProperties.length() - 1, keyProperties.length());
            builder.keyProperty(keyProperties.toString());
        }
        builder.timeout(ms.getTimeout());
        builder.parameterMap(ms.getParameterMap());
        builder.resultMaps(ms.getResultMaps());
        builder.resultSetType(ms.getResultSetType());
        builder.cache(ms.getCache());
        builder.flushCacheRequired(ms.isFlushCacheRequired());
        builder.useCache(ms.isUseCache());

        return builder.build();
    }

    @Override
    public Object plugin(Object target) {
        return target instanceof Executor ? (Plugin.wrap(target, this)) : target;
    }

    @Override
    public void setProperties(Properties properties) {

    }

}
