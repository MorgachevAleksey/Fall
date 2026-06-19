package ru.fintech.deposit.fall.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.*;

//Входные данные для расчета
public record CalculationRequest (            //поля final
        //Первоначальный взнос
        @NotNull //Валидация - не должен быть null (а он может прийти пустым), валидирую как можно раньше на этапе DTO, подключенна зависимость spring-validation
        @DecimalMin(value = "0.01", inclusive = true) //Не должен быть меньше одной копейки, включительно! (по умолчанию, но прописал явно)
        BigDecimal principal,                 //для денег !только BigDecimal
        //Годовая ставка
        @NotNull
        @DecimalMin(value = "0.0001", inclusive = true)
        BigDecimal annualRate,
        //Срок
        @NotNull
        @Min(1) // >= 1
        Integer termMonths,                    //Integer чтобы был null иначе, пустое поле превратит в null
        //Частота начисления
        @NotNull
        CapitalisatyonType capitalisatyonType //Перечисление для типобезопасности (String с мусором пошел бы дальше)
){

}
