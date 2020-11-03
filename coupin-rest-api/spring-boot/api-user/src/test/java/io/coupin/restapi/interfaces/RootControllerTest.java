package io.coupin.restapi.interfaces;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class RootControllerTest extends AbstractControllerTest {

  @Autowired
  private RootController controller;

  @Override
  protected Object serveController() {

    return controller;
  }

  @DisplayName( "[GET] /" )
  @Test
  public void helloWorldTest() throws Exception {

    mockMvc.perform(get("/"))
           .andExpect(status().isOk())
           .andExpect(content().string(containsString("\"apiName\":\"coupin-user-api\"")));
  }

  @DisplayName( "[GET] /health-check" )
  @Test
  public void healthCheckTest() throws Exception {

    mockMvc.perform(get("/health-check"))
           .andExpect(status().isOk());
  }

}