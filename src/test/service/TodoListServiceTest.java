package test.service;

import entity.TodoList;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListServiceTest {

    public static void main(String[] args) {

        testAddTodoList();

    }

    public static void testShowTodoList(){
//        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl();
        todoListRepository.data[0] = new TodoList("Belajar JAVA Dasar");
        todoListRepository.data[1] = new TodoList("Belajar JAVA OOP");
        todoListRepository.data[2] = new TodoList("Belajar JAVA Standard Class");
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        todoListService.showTodoList();
    }

    public static void testAddTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        todoListService.addTodoList("Belajar JAVA Dasar");
        todoListService.addTodoList("Belajar JAVA OOP");
        todoListService.addTodoList("Belajar JAVA Stadard Class");
        todoListService.showTodoList();
    }

}
