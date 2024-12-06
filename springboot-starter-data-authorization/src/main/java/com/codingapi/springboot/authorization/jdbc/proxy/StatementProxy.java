package com.codingapi.springboot.authorization.jdbc.proxy;

import com.codingapi.springboot.authorization.interceptor.SQLRunningContext;
import com.codingapi.springboot.authorization.interceptor.SQLInterceptState;
import lombok.AllArgsConstructor;

import java.sql.*;

@AllArgsConstructor
public class StatementProxy implements Statement {

    private final Statement statement;
    private SQLInterceptState interceptState;



    @Override
    public ResultSet executeQuery(String sql) throws SQLException {
        this.interceptState = SQLRunningContext.getInstance().intercept(sql);
        return new ResultSetProxy(statement.executeQuery(interceptState.getSql()), interceptState);
    }

    @Override
    public int executeUpdate(String sql) throws SQLException {
        this.interceptState = SQLRunningContext.getInstance().intercept(sql);
        return statement.executeUpdate(interceptState.getSql());
    }

    @Override
    public void close() throws SQLException {
        statement.close();
    }

    @Override
    public int getMaxFieldSize() throws SQLException {
        return statement.getMaxFieldSize();
    }

    @Override
    public void setMaxFieldSize(int max) throws SQLException {
        statement.setMaxFieldSize(max);
    }

    @Override
    public int getMaxRows() throws SQLException {
        return statement.getMaxRows();
    }

    @Override
    public void setMaxRows(int max) throws SQLException {
        statement.setMaxRows(max);
    }

    @Override
    public void setEscapeProcessing(boolean enable) throws SQLException {
        statement.setEscapeProcessing(enable);
    }

    @Override
    public int getQueryTimeout() throws SQLException {
        return statement.getQueryTimeout();
    }

    @Override
    public void setQueryTimeout(int seconds) throws SQLException {
        statement.setQueryTimeout(seconds);
    }

    @Override
    public void cancel() throws SQLException {
        statement.cancel();
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        return statement.getWarnings();
    }

    @Override
    public void clearWarnings() throws SQLException {
        statement.clearWarnings();
    }

    @Override
    public void setCursorName(String name) throws SQLException {
        statement.setCursorName(name);
    }

    @Override
    public boolean execute(String sql) throws SQLException {
        this.interceptState = SQLRunningContext.getInstance().intercept(sql);
        return statement.execute(interceptState.getSql());
    }

    @Override
    public ResultSet getResultSet() throws SQLException {
        return new ResultSetProxy(statement.getResultSet(), interceptState);
    }

    @Override
    public int getUpdateCount() throws SQLException {
        return statement.getUpdateCount();
    }

    @Override
    public boolean getMoreResults() throws SQLException {
        return statement.getMoreResults();
    }

    @Override
    public void setFetchDirection(int direction) throws SQLException {
        statement.setFetchDirection(direction);
    }

    @Override
    public int getFetchDirection() throws SQLException {
        return statement.getFetchDirection();
    }

    @Override
    public void setFetchSize(int rows) throws SQLException {
        statement.setFetchSize(rows);
    }

    @Override
    public int getFetchSize() throws SQLException {
        return statement.getFetchSize();
    }

    @Override
    public int getResultSetConcurrency() throws SQLException {
        return statement.getResultSetConcurrency();
    }

    @Override
    public int getResultSetType() throws SQLException {
        return statement.getResultSetType();
    }

    @Override
    public void addBatch(String sql) throws SQLException {
        this.interceptState = SQLRunningContext.getInstance().intercept(sql);
        statement.addBatch(interceptState.getSql());
    }

    @Override
    public void clearBatch() throws SQLException {
        statement.clearBatch();
    }

    @Override
    public int[] executeBatch() throws SQLException {
        return statement.executeBatch();
    }

    @Override
    public Connection getConnection() throws SQLException {
        return new ConnectionProxy(statement.getConnection());
    }

    @Override
    public boolean getMoreResults(int current) throws SQLException {
        return statement.getMoreResults(current);
    }

