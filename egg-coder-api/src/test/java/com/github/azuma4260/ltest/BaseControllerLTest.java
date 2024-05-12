package com.github.azuma4260.ltest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.azuma4260.config.CsvDataSetLoader;
import com.github.azuma4260.config.DataSourceKeys;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseSetups;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

@ActiveProfiles("test")
@SpringBootTest
@DbUnitConfiguration(databaseConnection = DataSourceKeys.EGG_CODER,
    dataSetLoader = CsvDataSetLoader.class)
@DatabaseSetups({@DatabaseSetup(value = "/database/init/egg_coder",
    type = DatabaseOperation.CLEAN_INSERT, connection = DataSourceKeys.EGG_CODER)})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
    TransactionDbUnitTestExecutionListener.class})
public abstract class BaseControllerLTest {
  @Autowired
  private WebApplicationContext context;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private UserDetailsService userDetailsService;

  private MockMvc mockMvc;

  private UserDetails userDetails;

  void setController() {
    userDetails = userDetailsService.loadUserByUsername("Manager1");
    mockMvc = MockMvcBuilders.webAppContextSetup(context)
        .apply(SecurityMockMvcConfigurers.springSecurity()).build();
  }

  protected ResultActions performPost(String path) throws Exception {
    return performPost(path, "", MediaType.TEXT_PLAIN);
  }

  protected ResultActions performPost(String path, Object request) throws Exception {
    String json = objectMapper.writeValueAsString(request);
    return performPost(path, json, MediaType.APPLICATION_JSON);
  }

  protected ResultActions performPost(String path, String content, MediaType mediaType)
      throws Exception {
    return mockMvc.perform(MockMvcRequestBuilders.post(path).contentType(mediaType).content(content)
        .with(csrf()).with(user(userDetails)));

  }
}
