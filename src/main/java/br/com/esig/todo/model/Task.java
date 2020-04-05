package br.com.esig.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * This class represents a task in a todo list
 * 
 * @author rafaelhrborges
 *
 */
@Entity
@Table(name = "task")
public class Task {
	
	@Getter 
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Getter
	@Setter
	private String title;
	
	@Getter
	@Setter
	private Boolean completed = false;

	public void toogleStatus() {
		this.completed = !this.completed;
	}
}
