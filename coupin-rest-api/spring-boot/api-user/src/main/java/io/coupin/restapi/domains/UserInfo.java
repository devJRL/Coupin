package io.coupin.restapi.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class UserInfo {

  @NonNull private final long userNo;

  @NonNull private final String userId;

  @NonNull private String userPw;

  @NonNull private String userEmail;

}
