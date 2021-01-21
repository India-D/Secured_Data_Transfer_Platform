package com.masterpiece.securedDataPlatform.services;

import com.masterpiece.securedDataPlatform.dtos.MemberViewDto;
import com.masterpiece.securedDataPlatform.entities.Member;
import com.masterpiece.securedDataPlatform.repositories.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;


    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void create(MemberViewDto dto) {
        Member member = new Member();
        populateAndSave(dto,member);
    }

    @Override
    public Member getOne(Long id) {
        return memberRepository.getById(id);
    }

    private void populateAndSave(MemberViewDto dto, Member member){
        member.setFirstName(dto.getFirstName());
        member.setLastName(dto.getLastName());
        member.setEmail(dto.getEmail());
        member.setPassword(dto.getPassword());
        member.setUsername(dto.getEmail());
        memberRepository.save(member);
    }
}
