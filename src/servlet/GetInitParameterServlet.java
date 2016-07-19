package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetInitParameterServlet
 */
public class GetInitParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetInitParameterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/*@Override
	public void init() throws ServletException {
		this.setUsername(this.getInitParameter("username"));;
		this.setPassword(this.getInitParameter("password"));
	}*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("ServletConfig有如下参数：<br/>");
		
		Enumeration e = getServletConfig().getInitParameterNames();
		while(e.hasMoreElements()) {
			out.println("<br>参数名: " + e.nextElement() + "<br>");
		}
		
		out.println("<hr/>");
		/*out.println("用户名:" + this.getUsername());
		out.println("密码:" + this.getPassword());*/
		out.println("<h3>如下是通过ServletContext获取的全局Servlet共享的参数</h3>");
		out.println("Email地址是:" + getServletContext().getInitParameter("adminEmail"));
		out.flush();
		out.close();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.setUsername(this.getInitParameter("username"));;
		this.setPassword(this.getInitParameter("password"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
