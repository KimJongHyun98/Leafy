package com.plant.dto;

public class PaggingVO { // 페이징vo
	// 전체 게시글 수
	private int count;
	// 현재 페이지 번호
	private int currentPageNo;
	// 페이지당 출력할 게시글 개수
	private int pageOfContentCount;
	// 페이지 그룹당 나타낼 페이지 번호 수
	private int pageGroupofCount;

	public PaggingVO() {
		super();
	}

	public PaggingVO(int count, int currentPageNo, int pageOfContentCount, int pageGroupofCount) {
		super();
		this.count = count;
		this.currentPageNo = currentPageNo;
		this.pageOfContentCount = pageOfContentCount;
		this.pageGroupofCount = pageGroupofCount;
	}
	
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	
	public int getTotalPage() {
		int result = count / pageOfContentCount;
		if(count % pageOfContentCount != 0)
			result++;
		return result;
	}
	
	public int getTotalPageGroup() {
		int result = getTotalPage() / pageGroupofCount;
		if(getTotalPage() % pageGroupofCount != 0)
			result++;
		return result;
	}
	
	public int getNowPageGroupNo() {
		int result = currentPageNo / pageGroupofCount;
		if(currentPageNo % pageGroupofCount != 0)
			result++;
		return result;
	}
	
	public int getStartPageOfPageGroup() {
		return (getNowPageGroupNo() - 1) * pageGroupofCount + 1;
	}
	
	public int getEndPageOfPageGroup() {
		int result = getNowPageGroupNo() * pageGroupofCount;
		if(result > getTotalPage())
			result = getTotalPage();
		return result;
	}
	
	public boolean isPreviousPageGroup() {
		return getNowPageGroupNo() > 1;
	}
	
	public boolean isNextPageGroup() {
		return getNowPageGroupNo() < getTotalPageGroup();
	}

	@Override
	public String toString() {
		return "PaggingVO [count=" + count + ", currentPageNo=" + currentPageNo + ", pageOfContentCount="
				+ pageOfContentCount + ", pageGroupofCount=" + pageGroupofCount + ", getCurrentPageNo()="
				+ getCurrentPageNo() + ", getTotalPage()=" + getTotalPage() + ", getTotalPageGroup()="
				+ getTotalPageGroup() + ", getNowPageGroupNo()=" + getNowPageGroupNo() + ", getStartPageOfPageGroup()="
				+ getStartPageOfPageGroup() + ", getEndPageOfPageGroup()=" + getEndPageOfPageGroup()
				+ ", isPreviousPageGroup()=" + isPreviousPageGroup() + ", isNextPageGroup()=" + isNextPageGroup() + "]";
	}
	

	
}












