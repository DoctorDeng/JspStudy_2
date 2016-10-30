package filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter(filterName="AsynFilter",
		   value={"/filter/main.jsp"}, 
		   dispatcherTypes={DispatcherType.REQUEST, DispatcherType.ASYNC},
		   asyncSupported = true)
public class AsynFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("AsynFilter 开始过滤");
		chain.doFilter(request, response);
		System.out.println("AsynFilter 过滤结束");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("AsynFilter 初始化了");
	}

}
