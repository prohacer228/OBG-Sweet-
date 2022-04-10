package com.project.grazproject.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.project.grazproject.R;
import com.project.grazproject.User.User;
import com.project.grazproject.ui.login.LoginActivity;

public class UserDataRegister extends AppCompatActivity {

    //TODO: если хотите не проверять заполненность полей, то закоментить isEmptyFields

    Button registerUserData;
    EditText name, surname, middleName, telephone, city, street, house, apartment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data_register);

        registerUserData = findViewById(R.id.saveRegUserData);

        name = findViewById(R.id.userNameRegister);
        surname = findViewById(R.id.userSurnameRegister);
        telephone = findViewById(R.id.userPhoneRegister);
        city = findViewById(R.id.userTownRegister);
        street = findViewById(R.id.userStreetRegister);
        middleName = findViewById(R.id.userMidNameRegister);
        apartment = findViewById(R.id.userApartRegister);
        house = findViewById(R.id.userHouseRegister);

        registerUserData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //После рестирации данных, переход на логин активити
                if(isEmptyFields()) {

                    String name1 = name.getText().toString();
                    String surname1 = surname.getText().toString();
                    String phone = telephone.getText().toString();
                    String city1 = city.getText().toString();
                    String street1 = street.getText().toString();
                    String midName = middleName.getText().toString();
                    String house1 = house.getText().toString();
                    String apart = apartment.getText().toString();

                    SetUserData(RegisterActivity.newUser, name1, surname1, midName, city1, street1, house1, apart, phone);

                    Intent intent = new Intent(UserDataRegister.this, LoginActivity.class);
                    startActivity(intent);

                    //Уничтожает активити с регистрацией, после перхода на страницу логина
                   // finish();
                }
            }
        });
    }

   public void SetUserData(User user, String name, String surname, String middleName, String city, String street,
                           String house, String apartment, String phone)
    {
        if(!name.isEmpty()) {
            user.name = name;
        }
        if(!surname.isEmpty()) {
            user.surname = surname;
        }
        if(!middleName.isEmpty()) {
            user.middleName = middleName;
        }
        else
        {
            user.phone = "Пусто";
        }
        if(!city.isEmpty()) {
            user.city = city;
        }else
        {
            user.city="Самара";
        }
        if(!street.isEmpty()) {
            user.street = street;
        }
        if(!house.isEmpty()) {
            user.house = house;
        }
        if(!apartment.isEmpty()) {
            user.apartment = apartment;
        }
        else
        {
            user.phone = "Пусто";
        }
        if(!phone.isEmpty()) {
            user.phone = phone;
        }


        // LoginActivity.users.add(user);
      //  users.add(user);

        User.users.add(user);
       // User.RegUser = user;
        Toast.makeText(this, "Пользователь добавлен", Toast.LENGTH_SHORT).show();

    }


    boolean isEmptyFields()
    {
        //Поля не должны быть пустыми
        if(name.getText().toString().isEmpty() || surname.getText().toString().isEmpty()
                || street.getText().toString().isEmpty()
                || telephone.getText().toString().isEmpty() || city.getText().toString().isEmpty())
        {
            Toast.makeText(UserDataRegister.this, "Заполните поля!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            return true;
        }
    }
}