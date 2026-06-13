package ru.fintech.deposit.fall.service;

import org.springframework.stereotype.Service;
import ru.fintech.deposit.fall.dto.CalculationRequest;
import ru.fintech.deposit.fall.dto.CalculationResponse;

import java.math.BigDecimal;

@Service
public class DepositCalculationService {

    private static final BigDecimal TAX_RATE = new BigDecimal("0.13");  //Наловговая ставка
    private static final int CALCULATION_SCALE = 10;                        //Точность расчета
    private static final int MONEY_SCALE = 2;                               //Копейки
    private static final int ONE_HUNDRED = 100;                             //На будущее

    public CalculationResponse calculate (CalculationRequest request) {
        //TODO Переписать заглушку

        return new CalculationResponse(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
    }
}
