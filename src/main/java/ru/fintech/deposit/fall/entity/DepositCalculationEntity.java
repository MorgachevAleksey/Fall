package ru.fintech.deposit.fall.entity;

import jakarta.persistence.*;

//Класс-сущность, фактически описывает таблицу в БД
@Entity //Как раз указывает на то что этот класс - сущность
@Table(name = "deposit_calculations") //Имя таблицы явно
public class DepositCalculationEntity {
    @Id //Поле уникального ключа, обязательное
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Способ генерации id //TODO заменить на SEQUENCE
    @Column(name = "id")
    //Фактически - поле класса - колонка таблицы, значение в экземпляре - значение ячейки
    private long id; //Идеоматически приватные, с доступом через сеттеры, гетеры

    //Конструктор
    public DepositCalculationEntity(){ //Hibernate сам создает обьекты, поэтому ему нужен пустой конструктор и геттеры\сеттеры

    }

    //Геттеры
    public long getId() {
        return id;
    }

    //Сеттеры
    public void setId(long id) {
        this.id = id;
    }
}
