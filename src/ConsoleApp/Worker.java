/*
 * Copyright (c) 2020. Ivannikov Alexandr Romanovich.
 * The text of this program is protected by copyright. Using it for commercial or personal purposes is prohibited
 * All rights reserved.
 */

package ConsoleApp;

import java.time.LocalDateTime;

public class Worker {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double salary; //Значение поля должно быть больше 0
    private Position position; //Поле не может быть null
    private Status status; //Поле не может быть null
    private Person person; //Поле может быть null

    public Worker(String name, float x, Long y, double salary, Position position, Status status, Double height, Long weight, String passportID, Float x1, Long y2, long z) {
        this.name = name;
        this.coordinates = new Coordinates(x, y);
        this.salary = salary;
        this.position = position;
        this.status = status;
        this.person = new Person(height, weight, passportID, x1, y2, z);
        this.id = IdGenerator.generate();
        this.creationDate = LocalDateTime.now();
    }

    public Worker(String name, float x, Long y, double salary, Position position, Status status, Person person) {
        this.name = name;
        this.coordinates = new Coordinates(x, y);
        this.salary = salary;
        this.position = position;
        this.status = status;
        this.person = person;
        this.id = IdGenerator.generate();
        this.creationDate = LocalDateTime.now();
    }

    public class Coordinates {
        public Coordinates(float x, Long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        private float x; //Максимальное значение поля: 553
        private Long y; //Значение поля должно быть больше -179, Поле не может быть null
    }

    public enum Position {
        HUMAN_RESOURCES("Отдел кадров"),
        HEAD_OF_DIVISION("Начальник отдела"),
        LEAD_DEVELOPER("Ведущий разработчик"),
        CLEANER("Уборщик"),
        MANAGER_OF_CLEANING("Менеджер по уборке");

        private String value;

        Position(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum Status {
        FIRED("Уволен"),
        HIRED("Наемный"),
        RECOMMENDED_FOR_PROMOTION("Рекомендован"),
        REGULAR("Работает"),
        PROBATION("На испытательном сроке");

        private String value;

        Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    @Override
    public String toString() {
        return
                Colors.blue() +" id: " + Colors.reset() + id +
                Colors.blue() +"\n Имя рабочего: "+ Colors.reset() + name +
                Colors.blue() +"\n Координаты рабочего: "+ Colors.reset() + coordinates.toString() +
                Colors.blue() +"\n Дата добавления рабочего: "+ Colors.reset() + creationDate +
                Colors.blue() +"\n Зарплата рабочего: "+ Colors.reset() + salary +
                Colors.blue() +"\n Должность рабочего: "+ Colors.reset() + position.getValue() +
                Colors.blue() +"\n Статус рабочего: "+ Colors.reset() + status.getValue() +
                Colors.blue() +"\n Человек: "+ Colors.reset() + person +
                '}';
    }

}
