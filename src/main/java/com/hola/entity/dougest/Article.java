package com.hola.entity.dougest;

import java.util.Date;

import javax.persistence.*;

/**
 * 文章信息
 * @author Dougest 2017年5月4日    下午10:14:24
 *
 */
@Entity
@Table(name = "t_csdn_weekly_article")
public class Article extends BaseEntity {
	/**
     * 文章名称
     */
    private String name;
    /**
     * 文章名称
     */
    private String url;
    /**
     * 属于哪一期
     */
    private Integer stage;
    /**
     * 浏览量
     */
    private Integer views;
    /**
     * 收藏数
     */
    private Integer collections;
    /**
     * 所属知识库类别
     */
    private String type;
    /**
     * 类别图片地址
     */
    private String img;
    /**
     * 更新时间
     */
    @Column(name = "update_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getStage() {
		return stage;
	}
	public void setStage(Integer stage) {
		this.stage = stage;
	}
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}
	public Integer getCollections() {
		return collections;
	}
	public void setCollections(Integer collections) {
		this.collections = collections;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	@Override
	public String toString() {
		return "Article [name=" + name + ", url=" + url + ", stage=" + stage + ", views=" + views + ", collections="
				+ collections + ", type=" + type + ", img=" + img + ", updateAt=" + updateAt + "]";
	}
    
    
}
