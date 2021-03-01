package com.masterpiece.securedDataPlatform.repositories;

import com.masterpiece.securedDataPlatform.dtos.DocumentDto;
import com.masterpiece.securedDataPlatform.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member getById (Long id);

}
