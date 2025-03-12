package net.jayzen.springfirststepbean;

import net.jayzen.springfirststepbean.domain.Member;
import net.jayzen.springfirststepbean.repository.MemberRepository;
import net.jayzen.springfirststepbean.repository.MemberRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TestSpringConfig {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext
                        (SpringConfig.class);

        MemberRepository memberRepository =
                context.getBean
                        (MemberRepository.class);

        Member member = new Member(null,
                "드!",
                "라!",
                "군!",
                LocalDateTime.now(),
                LocalDateTime.now());
        System.out.println(member);
        member = memberRepository.save(member);
        System.out.println(member);
    }
}
