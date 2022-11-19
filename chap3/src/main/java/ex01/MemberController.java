package ex01;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO memberDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        memberDAO = new MemberDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO member = new MemberVO();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String action = request.getPathInfo();
//		System.out.println("action: " + action);
		if (action == null || action.equals("/listMembers.do")) {
			List<MemberVO> memberList = memberDAO.listMembers();
			request.setAttribute("memberList", memberList);
			forwardReq(request, response, "/ex01/listMembers.jsp");
		}
		
		else if (action.equals("/insertReq.do")) {
			forwardReq(request, response, "/ex01/insert.jsp");
		}
		
		else if (action.equals("/insert.do")) {
			member.setName(request.getParameter("name"));
			member.setPassword(request.getParameter("password"));
			member.setEmail(request.getParameter("email"));
			member.setRegdate(request.getParameter("regdate"));
			memberDAO.insert(member);
			response.sendRedirect("listMembers.do");
		}
		
		else if (action.equals("/detail.do")) {
			System.out.println("넘어온다");
			String id = request.getParameter("id");
			System.out.println(id);
			
		}
		
		
	}
	
	private void forwardReq(HttpServletRequest request, HttpServletResponse response, String nextPage) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}
}
