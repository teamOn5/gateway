package com.teamon5.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthController {

    // ALB 타겟 그룹 헬스 체크용 루트 엔드포인트
    @GetMapping("/")
    public Mono<Map<String, Object>> rootHealth() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("service", "api-gateway");
        response.put("message", "Spring Cloud Gateway is running healthy!");
        response.put("timestamp", System.currentTimeMillis());
        return Mono.just(response);
    }
}
