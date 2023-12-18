package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

			@RequestParam("goal_name") String name,
			Model model) {
		//Goalオブジェクトの生成
		Goal goal = new Goal(name);
		//itemテーブルへのデータの反映(INSERT)
		goalRepository.save(goal);
		//「/items」にGETでリクエストしなおせ(リダイレクト)
		return "redirect:/goals";
	}

	//編集画面表示
	@GetMapping("/goal/{id}/edit")
	public String edit(
			@PathVariable("id") Integer id,
			Model model) {

		Goal goal = goalRepository.findById(id).get();
		model.addAttribute("goal", goal);
		return "goal_edit";

	}

	@PostMapping("/goal/{id}/edit")
	public String update(
			@PathVariable("id") Integer id,
			@RequestParam(value = "name", defaultValue = "") String name) {

		// 1. DBから変更したいデータを取得する
		Goal goal = goalRepository.findById(id).get();
		// 2. そのデータを書き換える
		goal.setName(name);

		// 3. 書き換えたデータを保存する
		goalRepository.save(goal);

		return "redirect:/goals";

	}

}
