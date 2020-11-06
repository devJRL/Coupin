package io.coupin.restapi.interfaces;

import io.coupin.restapi.domains.UserInfo;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnsignedUserController {

  @PostMapping( "/users/{id}" )
  public ResponseEntity<?> registerNewUser() throws URISyntaxException {

    UserInfo userInfo = UserInfo.builder()
                                .userNo( 99 )
                                .userId( "dev-2020" )
                                .userPw( "P@ssword" )
                                .userEmail( "your@email.com" )
                                .build();

    Map<String, Object> body = new HashMap<>();
    body.put( "userNo", userInfo.getUserNo() );
    body.put( "userId", userInfo.getUserId() );
    body.put( "userEmail", userInfo.getUserEmail() );

    return ResponseEntity.created( new URI( "/users/" + 99 ) )
                         .body( body );
  }
}
