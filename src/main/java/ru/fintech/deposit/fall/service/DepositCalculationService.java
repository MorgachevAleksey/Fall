package ru.fintech.deposit.fall.service;

import org.springframework.stereotype.Service;
import ru.fintech.deposit.fall.dto.CalculationRequest;
import ru.fintech.deposit.fall.dto.CalculationResponse;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class DepositCalculationService {

    //Наловговая ставка
    private static final BigDecimal TAX_RATE = new BigDecimal("0.13"); //Обязатель из string
    //Точность расчета
    private static final int CALCULATION_SCALE = 10;
    //Копейки
    private static final int MONEY_SCALE = 2;
    //На будущее
    private static final int ONE_HUNDRED = 100;

    //Метод получает на вход DTO request
    public CalculationResponse calculate (CalculationRequest request) {
        //Первоначальный взнос
        BigDecimal principal = request.principal(); //Геттер record по умолчанию
        //Годовая ставка
        BigDecimal annualRate = request.annualRate();
        //Срок
        Integer termMonths = request.termMonths();

        //Вычисление баланса депозита
        //Формула сложного процента итог = начальная_сумма × (1 + ставка_за_период) ^ количество_периодов
        //Месячная ставка
        BigDecimal monthlyRate = annualRate.divide(BigDecimal.valueOf(12), CALCULATION_SCALE, RoundingMode.HALF_UP); //Деление (знаменатель, скейл, округление) !скейл при делении прописывается сразу
        //(1 + ставка_за_перод) - месяц
        BigDecimal multiplier = BigDecimal.ONE.add(monthlyRate);
        //Вся формула
        BigDecimal totalAmount = principal;
        for (int i = 0; i < termMonths; i++){
            totalAmount = totalAmount.multiply(multiplier).setScale(CALCULATION_SCALE, RoundingMode.HALF_UP);
        }
        //Округление результата до копеек
        totalAmount = totalAmount.setScale(MONEY_SCALE, RoundingMode.HALF_UP);

        //Вычисление только начисленных процентов
        BigDecimal interestAmount = totalAmount.subtract(principal);
        //Вычисление удержанных налогов
        BigDecimal taxAmount = interestAmount.multiply(TAX_RATE).setScale(MONEY_SCALE, RoundingMode.HALF_UP);
        //Вычисление чистой прибыли
        BigDecimal netAmount = interestAmount.subtract(taxAmount);

        //Метод возвращает DTO response
        return new CalculationResponse(totalAmount, interestAmount, taxAmount, netAmount);
    }
}
