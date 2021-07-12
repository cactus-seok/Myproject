package com.myblog.myblogproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MyBlogProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBlogProjectApplication.class, args);
    }

}
