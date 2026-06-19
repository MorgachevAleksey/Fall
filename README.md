# FALL

Корпоративный депозитный калькулятор на SpringBoot.
REST API принимает параметры депозита, считает сложные проценты с капитализацией, удерживает НДФЛ 13% и возвращает детальный график начислений.

---

**Текущий прогресс:**
- готовы DTO-контракты API: `CalculationRequest`, `CalculationResponse`, `CapitalisatyonType`
- реализован контроллер `DepositController` с эндпоинтом `POST /api/v1/deposits/calculate` (constructor injection → service)
- реализован сервис `DepositCalculationService`: сложный процент с помесячной капитализацией, расчёт процентов, НДФЛ 13%, `netAmount`
- расчёты на `BigDecimal` с отдельной точностью для промежуточных вычислений и итоговых сумм (`RoundingMode.HALF_UP`)
- валидация пользовательского ввода

---

**Запуск:** 
`./gradlew bootRun`