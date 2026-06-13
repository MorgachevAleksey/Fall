package ru.fintech.deposit.fall.controller;

import org.springframework.web.bind.annotation.*;
import ru.fintech.deposit.fall.dto.CalculationRequest;
import ru.fintech.deposit.fall.dto.CalculationResponse;

import java.math.BigDecimal;

@RestController                         //Controller + ResponsableBodt
@RequestMapping("/api/v1/deposits")  //Адрес эндпоинта
public class DepositController {

    @PostMapping("/calculate")  //POST-метод принимает Request возвращает Response
    public CalculationResponse calculate (@RequestBody CalculationRequest request) {
        return new CalculationResponse(
                BigDecimal.ZERO,
                BigDecimal.ZERO,
                BigDecimal.ZERO,
                BigDecimal.ZERO
                //FIXME пока что заглушка
        );
    }
}
