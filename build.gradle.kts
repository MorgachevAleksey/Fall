plugins {
    java
    id("org.springframework.boot") version "4.0.6"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "ru.fintech.deposit"
version = "0.0.1-SNAPSHOT"
description = "Fall"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webmvc")
    testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation("org.springframework.boot:spring-boot-starter-validation") //Зависимость для валидации: Jakarta Validation API + Hibernate Validator
    implementation("org.springframework.boot:spring-boot-starter-data-jpa") //Зависимость для работы с БД
    runtimeOnly("org.postgresql:postgresql") //Подключение postgreSQL при запуске
    //implementation("org.springframework.boot:spring-boot-starter-web") //Поднять сервер
}

tasks.withType<Test> {
    useJUnitPlatform()
}
