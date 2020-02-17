/*
 * Copyright (c) 2020. Ivannikov Alexandr Romanovich.
 * The text of this program is protected by copyright. Using it for commercial or personal purposes is prohibited
 * All rights reserved.
 */

package ConsoleApp;

import java.util.Scanner;


public class Factory {
    Factory() {

    }

    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Worker.Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double salary; //Значение поля должно быть больше 0
    private Worker.Position position; //Поле не может быть null
    private Worker.Status status; //Поле не может быть null
    private Person person; //Поле может быть null
    private float x; //Максимальное значение поля: 553
    private Long y; //Значение поля должно быть больше -179, Поле не может быть null
    private Double height; //Поле может быть null, Значение поля должно быть больше 0
    private Long weight; //Поле не может быть null, Значение поля должно быть больше 0
    private String passportID; //Значение этого поля должно быть уникальным, Строка не может быть пустой, Поле может быть null
    private Person.Location location; //Поле не может быть null
    private Float x1; //Поле не может быть null
    private Long y2; //Поле не может быть null
    private long z;
    Scanner scanner = new Scanner(System.in);

    /**
     * Создает человека
     * @return человек Person
     */
    public Person createPerson(){
        System.out.println("Введите рост рабочего.");
        setHeight();
        System.out.println("Введите вес рабочего");
        setWeight();
        setPassportID();
        setLocation();
        return new Person(height,weight,passportID,x1,y2,z);
    }

    /**
     * Создает рабочего
     * @return рабочий Worker
     */
    public Worker createWorker() {
        System.out.println("Здравствуйте! Для добавления нового рабочего в систему необходимо ввести данные о нем!");
        System.out.println("Введите пожалуйста ФИО");
        setName();
        System.out.println("Введите пожалуйста зарплату рабочего");
        setSalary();
        System.out.println("Введите пожалуйста должность рабочего");
        setPosition();
        System.out.println("Введите пожалуйста статус рабочего");
        setStatus();
        System.out.println("Введите координату Х рабочего");
        setX();
        System.out.println("Введите координату У рабочего");
        setY();
        System.out.println("Рабочий существует в реальности? Да/Нет");
        setPerson();
        if(person == null){
            return new Worker(name,x,y,salary,position,status,person);
        }else{
            return new Worker(name,x,y,salary,position,status,height,weight,passportID,x1,y2,z);
        }
    }

    public void setName() {
        String line = scanner.nextLine();
        try {
            Double d1 = new Double(line);
            System.out.println("Вы ввели неккоректное ФИО! Попробуйте еще раз");
            setName();
        } catch (NumberFormatException e) {
            if (line.length() <= 75 && line.length() >= 3) {
                name = line;
            } else {
                System.out.println("Недопустимая длина ФИО");
                setName();
            }
            ;
        }
    }

    public void setSalary() {
        String line = scanner.nextLine();
        try {
            Double d1 = new Double(line);
            if (d1 > 0) {
                salary = d1;
            } else {
                System.out.println("Вы не можете выплачивать рабочему отрицательные суммы. Он что-то заподозрит. Повторите ввод");
                setSalary();
            }
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели неккоректное число, попробуйте снова!");
            setSalary();
        }
    }

    public void setPosition() {
        System.out.println("Введите одну из возможных должностей:");
        System.out.println("Отдел кадров");
        System.out.println("Начальник отдела");
        System.out.println("Ведущий разработчик");
        System.out.println("Уборщик");
        System.out.println("Менеджер по уборке");
        String line = scanner.nextLine();
        switch (line) {
            case ("Отдел кадров"):
                position = Worker.Position.HUMAN_RESOURCES;
                break;
            case ("Начальник отдела"):
                position = Worker.Position.HEAD_OF_DIVISION;
                break;
            case ("Ведущий разработчик"):
                position = Worker.Position.LEAD_DEVELOPER;
                break;
            case ("Уборщик"):
                position = Worker.Position.CLEANER;
                break;
            case ("Менеджер по уборке"):
                position = Worker.Position.MANAGER_OF_CLEANING;
                break;
            default:
                System.out.println("Вы ввели неккоректную должность! Попробуйте снова!");
                setPosition();
                break;
        }
    }

