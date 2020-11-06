package io.coupin.restapi.interfaces;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.head;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;

@DisplayName( "Interfaces > RootControllerTest" )
@TestMethodOrder( OrderAnnotation.class )
class RootControllerTest extends AbstractControllerTest {

  @Autowired private RootController controller;

  @Override
  protected Object serveController() { return controller; }

  @Override
  protected void setupBeforeEach() {}

  @DisplayName( "[GET] '/'" )
  @Test
  @Order( 1 )
  public void apiNameTest() throws Exception {

    mockMvc.perform( get( "/" ) )
           .andExpect( status().isOk() )
           .andExpect( content().string( containsString( "\"apiName\":\"coupin-user-api\"" ) ) );
  }

  @DisplayName( "[HEAD] '/health-check'" )
  @Test
  @Order( 2 )
  public void healthCheckTest() throws Exception {

    mockMvc.perform( head( "/health-check" ) )
           .andExpect( status().isOk() );
  }

}