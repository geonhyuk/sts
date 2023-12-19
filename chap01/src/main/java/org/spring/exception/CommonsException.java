package org.spring.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.http.HttpStatus;
import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Log4j
public class CommonsException {
	
    // NoHandlerFoundException을 처리하는 메서드
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle404(NoHandlerFoundException ex, Model model) {
        // 로그에 404 Not Found 에러를 기록
        log.error("404 Not Found", ex);
        
        // 모델에 에러 메시지와 예외 객체를 추가
        model.addAttribute("error", "404 Not Found");
        model.addAttribute("e", ex);
        
        // "error" 뷰를 반환
        return "error";	
    }
    
    // 일반적인 예외를 처리하는 메서드
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        // 로그에 예외 정보를 기록
        log.error("Exception", e);
        
        // 모델에 에러 메시지와 예외 객체를 추가
        model.addAttribute("error", "Internal Server Error");
        model.addAttribute("e", e);
        
        // "error" 뷰를 반환
        return "error";
    }
}
