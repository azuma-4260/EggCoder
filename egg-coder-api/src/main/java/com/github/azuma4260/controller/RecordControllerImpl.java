package com.github.azuma4260.controller;

import com.github.azuma4260.controller.entity.CERecord.*;
import com.github.azuma4260.transaction.RecordTransaction;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class RecordControllerImpl extends EggCoderController implements RecordController {
  private final RecordTransaction recordTransaction;

  @Override
  public Entity get(Id id) {
    return recordTransaction.getByPk(UUID.fromString(id.getId()));
  }

  @Override
  public List<Entity> search(Selector selector) {
    return recordTransaction.search(selector);
  }

  @Override
  public Result add(Create create) {
    return recordTransaction.create(create, getOperator());
  }

  @Override
  public Result edit(Update update) {
    return recordTransaction.update(update, getOperator());
  }

  @Override
  public Result remove(Delete delete) {
    return recordTransaction.delete(delete, getOperator());
  }
}
