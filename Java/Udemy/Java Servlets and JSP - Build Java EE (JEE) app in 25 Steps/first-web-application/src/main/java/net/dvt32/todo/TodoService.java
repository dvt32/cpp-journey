package net.dvt32.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoService {
	
	private static List<Todo> todos = new ArrayList<>();
	
	static {
		todos.add( new Todo("Learn Web Application Development", "Study") );
		todos.add( new Todo("Learn Spring MVC", "Study") );
		todos.add( new Todo("Learn Spring Rest Services", "Study") );
	}
	
	public List<Todo> getTodos() {
		return todos;
	}
	
	public void addTodo(Todo todo) {
		todos.add(todo);
	}
	
	public void deleteTodo(Todo todo) {
		todos.remove(todo);
	}
	
}