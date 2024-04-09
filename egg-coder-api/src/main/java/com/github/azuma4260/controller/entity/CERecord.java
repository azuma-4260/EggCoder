package com.github.azuma4260.controller.entity;

import lombok.*;

import javax.validation.constraints.NotNull;


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
  }


  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Result {
    private Boolean succeeded;
  }
}
