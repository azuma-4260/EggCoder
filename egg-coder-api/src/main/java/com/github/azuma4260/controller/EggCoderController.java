package com.github.azuma4260.controller;

import com.github.azuma4260.model.Operator;
import com.github.azuma4260.model.User;
import com.github.azuma4260.transaction.UserTransaction;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RequestMapping("/api")
public abstract class EggCoderController {
  private UserTransaction userTransaction;

  public Operator getOperator() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication == null || !authentication.isAuthenticated()
        || authentication.getPrincipal() == null) {
      return Operator.ANONYMOUS;
    }

    Object principal = authentication.getPrincipal();
    // FIXME: loginUserを取得する処理を実装する
    // User loginUser = userTransaction.getByName(((UserDetails) principal).getUsername());
    User loginUser =
        User.builder().id(UUID.fromString("670254d1-70ec-1491-9a1f-92716f62f1dc")).build();
    return Operator.fromUser(loginUser);
  }
}
