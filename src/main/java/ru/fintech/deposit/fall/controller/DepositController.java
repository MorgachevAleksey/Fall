package ru.fintech.deposit.fall.controller;

import org.springframework.web.bind.annotation.*;
import ru.fintech.deposit.fall.dto.CalculationRequest;
import ru.fintech.deposit.fall.dto.CalculationResponse;
import ru.fintech.deposit.fall.service.DepositCalculationService;

@RestController                         //Controller + ResponsableBodt
@RequestMapping("/api/v1/deposits")  //Адрес эндпоинта
public class DepositController {
    //ТОЛЬКО Constructor Injection
    //Зависимость, поле сервиса в контроллере
    private final DepositCalculationService calculationService;
    //Контструктор коннтроллера с сервисом (можно без @Autowired т.к. конструктор всего один)
    public DepositController (DepositCalculationService calculationService){
        this.calculationService = calculationService;
    }

    @PostMapping("/calculate")       //POST-метод принимает Request возвращает Response
    public CalculationResponse calculate (@RequestBody CalculationRequest request) {
        return calculationService.calculate(request);
    }
}
