package egovframework.example.auth.service.impl;

import java.util.Locale;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.auth.service.MemberService;
import egovframework.example.auth.service.MemberVO;

@Service
public class MemberServiceImpl extends EgovAbstractServiceImpl  implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

	@Override
	public MemberVO authenticateMember(MemberVO loginVO) throws Exception {
		//
//	사용자 있는지 DB 조회 
		MemberVO memberVO = memberMapper.authenticate(loginVO);

//    	회원이 없으면
    	if(memberVO == null) throw processException("errors.login");
    	
//	회원이 있으면 암호 체크
		if (memberVO != null) {
//    	TODO: 암호화 Bcryt , DB 암호와 입력암호가 같은지 비교
			boolean isMatchedPassword = BCrypt.checkpw(loginVO.getPassword(), memberVO.getPassword());

			if (isMatchedPassword == false) throw processException("errors.login");
		}

		return memberVO;
	}

	@Override
	public void registerMember(MemberVO memberVO) throws Exception {
//		사용자 있는지 DB 조회 
		MemberVO cmemberVO = memberMapper.authenticate(memberVO);

//	    	회원이 있으면
    	if(cmemberVO != null) throw processException("errors.register");
	    	
//    	TODO: 암호화 Bcryt(salting 난수화 알고리즘 적용: 레인보우테이블 해킹공격 방어), 암호는 해싱(암호화)해서 DB 에 저장함.
    	String hashedPassword = BCrypt.hashpw(memberVO.getPassword(), BCrypt.gensalt());
    	memberVO.setPassword(hashedPassword);
		
		memberMapper.register(memberVO);
	}

}
 