# FALL

Корпоративный депозитный калькулятор на SpringBoot.
REST API принимает параметры депозита, считает сложные проценты с капитализацией, удерживает НДФЛ 13% и возвращает детальный график начислений.

---

**Текущий прогресс:** 
- готовы DTO-контракты API `CalculationRequest`, `CalculationResponse`, `CapitalizationType`
- создан скелет контроллера `DepositController` с заглушкой на эндпоинте `POST /api/v1/deposits/calculate`
- подготовлен пустой сервисный слой `DepositCalculationService` для бизнес-логики расчёта.

---

**Запуск:** 
`./gradlew bootRun`