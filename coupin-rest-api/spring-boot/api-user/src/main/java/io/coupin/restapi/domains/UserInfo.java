package io.coupin.restapi.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@Entity
public class UserInfo {

  @Id
  @GeneratedValue( strategy = GenerationType.AUTO )
  private long userNo;

  private String userId;

  @Setter
  private String userPw;

  @Setter
  private String userEmail;

  @Override
  public String toString() {

    return String.format( "UserInfo > userNo(%d), userId(%s), userEmail(%s)",
                          userNo, userId, userEmail );
  }
}
