package com.project.grazproject.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.project.grazproject.R;
import com.project.grazproject.ui.login.LoginActivity;

public class UserDataRegister extends AppCompatActivity {

    //TODO: если хотите не проверять заполненность полей, то закоментить isEmptyFields

    Button registerUserData;
    EditText name, surname, middleName, telephone, city, street, house, apartment;

    //список юзеров


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

                    Intent intent = new Intent(UserDataRegister.this, LoginActivity.class);
                    startActivity(intent);


                    //Уничтожает активити с регистрацией, после перхода на страницу логина
                   // finish();
                }
            }
        });
    }

 /*   public void SetUserData(String username, String email, String password, String name,String surname, String middleName, String city, String street,
                            String house, String apartment)
    {
        User user = new User();
        user.username = username;
        user.email = email;
        user.password = password;
        user.name = name;
        user.surname = surname;
        user.middleName = middleName;
        user.city = city;
        user.street = street;
        user.house = house;
        user.apartment = apartment;

        users.add(user);

    }

*/
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