package com.juliusyolo.yoho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableWebFlux
@EnableMethodSecurity
public class YohoApplication {

    public static void main(String[] args) {
        SpringApplication.run(YohoApplication.class, args);
    }

}
