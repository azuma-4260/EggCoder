package com.github.azuma4260.config;

import com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.datasource.eggcoder")
public class EggCoderDatabaseConfig extends AbstractMysqlDatabaseConfig {
  @Primary
  @Bean(DataSourceKeys.EGG_CODER)
  public DatabaseDataSourceConnectionFactoryBean dbUnitDatabaseConnection() {
    return super.dbUnitDatabaseConnection();
  }
}
