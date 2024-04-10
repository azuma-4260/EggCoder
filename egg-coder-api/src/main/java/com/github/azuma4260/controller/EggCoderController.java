package com.github.azuma4260.controller;

import com.github.azuma4260.model.Operator;
import com.github.azuma4260.model.User;
import com.github.azuma4260.transaction.UserTransaction;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;

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
    User loginUser = userTransaction.getByName(((UserDetails) principal).getUsername());
    return Operator.fromUser(loginUser);
  }
}
