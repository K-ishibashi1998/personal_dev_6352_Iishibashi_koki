data.sql	INSERT INTO goals(name) VALUES('生活習慣直す');
	INSERT INTO goals(name) VALUES('Javaを習得する');
	INSERT INTO goals(name) VALUES('痩せる');
	
	INSERT INTO tasks(goal_id, name, num) VALUES(1, '朝6時に起きる', 1);
	
	INSERT INTO tasks(goal_id, name,num) VALUES(2, '予習・復習する',5);
	INSERT INTO tasks(goal_id, name,num) VALUES(2, '課題を完全に理解する',3);
	
	INSERT INTO tasks(goal_id, name, num) VALUES(3, '間食をやめる', 0);
	INSERT INTO tasks(goal_id, name, num) VALUES(3, 'お菓子を我慢する', 1);
	INSERT INTO tasks(goal_id, name, num) VALUES(3, '腹筋50回する', 1);