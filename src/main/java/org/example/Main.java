package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {

            Scanner scan = new Scanner(System.in);
            boolean exit = false;

            String path = "";

            while (!exit) {
                System.out.println(
                        "Выберете пункт меню:" + "\n"
                                + "1. Чтение списка пар из файла" + "\n"
                                + "2. Просмотр словаря" + "\n"
                                + "3. Удаление записи по ключу" + "\n"
                                + "4. Поиск записи по ключу" + "\n"
                                + "5. Добавление записи при условии соответствия требованиям конкретного словаря" + "\n"
                                + "6. Перевернуть словарь" + "\n"
                                + "7. Выход" + "\n");
                int menuinput = scan.nextInt();

                switch (menuinput) {
                    case 1:
                        path = "";
                        System.out.println("Введите путь к файлу: ");
                        path = scan.next();
                        break;
                    case 2:
                        break;
                    case 3:

                        System.out.println("Введите ключ по которому необходимо удалить запись в словаре: ");
                        String kdelete = scan.next();
                        break;
                    case 4:

                        System.out.println("Введите ключ по которому необходимо найти запись в словаре: ");
                        String ksearch = scan.next();
                        break;
                    case 5:

                        System.out.println("Введите ключ: ");
                        String keyAdd = scan.next();
                        System.out.println("Введите значение: ");
                        String valueAdd = scan.next();
                        keyAdd += " - " + valueAdd;
                        break;
                    case 6:
                        System.out.println("Словарь перевернут");
                        break;
                    case 7:
                        exit = true;
                        break;

                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}