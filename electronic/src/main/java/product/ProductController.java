package product;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/product/*")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ProductDAO dao;
    HttpSession session;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        dao = new ProductDAO();
        
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		session =request.getSession();
		String action = request.getPathInfo();
		
		if (action == null || action.equals("/list.do")) {
			List<ProductVO> productList = dao.listProducts();
			request.setAttribute("productList", productList);
			forwardReq(request, response, "/printProduct.jsp");
		}
		

		
		else if (action.equals("/detail.do")) {
			
			String selectedId = request.getParameter("id");
			ProductVO selProduct = dao.choiceProduct(selectedId);
			//System.out.println(selectedId); id가 제대로 넘어오는가? yes
			request.setAttribute("selProduct", selProduct);
			forwardReq(request, response, "/detailInfo.jsp");
			
		}
		
		else if(action.equals("/buy.do")) {
			String selectedId = request.getParameter("id");
			List<ProductVO> basketProductList = dao.basketProducts(selectedId);
			session.setAttribute("basketProductList", basketProductList);
			forwardReq(request, response, "/basketProduct.jsp");
			
		}
		
		
		// 여기에 코드 작성
	}
	
	private void forwardReq(HttpServletRequest request, HttpServletResponse response, String nextPage) throws ServletException, IOException  {
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}
}
