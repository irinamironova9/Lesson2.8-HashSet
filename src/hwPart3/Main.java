package hwPart3;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println(new MultiplicationTable());

        Passport katya = new Passport("3056087234", "Сидорова",
                "Екатерина", "Васильевна",
                LocalDate.parse("2000-10-03"));
        Passport vitya = new Passport("6335986745", "Петров",
                "Виктор", null,
                LocalDate.parse("1993-12-14"));
        Passport sonya = new Passport("5436855895", "Бржезинская",
                "Софья", "Анатольевна",
                LocalDate.parse("1998-05-23"));
        Passport petya = new Passport("1001290436", "Иванов",
                "Петр", "Алексеевич",
                LocalDate.parse("2002-09-15"));

        Passport petyaNew = new Passport("1001290436", "Иваненков",
                "Пётр", "Алексеевич",
                LocalDate.parse("2002-09-15"));

        DataBase dataBase = new DataBase();
        dataBase.addPassport(katya);
        dataBase.addPassport(vitya);
        dataBase.addPassport(sonya);
        dataBase.addPassport(petya);
        dataBase.addPassport(katya);
        dataBase.addPassport(petyaNew);

        System.out.println(dataBase);

        System.out.println(dataBase.getPassport("5436855895"));
        System.out.println(dataBase.getPassport("5530857896"));

        // Задание 3
        // Меньше всего времени на выполнение метода понадобится, если коллекцией
        // будет HashSet, т.к. в отличие от ArrayList и LinkedList, при вызове метода
        // contains не понадобится прокручивать в цикле все объекты хэш-сета,
        // чтобы найти нужный. По хэш-коду найдётся ячейка массива, в котором хранится
        // искомый объект, а затем сам объект.
    }

//    private void process(Collection firstCollection, List list) {
//        if (firstCollection.containsAll(list)) {
//            System.out.println("Первая коллекция содержит все элементы списка");
//        } else {
//            System.out.println("Некоторые (или все) элементы из списка отсутствуют в первой коллекции");
//        }
//    }
}
