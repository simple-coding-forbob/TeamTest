package egovframework.example.cmmn.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthenticInterceptor extends HandlerInterceptorAdapter {
	
	/**
	 * 세션에 계정정보(Account)가 있는지 여부로 인증 여부를 체크한다.
	 * 계정정보(Account)가 없다면, 로그인 페이지로 이동한다.
	 */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

//    	세션 가져오기: false: 없으면 세션을 만들지 않고 null 리턴
        HttpSession session = request.getSession(false);

        // 1. 로그인 여부 확인
        if (session == null || session.getAttribute("memberVO") == null) {
            response.sendRedirect("/login.do");
            return false;
        }

        // 2. CSRF 토큰 검증 (POST 요청일 때만)
//      CSRF(Cross-Site Request Forgery): 
        if ("POST".equals(request.getMethod())) {
            String sessionToken = (String) session.getAttribute("CSRF_TOKEN");
            String requestToken = request.getParameter("csrf");

            if (sessionToken == null || !sessionToken.equals(requestToken)) {
            	throw new Exception("csrf 위반입니다.");
            }
        }

        // 통과
        return true;
    }
}
