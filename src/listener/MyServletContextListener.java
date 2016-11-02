package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import entity.Dog;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("====监听器销毁====");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("====监听器初始化====");
		ServletContext sc = event.getServletContext();
		//获取上下文初始化参数
		String dogBreed = sc.getInitParameter("breed");
		Dog d = new Dog(dogBreed);
		sc.setAttribute("dog", d);
	}

}
