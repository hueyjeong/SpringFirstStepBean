package net.jayzen.springfirststepbean.repository;

import net.jayzen.springfirststepbean.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
    private final Map<Long, Member> members;
    private final AtomicLong sequence;

    public MemberRepositoryImpl() {
        this.members = new ConcurrentHashMap<>();
        this.sequence = new AtomicLong();
    }

    @Override
    public Member save(Member member) {
        member.setId(sequence.addAndGet(1));
        members.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(long id) {
        return Optional.of(members.get(id));
    }

    @Override
    public Optional<Member> findByUsername(String username) {
        return members.values().stream().filter((Member member) -> member.getUsername().equals(username)).findAny();
    }
}
