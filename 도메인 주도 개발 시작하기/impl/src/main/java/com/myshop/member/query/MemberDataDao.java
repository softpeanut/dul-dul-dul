package com.myshop.member.query;

import org.springframework.data.repository.Repository;

public interface MemberDataDao extends Repository<MemberData, String> {

    MemberData findById(String memberId);
}
