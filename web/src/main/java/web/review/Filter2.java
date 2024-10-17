package web.review;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebFilter("*.do")
public class Filter2 implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
	
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		
		String idpw = (String)session.getAttribute("idpw");
		
		if(idpw != null) { //idpw 가 null이 아니라면 즉 비지않았다. 채워졌다. 즉 로그인되었다면
			
			chain.doFilter(req, resp);
			
			//만든게 적용이 된건지 확인하는 로직
			System.out.println("아?");
			
		} else {	//로그인 이 되지 않았다면.
			resp.sendRedirect("/web.login/login");
			// 로그인 해라 !! 
		}
		
	}
}
