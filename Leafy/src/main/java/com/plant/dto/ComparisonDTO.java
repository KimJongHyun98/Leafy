package com.plant.dto;



public class ComparisonDTO {
	private String title;
	private String link;
	private String image;
	private String lprice;
	private String hprice;
	private String mallName;
	private int productType;
	private String maker;
	private String brand;
	private String category1;
	private String category2;
	private String category3;
	private String category4;

	public ComparisonDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComparisonDTO(String title, String link, String image, String lprice, String hprice, String mallName,
			int productType, String maker, String brand, String category1, String category2, String category3,
			String category4) {
		super();
		this.title = title;
		this.link = link;
		this.image = image;
		this.lprice = lprice;
		this.hprice = hprice;
		this.mallName = mallName;
		this.productType = productType;
		this.maker = maker;
		this.brand = brand;
		this.category1 = category1;
		this.category2 = category2;
		this.category3 = category3;
		this.category4 = category4;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLprice() {
		return lprice;
	}

	public void setLprice(String lprice) {
		this.lprice = lprice;
	}

	public String getHprice() {
		return hprice;
	}

	public void setHprice(String hprice) {
		this.hprice = hprice;
	}

	public String getMallName() {
		return mallName;
	}

	public void setMallName(String mallName) {
		this.mallName = mallName;
	}

	public int getproductType() {
		return productType;
	}

	public void setproductType(int productType) {
		this.productType = productType;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory1() {
		return category1;
	}

	public void setCategory1(String category1) {
		this.category1 = category1;
	}

	public String getCategory2() {
		return category2;
	}

	public void setCategory2(String category2) {
		this.category2 = category2;
	}

	public String getCategory3() {
		return category3;
	}

	public void setCategory3(String category3) {
		this.category3 = category3;
	}

	public String getCategory4() {
		return category4;
	}

	public void setCategory4(String category4) {
		this.category4 = category4;
	}

	@Override
	public String toString() {
		return "ComparisonDTO [title=" + title + ", link=" + link + ", image=" + image + ", lprice=" + lprice
				+ ", hprice=" + hprice + ", mallName=" + mallName + ", productType=" + productType + ", maker=" + maker
				+ ", brand=" + brand + ", category1=" + category1 + ", category2=" + category2 + ", category3="
				+ category3 + ", category4=" + category4 + "]";
	}



}
