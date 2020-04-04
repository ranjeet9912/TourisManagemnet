package com.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Controller;

@Controller
@Entity
@Table(name="faculty_info")
public class Employee {
	@Id
	@Column(name="fac_id")
	@GeneratedValue //autoincrement
	private int fac_id;
	
	//@Size(min = 5, max = 15, message = "Your username must between 8 and 15 characters")
	@Column(name="fac_name")
	//@NotEmpty(message = "Please enter valid name")
	private String fname;
	
	
	@Column(name="fac_email")
	//@Column(name = "fac_email",unique=true,columnDefinition="VARCHAR(64)")
	@NotEmpty(message = "Please enter valid email")
	private String femail;
	
	
	@Column(name="fac_pass")
	private String fpass;
	
	@Column(name="gender")
	private String gender;
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Column(name="fac_address")
	private String faddress;
	
	@Column(name="fac_dob")
	private String fdob;
	
	@Column(name="fac_dept")
	private String fdept;
	
	public int getFac_id() {
		return fac_id;
	}
	public void setFac_id(int fac_id) {
		this.fac_id = fac_id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFemail() {
		return femail;
	}
	public void setFemail(String femail) {
		this.femail = femail;
	}
	public String getFpass() {
		return fpass;
	}
	public void setFpass(String fpass) {
		this.fpass = fpass;
	}
	public String getFaddress() {
		return faddress;
	}
	public void setFaddress(String faddress) {
		this.faddress = faddress;
	}
	public String getFdob() {
		return fdob;
	}
	public void setFdob(String fdob) {
		this.fdob = fdob;
	}
	public String getFdept() {
		return fdept;
	}
	public void setFdept(String fdept) {
		this.fdept = fdept;
	}
	
	private int flag;

	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
}
