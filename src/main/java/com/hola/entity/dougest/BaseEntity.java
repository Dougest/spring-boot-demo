package com.hola.entity.dougest;

import java.util.Date;

import javax.persistence.*;

/**
 * 实体基类
 * @author Dougest 2017年5月4日    下午10:26:13
 *
 */
@MappedSuperclass
public class BaseEntity {
	/**
     * 主键ID
     */
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "insert_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date inertAt;

    public BaseEntity() {
        inertAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInertAt() {
        return inertAt;
    }

    public void setInertAt(Date inertAt) {
        this.inertAt = inertAt;
    }
}
