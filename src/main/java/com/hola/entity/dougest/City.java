package com.hola.entity.dougest;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Created by Dougest on 2017/3/10 0010.
 */
@Entity(name="city")
@Table(name = "city")
public class City implements Serializable{

	private static final long serialVersionUID = 1766214635411395993L;
	private Integer id;
    private String name;
    private String CountryCode;
    private String district;
    private Integer population;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name="country_code")
    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }
    @Column(name="district")
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
    @Column(name="population")
    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", CountryCode=" + CountryCode + ", district=" + district
				+ ", population=" + population + "]";
	}
    
    
}
