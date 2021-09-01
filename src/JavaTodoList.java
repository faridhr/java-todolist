public class JavaTodoList {

    public static String[] model = new String[10];

    public static void main(String[] args) {
//        testShowTodoList();
        testAddTodoList();
    }

    /**
     * menampilkan TodoList
     */
    public static void showTodoList(){
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
        for (int i = 0; i < 25; i++) {
            addTodoList("Contoh Todo ke-" + i);
        }
        showTodoList();
    }

    /**
     * menghapus TodoList
     */
    public static void removeTodoList(){

    }
}
