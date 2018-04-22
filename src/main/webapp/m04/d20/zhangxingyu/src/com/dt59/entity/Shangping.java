package com.dt59.entity;

/**
 * Shangping entity. @author MyEclipse Persistence Tools
 * Serializable 类在实例化过程中，new把当前的java bean 变成字节码(jvm)便于传输数据
 */

public class Shangping implements java.io.Serializable {

	// Fields

	private Integer spid;
	private String spname;
	private Float spprice;
	private String spdesc;
	private int num=1;
	
	// Constructors

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	/** default constructor */
	public Shangping() {
	}

	/** minimal constructor */
	public Shangping(Integer spid) {
		this.spid = spid;
	}

	/** full constructor */
	public Shangping(Integer spid, String spname, Float spprice, String spdesc) {
		this.spid = spid;
		this.spname = spname;
		this.spprice = spprice;
		this.spdesc = spdesc;
	}

	// Property accessors

	public Integer getSpid() {
		return this.spid;
	}

	public void setSpid(Integer spid) {
		this.spid = spid;
	}

	public String getSpname() {
		return this.spname;
	}

	public void setSpname(String spname) {
		this.spname = spname;
	}

	public Float getSpprice() {
		return this.spprice;
	}

	public void setSpprice(Float spprice) {
		this.spprice = spprice;
	}

	public String getSpdesc() {
		return this.spdesc;
	}

	public void setSpdesc(String spdesc) {
		this.spdesc = spdesc;
	}

}