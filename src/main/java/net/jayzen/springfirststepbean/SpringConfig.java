package net.jayzen.springfirststepbean;

import net.jayzen.springfirststepbean.repository.MemberRepository;
import net.jayzen.springfirststepbean.repository.MemberRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberRepository memMemberRepository() {
        return new MemberRepositoryImpl();
    }
}
