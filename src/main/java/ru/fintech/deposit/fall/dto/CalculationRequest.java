package ru.fintech.deposit.fall.dto;

import java.math.BigDecimal;

//Входные данные для расчета
public record CalculationRequest (            //поля final
        //Первоначальный взнос
        BigDecimal principal,                 //для денег !только BigDecimal
        //Годовая ставка
        BigDecimal annualRate,
        //Срок
        Integer termMonths,                    //Integer чтобы был null иначе, пустое поле превратит в null
        //Частота начисления
        CapitalisatyonType capitalisatyonType //Перечисление для типобезопасности (String с мусором пошел бы дальше)
){

}
