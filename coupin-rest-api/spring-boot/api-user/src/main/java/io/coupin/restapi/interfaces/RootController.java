package io.coupin.restapi.interfaces;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

  @GetMapping( "/" )
  public ResponseEntity<?> apiName() {

    Map<String, Object> jsonMap = new HashMap<>();
    jsonMap.put( "apiName", "coupin-user-api" );

    return ResponseEntity.ok( jsonMap );
  }

  @RequestMapping( method = RequestMethod.HEAD, value = "/health-check" )
  public ResponseEntity<?> healthCheck() {

    return ResponseEntity.ok( 200 );
  }

}
