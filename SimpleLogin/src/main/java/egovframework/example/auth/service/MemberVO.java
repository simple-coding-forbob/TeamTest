package egovframework.example.auth.service;

import egovframework.example.common.Criteria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO extends Criteria {
    private String email;    // 기본키, 로그인 id
    private String password; // 암호
    private String name;     // 유저명
}
