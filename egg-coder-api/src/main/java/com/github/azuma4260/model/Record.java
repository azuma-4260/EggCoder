package com.github.azuma4260.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Record {
  private UUID id;
  private String title;
  private String question;
  private String userAnswer;
  private String modelAnswer;
  private String comment;
  private Boolean reviewFlag;
}
