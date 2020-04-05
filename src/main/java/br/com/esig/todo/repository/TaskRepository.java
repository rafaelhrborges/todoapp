package br.com.esig.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.esig.todo.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

	List<Task> findAllByCompletedTrue();
	
	void deleteAllByCompletedTrue();
	
	@Modifying
	@Query("update Task task set task.completed = false")
	void markAllAsPending();
	
	@Modifying
    @Query("update Task task set task.completed = true")
    void markAllAsCompleted();
}
