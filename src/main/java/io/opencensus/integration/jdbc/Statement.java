// Copyright 2018, OpenCensus Authors
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package io.opencensus.integration.jdbc;

import java.sql.SQLException;

import io.opencensus.integration.jdbc.Observability;

public class Statement implements java.sql.Statement, java.sql.Wrapper {
    private java.sql.Statement stmt;
    private boolean shouldAnnotateSpansWithSQL;
    private Observability.TraceOption[] startOptions;

    public Statement(java.sql.Statement stmt, Observability.TraceOption ...opts) throws SQLException {
        this.stmt = stmt;
        this.shouldAnnotateSpansWithSQL = Observability.shouldAnnotateSpansWithSQL(opts);
        this.startOptions = opts;
    }

    @Override
    public void addBatch(String SQL) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.addBatch",
                                                                                             "addBatch",
                                                                                             this.shouldAnnotateSpansWithSQL,
                                                                                             SQL);

        try {
            this.stmt.addBatch(SQL);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void cancel() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.cancel", "cancel");

        try {
            this.stmt.cancel();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void clearBatch() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.createBatch", "createBatch");

        try {
            this.stmt.clearBatch();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void clearWarnings() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.clearWarnings", "clearWarnings");

        try {
            this.stmt.clearWarnings();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void close() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.close", "close");

        try {
            this.stmt.close();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void closeOnCompletion() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.closeOnCompletion", "closeOnCompletion");

        try {
            this.stmt.closeOnCompletion();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public boolean execute(String SQL) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.execute",
                                                                                             "execute",
                                                                                             this.shouldAnnotateSpansWithSQL,
                                                                                             SQL);

        try {
            return this.stmt.execute(SQL);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public boolean execute(String SQL, int autoGeneratedKeys) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.execute",
                                                                                             "execute",
                                                                                             this.shouldAnnotateSpansWithSQL,
                                                                                             SQL);

        try {
            return this.stmt.execute(SQL, autoGeneratedKeys);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public boolean execute(String SQL, int[] columnIndices) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.execute",
                                                                                             "execute",
                                                                                             this.shouldAnnotateSpansWithSQL,
                                                                                             SQL);

        try {
            return this.stmt.execute(SQL, columnIndices);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public boolean execute(String SQL, String[] columnNames) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.execute",
                                                                                             "execute",
                                                                                             this.shouldAnnotateSpansWithSQL,
                                                                                             SQL);

        try {
            return this.stmt.execute(SQL, columnNames);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public int[] executeBatch() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.executeBatch", "executeBatch");

        try {
            return this.stmt.executeBatch();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.ResultSet executeQuery(String SQL) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.executeQuery",
                                                                                             "executeQuery",
                                                                                             this.shouldAnnotateSpansWithSQL,
                                                                                             SQL);

        try {
            java.sql.ResultSet rs = this.stmt.executeQuery(SQL);
            return new ResultSet(rs);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public int executeUpdate(String SQL) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.executeUpdate",
                                                                                             "executeUpdate",
                                                                                             this.shouldAnnotateSpansWithSQL,
                                                                                             SQL);

        try {
            return this.stmt.executeUpdate(SQL);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public int executeUpdate(String SQL, int autoGeneratedKeys) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.executeUpdate",
                                                                                             "executeUpdate",
                                                                                             this.shouldAnnotateSpansWithSQL,
                                                                                             SQL);

        try {
            return this.stmt.executeUpdate(SQL, autoGeneratedKeys);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public int executeUpdate(String SQL, int[] columnIndices) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.executeUpdate",
                                                                                             "executeUpdate",
                                                                                             this.shouldAnnotateSpansWithSQL,
                                                                                             SQL);

        try {
            return this.stmt.executeUpdate(SQL, columnIndices);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public int executeUpdate(String SQL, String[] columnNames) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.executeUpdate",
                                                                                             "executeUpdate",
                                                                                             this.shouldAnnotateSpansWithSQL,
                                                                                             SQL);

        try {
            return this.stmt.executeUpdate(SQL, columnNames);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.Connection getConnection() throws SQLException {
        return this.stmt.getConnection();
    }

    @Override
    public int getFetchDirection() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.getFetchDirection", "getFetchDirection");

        try {
            return this.stmt.getFetchDirection();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public int getFetchSize() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.getFetchSize", "getFetchSize");

        try {
            return this.stmt.getFetchSize();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.ResultSet getGeneratedKeys() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.getGeneratedKeys", "getGeneratedKeys");

        try {
            java.sql.ResultSet rs = this.stmt.getGeneratedKeys();
            return new ResultSet(rs);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public int getMaxFieldSize() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.getMaxFieldSize", "getMaxFieldSize");

        try {
            return this.stmt.getMaxFieldSize();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public int getMaxRows() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.getMaxRows", "getMaxRows");

        try {
            return this.stmt.getMaxRows();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public boolean getMoreResults(int current) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.getMoreResults", "getMoreResults");

        try {
            return this.stmt.getMoreResults(current);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public boolean getMoreResults() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.getMoreResults", "getMoreResults");

        try {
            return this.stmt.getMoreResults();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public int getQueryTimeout() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.getQueryTimeout", "getQueryTimeout");

        try {
            return this.stmt.getQueryTimeout();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.ResultSet getResultSet() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.getResultSet", "getResultSet");

        try {
            java.sql.ResultSet rs = this.stmt.getResultSet();
            return new ResultSet(rs);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public int getResultSetConcurrency() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.getResultSetConcurrency", "getResultSetConcurrency");

        try {
            return this.stmt.getResultSetConcurrency();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public int getResultSetHoldability() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.getResultSetHoldability", "getResultSetHoldability");

        try {
            return this.stmt.getResultSetHoldability();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public int getResultSetType() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.getResultSetType", "getResultSetType");

        try {
            return this.stmt.getResultSetType();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public int getUpdateCount() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.getUpdateCount", "getUpdateCount");

        try {
            return this.stmt.getUpdateCount();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public java.sql.SQLWarning getWarnings() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.getWarnings", "getWarnings");

        try {
            return this.stmt.getWarnings();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public boolean isClosed() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.isClosed", "isClosed");

        try {
            return this.stmt.isClosed();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public boolean isCloseOnCompletion() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.isCloseOnCompletion", "isCloseOnCompletion");

        try {
            return this.stmt.isCloseOnCompletion();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public boolean isPoolable() throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.isPoolable", "isPoolable");

        try {
            return this.stmt.isPoolable();
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void setCursorName(String cursorName) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.setCursorName", "setCursorName");

        try {
            this.stmt.setCursorName(cursorName);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void setEscapeProcessing(boolean enable) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.setEscapeProcessing", "setEscapeProcessing");

        try {
            this.stmt.setEscapeProcessing(enable);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void setFetchDirection(int direction) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.setFetchDirection", "setFetchDirection");

        try {
            this.stmt.setFetchDirection(direction);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void setFetchSize(int rows) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.setFetchSize", "setFetchSize");

        try {
            this.stmt.setFetchSize(rows);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void setMaxFieldSize(int max) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.setMaxFieldSize", "setMaxFieldSize");

        try {
            this.stmt.setMaxFieldSize(max);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void setMaxRows(int max) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.setMaxRows", "setMaxRows");

        try {
            this.stmt.setMaxRows(max);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void setPoolable(boolean poolable) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.setPoolable", "setPoolable");

        try {
            this.stmt.setPoolable(poolable);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public void setQueryTimeout(int seconds) throws SQLException {
        Observability.RoundtripTrackingSpan span = Observability.createRoundtripTrackingSpan("java.sql.Statement.setQueryTimeout", "setQueryTimeout");

        try {
            this.stmt.setQueryTimeout(seconds);
        } catch (Exception e) {
            span.recordException(e);
            throw e;
        } finally {
            span.close();
        }
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return this.stmt.isWrapperFor(iface);
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return this.stmt.unwrap(iface);
    }
}