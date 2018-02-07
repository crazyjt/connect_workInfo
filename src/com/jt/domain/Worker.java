package com.jt.domain;

import java.io.Serializable;


public class Worker implements Serializable{
	
	private String w_id;
	private String w_password;
	private String w_name;
	private String w_type;
	private String w_sex;
	private float w_workTime;
	
	public Worker (){
		
	}
	public Worker(String w_id, String w_password, String w_name, String w_type, String w_sex, float w_workTime) {
		super();
		this.w_id = w_id;
		this.w_password = w_password;
		this.w_name = w_name;
		this.w_type = w_type;
		this.w_sex = w_sex;
		this.w_workTime = w_workTime;
	}
	
	public String getW_id() {
		return w_id;
	}
	public void setW_id(String w_id) {
		this.w_id = w_id;
	}
	public String getW_password() {
		return w_password;
	}
	public void setW_password(String w_password) {
		this.w_password = w_password;
	}
	public String getW_name() {
		return w_name;
	}
	public void setW_name(String w_name) {
		this.w_name = w_name;
	}
	public String getW_type() {
		return w_type;
	}
	public void setW_type(String w_type) {
		this.w_type = w_type;
	}
	public String getW_sex() {
		return w_sex;
	}
	public void setW_sex(String w_sex) {
		this.w_sex = w_sex;
	}
	public float getW_workTime() {
		return w_workTime;
	}
	public void setW_workTime(float w_workTime) {
		this.w_workTime = w_workTime;
	}
	
	@Override
	public String toString() {
		return "Worker [w_id=" + w_id + ", w_password=" + w_password + ", w_name=" + w_name + ", w_type=" + w_type
				+ ", w_sex=" + w_sex + ", w_workTime=" + w_workTime + "]";
	}
}
