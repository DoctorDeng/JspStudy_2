package dao;

import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.impl.orbutil.closure.Constant;

import imooc.Page;
import imooc.Student;
/**
 * 使用mySQL数据库limit关键字实现分页
 * @author Doctor邓
 *
 */
public class JdbcSqlStudentDaoImpl implements StudentDao {

	@Override
	public Page<Student> findStudent(Student searchModel, int pageNum, int pageSize) {
		Page<Student> result = null;
		/**
		 * 存放查询参数的列表
		 */
		List<Object> paramList = new ArrayList<Object>();
		String stuName = searchModel.getStuName();
		int gender = searchModel.getGender();
		
		StringBuilder sql = new StringBuilder(
				"SELECT * FROM t_student where 1=1");
		StringBuilder countSql = new StringBuilder(
				"SELECT count(id) as totalRecord FROM t_student WHERE 1=1");
		
		if(stuName != null && !stuName.equals("")) {
			sql.append(" and stu_name like ? ");
			countSql.append(" and stu_name like ? ");
			paramList.add("%" + stuName + "%");
		}
		
		if (gender == Constan.GENDER_FEMALE || gender = Cont)
		
		return null;
	}

}
