package com.lxg.acm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 * @author Administrator
 *
 */
public class User implements Serializable {

	Long uid; 	 	 // 用户id
	String username; // 用户名
	String password; // 用户密码
	String email;    // 用户邮箱
	String qq;		 // 用户QQ
	int submit;
	int accepted;
	int solved;
	boolean defunct;
	Date regTime;
	String nick;
	String school;
	String majorClass;
	String stuid;
	String type;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSubmit() {
		return submit;
	}

	public void setSubmit(int submit) {
		this.submit = submit;
	}

	public int getSolved() {
		return solved;
	}

	public void setSolved(int solved) {
		this.solved = solved;
	}

	public boolean isDefunct() {
		return defunct;
	}

	public void setDefunct(boolean defunct) {
		this.defunct = defunct;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public int getAccepted() {
		return accepted;
	}

	public void setAccepted(int accepted) {
		this.accepted = accepted;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMajorClass() {
		return majorClass;
	}

	public void setMajorClass(String majorClass) {
		this.majorClass = majorClass;
	}

	public String getStuid() {
		return stuid;
	}

	public void setStuid(String stuid) {
		this.stuid = stuid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}

}
