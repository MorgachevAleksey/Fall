package ru.fintech.deposit.fall.dto.error;

import java.time.LocalDateTime;

//Возврат ошибки
public record ErrorResponse( //record - стандартно для DTO
        String code, //машиночитаемый код ошибки
        String message, //человекочитаемое описание ошибки на en
        LocalDateTime timestamp //время
) {

}