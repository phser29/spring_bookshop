package org.zerock.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.zerock.model.MemberVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class AdminInterceptor implements HandlerInterceptor {
	
	@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			
			HttpSession session = request.getSession();
			
			MemberVO lvo = (MemberVO)session.getAttribute("member");
			
			if(lvo == null || lvo.getAdminCk() == 0) {
				response.sendRedirect("/main");
				return false;
			}
		
			return true;
		}
}
