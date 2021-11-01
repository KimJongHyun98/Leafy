package com.plant.dto;

import org.apache.ibatis.type.Alias;

@Alias("member") // 회원 DTO
public class MemberDTO {
	// 아이디, 패스워드, 닉네임, 이름, 주민번호, 성별, 주소, 폰번호,이메일, 추천한 게시글, 전화인증
	private String id;
	private String passwd;
	private String nickname;
	private String name;
	private String pno;
	private int gender;
	private String address;
	private	String phone;
	private String email;
	private int recommand_bno;
	private int phone_confirm;
	
	

	public MemberDTO(String id, String passwd, String nickname, String name, String pno2, int gender, String address,
			String phone2, String email, int recommand_bno, int phone_confirm) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.nickname = nickname;
		this.name = name;
		this.pno = pno2;
		this.gender = gender;
		this.address = address;
		this.phone = phone2;
		this.email = email;
		this.recommand_bno = recommand_bno;
		this.phone_confirm = phone_confirm;
	}
	

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRecommand_bno() {
		return recommand_bno;
	}

	public void setRecommand_bno(int recommand_bno) {
		this.recommand_bno = recommand_bno;
	}

	public int getPhone_confirm() {
		return phone_confirm;
	}

	public void setPhone_confirm(int phone_confirm) {
		this.phone_confirm = phone_confirm;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", passwd=" + passwd + ", nickname=" + nickname + ", name=" + name + ", pno="
				+ pno + ", gender=" + gender + ", address=" + address + ", phone=" + phone + ", email=" + email
				+ ", recommand_bno=" + recommand_bno + ", phone_confirm=" + phone_confirm + "]";
	}




	
}
