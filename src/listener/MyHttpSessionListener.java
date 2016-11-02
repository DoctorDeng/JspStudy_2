package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MyHttpSessionListener
 *
 */
public class MyHttpSessionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public MyHttpSessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent sessionEvent)  { 
    	System.out.println("用户首次登录服务器,创建一个 session");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent sessionEvent)  { 
    	System.out.println("session 销毁分为如下几种："
    						+ "1.关闭服务器"
    						+ "2.关闭浏览器到 Session 过期"
    						+ "3.不关闭浏览器 Session 超时");
    }
	
}
