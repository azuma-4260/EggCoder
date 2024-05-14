package com.github.azuma4260.ltest;

import com.github.azuma4260.controller.entity.CERecord;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

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
  @DisplayName("/api/record/search")
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

  @Test
  @DisplayName("/api/record/add")
  @ExpectedDatabase(value = "/database/result/RecordControllerLTest/add-expected",
      assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
  void create() throws Exception {
    CERecord.Create create =
        CERecord.Create.builder().title("record5").question("question5").userAnswer("user_answer5")
            .modelAnswer("model_answer5").comment("comment5").reviewFlag(Boolean.TRUE).build();

    performPost("/api/record/add", create).andExpect(status().isOk())
        .andExpect(jsonPath("$.succeeded").value("true"));
  }

  @Test
  @DisplayName("/api/record/edit")
  @ExpectedDatabase(value = "/database/result/RecordControllerLTest/edit-expected",
      assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
  void update() throws Exception {
    CERecord.Update update = CERecord.Update.builder().id("b72489d4-7d72-046e-3d65-68ba51ccee91")
        .title("record5").question("question5").userAnswer("user_answer5")
        .modelAnswer("model_answer5").comment("comment5").reviewFlag(Boolean.TRUE).build();

    performPost("/api/record/edit", update).andExpect(status().isOk())
        .andExpect(jsonPath("$.succeeded").value("true"));
  }

  @Test
  @DisplayName("/api/record/remove")
  @ExpectedDatabase(value = "/database/result/RecordControllerLTest/delete-expected",
      assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
  void delete() throws Exception {
    CERecord.Delete delete =
        CERecord.Delete.builder().id("b72489d4-7d72-046e-3d65-68ba51ccee91").build();

    performPost("/api/record/remove", delete).andExpect(status().isOk())
        .andExpect(jsonPath("$.succeeded").value("true"));
  }
}
