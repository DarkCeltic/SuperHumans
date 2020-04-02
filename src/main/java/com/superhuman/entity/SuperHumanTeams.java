package com.superhuman.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "superhuman_teams")
public class SuperHumanTeams {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "superhuman_id")
	private int teamId;
	
	@Column(name = "team_alignment")
	private int teamAlignment;
	
	@Column(name = "team_name")
	private String teamName;

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getTeamAlignment() {
		return teamAlignment;
	}

	public void setTeamAlignment(int teamAlignment) {
		this.teamAlignment = teamAlignment;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public SuperHumanTeams() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SuperHumanTeams [teamId=" + teamId + ", teamAlignment=" + teamAlignment + ", teamName=" + teamName
				+ "]";
	}

}
