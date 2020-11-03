package io.coupin.restapi.interfaces;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

  @GetMapping( "/" )
  public Map<String, Object> helloWorld() {

    Map<String, Object> jsonMap = new HashMap<>();
    jsonMap.put("apiName", "coupin-user-api");

    return jsonMap;
  }

  @GetMapping( "/health-check" )
  public ResponseEntity<?> healthCheck() {

    return ResponseEntity.ok(200);
  }

}
