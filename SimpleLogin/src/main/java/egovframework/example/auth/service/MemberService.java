package egovframework.example.auth.service;

public interface MemberService {
	
	public MemberVO authenticateMember(MemberVO loginVO) throws Exception;	
	
	public void registerMember(MemberVO memberVO) throws Exception;
}
