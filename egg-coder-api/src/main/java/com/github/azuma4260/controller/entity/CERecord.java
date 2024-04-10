package com.github.azuma4260.controller.entity;

import com.github.azuma4260.model.Record;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.UUID;


public class CERecord {
  // Request
  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Id {
    @NotNull
    private String id;
  }

  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Selector {
    private Integer limit;
    private Integer offset;
  }

  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Create {
    @NotNull
    private String title;
    @NotNull
    private String question;
    private String userAnswer;
    private String modelAnswer;
    private String comment;
    private Boolean reviewFlag;

    public Record toRecord() {
      return Record.builder().id(UUID.randomUUID()).title(title).question(question)
          .userAnswer(userAnswer).modelAnswer(modelAnswer).comment(comment).reviewFlag(reviewFlag)
          .build();
    }
  }

  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Update {
    @NotNull
    private String id;
    @NotNull
    private String title;
    @NotNull
    private String question;
    private String userAnswer;
    private String modelAnswer;
    private String comment;
    private Boolean reviewFlag;

    public Record toRecord() {
      return Record.builder().id(UUID.fromString(id)).title(title).question(question)
          .userAnswer(userAnswer).modelAnswer(modelAnswer).comment(comment).reviewFlag(reviewFlag)
          .build();
    }
  }

  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Delete {
    @NotNull
    private String id;
  }

  // Response
  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Entity {
    @NotNull
    private String id;
    @NotNull
    private String title;
    @NotNull
    private String question;
    private String userAnswer;
    private String modelAnswer;
    private String comment;
    private Boolean reviewFlag;

    public static Entity from(Record record) {
      return Entity.builder().id(record.getId()).title(record.getTitle())
          .question(record.getQuestion()).userAnswer(record.getUserAnswer())
          .modelAnswer(record.getModelAnswer()).comment(record.getComment())
          .reviewFlag(record.getReviewFlag()).build();
    }
  }


  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Result {
    private Boolean succeeded;
  }
}
