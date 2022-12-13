package kr.bit.entity;

public class Criteria {

	private int page; // 현재 페이지 번호
	private int perPageNum; // 한 페이지에 보여줄 게시글 수
	
	public Criteria() {
		this.page =1;
		this.perPageNum = 3;
	}
	
	//현재 페이지 글의 시작번호
	//함수 값 pageStart값을 sql로넘김
	public int getPageStart() {		 //1페이지   2페이지		 
		return (page-1) *perPageNum; //0~    10~  
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}
	
	
}
