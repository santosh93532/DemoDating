package com.datingengine.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "user_interests")
public class MatchResultDto {
	@Column(name="name")
    private String name;
	
	@Column(name="age")
    private Integer age;
	
	@Column(name="matchingInterests")
    private Integer matchingInterests;
    
    
    
	public MatchResultDto(String name, Integer age, Integer matchingInterests) {
		super();
		this.name = name;
		this.age = age;
		this.matchingInterests = matchingInterests;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getMatchingInterests() {
		return matchingInterests;
	}
	public void setMatchingInterests(Integer matchingInterests) {
		this.matchingInterests = matchingInterests;
	}
    
    
}
