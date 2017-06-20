package com.hola.entity.ztahti;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author ztahti
 *	用户
 * 2017年4月26日 下午2:34:57
 */

public class Account implements Serializable {
	
	private static final long serialVersionUID = 2906235613185562006L;
	private Long id;
	private String userName;
	private String nickName;
	private String realName;
	private String password;
	private String problem1;
	private String answer1;
	private String problem2;
	private String answer2;
	private String problem3;
	private String answer3;
	private String email;
	private Date createTime;
	private Date updateTime;
	private String registeIp;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProblem1() {
		return problem1;
	}
	public void setProblem1(String problem1) {
		this.problem1 = problem1;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getProblem2() {
		return problem2;
	}
	public void setProblem2(String problem2) {
		this.problem2 = problem2;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getProblem3() {
		return problem3;
	}
	public void setProblem3(String problem3) {
		this.problem3 = problem3;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getRegisteIp() {
		return registeIp;
	}
	public void setRegisteIp(String registeIp) {
		this.registeIp = registeIp;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", userName=" + userName + ", nickName=" + nickName + ", realName=" + realName
				+ ", password=" + password + ", problem1=" + problem1 + ", answer1=" + answer1 + ", problem2="
				+ problem2 + ", answer2=" + answer2 + ", problem3=" + problem3 + ", answer3=" + answer3 + ", email="
				+ email + ", createTime=" + createTime + ", updateTime=" + updateTime + ", registeIp=" + registeIp
				+ "]";
	}
	
}
