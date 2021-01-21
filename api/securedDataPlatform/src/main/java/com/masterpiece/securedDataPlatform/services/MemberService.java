package com.masterpiece.securedDataPlatform.services;

import com.masterpiece.securedDataPlatform.dtos.MemberViewDto;
import com.masterpiece.securedDataPlatform.entities.Member;

public interface MemberService {
    void create (MemberViewDto dto);

    Member getOne(Long id);

}
