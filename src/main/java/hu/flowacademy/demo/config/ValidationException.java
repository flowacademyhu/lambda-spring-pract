package hu.flowacademy.demo.config;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
