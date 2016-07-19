package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Dog;

/**
 * Servlet implementation class ListenerTester
 */
public class ListenerTester extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListenerTester() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>测试监听器</h1>");
		out.print("<hr>");
		out.print("<p>以下属性是通过监听器获取ServletContext配置参数的值，然后封装到dog对象中，并把dog存储到ServletContext中，然后通过Servlet获取dog对象中的属性：</p>");
		Dog dog = (Dog)getServletContext().getAttribute("dog");
		out.print("<p>dog的breed是："+dog.getBreed()+"</p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
