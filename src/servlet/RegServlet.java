package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Users;

/**d
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Users u = new Users();
		String username;
		String mypassword;
		String gender;
		String email;
		String introduce;
		Date birthday;
		String[] favorites;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String isAccept;
		
		try {
			request.setCharacterEncoding("utf-8");
			username = request.getParameter("username");
			mypassword = request.getParameter("mypasswrod");
			gender = request.getParameter("gender");
			email = request.getParameter("eamil");
			introduce = request.getParameter("introduce");
			String date = request.getParameter("birthday");
			birthday =  sdf.parse(date);
					

			//用来获取多个复选按钮的值
			favorites = request.getParameterValues("favorite");
			isAccept = request.getParameter("isAccept");
			
			u.setUsername(username);
			u.setMypassword(mypassword);
			u.setGender(gender);;
			u.setEmail(email);
			u.setIntroduce(introduce);
			u.setFavorites(favorites);
			u.setBirthday(birthday);
			u.setAccept(isAccept.equals("true")?true:false);
			
			//把注册成功的用户对象保存到session中
			request.getSession().setAttribute("regUser", u);
			request.getRequestDispatcher("userinfo.jsp").forward(request, response);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
