import java.util.Scanner;

public class JavaTodoList {

    public static String[] model = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    /**
     * menampilkan TodoList
     */
    public static void showTodoList(){
        System.out.println("TODO");
        for (var i = 0; i < model.length; i++){
            String todo = model[i];
            Integer no = i+1;

            if (model[i] != null){
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodoList(){
        model[0] = "Belajar Java Dasar";
        model[1] = "Mencoba Aplikasi Todo List";
        showTodoList();
    }

    /**
     * menambahkan TodoList
     */
    public static void addTodoList(String todo){
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null){
                isFull = false;
                break;
            }
        }

        if (isFull){
            var temp = model;
            model = new String[model.length * 2];
            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        for (int i = 0; i < model.length; i++) {
            if (model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList(){
        for (int i = 0; i < 10; i++) {
            addTodoList("Contoh Todo ke-" + (i+1));
        }
        showTodoList();
    }

    /**
     * menghapus TodoList
     */
    public static boolean removeTodoList(Integer number){
        if (number > model.length){
            return false;
        }else if(number < 1){
            return false;
        }else if (model[number-1] == null) {
            return false;
        }else {
            for (int i = (number-1); i < model.length; i++) {
                if (i != (model.length - 1)) {
                    model[i] = model[i+1];
                }else {
                    model[i] = null;
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList(){
        testAddTodoList();
        while (true){
            var input = input("Pilih");
            if (removeTodoList(Integer.valueOf(input))){
                System.out.println("DATA " + input + " BERHASIL DIHAPUS");
            }else {
                System.out.println("DATA " + input + " GAGAL DIHAPUS");
            }
            showTodoList();
        }

    }

    public static String input(String info) {
        System.out.print(info + " : ");
        var data = scanner.nextLine();
        return data;
    }

    public static void viewShowTodoList(){
        while (true){
            showTodoList();
            System.out.println("MENU:");
            System.out.println("1. Tambah Data");
            System.out.println("2. Hapus Data");
            System.out.println("3. Keluar (x)");
            var input = input("Pilih");
            if (input.equals("1")){
                viewAddTodoList();
            }else if(input.equals("2")){
                viewRemoveTodoList();
            }else if(input.equals("3")){
                break;
            }else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }

    }

    public static void testViewShowTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");
        viewShowTodoList();
    }

    public static void viewAddTodoList(){
        System.out.println("MENAMBAH TODOLIST");
        var input = input("TODO (x jika batal)");
        if (input.equals("x")){

        }else {
            addTodoList(input);
        }
    }

    public static void testViewAddTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        viewAddTodoList();
        showTodoList();
    }

    public static void viewRemoveTodoList(){
        System.out.println("MENGHAPUS TODOLIST");
        var input = input("Pilih Nomor: (x) jika batal");
        if (input.equals("x")){

        }else {
            boolean success = removeTodoList(Integer.valueOf(input));
            if (!success){
                System.out.println("Gagal menghapus TODO: " + input);
            }
        }
    }

    public static void testViewRemoveTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        showTodoList();
        viewRemoveTodoList();
        showTodoList();
    }
}
