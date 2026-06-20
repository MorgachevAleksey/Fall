package ru.fintech.deposit.fall.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.fintech.deposit.fall.dto.error.ErrorResponse;

import java.time.LocalDateTime;

//Глобальный обработчик ошибок
@RestControllerAdvice //@ControllerAdvice + @ResponseBody(возвращаем JSON, не HTML) один обработчик на все приложение, глобальный
public class GlobalExceptionHandler {
    //Важно чтобы метод с обработкой конкретной ошибки шел перед родителем(Exception) - обработчики ищутся сверху-вниз, от конкретного к общему
    @ExceptionHandler(MethodArgumentNotValidException.class) //Если из любого контроллера(1 на приложение) вылетает MethodArgumentNotValidException(аргумент не прошел валидацию) - вызывается метод под аннотацией
    public ResponseEntity<ErrorResponse> handleValidation (MethodArgumentNotValidException ex){ //ResponseEntity - класс с тремя компонентами HTTP-статус, Тело(здесь будет ErrorResponse), Заголовки
        String message = String.valueOf(ex.getBindingResult().getFieldError()); //FIXME безопасность через неявность

        ErrorResponse error = new ErrorResponse("VALIDATION_ERROR",message, LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    //TODO @ExceptionHandler(Exception.class)
}
