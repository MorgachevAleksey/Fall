Теоретический файл 

---
Порядок разработки

Проект писался снаружи->внутрь:
1. HTTP-контракты
2. Контроллер
3. Сервис
4. Валидация и обрабока ошибок
5. Сущность
6. Подключение БД и репозиторий

---
Spring Boot

Используемые аннотации:

Spring Boot 
1. @SpringBootApplication

Spring Web (Spring MVC)
1. @RestController 
2. @RequestMapping 
3. @PostMapping 
4. @RequestBody 
5. @RestControllerAdvice 
6. @ExceptionHandler

Spring Context (IoC)
1. @Service

Jakarta Validation (Bean Validation)
1. @Valid 
2. @NotNull 
3. @Min 
4. @DecimalMin

JPA / Hibernate 
1. @Entity 
2. @Table 
3. @Id 
4. @GeneratedValue 
5. @Column

---
Прочие технологии

Docker:
1. Установлен "снимок" postgreSQL 15.18
2. Создан контейнер
3. Добавлены зависимости (build.gradle.kts) //TODO описать подробно
4. Добавлены настройки подключения (application.poperties) //TODO описать подробно

---
Архитектура

Клссическая трехслойная архитектура

Зависимость слоев: Контролер -> Сервис -> Репозиторий
Зависимости инжектируются через конструктор