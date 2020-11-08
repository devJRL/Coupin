package io.coupin.restapi.domains;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {

  UserInfo findByUserId( String userId );

  UserInfo findByUserEmail( String userEmail );

  UserInfo save( UserInfo userInfo );

}
