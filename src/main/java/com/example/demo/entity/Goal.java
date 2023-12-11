package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "goal")

public class Goal {
	
	//フィールド
	@Id//主キー
	@GeneratedValue(strategy=GenerationType.IDENTITY)//自動採番
	private Integer id;
	@Column(name="Goals_id")
	private Integer goalId;
	private String TEXT; 
	
	//ゲッター
	public Integer getId() {
		return id;
	}
	
	public Integer getGoalsId() {
		return getGoalsId();
		
	}
	
	public String getTextId() {
		return TEXT;
	}
	

}
