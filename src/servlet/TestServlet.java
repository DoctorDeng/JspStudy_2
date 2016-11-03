package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import listener.User;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//测试 Ajax 传递数组，后台是否可以接收
		/*String[] bankids = request.getParameterValues("bankIds");
		System.out.println("bankIds" + bankids);
		for (int i = 0, len = bankids.length; i < len; i++) {
			System.out.println("bankId:" + bankids[i]);
		}*/
		//测试 对于属性的增加删除进行监听的监听器
		/*request.setAttribute("id", bankids[0]);
		request.getServletContext().setAttribute("id", bankids[0]);
		request.getSession().setAttribute("id", bankids[0]);
		
		request.setAttribute("id", bankids[1]);
		request.getServletContext().setAttribute("id", bankids[1]);
		request.getSession().setAttribute("id", bankids[1]);
		request.removeAttribute("id");
		request.getServletContext().removeAttribute("id");
		request.getSession().removeAttribute("id");*/
		
		//测试 监听绑定 到HttpSession 中某个对象的状态的时间监听器
		User user = new User();
		user.setPassowrd("123");
		user.setUsername("DoctorDeng");
		
		request.getSession().setAttribute("currentUser", user);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
