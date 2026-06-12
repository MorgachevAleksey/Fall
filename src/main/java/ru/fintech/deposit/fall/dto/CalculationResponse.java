package ru.fintech.deposit.fall.dto;

import java.math.BigDecimal;

//Выходные данные расчета
public record CalculationResponse(
        BigDecimal totalAmount,         //Всего денег на счету
        BigDecimal interestAmount,      //Начиселенные проценты
        BigDecimal taxAmount,           //Удержанные налоги
        BigDecimal netAmount            //Чистые
) {

}
