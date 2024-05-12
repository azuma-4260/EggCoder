package com.github.azuma4260.service;

import com.github.azuma4260.controller.entity.CERecord;
import com.github.azuma4260.mapper.RecordMapper;
import com.github.azuma4260.model.Operator;
import com.github.azuma4260.model.Record;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RecordServiceImpl implements RecordService {
  private final RecordMapper recordMapper;

  @Override
  public Record getByPk(UUID uuid) {
    return recordMapper.selectByPk(uuid);
  }

  @Override
  public List<Record> search(CERecord.Selector selector) {
    return recordMapper.search(selector);
  }

  @Override
  public int create(Record record, Operator operator) {
    return recordMapper.insert(record, operator);
  }

  @Override
  public int update(Record record, Operator operator) {
    return recordMapper.update(record, operator);
  }

  @Override
  public int delete(UUID id, Operator operator) {
    return recordMapper.delete(id, operator);
  }
}
