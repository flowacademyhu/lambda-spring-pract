package hu.flowacademy.demo.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class ExceptionCatcher {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleValidationEx(ValidationException ex) {
        return ResponseEntity.badRequest()
                .body(
                        Map.of("error", ex.getMessage())
                );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationStuff(MethodArgumentNotValidException ex) {
        System.out.println(ex.getParameter());
        return ResponseEntity.badRequest()
                .body(
                        Map.of("error", ex.getMessage())
                );
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Object> handleAnyOtherCases(Throwable e) {
        System.out.println(e.getClass().getName() + ":" + e.getMessage());
        return ResponseEntity.internalServerError()
                .body(
                        Map.of("error", "Something went really wrong...")
                );
    }
}
