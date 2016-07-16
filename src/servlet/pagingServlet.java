package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bussiness.StudentAction;
import entity.Page;
import entity.StuPage;
import entity.Student;

/**
 * Servlet implementation class pagingServlet
 */
public class pagingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pagingServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
  		StudentAction stuAction = new StudentAction();
		int pageSize = 4;
  		int currentPage = 1;
  		int indexPage = 1;
		int nextPage=1;
 		int upPage=1;
 		
 		String pageSizeStr = request.getParameter("pageSize");
 		String currentPageStr = request.getParameter("currentPage");
		if (null !=currentPageStr) {
			currentPage = Integer.parseInt(currentPageStr);
		}
		if (null !=pageSizeStr) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		
		Page<Student> stuPage = stuAction.getStuPage(currentPage, pageSize);
  		int pageNum = stuPage.getPageNum();
  		List<Student> stuList = stuPage.getDataList();
  		
  		if (currentPage!=1 && pageNum > 1) {
  			upPage = currentPage - 1; 
  		}
  		if (currentPage<pageNum && pageNum>2) {
  			nextPage = currentPage +1;
  		}
  		if (currentPage== pageNum) {
  			nextPage = pageNum;
  		}
	
  		StuPage studentPage = new StuPage(stuPage, indexPage, pageNum, upPage, nextPage);
  		
  		request.getSession().setAttribute("stuPage", studentPage);
  		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
