/*package com.hola.entity.dougest;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.voodoodyne.jackson.jsog.JSOGGenerator;
*//**
 * neo4j 测试类 角色
 * @author Dougest 2017年6月2日    下午11:58:23
 *
 *//*
//@JsonIdentityInfo(generator=JSOGGenerator.class)
@RelationshipEntity(type="ACTS_IN")
public class Role {
	@GraphId
	private Long id;
	
	private String role;
	@StartNode
	private Actor actor;
	@EndNode
	private Movie movie;
	
	private Role(){}

	public Long getId() {
		return id;
	}

	public Role(String name, Actor actor, Movie movie) {
		this.role = name;
		this.actor = actor;
		this.movie = movie;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	
}
*/