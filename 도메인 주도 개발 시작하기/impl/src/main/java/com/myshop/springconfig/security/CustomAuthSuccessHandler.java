package com.myshop.springconfig.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static com.myshop.springconfig.security.WebSecurityConfig.AUTHCOOKIENAME;

public class CustomAuthSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        UserDetails user = (UserDetails) authentication.getPrincipal();
        Cookie authCookie = new Cookie(AUTHCOOKIENAME, URLEncoder.encode(encryptId(user), StandardCharsets.UTF_8));
        authCookie.setPath("/");
        response.addCookie(authCookie);
        response.sendRedirect("/home");
    }

    private String encryptId(UserDetails user) {
        return user.getUsername();
    }
}
