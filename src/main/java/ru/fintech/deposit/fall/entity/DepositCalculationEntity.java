package ru.fintech.deposit.fall.entity;  //TODO заккоментировать поля

import jakarta.persistence.*;
import ru.fintech.deposit.fall.dto.request.CapitalizationType;
import java.math.BigDecimal;
import java.time.LocalDateTime;

//Класс-сущность, фактически описывает таблицу в БД
@Entity //Как раз указывает на то что этот класс - сущность
@Table(name = "deposit_calculations") //Имя таблицы явно
public class DepositCalculationEntity {
    @Id //Поле уникального ключа, обязательное
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Способ генерации id //TODO заменить на SEQUENCE
    @Column(name = "id")
    //Фактически - поле класса - колонка таблицы, значение в экземпляре - значение ячейки
    private long id; //Идеоматически приватные, с доступом через сеттеры, гетеры

    @Column(name = "principal", nullable = false, precision = 19, scale = 2)
    private BigDecimal principal;

    @Column(name = "annual_rate", nullable = false, precision = 19, scale = 2)
    private BigDecimal annualRate;

    @Column(name = "term_months", nullable = false)
    private Integer termMonths;

    @Enumerated(EnumType.STRING) //Важно!
    @Column(name = "capitalization_type", nullable = false, length = 20)
    private CapitalizationType capitalizationType;

    @Column(name = "total_amount", nullable = false, precision = 19, scale = 2)
    private BigDecimal totalAmount;

    @Column(name = "interest_amount", nullable = false, precision = 19, scale = 2)
    private BigDecimal interestAmount;

    @Column(name = "tax_amount", nullable = false, precision = 19, scale = 2)
    private BigDecimal taxAmount;

    @Column(name = "net_amount", nullable = false, precision = 19, scale = 2)
    private BigDecimal netAmount;

    @Column(name = "calculated_at", nullable = false) //Прописать логику в сервисе
    private LocalDateTime calculatedAt;

    //Конструктор
    public DepositCalculationEntity(){ //Hibernate сам создает обьекты, поэтому ему нужен пустой конструктор и геттеры\сеттеры

    }

    //Геттеры
    public long getId() {
        return id;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public BigDecimal getAnnualRate() {
        return annualRate;
    }

    public Integer getTermMonths() {
        return termMonths;
    }

    public CapitalizationType getCapitalizationType() {
        return capitalizationType;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public BigDecimal getInterestAmount() {
        return interestAmount;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public LocalDateTime getCalculatedAt() {
        return calculatedAt;
    }

    //Сеттеры
    public void setId(long id) {
        this.id = id;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public void setAnnualRate(BigDecimal annualRate) {
        this.annualRate = annualRate;
    }

    public void setTermMonths(Integer termMonths) {
        this.termMonths = termMonths;
    }

    public void setCapitalizationType(CapitalizationType capitalizationType) {
        this.capitalizationType = capitalizationType;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setInterestAmount(BigDecimal interestAmount) {
        this.interestAmount = interestAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public void setCalculatedAt(LocalDateTime calculatedAt) {
        this.calculatedAt = calculatedAt;
    }
}
