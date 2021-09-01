package service;

import entity.TodoList;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {

    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        TodoList[] model = todoListRepository.getAll();
        for (var i = 0; i < model.length; i++){
            var todo = model[i];
            Integer no = i+1;

            if (model[i] != null){
                System.out.println(no + ". " + todo.getTodo());
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        TodoList todoList = new TodoList(todo);
        todoListRepository.add(todoList);
        System.out.println("SUKSES MENAMBAHKAN TODO : " + todo);
    }

    @Override
    public void removeTodoList(Integer number) {

    }
}
