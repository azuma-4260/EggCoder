package com.github.azuma4260.model;

import lombok.*;

@Getter
@Builder
public class Operator {
  public static final Operator ANONYMOUS = new Operator("ANONYMOUS");
  private final String code;

  public static Operator fromUser(User user) {
    return Operator.builder().code(user.getId().toString()).build();
  }
}
