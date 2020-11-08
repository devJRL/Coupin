package io.coupin.restapi.applications;

import io.coupin.restapi.domains.UserInfo;
import io.coupin.restapi.domains.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

  @Autowired private UserInfoRepository userInfoRepository;

  public UserInfo insertNewUser( UserInfo newUser ) {

    return userInfoRepository.save( newUser );
  }
}
