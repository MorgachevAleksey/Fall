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
    public ResponseEntity<ErrorResponse> handleValidation (MethodArgumentNotValidException ex){ //Метод обработки ошибок валидации полей пользовательского ввода;ResponseEntity - класс с тремя компонентами HTTP-статус, Тело(здесь будет ErrorResponse), Заголовки
        String message = ex
                .getBindingResult() //Результат валидации, содержит ВСЕ ошибки
                .getFieldErrors() //Список (List) ошибок по полям
                .stream() //Поток, идеоматичный выбор, в отличие от цикла
                .map(error -> error.getField() + ":" + error.getDefaultMessage()) //Лямбда-выржаение для каждой ошибки (элемента списка)
                .findFirst() //Взять из потока первую ошибку, обернуть в Optional и вернуть
                .orElse("VALIDATION FAILED"); //Нужен если контейнер ошибок пуст (это невозможно если уж поймана ошибка валидации), но требуется для findFrist(возвращает Optional) для обработки null

        ErrorResponse error = new ErrorResponse("VALIDATION_ERROR",message, LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    //Общий обработчик
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric (Exception ex){
        ErrorResponse error = new ErrorResponse("ITERNAL_ERROR", "An unexpected error occurred", LocalDateTime.now()); //Безопасность через неинформативность

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
