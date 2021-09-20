package exeption;

public class ConstructorException extends Exception {
    String message;

    public ConstructorException(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}
