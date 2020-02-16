/*
 * Copyright (c) 2020. Ivannikov Alexandr Romanovich.
 * The text of this program is protected by copyright. Using it for commercial or personal purposes is prohibited
 * All rights reserved.
 */

package ConsoleApp;

import java.time.LocalDateTime;
import java.util.Objects;

import com.google.gson.*;

public class Worker implements Comparable<Worker> {
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

        public float getX() {
            if(x>553) throw new FieldException();
            else return x;
        }

        public Long getY() {
            if(y<=-179) throw new FieldException();
            else return y;
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
                Colors.blue() + " id: " + Colors.reset() + id +
                        Colors.blue() + "\n Имя рабочего: " + Colors.reset() + name +
                        Colors.blue() + "\n Координаты рабочего: " + Colors.reset() + coordinates.toString() +
                        Colors.blue() + "\n Дата добавления рабочего: " + Colors.reset() + creationDate +
                        Colors.blue() + "\n Зарплата рабочего: " + Colors.reset() + salary +
                        Colors.blue() + "\n Должность рабочего: " + Colors.reset() + position.getValue() +
                        Colors.blue() + "\n Статус рабочего: " + Colors.reset() + status.getValue() +
                        Colors.blue() + "\n Человек: " + Colors.reset() + person +
                        '}';
    }

    public int getId() {
        if (id < 0) throw new FieldException();
        else return id;
    }

    @Override
    public int compareTo(Worker o) {
        return Double.compare(getSalary(), o.getSalary());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;
        Worker worker = (Worker) o;
        return id == worker.id &&
                Double.compare(worker.salary, salary) == 0 &&
                name.equals(worker.name) &&
                coordinates.equals(worker.coordinates) &&
                creationDate.equals(worker.creationDate) &&
                position == worker.position &&
                status == worker.status &&
                Objects.equals(person, worker.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, salary, position, status, person);
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Worker parseWorker(String json) {
        Worker worker = new Gson().fromJson(json, Worker.class);
        try {
            worker.getSalary();
            worker.getId();
            worker.getName();
            worker.getCoordinates();
            worker.getCoordinates().getX();
            worker.getCoordinates().getY();
            if(worker.getPerson() != null){
                worker.getPerson().getLocation();
                worker.getPerson().getWeight();
                worker.getPerson().getHeight();
                worker.getPerson().getPassportID();
                worker.getPerson().getLocation().getX();
                worker.getPerson().getLocation().getY();
            }
            worker.getCreationDate();
            worker.getPosition();
            worker.getStatus();
            return worker;
        }catch (FieldException e){
            throw new FileArgsException();
        }
    }

    public String toJSON() {
        return new Gson().toJson(this);
    }

    public double getSalary() {
        if (salary < 0) throw new FieldException();
        else return salary;
    }

    public String getName() {
        if (name == null || name.equals("")) throw new FieldException();
        else return name;
    }

    public Coordinates getCoordinates() {
        if (coordinates == null) throw new FieldException();
        else return coordinates;
    }

    public LocalDateTime getCreationDate() {
        if(creationDate == null) throw new FieldException();
        else return creationDate;
    }

    public Position getPosition() {
        if(position == null) throw new FieldException();
        else return position;
    }

    public Status getStatus() {
        if(status == null) throw new FieldException();
        else return status;
    }

    public Person getPerson() {
        return person;
    }
}
