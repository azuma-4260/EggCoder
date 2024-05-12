package com.github.azuma4260.transaction;

import com.github.azuma4260.controller.entity.CERecord.*;
import com.github.azuma4260.model.Operator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Transactional(rollbackFor = Exception.class)
public interface RecordTransaction {
  Entity getByPk(UUID uuid);

  List<Entity> search(Selector selector);

  Result create(Create create, Operator operator);

  Result update(Update update, Operator operator);

  Result delete(Delete delete, Operator operator);
}
