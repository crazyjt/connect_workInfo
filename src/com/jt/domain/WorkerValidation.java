package com.jt.domain;

import java.util.HashMap;
import java.util.Map;

public class WorkerValidation {
	private String w_id;
	private String w_password;
	private String w_repassword;
	private String w_name;
	private String w_type;
	private float w_workTime;
	
	//���ڴ�Ŵ�����Ϣ
	Map<String, String> validateMsg = new HashMap<>();

	//������֤�ĺ���
	public boolean validate() {
		if ("".equals(w_id)) {
			validateMsg.put("w_id", "�û�id����Ϊ��");
		} 
		if ("".equals(w_password)) {
			validateMsg.put("w_password", "���벻��Ϊ��");
		}
		if ("".equals(w_password)) {
			validateMsg.put("w_password", "���벻��Ϊ��");
		}
		if ("".equals(w_repassword)) {
			validateMsg.put("w_repassword", "���벻��Ϊ��");
		} else if (!w_repassword.equals(w_password)) {
			validateMsg.put("w_repassword", "�����������벻һ��");
		}
		if ("".equals(w_name)) {
			validateMsg.put("w_name", "��������Ϊ��");
		}
		if ("".equals(w_type)) {
			validateMsg.put("w_type", "��λ����Ϊ��");
		}
		
		return validateMsg.isEmpty();
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

	public String getW_repassword() {
		return w_repassword;
	}
	public void setW_repassword(String w_repassword) {
		this.w_repassword = w_repassword;
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

	public float getW_workTime() {
		return w_workTime;
	}

	public void setW_workTime(float w_workTime) {
		this.w_workTime = w_workTime;
	}

	public Map<String, String> getvalidateMsg() {
		return validateMsg;
	}

	public void setvalidateMsg(Map<String, String> validateMsg) {
		this.validateMsg = validateMsg;
	}
	
	
}
