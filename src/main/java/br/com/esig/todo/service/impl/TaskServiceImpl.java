package br.com.esig.todo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.esig.todo.model.Task;
import br.com.esig.todo.repository.TaskRepository;
import br.com.esig.todo.service.TaskService;

@Transactional
@Service	
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository repository;
	
	@Override
	public List<Task> findAll() {
		return repository.findAll();
	}

	@Override
	public Task save(Task task) {
		return repository.save(task);
	}

	@Override
	public void delete(Task task) {
		repository.delete(task);
	}

	@Override
	public void toggleStatus(Task task) {
		task.toogleStatus();
		this.save(task);
	}

	@Override
	public Task findById(Integer id) {
		return this.repository.getOne(id);
	}

	@Override
	public void toggleAllStatus(List<Task> tasks) {
		tasks.forEach(task -> {
			this.toggleStatus(task);
		});
	}
	
	@Override
	public void markAllAsPending() {
		this.repository.markAllAsPending();
	}

	@Override
	public void markAllAsCompleted() {
		this.repository.markAllAsCompleted();
	}

}
