package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Application Lifecycle Listener implementation class MyRequestListener
 *
 */
public class MyRequestListener implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public MyRequestListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent requestEvent)  { 
    	System.out.println(" Request 结束");
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent requestEvent)  { 
    	System.out.println("有 Request 请求");
    	String[] bankids = requestEvent.getServletRequest().getParameterValues("bankIds");
		if (null != bankids) {
			System.out.println("参数是：" + bankids.toString());
		}
    }
}
