package listener;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

public class User implements HttpSessionBindingListener,
							 HttpSessionActivationListener,
							 Serializable{

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String passowrd;
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("User 正在绑定");
		System.out.println("绑定的是：" + event.getName() + "  值是：" + event.getValue());
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("User 正在解绑");
		System.out.println("解绑的是：" + event.getName() + "  值是：" + event.getValue());
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent event) {
		System.out.println("User 正在活化");
		System.out.println("地址" + event.getSource().toString());
	}
	
	@Override
	public void sessionWillPassivate(HttpSessionEvent event) {
		System.out.println("User 正在钝化");
		System.out.println("地址：" + event.getSource().toString());
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassowrd() {
		return passowrd;
	}

	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}
}
