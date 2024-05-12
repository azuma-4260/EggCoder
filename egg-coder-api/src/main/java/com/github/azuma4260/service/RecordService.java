package com.github.azuma4260.service;

import com.github.azuma4260.controller.entity.CERecord;
import com.github.azuma4260.model.Operator;
import com.github.azuma4260.model.Record;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface RecordService {
  Record getByPk(UUID uuid);

  List<Record> search(CERecord.Selector selector);

  int create(Record record, Operator operator);

  int update(Record record, Operator operator);

  int delete(UUID id, Operator operator);
}
