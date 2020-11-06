package io.coupin.restapi.applications;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.coupin.restapi.domains.UserInfo;
import io.coupin.restapi.domains.UserInfoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;

@DisplayName( "Application > UserInfoServiceTest" )
class UserInfoServiceTest extends AbstractServiceTest {

  @Mock private UserInfoRepository mockUserInfoRepository;

  private UserInfo inputUserInfo;

  private UserInfo outputUserInfo;

  @Override
  protected void setMocks() {

    inputUserInfo = UserInfo.builder()
                            .userId( "dev-2020" )
                            .userPw( "P@ssword" )
                            .userEmail( "your@email.com" )
                            .build();

    outputUserInfo = UserInfo.builder()
                             .userNo( 99 )
                             .userId( inputUserInfo.getUserId() )
                             .userPw( inputUserInfo.getUserPw() )
                             .userEmail( inputUserInfo.getUserEmail() )
                             .build();

    BDDMockito.given( mockUserInfoRepository.save( inputUserInfo ) )
              .willReturn( outputUserInfo );
  }

  @DisplayName( "Save new user into repository" )
  @Test
  @Order( 1 )
  public void insertNewUserTest() {

    assertEquals( mockUserInfoRepository.save( inputUserInfo ).getUserNo(),
                  outputUserInfo.getUserNo() );
  }
}