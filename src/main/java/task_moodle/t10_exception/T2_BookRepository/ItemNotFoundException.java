package task_moodle.t10_exception.T2_BookRepository;

public class ItemNotFoundException extends Exception {

    public ItemNotFoundException(String message) {
        super(message);
    }

    public ItemNotFoundException() {
    }
}
