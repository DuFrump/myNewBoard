package com.example.newboard.web.exception;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "잘못된 요청입니다: " + e.getMessage());
        return "redirect:/articles"; // 에러 발생 시 목록 페이지로 리다이렉트
    }

    @ExceptionHandler(AccessDeniedException.class)
    public String handleAccessDeniedException(AccessDeniedException e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "접근 권한이 없습니다: " + e.getMessage());
        return "redirect:/articles"; // 권한 없음 시 목록 페이지로 리다이렉트
    }

    // 다른 모든 예외를 처리
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        model.addAttribute("error", "알 수 없는 오류가 발생했습니다: " + e.getMessage());
        return "error"; // templates/error.html 뷰를 생성해야 합니다.
    }
}