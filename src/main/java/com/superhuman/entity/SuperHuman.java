package com.superhuman.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "superhuman_info")
public class SuperHuman {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "superhuman_id")
	private int superhumanId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "alias")
	private String alias;
	
	@Column(name = "hometown")
	private String hometown;
	
	@Column(name = "alignment")
	private int alignment;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team")
	private Integer team;
	
	@Column(name = "powers")
	private String powers;

	public int getSuperhumanId() {
		return superhumanId;
	}

	public void setSuperhumanId(int superhumanId) {
		this.superhumanId = superhumanId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public int getAlignment() {
		return alignment;
	}

	public void setAlignment(int alignment) {
		this.alignment = alignment;
	}

	public Integer getTeam() {
		return team;
	}

	public void setTeam(Integer team) {
		this.team = team;
	}

	public String getPowers() {
		return powers;
	}

	public void setPowers(String powers) {
		this.powers = powers;
	}

	@Override
	public String toString() {
		return "SuperHuman [superhumanId=" + superhumanId + ", name=" + name + ", alias=" + alias + ", hometown="
				+ hometown + ", alignment=" + alignment + ", team=" + team + ", powers=" + powers + "]";
	}

	public SuperHuman() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
