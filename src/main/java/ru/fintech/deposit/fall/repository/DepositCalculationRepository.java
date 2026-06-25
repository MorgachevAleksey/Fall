package ru.fintech.deposit.fall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fintech.deposit.fall.entity.DepositCalculationEntity;

//Интерфейс репозитория, для взаимодействия с бд
public interface DepositCalculationRepository extends JpaRepository<DepositCalculationEntity, Long>{ //Два параметра: тип сущности (какой таблице соответсвует) и тип первичного ключа (id)

}
