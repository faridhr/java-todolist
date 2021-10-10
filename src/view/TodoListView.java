package view;

import service.TodoListService;
import service.TodoListServiceImpl;
import util.InputUtil;

public class TodoListView {

    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public  void showTodoList(){
        while (true){
            todoListService.showTodoList();
            System.out.println("MENU:");
            System.out.println("1. Tambah Data");
            System.out.println("2. Hapus Data");
            System.out.println("3. Keluar (x)");
            var input = InputUtil.input("Pilih");
            if (input.equals("1")){
                addTodoList();
            }else if(input.equals("2")){
                removeTodoList();
            }else if(input.equals("3")){
                break;
            }else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public void addTodoList(){
        System.out.println("MENAMBAH TODOLIST");
        var input = InputUtil.input("TODO (x jika batal)");
        if (input.equals("x")){

        }else {
            todoListService.addTodoList(input);
        }
    }

    public void removeTodoList(){
        System.out.println("MENGHAPUS TODOLIST");
        var input = InputUtil.input("Pilih Nomor: (x) jika batal");
        if (input.equals("x")){

        }else {
            todoListService.removeTodoList(Integer.valueOf(input));
        }
    }

}
