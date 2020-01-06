package com.example;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDataSourceTransactionManager extends DataSourceTransactionManager {
    public MyDataSourceTransactionManager(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected void prepareTransactionalConnection(Connection con, TransactionDefinition definition) throws SQLException {
        super.prepareTransactionalConnection(con, definition);
        try (Statement stmt = con.createStatement()) {
            stmt.execute("SET SEARCH_PATH TO hoge");
        }
    }
}
