package io.coupin.restapi.interfaces;

import io.coupin.restapi.applications.UserInfoService;
import io.coupin.restapi.domains.UserInfo;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnsignedUserController {

  @Autowired UserInfoService userInfoService;

  @PostMapping( "/users/{id}" )
  public ResponseEntity<?> registerNewUser() throws URISyntaxException {

    UserInfo newUser = UserInfo.builder()
                               .userId( "dev-2020" )
                               .userPw( "P@ssword" )
                               .userEmail( "your@email.com" )
                               .build();

    UserInfo savedUser = userInfoService.insertNewUser( newUser );

    Map<String, Object> body = new HashMap<>();
    body.put( "userNo", savedUser.getUserNo() );
    body.put( "userId", savedUser.getUserId() );
    body.put( "userEmail", savedUser.getUserEmail() );

    return ResponseEntity.created( new URI( "/users/" + savedUser.getUserNo() ) )
                         .body( body );
  }
}
