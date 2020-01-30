package com.masterpiece.securedDataPlatform.services;

import com.masterpiece.securedDataPlatform.dtos.MemberViewDto;

public interface MemberService {
    void create (MemberViewDto dto);

    MemberViewDto getOne(Long id);
}
