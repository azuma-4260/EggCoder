package com.github.azuma4260.transaction;

import com.github.azuma4260.controller.entity.CERecord;
import com.github.azuma4260.model.Operator;
import com.github.azuma4260.service.RecordService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class RecordTransactionImpl implements RecordTransaction {
  private final RecordService recordService;

  @Override
  public CERecord.Entity getByPk(UUID uuid) {
    return CERecord.Entity.from(recordService.getByPk(uuid));
  }

  @Override
  public List<CERecord.Entity> search(CERecord.Selector selector) {
    return recordService.search(selector).stream().map(CERecord.Entity::from).toList();
  }

  @Override
  public CERecord.Result create(CERecord.Create create, Operator operator) {
    int result = recordService.create(create.toRecord(), operator);
    return CERecord.Result.builder().succeeded(result > 0).build();
  }

  @Override
  public CERecord.Result update(CERecord.Update update, Operator operator) {
    int result = recordService.update(update.toRecord(), operator);
    return CERecord.Result.builder().succeeded(result > 0).build();
  }

  @Override
  public CERecord.Result delete(CERecord.Delete delete, Operator operator) {
    int result = recordService.delete(UUID.fromString(delete.getId()), operator);
    return CERecord.Result.builder().succeeded(result > 0).build();
  }
}
