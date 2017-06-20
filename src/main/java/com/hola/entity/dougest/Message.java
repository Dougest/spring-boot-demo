package com.hola.entity.dougest;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.PersistenceConstructor;
//import org.springframework.data.mongodb.core.mapping.Document;

@Entity(name="message")
@Table(name="Message")
//@Document(collection = "message")
public class Message implements Serializable{
	private static final long serialVersionUID = 7191923803765598724L;
	private Long id;
	//@Index(unque=true)
	private String content;
	private Date creatTime;
	private String host;
	private String address;
	private String userAgent;
	private String locale;
	private String ip;

	private String scheme;
	
	public Message (){}
	
	public Message(Long id, String content, Date creatTime, Long ip) {
		super();
		this.id = id;
		this.content = content;
		this.creatTime = creatTime;
	}
	
	
	public Message(Long id, String content, Date creatTime, Long ip, String userAgent) {
		super();
		this.id = id;
		this.content = content;
		this.creatTime = creatTime;
		this.userAgent = userAgent;
	}
	
	public Message(Long id, String content, Date creatTime, String host, String address, String userAgent,
			String locale, String scheme) {
		super();
		this.id = id;
		this.content = content;
		this.creatTime = creatTime;
		this.host = host;
		this.address = address;
		this.userAgent = userAgent;
		this.locale = locale;
		this.scheme = scheme;
	}
	@PersistenceConstructor
	public Message(Long id, String content, Date creatTime, String host, String address, String userAgent,
			String locale, String ip, String scheme) {
		super();
		this.id = id;
		this.content = content;
		this.creatTime = creatTime;
		this.host = host;
		this.address = address;
		this.userAgent = userAgent;
		this.locale = locale;
		this.ip = ip;
		this.scheme = scheme;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="content")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creat_time")
	public Date getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	@Column(name="userAgent")
	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	@Column(name="host")
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
	@Column(name="address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="locale")
	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}
	@Column(name="scheme")
	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
	@Column(name="ip")
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + ", creatTime=" + creatTime + ", host=" + host
				+ ", address=" + address + ", userAgent=" + userAgent + ", locale=" + locale + ", scheme=" + scheme
				+ "]";
	}
	
}
