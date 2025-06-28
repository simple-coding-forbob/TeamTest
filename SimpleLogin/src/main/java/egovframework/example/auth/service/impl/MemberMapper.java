package egovframework.example.auth.service.impl;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.example.auth.service.MemberVO;

@Mapper
public interface MemberMapper {

	public MemberVO authenticate(MemberVO memberVO);
	
    public void register(MemberVO memberVO);
}
