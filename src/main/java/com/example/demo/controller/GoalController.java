package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Goal;
import com.example.demo.repository.GoalRepository;

@Controller
public class GoalController {

	@Autowired
	GoalRepository goalRepository;
	//目標一覧表示
	@GetMapping({ "/", "/goals" })
	public String Index(Model model) {
		//goalsテーブルから目標一覧を取得
		List<Goal> goalList = goalRepository.findAll();

		model.addAttribute("goals", goalList);
		return "goal";
	}

}
