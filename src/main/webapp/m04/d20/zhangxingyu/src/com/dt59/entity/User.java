package com.dt59.entity;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String uname;
	private String upwd;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Integer uid) {
		this.uid = uid;
	}
	public User( String uname, String upwd) {
		
		this.uname = uname;
		this.upwd = upwd;
	}

	/** full constructor */
	public User(Integer uid, String uname, String upwd) {
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return this.upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

}