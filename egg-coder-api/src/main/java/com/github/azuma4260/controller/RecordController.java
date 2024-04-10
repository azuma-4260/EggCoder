package com.github.azuma4260.controller;

import com.github.azuma4260.controller.entity.CERecord.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface RecordController {
  String PATH = "/record";

  @PostMapping(PATH + "/getByPk")
  Entity get(@RequestBody Id id);

  @PostMapping(PATH + "/search")
  List<Entity> search(@RequestBody Selector selector);

  @PostMapping(PATH + "/add")
  Result add(@RequestBody Create create);

  @PostMapping(PATH + "/edit")
  Result edit(@RequestBody Update update);

  @PostMapping(PATH + "/remove")
  Result remove(@RequestBody Delete delete);
}
