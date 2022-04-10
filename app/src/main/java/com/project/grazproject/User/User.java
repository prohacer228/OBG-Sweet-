package com.project.grazproject.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    public String username;
    public  String name;
    public String surname;
    public String middleName;
    public String city;
    public String street;
    public String email;
    public String password;
    public String house, apartment;
    public String phone;

    public static User RegUser;
    public static List<User> users = new ArrayList<>();
   public static Boolean isExistedUser;

   public static void DefaultSettingsUser()
    {
        User user = new User();
        user.username = "Sergey";
        user.email = "ser@mail.ru";
        user.password = "ser123";
        user.name = "Сергей";
        user.surname = "Булкин";
        user.middleName = "Николаевич";
        user.city = "Самара";
        user.street = "Мичурина";
        user.house = "40";
        user.apartment = "130";
        user.phone = "89678568787";

        users.add(user);

    }

    public static void addSania()
    {
        User user = new User();
        user.username = "Sania";
        user.email = "sania@mail.ru";
        user.password = "Sania123";
        user.name = "Саня";
        user.surname = "Иванов";
        user.middleName = "Юрьевич";
        user.city = "Самара";
        user.street = "Ново-Вокзальная";
        user.house = "189";
        user.apartment = "41";
        user.phone = "89012342134";

        users.add(user);
    }

    //стандартный Юзер бабочка
    public static void addButterflyArtur()
    {
        User user = new User();
        user.username = "Butterfly";
        user.email = "butterfly@mail.ru";
        user.password = "Butterfly";
        user.name = "Артур";
        user.surname = "Азюков";
        user.middleName = "";
        user.city = "Самара";
        user.street = "проспект Карла Маркса";
        user.house = "235";
        user.apartment = "";
        user.phone = "89764564433";

        users.add(user);
    }

    //поиск юзера по паролю и имени в массиве юзеров
    public static Boolean findUser(String username, String password) {
        if (!users.isEmpty())
            for (User test : users) {
                if ((Objects.equals(test.username, username)) && (Objects.equals(test.password, password))) {
                    RegUser = test;
                    isExistedUser = true;
                      break;
                } else {
                    isExistedUser = false;
                }
            }
        else
        {
          isExistedUser = false;
        }
        return isExistedUser;
    }
}
