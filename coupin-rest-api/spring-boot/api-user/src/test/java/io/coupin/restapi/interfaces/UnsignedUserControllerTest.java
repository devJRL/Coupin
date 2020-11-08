package io.coupin.restapi.interfaces;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.coupin.restapi.applications.UserInfoService;
import io.coupin.restapi.domains.UserInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@DisplayName( "Interfaces > UnsignedUserControllerTest" )
@TestMethodOrder( OrderAnnotation.class )
class UnsignedUserControllerTest extends AbstractControllerTest {

  @Autowired private UnsignedUserController controller;

  @Mock private UserInfoService userInfoService;

  private UserInfo givenUserInfo;

  private UserInfo willUserInfo;

  @Override
  protected Object serveController() { return controller; }

  @Override
  protected void setupBeforeEach() {

    givenUserInfo = UserInfo.builder()
                            .userId( "dev-2020" )
                            .userPw( "P@ssword" )
                            .userEmail( "your@email.com" )
                            .build();

    willUserInfo = UserInfo.builder()
                           .userNo( 9988 )
                           .userId( givenUserInfo.getUserId() )
                           .userPw( givenUserInfo.getUserPw() )
                           .userEmail( givenUserInfo.getUserEmail() )
                           .build();

    // Given
    BDDMockito.given( userInfoService.insertNewUser( givenUserInfo ) )
              .willReturn( willUserInfo );
  }

  @DisplayName( "register > [POST] '/users/{id}'" )
  @Test
  @Order( 3 )
  public void registerNewUserTest() throws Exception {

    MultiValueMap<String, String> payload = new LinkedMultiValueMap<>();
    payload.add( "userPw", givenUserInfo.getUserPw() );
    payload.add( "userEmail", givenUserInfo.getUserEmail() );

    mockMvc.perform( post( "/users/" + givenUserInfo.getUserId() ).params( payload ) )
           .andExpect( status().isCreated() )
           .andExpect( content().string( containsString( "\"userNo\":" + willUserInfo.getUserNo() ) ) )
           .andExpect( content().string( containsString( "\"userId\":\"" + willUserInfo.getUserId() + "\"" ) ) )
           .andExpect( content().string( containsString( "\"userEmail\":\"" + willUserInfo.getUserEmail() + "\"" ) ) );
  }

}