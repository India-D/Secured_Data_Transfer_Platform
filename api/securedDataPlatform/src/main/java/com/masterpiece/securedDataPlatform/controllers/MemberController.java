package com.masterpiece.securedDataPlatform.controllers;

import com.masterpiece.securedDataPlatform.dtos.MemberViewDto;
import com.masterpiece.securedDataPlatform.services.MemberService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/members")
@CrossOrigin
public class MemberController {

    private final MemberService memberService;


    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    protected void create(@Valid @RequestBody MemberViewDto dto){
        memberService.create(dto);
    }
    /*
    @GetMapping({"/all}")
    protected MemberViewDto getAll(){
         List<MemberViewDto> members = memberService.getAll();
    return members;
    }
    /*
    @GetMapping("{/id}")
    protected  MemberViewDto getOne(@PathVariable("id") Long id){
        return memberService.getOne(id);
    }
     */
}