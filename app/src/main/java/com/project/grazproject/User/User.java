package com.project.grazproject.User;

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


   public static void DefaultSettingsUser(User user)
    {
        user.username = "NewCitizen";
        user.email = "newUser@gmail.com";
        user.password = "123";
        user.name = "Сергей";
        user.surname = "Булкин";
        user.middleName = "Николаевич";
        user.city = "Samara";
        user.street = "Мичурина";
        user.house = "40";
        user.apartment = "130";
    }
}
