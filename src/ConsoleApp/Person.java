/*
 * Copyright (c) 2020. Ivannikov Alexandr Romanovich.
 * The text of this program is protected by copyright. Using it for commercial or personal purposes is prohibited
 * All rights reserved.
 */

package ConsoleApp;

public class Person {
    public Person(Double height, Long weight, String passportID, Float x, Long y, long z) {
        this.height = height;
        this.weight = weight;
        this.passportID = passportID;
        this.location = new Location(x, y, z);
    }

    private Double height; //Поле может быть null, Значение поля должно быть больше 0
    private Long weight; //Поле не может быть null, Значение поля должно быть больше 0
    private String passportID; //Значение этого поля должно быть уникальным, Строка не может быть пустой, Поле может быть null
    private Location location; //Поле не может быть null

    public class Location {

        private Float x; //Поле не может быть null
        private Long y; //Поле не может быть null
        private long z;

        @Override
        public String toString() {
            return "{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }

        public Location(Float x, Long y, long z) {
            this.x = x;
            this.y = y;
            this.z = z;

        }
    }

    @Override
    public String toString() {
        return
                Colors.blue() + "\n  Рост: " + Colors.reset() + height +
                Colors.blue() + "\n  Вес: " + Colors.reset() + weight +
                Colors.blue() + "\n  Номер пасспорта: '" + Colors.reset() + passportID + '\'' +
                Colors.blue() + "\n  Локация: " + Colors.reset() + location.toString() +
                '}';
    }
}
