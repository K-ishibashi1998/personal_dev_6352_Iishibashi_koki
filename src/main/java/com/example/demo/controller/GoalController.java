package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/goals/add")
	public String create() {
		return "goal_add";
	}
	
	//新規登録処理
	@PostMapping("/goals/add")
	public String create(
			
			@RequestParam("goal_name")String name,
			Model model) {
		System.out.println("@@@@@@@@@@@@@@@");
		System.out.println(name);
		//Itemオブジェクトの生成
		 Goal goal= new Goal(name);
		//itemテーブルへのデータの反映(INSERT)
		goalRepository.save(goal);
		//「/items」にGETでリクエストしなおせ(リダイレクト)
		return "redirect:/goals";
	}

}
