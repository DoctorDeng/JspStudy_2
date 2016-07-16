package entity;

import java.io.Serializable;
import java.util.List;

public class Page<T>  {
	private int   pageSize; //每页显示记录条数
	private int   currentPage; //当前页数
	private int   recordNum; //记录数量
	private int   pageNum; //一共多少页记录
	//定义一个通用的泛型，（泛型方法）
	private List<T> dataList;//要显示的数据
	
	public Page(){}
	
	public Page(int pageSize, int currentPage, int recordNum, int pageNum, List<T> dataList) {
		super();
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.recordNum = recordNum;
		this.pageNum = pageNum;
		this.dataList = dataList;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRecordNum() {
		return recordNum;
	}

	public void setRecordNum(int recordNum) {
		this.recordNum = recordNum;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	

}
