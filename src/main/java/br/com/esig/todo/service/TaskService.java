package br.com.esig.todo.service;

import java.util.List;

import br.com.esig.todo.model.Task;

public interface TaskService {
	
	Task save(Task task);
	
	void delete(Task task);
	
	List<Task> findAll();
	
	void toggleStatus(Task task);
	
	Task findById(Integer id);
	
	void toggleAllStatus(List<Task> tasks);
	
	void markAllAsCompleted();
	
	void markAllAsPending();
}
