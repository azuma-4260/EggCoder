package com.github.azuma4260.config;

import com.github.springtestdbunit.bean.DatabaseConfigBean;
import com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean;
import javax.sql.DataSource;
import lombok.Setter;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * MySQL Database Config
 */

@Setter
public abstract class AbstractMysqlDatabaseConfig {
  private String driverClassName;
  private String url;
  private String username;
  private String password;

  protected DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(driverClassName);
    dataSource.setUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    return dataSource;
  }

  protected DatabaseDataSourceConnectionFactoryBean dbUnitDatabaseConnection() {
    DatabaseConfigBean bean = new DatabaseConfigBean();
    bean.setDatatypeFactory(new MySqlDataTypeFactory());
    bean.setAllowEmptyFields(true);

    DatabaseDataSourceConnectionFactoryBean dbConnectionFactory =
        new DatabaseDataSourceConnectionFactoryBean(dataSource());
    dbConnectionFactory.setDatabaseConfig(bean);
    return dbConnectionFactory;
  }
}
