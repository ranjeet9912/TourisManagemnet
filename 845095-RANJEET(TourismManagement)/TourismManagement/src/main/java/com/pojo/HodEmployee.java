package com.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Controller;

@Controller
@Entity
@Table(name="hod_details")
public class HodEmployee {
	@Id
	@Column(name="h_id")
	@GeneratedValue //autoincrement
	private int hid;
	
	//@Size(min = 5, max = 15, message = "Your username must between 8 and 15 characters")
	@Column(name="h_name")
	private String hname;
	
	
	@Column(name="h_email")
	private String hemail;
	
	
	@Column(name="h_pass")
	private String hpass;
	
	@Column(name="gender")
	private String gender;
	
	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getHemail() {
		return hemail;
	}

	public void setHemail(String hemail) {
		this.hemail = hemail;
	}

	public String getHpass() {
		return hpass;
	}

	public void setHpass(String hpass) {
		this.hpass = hpass;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHaddress() {
		return haddress;
	}

	public void setHaddress(String haddress) {
		this.haddress = haddress;
	}

	public String getHdob() {
		return hdob;
	}

	public void setHdob(String hdob) {
		this.hdob = hdob;
	}

	public String getHdept() {
		return hdept;
	}

	public void setHdept(String hdept) {
		this.hdept = hdept;
	}

	@Column(name="h_address")
	private String haddress;
	
	@Column(name="h_dob")
	private String hdob;
	
	@Column(name="h_dept")
	private String hdept;
	private int hflag;

	public int getHflag() {
		return hflag;
	}

	public void setHflag(int hflag) {
		this.hflag = hflag;
	}

}