    public void setStatus() {
        System.out.println("Введите один из возможных статусов:");
        System.out.println("Уволен");
        System.out.println("Наемный");
        System.out.println("Рекомендован");
        System.out.println("Работает");
        System.out.println("На испытательном сроке");
        String line = scanner.nextLine();
        switch (line) {
            case ("Уволен"):
                status = Worker.Status.FIRED;
                break;
            case ("Наемный"):
                status = Worker.Status.HIRED;
                break;
            case ("Рекомендован"):
                status = Worker.Status.RECOMMENDED_FOR_PROMOTION;
                break;
            case ("Работает"):
                status = Worker.Status.REGULAR;
                break;
            case ("На испытательном сроке"):
                status = Worker.Status.PROBATION;
                break;
            default:
                System.out.println("Вы ввели неккоректный статус! Попробуйте снова!");
                setStatus();
                break;
        }
    }

    public void setX() {
        String line = scanner.nextLine();
        try {
            float d = Float.parseFloat(line);
            if (d <= 553) {
                x = d;
            } else {
                System.out.println("Вы ввели слишком большое число! Попробуйте снова!");
                setX();
            }
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели неккоректное число, попробуйте снова!");
            setX();
        }
    }

    public void setY() {
        String line = scanner.nextLine();
        try {
            Long d = Long.parseLong(line);
            if (d > -179) {
                y = d;
            } else {
                System.out.println("Вы ввели слишком маленькое число! Попробуйте снова!");
                setY();
            }
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели неккоректное число, попробуйте снова!");
            setY();
        }
    }

    public void setPerson() {
        String line = scanner.nextLine();
        switch (line) {
            case ("Да"):
                setHeight();
                System.out.println("Введите вес рабочего");
                setWeight();
                setPassportID();
                setLocation();
                person = new Person(height,weight,passportID,x1,y2,z);
                break;
            case ("Нет"):
                person = null;
                break;
            default:
                System.out.println("Он либо существует, либо нет. Введите Да или Нет");
                setPerson();
        }
    }

    public void setHeight() {
        System.out.println("У рабочего есть рост? Да/Нет");
        String line = scanner.nextLine();
        line = line.toLowerCase();
        switch (line) {
            case ("да"):
                try {
                    line = scanner.nextLine();
                    Double d = Double.parseDouble(line);
                    if (d > 0) {
                        height = d;
                    } else {
                        System.out.println("Вы ввели отрицательный рост. Как человек может быть с отрицательным ростом?");
                        setHeight();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Вы ввели неккоректное число, попробуйте снова!");
                    setHeight();
                }
                break;
            case ("нет"):
                height = null;
                break;
        }
    }

    public void setWeight() {
        String line = scanner.nextLine();
        try {
            Long d = Long.parseLong(line);
            if (d > 0) {
                weight = d;
            } else {
                System.out.println("Вы ввели отрицательный вес. Как человек может быть с отрицательным весом?");
                setWeight();
            }
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели неккоректное число, попробуйте снова!");
            setWeight();
        }
    }

    public void setPassportID() {
        System.out.println("У человека есть паспортные данные? Да/Нет");
        String line = scanner.nextLine();
        switch (line) {
            case ("Да"):
                System.out.println("Введите паспортные данные:");
                line = scanner.nextLine();
                if (!line.equals("")) {
                    passportID = line;
                } else {
                    System.out.println("Ты ввел пустую строку, повтори ввод!");
                    setPassportID();
                }
                break;
            case ("Нет"):
                passportID = null;
                break;
            default:
                System.out.println("Тебе русским языком сказали. ДА или НЕТ. Третьего не дано! Повтори ввод");
                setPassportID();
        }
    }

    public void setLocation() {
        System.out.println("Введите координату Х(снова)");
        setX1();
        System.out.println("Введите координату У(снова)");
        setY2();
        System.out.println("Введите координату Z(мы теперь в трехмерном пространстве)");
        setZ();
    }

    public void setX1() {
        String line = scanner.nextLine();
        try {
            x1 = Float.parseFloat(line);
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели неккоректное число, попробуйте снова!");
            setX1();
        }
    }

    public void setY2() {
        String line = scanner.nextLine();
        try {
            y2 = Long.parseLong(line);
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели неккоректное число, попробуйте снова!");
            setY2();
        }
    }

    public void setZ() {
        String line = scanner.nextLine();
        try {
            z = Long.parseLong(line);
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели неккоректное число, попробуйте снова!");
            setX1();
        }
    }
}
