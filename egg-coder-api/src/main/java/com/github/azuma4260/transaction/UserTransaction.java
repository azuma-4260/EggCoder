package com.github.azuma4260.transaction;

import com.github.azuma4260.model.User;
import org.springframework.stereotype.Service;

public interface UserTransaction {
  User getByName(String username);
}
