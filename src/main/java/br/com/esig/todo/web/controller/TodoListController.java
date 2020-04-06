package br.com.esig.todo.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.esig.todo.model.Task;
import br.com.esig.todo.service.TaskService;
import lombok.Getter;
import lombok.Setter;

@Component
@Scope("view")
public class TodoListController {
	
	@Autowired
	private TaskService taskService;
	
	@Getter
	private Task task = new Task();
	
	private List<Task> tasks = new ArrayList<>();
	
	private Boolean checkAll = false;
	
	@Getter
	@Setter
	private String filterOption = "all";
	
	@PostConstruct
    public void init() {
        this.loadTasks();
    }
	
	private void loadTasks() {
		this.tasks = taskService.findAll();
	}

	public void addTask() {
		this.taskService.save(task);
		task = new Task();
		this.loadTasks();
	}
	
	public void markTaskAsCompleted(Integer taskId) {
		Task task = this.taskService.findById(taskId);
		this.taskService.toggleStatus(task);
		this.loadTasks();
	}
	
	public void removeTask(Task task) {
		this.taskService.delete(task);
		this.loadTasks();
	}
	
	public Boolean getCheckAll() {
		return this.tasks.size() > 0 && this.tasks.stream().filter(task -> {
			return task.getCompleted();
		}).count() == this.tasks.size() ? true : this.checkAll;
	}
	
	public void setCheckAll(Boolean checkAll) {
		this.checkAll = checkAll;
	}
	
	public void toggleCheckAll() {
		if(this.checkAll) {
			this.taskService.markAllAsCompleted();
		}else {
			this.taskService.markAllAsPending();
		}
		this.loadTasks();
	}

	public List<Task> getTasks() {
		return (List<Task>) this.tasks.stream().filter(task -> {
			switch(this.filterOption) {
				case "pending":
					return !task.getCompleted();
				case "completed":
					return task.getCompleted();
			}
			return true;
		}).sorted((t1, t2) -> {
			return t1.getId() > t2.getId() ? 1 : -1;
		}).collect(Collectors.toList());
	}
}
