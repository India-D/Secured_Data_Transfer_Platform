package com.masterpiece.securedDataPlatform.services;

import com.masterpiece.securedDataPlatform.dtos.DocumentDto;
import com.masterpiece.securedDataPlatform.dtos.MemberViewDto;
import com.masterpiece.securedDataPlatform.entities.Document;
import com.masterpiece.securedDataPlatform.entities.Member;
import com.masterpiece.securedDataPlatform.repositories.DocumentRepository;
import com.masterpiece.securedDataPlatform.repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    private final DocumentRepository documentRepository;
    private final MemberRepository memberRepository;
    private final DocumentServiceImpl documentService;

    public MemberServiceImpl(MemberRepository memberRepository, DocumentRepository documentRepository, DocumentServiceImpl documentService) {
        this.documentRepository = documentRepository;
        this.memberRepository = memberRepository;
        this.documentService = documentService;
    }

    @Override
    public void create(MemberViewDto dto) {
        Member member = new Member();
        populateAndSave(dto, member);
        checkAccount(member.getEmail(), member);
        System.out.println("success or not");
    }

    @Override
    public Member getOne(Long id) {
        return memberRepository.getById(id);
    }


    @Override
    public void update(Long id, MemberViewDto dto) {
        Member member = memberRepository.findById(id).get();
        populateAndSave(dto, member);
    }

    //check if the memberRecipient have an account
    //if not create the account and upload the files
    public List<Document> checkAccount(String email, Member member) {
        List<Document> documents = documentRepository.getByMemberRecipientEmail(email);
       for (Document document : documents){
           documentService.update(member,document);
       }

        return documents;
    }

    private void populateAndSave(MemberViewDto dto, Member member) {
        member.setFirstName(dto.getFirstName());
        member.setLastName(dto.getLastName());
        member.setEmail(dto.getEmail());
        member.setPassword(dto.getPassword());
        member.setUsername(dto.getEmail());
        memberRepository.save(member);
    }
}
