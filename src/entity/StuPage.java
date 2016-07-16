package entity;

public class StuPage extends Page<Student> {
	
	private int upPage;
	private int nextPage;
	private int indexPage;
	private int endPage;
	
	public StuPage(){}

	public StuPage(Page<Student> page,int indexPage, int endPage, int upPage,
			int nextPage
			){
		this.indexPage  = indexPage;
		this.endPage    = endPage;
		this.upPage     = upPage;
		this.nextPage   = nextPage;
		this.setPageSize(page.getPageSize());
		this.setCurrentPage(page.getCurrentPage());
		this.setRecordNum(page.getRecordNum());
		this.setPageNum(page.getPageNum());
		this.setDataList(page.getDataList());
	}
	
	public int getUpPage() {
		return upPage;
	}

	public void setUpPage(int upPage) {
		this.upPage = upPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getIndexPage() {
		return indexPage;
	}

	public void setIndexPage(int indexPage) {
		this.indexPage = indexPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
}
