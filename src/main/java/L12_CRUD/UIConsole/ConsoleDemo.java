package L12_CRUD.UIConsole;

public class ConsoleDemo {
    public static void main(String[] args) {
        Console console = new Console();
        console.crud.getModel().initialModelDemo();
        console.start();
    }
}
