package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {

	//フィールド
	@Id //主キー
	@GeneratedValue(strategy = GenerationType.IDENTITY) //自動採番
	private Integer id;
	@Column(name = "goal_id")
	private Integer goalId;
	private String name;
	private Integer num;

	//ゲッター

	public Integer getGoalId() {
		return goalId;
	}

	public String getName() {
		return name;
	}

	public Integer getNum() {
		return num;
	}
	
	public Integer getId() {
		return id;
	}
	
	

	public Task() {

	}

	public Task(String name, Integer goalId) {
		this.name = name;
		this.goalId = goalId;
	}

	public void setName(String name) {
		this.name = name;
		}

	public void setNum(Integer num) {
		this.num=num;
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
