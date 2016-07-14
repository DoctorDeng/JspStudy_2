package service;

import imooc.Page;
import imooc.Student;

public interface StudentService {
	/**
	 * 根据查询条件，查询学生分页信息
	 * @param earchModel  查询条件
	 * @param pageNum     查询第几页数据
  	 * @param pageSize    每页多少条记录
	 * @return            查询结果
	 */
	public Page<Student> findStudent(Student earchModel, int pageNum, int pageSize);
}
