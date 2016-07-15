package bussiness;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import dao.CommanCURDDao;
import dao.impl.MySqlCURDDaoImpl;
import entity.Page;
import entity.Student;

public class StudentAction {
	private CommanCURDDao mySql;
	
	public StudentAction() {
		mySql = new MySqlCURDDaoImpl();
	}
	
	public int getStuNum() {
		int stuNum = 0;
		String sql = "SELECT count(id) FROM student";
		Vector<String[]> vector = mySql.select(sql, null);
		if (vector.size()==1) {
			stuNum = Integer.parseInt(vector.get(0)[0]);
		}
		return stuNum;
	}
	
	public int pageNum(int pageSize) {
		return  (int) Math.ceil(getStuNum()/pageSize);
	}
	
	public List<Student> getStudentBySql(String sql, List<String> fields) {
		List<Student> studentList = new ArrayList<>();
		Vector<String[]> vector = mySql.select(sql, fields); 
		for (String[]  str:vector) {
			if (str.length==5) {
				int id = Integer.parseInt(str[0]);
				String stu_name = str[1];
				int gender = Integer.parseInt(str[2]);
				int age = Integer.parseInt(str[3]);
				String address = str[4];
				Student student = new Student(id, stu_name,gender,age,address);
				studentList.add(student);
			}
		}
		return studentList;
	}
	
	public Page<Student> getStuPage(int currentPage ,int pageSize) {
		int recordNum = getStuNum();
		int pageNum   = (int) Math.ceil(recordNum/pageSize)+1;
		
		int index = pageSize*currentPage;
		int end   = index + pageSize;
		
		String sql = "SELECT id, stu_name, gender, age, address FROM student "
				+ " limit "+ (currentPage-1)*pageSize
				+" , "+ pageSize;
		List<String> fields = new ArrayList<>();
		/*fields.add(String.valueOf((currentPage-1)*pageSize));
		fields.add(String.valueOf(pageSize));*/
		List<Student> studentList = getStudentBySql(sql, null);
		
		Page<Student> page = new Page<Student>(pageSize, currentPage,recordNum,pageNum, studentList);
		return page;
	}
}
