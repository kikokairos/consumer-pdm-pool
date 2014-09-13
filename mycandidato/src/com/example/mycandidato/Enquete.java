package com.example.mycandidato;

import java.util.GregorianCalendar;

public class Enquete {
	private Integer id;
	private String enquete;
	private GregorianCalendar data;
	private String op1;
	private String op2;
	private String op3;
	private Integer contop1;
	private Integer contop2;
	private Integer contop3;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEnquete() {
		return enquete;
	}
	public void setEnquete(String enquete) {
		this.enquete = enquete;
	}
	public GregorianCalendar getData() {
		return data;
	}
	
	public void setData(GregorianCalendar data) {
		this.data = data;
	}
	
	public String getOp1() {
		return op1;
	}
	public void setOp1(String op1) {
		this.op1 = op1;
	}
	public String getOp2() {
		return op2;
	}
	public void setOp2(String op2) {
		this.op2 = op2;
	}
	public String getOp3() {
		return op3;
	}
	public void setOp3(String op3) {
		this.op3 = op3;
	}
	public Integer getContop1() {
		return contop1;
	}
	public void setContop1(Integer contop1) {
		this.contop1 = contop1;
	}
	public Integer getContop2() {
		return contop2;
	}
	public void setContop2(Integer contop2) {
		this.contop2 = contop2;
	}
	public Integer getContop3() {
		return contop3;
	}
	public void setContop3(Integer contop3) {
		this.contop3 = contop3;
	}

}
