package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;

@Controller

public class TaskController {

	@Autowired
	TaskRepository taskRepository;

	


	//taskカテゴリーによる絞り込み
	@GetMapping("/goals/{goalId}/tasks")
	public String tasks(
			@PathVariable("goalId") Integer goalId,
			Model model) {

		//task一覧情報の取得
		List<Task> taskList = null;
		if (goalId == null) {
			return "redirect:/"; 
		} else {
			//taskテーブルからカテゴリーIDを指定して一覧を取得
			taskList = taskRepository.findByGoalId(goalId);
			model.addAttribute("tasks",taskList);
			model.addAttribute("goalId",goalId);
		}
		return "/task";
			
	}
	
	// やることリストの追加画面の表示をしているメソッド
	@GetMapping("/tasks/add")
	public String create(
			@RequestParam(name="goalId",defaultValue="")Integer goalId,
			Model model) {
		
		
		model.addAttribute("goalId",goalId);
		
		// Springのcontrollerでは、returnの後にファイル名を書くことによって、
		// そのファイルを表示してくれる機能がある
		// 今回の場合は、task_new.htmlが表示される
		// 直接HTMLを表示することをフォワードと呼ぶ
		// フォワードを使うときは、以下のパターン
		// ・一覧画面の表示(検索結果の表示)
		// ・詳細画面の表示
		// ・新規登録画面の表示
		// ・編集画面の表示
		// つまり、@GetMapping()をメソッドの上に書いたときは、
		// フォワードを使用
		return "task_new";

	}
	
	
	// やることリストへのデータの追加を行っているメソッド
	@PostMapping("/tasks/add")
	public String createTask(
			// HTMLから送られる一つのデータにつき、@RequestParamは一つ
			@RequestParam("name")String name,
			@RequestParam("goalId")Integer goalId,
			Model model) {
			
		// Taskオブジェクトの生成
		Task task= new Task(name,goalId);
		//itemテーブルへのデータの反映(INSERT)
		taskRepository.save(task);
		//「/items」にGETでリクエストしなおせ(リダイレクト)
		
		
		// redirectは、redirectの:以降にのパスが書いてある
		// controllerのメソッドを実行する
		// 今回の場合は、@GetMapping("/tasks")以下のメソッドを実行する
		// 別のメソッドを実行することをリダイレクトと呼ぶ
		// ・データの新規登録をしたとき
		// ・データの更新をしたとき
		// ・データを削除したとき
		// つまり、@PostMapping()を書いたときは、リダイレクトを使用
		// return "redirect:/tasks";
		return "redirect:/tasks";
	}

}

	

