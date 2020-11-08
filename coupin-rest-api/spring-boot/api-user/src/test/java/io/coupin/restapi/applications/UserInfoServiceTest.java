package io.coupin.restapi.applications;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.coupin.restapi.domains.UserInfo;
import io.coupin.restapi.domains.UserInfoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName( "Application > UserInfoServiceTest" )
@ExtendWith( MockitoExtension.class )
class UserInfoServiceTest extends AbstractServiceTest {

  @InjectMocks private UserInfoService userInfoService;

  @Mock private UserInfoRepository mockUserInfoRepository;

  private UserInfo givenUserInfo;

  private UserInfo willUserInfo;

  @Override
  protected void setup() {

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
    BDDMockito.given( mockUserInfoRepository.save( givenUserInfo ) )
              .willReturn( willUserInfo );
  }

  @DisplayName( "Save new user into repository" )
  @Test
  @Order( 1 )
  public void insertNewUserTest() {

    // When
    UserInfo whenUserInfo = userInfoService.insertNewUser( givenUserInfo );

    // Then
    assertEquals( whenUserInfo, willUserInfo );
    assertEquals( whenUserInfo.getUserNo(), willUserInfo.getUserNo() );
    assertEquals( whenUserInfo.getUserId(), willUserInfo.getUserId() );
    assertEquals( whenUserInfo.getUserPw(), willUserInfo.getUserPw() );
    assertEquals( whenUserInfo.getUserEmail(), willUserInfo.getUserEmail() );
  }
}