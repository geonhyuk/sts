package org.spring.samlpe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

/*
 * 의존성 주입 방법
 * setter 주입
 * 생성자 주입
 * 필드 주입
 * 최근 가장 핫한 방법 final 사용
 */

@Component
@Data
@ToString
public class Restaurant {
    @Autowired
    private Chef chef;
}