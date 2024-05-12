package com.github.azuma4260.ltest;

import com.github.azuma4260.controller.entity.CERecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RecordControllerImplLTest extends BaseControllerLTest {
  @BeforeEach
  void setUp() {
    setController();
  }

  @Test
  @DisplayName("/api/record/getByPk")
  void getByPk() throws Exception {
    CERecord.Id id = CERecord.Id.builder().id("b72489d4-7d72-046e-3d65-68ba51ccee91").build();

    performPost("/api/record/getByPk", id).andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value("b72489d4-7d72-046e-3d65-68ba51ccee91"))
        .andExpect(jsonPath("$.title").value("record3"))
        .andExpect(jsonPath("$.question").value("question3"))
        .andExpect(jsonPath("$.userAnswer").value("user_answer3"))
        .andExpect(jsonPath("$.modelAnswer").value("model_answer3"))
        .andExpect(jsonPath("$.comment").value("comment3"))
        .andExpect(jsonPath("$.reviewFlag").value("false"));
  }

  @Test
  @DisplayName("/api/record/search[正常系]")
  void search() throws Exception {
    CERecord.Selector selector = CERecord.Selector.builder().limit(2).offset(1).build();

    performPost("/api/record/search", selector).andExpect(status().isOk())
        .andExpect(jsonPath("$[0].id").value("b72489d4-7d72-046e-3d65-68ba51ccee91"))
        .andExpect(jsonPath("$[0].title").value("record3"))
        .andExpect(jsonPath("$[0].question").value("question3"))
        .andExpect(jsonPath("$[0].userAnswer").value("user_answer3"))
        .andExpect(jsonPath("$[0].modelAnswer").value("model_answer3"))
        .andExpect(jsonPath("$[0].comment").value("comment3"))
        .andExpect(jsonPath("$[0].reviewFlag").value("false"))
        .andExpect(jsonPath("$[1].id").value("5b6d031c-043c-f086-0dc1-97d141776bfb"))
        .andExpect(jsonPath("$[1].title").value("record2"))
        .andExpect(jsonPath("$[1].question").value("question2"))
        .andExpect(jsonPath("$[1].userAnswer").value("user_answer2"))
        .andExpect(jsonPath("$[1].modelAnswer").value("model_answer2"))
        .andExpect(jsonPath("$[1].comment").value("comment2"))
        .andExpect(jsonPath("$[1].reviewFlag").value("false"));
  }
}
