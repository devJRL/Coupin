package io.coupin.restapi.interfaces;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.coupin.restapi.domains.UserInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@DisplayName( "Interfaces > UnsignedUserControllerTest" )
@TestMethodOrder( OrderAnnotation.class )
class UnsignedUserControllerTest extends AbstractControllerTest {

  private UserInfo userInfo;

  @Autowired private UnsignedUserController controller;

  @Override
  protected Object serveController() { return controller; }

  @Override
  protected void setupBeforeEach() {

    userInfo = UserInfo.builder()
                       .userNo( 99 )
                       .userId( "dev-2020" )
                       .userPw( "P@ssword" )
                       .userEmail( "your@email.com" )
                       .build();
  }

  @DisplayName( "register > [POST] '/users/{id}'" )
  @Test
  @Order( 3 )
  public void registerNewUserTest() throws Exception {

    MultiValueMap<String, String> payload = new LinkedMultiValueMap<>();
    payload.add( "userPw", userInfo.getUserPw() );
    payload.add( "userEmail", userInfo.getUserEmail() );

    mockMvc.perform( post( "/users/" + userInfo.getUserId() ).params( payload ) )
           .andExpect( status().isCreated() )
           .andExpect( content().string( containsString( "\"userNo\":" + userInfo.getUserNo() ) ) )
           .andExpect( content().string( containsString( "\"userId\":\"" + userInfo.getUserId() + "\"" ) ) )
           .andExpect( content().string( containsString( "\"userEmail\":\"" + userInfo.getUserEmail() + "\"" ) ) );
  }

}