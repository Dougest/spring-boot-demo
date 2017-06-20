/*package com.hola.entity.dougest;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.voodoodyne.jackson.jsog.JSOGGenerator;
*//**
 * neo4j 测试类 电影
 * @author Dougest 2017年6月2日    下午11:58:54
 *
 *//*
//@JsonIdentityInfo(generator=JSOGGenerator.class)
@NodeEntity
public class Movie {
	@GraphId
	private Long id;
	private String title;
	private String year;
	private String tagline;
	@Relationship(type="",direction=Relationship.INCOMING)
	List<Role> roles = new ArrayList();
	
	public Role addRole(Actor actor,String name){
		Role role = new Role(name,actor,this);
		this.roles.add(role);
		return role;
	}

	public Movie(Long id, String title, String year, String tagline, List<Role> roles) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.tagline = tagline;
		this.roles = roles;
	}

	public Movie() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
}
*/