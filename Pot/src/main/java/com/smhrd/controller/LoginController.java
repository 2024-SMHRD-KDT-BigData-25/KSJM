package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.PotUsers;


@WebServlet("/html/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 파라미터 받기 post 방식 (아이디, 비밀번호, 닉네임 -> 한글(인코딩))
				request.setCharacterEncoding("UTF-8");
						
				String user_id = request.getParameter("user_id");
				String user_pw = request.getParameter("user_pw");
				
				String previousUrl = request.getParameter("previousUrl");
			    
				PotUsers loginMember = new PotUsers(user_id, user_pw);
				
				MemberDAO dao = new MemberDAO();
				
				PotUsers res = dao.login(loginMember);
				
				System.out.println("이전 URL: " + previousUrl);
				
				if(res == null) {
					System.out.println("실패");
					//response.sendRedirect("index.jsp");
		            response.setContentType("text/html;charset=UTF-8");
		            response.getWriter().println("<html>");
		            response.getWriter().println("<head><title>로그인 실패</title></head>");
		            response.getWriter().println("<body>");
		            response.getWriter().println("<script type='text/javascript'>");
		            response.getWriter().println("alert('아이디 또는 비밀번호가 틀렸습니다.');");
		            response.getWriter().println("window.history.back();"); // 이전 페이지로 돌아가기
		            response.getWriter().println("</script>");
		            response.getWriter().println("</body>");
		            response.getWriter().println("</html>");
				}else {
					System.out.println("성공");
					HttpSession session = request.getSession();
					session.setAttribute("member", res);
					response.sendRedirect(previousUrl);
				}

	}

}
