package ru.fintech.deposit.fall.dto;

import java.math.BigDecimal;

//Выходные данные расчета
public record CalculationResponse(
        //Всего денег на счету
        BigDecimal totalAmount,
        //Начиселенные проценты
        BigDecimal interestAmount,
        //Удержанные налоги
        BigDecimal taxAmount,
        //Чистые
        BigDecimal netAmount
) {

}