    @Override
    public ResultSet getGeneratedKeys() throws SQLException {
        return new ResultSetProxy(statement.getGeneratedKeys(),this.interceptState);
    }

    @Override
    public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
        this.interceptState = SQLRunningContext.getInstance().intercept(sql);
        return statement.executeUpdate(interceptState.getSql(), autoGeneratedKeys);
    }

    @Override
    public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
        this.interceptState = SQLRunningContext.getInstance().intercept(sql);
        return statement.executeUpdate(interceptState.getSql(), columnIndexes);
    }

    @Override
    public int executeUpdate(String sql, String[] columnNames) throws SQLException {
        this.interceptState = SQLRunningContext.getInstance().intercept(sql);
        return statement.executeUpdate(interceptState.getSql(), columnNames);
    }

    @Override
    public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
        this.interceptState = SQLRunningContext.getInstance().intercept(sql);
        return statement.execute(interceptState.getSql(), autoGeneratedKeys);
    }

    @Override
    public boolean execute(String sql, int[] columnIndexes) throws SQLException {
        this.interceptState = SQLRunningContext.getInstance().intercept(sql);
        return statement.execute(interceptState.getSql(), columnIndexes);
    }

    @Override
    public boolean execute(String sql, String[] columnNames) throws SQLException {
        this.interceptState = SQLRunningContext.getInstance().intercept(sql);
        return statement.execute(interceptState.getSql(), columnNames);
    }

    @Override
    public int getResultSetHoldability() throws SQLException {
        return statement.getResultSetHoldability();
    }

    @Override
    public boolean isClosed() throws SQLException {
        return statement.isClosed();
    }

    @Override
    public void setPoolable(boolean poolable) throws SQLException {
        statement.setPoolable(poolable);
    }

    @Override
    public boolean isPoolable() throws SQLException {
        return statement.isPoolable();
    }

    @Override
    public void closeOnCompletion() throws SQLException {
        statement.closeOnCompletion();
    }

    @Override
    public boolean isCloseOnCompletion() throws SQLException {
        return statement.isCloseOnCompletion();
    }

    @Override
    public long getLargeUpdateCount() throws SQLException {
        return statement.getLargeUpdateCount();
    }

    @Override
    public void setLargeMaxRows(long max) throws SQLException {
        statement.setLargeMaxRows(max);
    }

    @Override
    public long getLargeMaxRows() throws SQLException {
        return statement.getLargeMaxRows();
    }

    @Override
    public long[] executeLargeBatch() throws SQLException {
        return statement.executeLargeBatch();
    }

    @Override
    public long executeLargeUpdate(String sql) throws SQLException {
        this.interceptState = SQLRunningContext.getInstance().intercept(sql);
        return statement.executeLargeUpdate(interceptState.getSql());
    }

    @Override
    public long executeLargeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
        this.interceptState = SQLRunningContext.getInstance().intercept(sql);
        return statement.executeLargeUpdate(interceptState.getSql(), autoGeneratedKeys);
    }

    @Override
    public long executeLargeUpdate(String sql, int[] columnIndexes) throws SQLException {
        this.interceptState = SQLRunningContext.getInstance().intercept(sql);
        return statement.executeLargeUpdate(interceptState.getSql(), columnIndexes);
    }

    @Override
    public long executeLargeUpdate(String sql, String[] columnNames) throws SQLException {
        this.interceptState = SQLRunningContext.getInstance().intercept(sql);
        return statement.executeLargeUpdate(interceptState.getSql(), columnNames);
    }

    @Override
    public String enquoteLiteral(String val) throws SQLException {
        return statement.enquoteLiteral(val);
    }

    @Override
    public String enquoteIdentifier(String identifier, boolean alwaysQuote) throws SQLException {
        return statement.enquoteIdentifier(identifier, alwaysQuote);
    }

    @Override
    public boolean isSimpleIdentifier(String identifier) throws SQLException {
        return statement.isSimpleIdentifier(identifier);
    }

    @Override
    public String enquoteNCharLiteral(String val) throws SQLException {
        return statement.enquoteNCharLiteral(val);
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return statement.unwrap(iface);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return statement.isWrapperFor(iface);
    }
}
