package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstFilter implements Filter {

    public FirstFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("被销毁了");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("开始过滤");
		HttpServletRequest req  = (HttpServletRequest)  request;
		HttpServletResponse res = (HttpServletResponse) response;
		//重定向
		//res.sendRedirect(req.getContextPath() + "/filter/main.jsp");
		//chain.doFilter(request, response);
		//req.getRequestDispatcher("main.jsp").forward(request, response);
		req.getRequestDispatcher("main.jsp").include(request, response);
		System.out.println("结束过滤");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("正在初始化");
	}

}
