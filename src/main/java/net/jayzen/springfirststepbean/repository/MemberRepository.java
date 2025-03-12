package net.jayzen.springfirststepbean.repository;

import net.jayzen.springfirststepbean.domain.Member;

import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(long id);
    Optional<Member> findByUsername(String username);
}
