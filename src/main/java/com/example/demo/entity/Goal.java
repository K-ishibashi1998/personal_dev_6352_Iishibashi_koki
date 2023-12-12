package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "goals")

public class Goal {
	
	//フィールド
	@Id//主キー
	@GeneratedValue(strategy=GenerationType.IDENTITY)//自動採番
	private Integer id;
	private String name; 
	
	//ゲッター
	public Integer getId() {
		return id;
	}
	

	
	public String getName() {
		return name;
	}
	

}
