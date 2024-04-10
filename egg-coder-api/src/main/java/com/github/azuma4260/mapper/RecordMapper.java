package com.github.azuma4260.mapper;


import com.github.azuma4260.controller.entity.CERecord;
import com.github.azuma4260.model.Operator;
import com.github.azuma4260.model.Record;

import java.util.List;
import java.util.UUID;

public interface RecordMapper {
  Record selectByPk(UUID id);

  List<Record> search(CERecord.Selector selector);

  int insert(Record record, Operator operator);

  int update(Record record, Operator operator);

  int delete(UUID id, Operator operator);
}
