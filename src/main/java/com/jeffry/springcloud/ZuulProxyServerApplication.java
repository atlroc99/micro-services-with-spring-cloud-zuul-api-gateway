package com.jeffry.springcloud;

import com.jeffry.springcloud.filters.CustomFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulProxyServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulProxyServerApplication.class, args);
    }

    @Bean
    public CustomFilter getFilter() {
        return new CustomFilter();
    }

}
