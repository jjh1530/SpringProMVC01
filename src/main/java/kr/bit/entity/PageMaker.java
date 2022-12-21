package kr.bit.entity;

public class PageMaker {

	private Criteria cri;
	private int totalCount; // 총게시글의 수
	private int startPage; // 시작 페이지 번호 1 2
	private int endPage; //끝 페이지 번호     10 20 페이지가 없을 시 20이 아닌 마지막 페이지로 조정
	private boolean prev; //이전 버튼 (true, false)
	private boolean next; //다음 버튼
	private int displayPageNum = 5; //1 2 3 4 5 6 7 8 9 10
	//총 게시글의 수를 구하는 메서드
	
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		makePaging();
	}
	//makePaging TotalCount
	private void makePaging() {
		//1. 화면에 보여질 마지막 페이지 번호     10 20 30 
		 endPage = (int) (Math.ceil(cri.getPage()/ (double)displayPageNum)*displayPageNum);
		// 2.화면에 보여질 시작 페이지 번호
		 startPage = (endPage-displayPageNum)+1;
		 if (startPage<=0)  {
			 startPage = 1;
		}
		// 3.전체 마지막 페이지 계산 (88개면 9페이지) 88/10 
		int temEndPage = (int) Math.ceil(totalCount/(double)cri.getPerPageNum());
		//4. 화면에 보여질 마지막 페이지 유효성 체크
		if (temEndPage < endPage) {
			endPage = temEndPage;
		}
		//5.이전 페이지 버튼 존재 여부
		prev = (startPage==1) ? false: true;
		//6.다음페이지 버튼 존재 여부
		next =(endPage< temEndPage)? true: false;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	
	
	
}
