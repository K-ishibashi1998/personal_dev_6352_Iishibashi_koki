package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;

@Controller

public class TaskController {
	
	@Autowired
	TaskRepository taskRepository;
	//目標一覧表示
	@GetMapping( "/tasks")
	public String Index(Model model) {
		//tasksテーブルから目標一覧を取得
		List<Task> taskList = taskRepository.findAll();

		model.addAttribute("tasks", taskList);
		return "task";
	}

}
