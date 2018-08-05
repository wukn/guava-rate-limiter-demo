package io.github.wukn.demo;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GuavaRateLimiterDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuavaRateLimiterDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ApplicationContext ctx) {
        return args -> {
            limit();
        };
    }


    public void limit() {
        // 每秒向桶中放入5个Token
        final RateLimiter limiter = RateLimiter.create(5);

        for (int i = 0; i < 10; i++) {
            // 从桶中获取1个Token
            double waitTime = limiter.acquire();
            System.out.println(waitTime);
        }
    }
}
