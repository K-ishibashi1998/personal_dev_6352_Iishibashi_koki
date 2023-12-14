package com.example.demo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;

@Controller

public class TaskController {

	@Autowired
	TaskRepository taskRepository;

	


	//taskカテゴリーによる絞り込み
	@GetMapping("/tasks")
	public String tasks(
			@RequestParam(name = "goalId", defaultValue = "") Integer goalId,
			Model model) {

		//task一覧情報の取得
		List<Task> taskList = null;
		if (goalId == null) {
			return "redirect:/"; 
		} else {
			//taskテーブルからカテゴリーIDを指定して一覧を取得
			taskList = taskRepository.findByGoalId(goalId);
			model.addAttribute("tasks",taskList);
		}
		return "/task";
			
	}
	
	@GetMapping("/tasks/add")
	public String create() {
		
		taskList = taskRepository.findByGoalId(goalId);
		model.addAttribute("tasks",taskList);
		
		return "task_new";
	}
	
	
	
	@PostMapping("/tasks/create")
	public String createTask(
			
			@RequestParam("name")String name,
			Model model) {
		//Goalオブジェクトの生成
		 Task task= new Task(name);
		//itemテーブルへのデータの反映(INSERT)
		taskRepository.save(task);
		//「/items」にGETでリクエストしなおせ(リダイレクト)
		return "redirect:/tasks";
	}

}

	

