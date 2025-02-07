package com.example.schedulejpa.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

@Slf4j
public class LoginFilter implements Filter {

    private static final String[] WHITE_LIST = {"/users/signin", "/users/login"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        HttpServletResponse httpServletResponse =(HttpServletResponse) response;

        log.info("로그인 필터를 실행합니다.");

        if (!isWhiteList(requestURI)) {
            HttpSession session = httpRequest.getSession(false);

            // 로그인을 하지않은 사용자인 경우

            if (session == null || session.getAttribute("sessionKey") == null){
                throw new RuntimeException("로그인을 해야합니다.");
            }

            log.info("로그인을 성공했습니다.");
        }

        chain.doFilter(request, response);
    }

    private boolean isWhiteList(String requestURI) {
        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }


}




