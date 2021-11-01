package com.plant.dto;

public class ReviewDTO {
	private String score;
	private String selectProduct;
	private String reviewContent;
	private String id;
	private String reviewDate;
	public ReviewDTO(String score, String selectProduct, String reviewContent, String id, String reviewDate) {
		super();
		this.score = score;
		this.selectProduct = selectProduct;
		this.reviewContent = reviewContent;
		this.id = id;
		this.reviewDate = reviewDate;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getSelectProduct() {
		return selectProduct;
	}
	public void setSelectProduct(String selectProduct) {
		this.selectProduct = selectProduct;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	@Override
	public String toString() {
		return "reviewDTO [score=" + score + ", selectProduct=" + selectProduct + ", reviewContent=" + reviewContent
				+ ", id=" + id + ", reviewDate=" + reviewDate + "]";
	}




}
