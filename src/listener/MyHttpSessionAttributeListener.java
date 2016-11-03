package listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class MyHttpSessionAttributeListener
 *
 */
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public MyHttpSessionAttributeListener() {
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
    	System.out.println("Session 属性添加了");
    	System.out.println("Session 添加的是：" + event.getName());
    	System.out.println("Session 添加的值：" + event.getValue());
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	System.out.println("Session 属性移除了");
    	System.out.println("Session 移除的是：" + event.getName());
    	System.out.println("Session 移除的值：" + event.getValue());
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	System.out.println("Session 属性替换了");
    	System.out.println("Session 替换的是：" + event.getName());
    	System.out.println("Session 替换的值：" + event.getValue());
    }
	
}
