package com.quebecwhisky;

import java.sql.Connection;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.XmlDataSet;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.context.transaction.BeforeTransaction;

public abstract class AbstractSpringDBUnitTest {

	@Autowired
	protected DataSource mDataSource;

	protected abstract Resource getTestDataResource();

	@BeforeTransaction
	public void populateDB() throws Exception {
		Connection jdbcConnection = mDataSource.getConnection();
		try {

			IDatabaseConnection connection = new DatabaseConnection(
					jdbcConnection);
			DatabaseConfig config = connection.getConfig();
			config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY,
			//		new HsqldbDataTypeFactory());
					new H2DataTypeFactory());
			DatabaseOperation.CLEAN_INSERT.execute(connection, new XmlDataSet(
					getTestDataResource().getInputStream()));
		} finally {
			DataSourceUtils.releaseConnection(jdbcConnection, mDataSource);
		}
	}

}
