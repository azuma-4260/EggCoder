package com.github.azuma4260.handler;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.util.StringUtils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@RequiredArgsConstructor
public class UUIDTypeHandler extends BaseTypeHandler<UUID> {

  @Override
  public void setNonNullParameter(PreparedStatement preparedStatement, int i, UUID uuid,
      JdbcType jdbcType) throws SQLException {
    preparedStatement.setObject(i, uuid.toString());
  }

  @Override
  public UUID getNullableResult(ResultSet resultSet, String s) throws SQLException {
    final String uuidString = resultSet.getString(s);
    if (!StringUtils.hasLength(uuidString)) {
      return null;
    }
    return UUID.fromString(uuidString);
  }

  @Override
  public UUID getNullableResult(ResultSet resultSet, int i) throws SQLException {
    final String uuidString = resultSet.getString(i);
    if (!StringUtils.hasLength(uuidString)) {
      return null;
    }
    return UUID.fromString(uuidString);
  }

  @Override
  public UUID getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
    final String uuidString = callableStatement.getString(i);
    if (!StringUtils.hasLength(uuidString)) {
      return null;
    }
    return UUID.fromString(uuidString);
  }
}
