package ru.fintech.deposit.fall.dto;

import java.math.BigDecimal;

//Входные данные для расчета
public record CalculationRequest (            //поля final
        BigDecimal principal,                 //для денег !только BigDecimal
        BigDecimal annualRate,
        Integer termMonth,                    //Integer чтобы был null иначе, пустое поле превратит в null
        CapitalisatyonType capitalisatyonType //Перечисление для типобезопасности (String с мусором пошел бы дальше)
){

}
