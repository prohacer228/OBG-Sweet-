package com.project.grazproject.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.project.grazproject.R;
import com.project.grazproject.about.AboutActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText username, email;
    EditText password, repeatPassword;
    TextView rulesProject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final Button RegisterButton = findViewById(R.id.registerButton);

        username = findViewById(R.id.usernameRegister);
        password = findViewById(R.id.passwordSet);
        repeatPassword = findViewById(R.id.repeatPasswordRegister);
        email = findViewById(R.id.emailRegister);
        rulesProject = findViewById(R.id.AgreementRulesCB);

       RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Проверка полей, они не должны быть пустыми
              if(isEmptyFields()) {
                  Intent intent = new Intent(RegisterActivity.this, UserDataRegister.class);
                  startActivity(intent);

                  //Уничтожает активити с регистрацией, после перезода на дальнейшую страницу
                //  finish();
              }
            }
        });

       //TODO: сделать переход на правила проекта отдельно от checkBox
        rulesProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

    }

    boolean isEmptyFields()
    {
        //Поля не должны быть пустыми
        if(username.getText().toString().isEmpty() || password.getText().toString().isEmpty()
        || repeatPassword.getText().toString().isEmpty() || email.getText().toString().isEmpty())
        {
            Toast.makeText(RegisterActivity.this, "Заполните поля!", Toast.LENGTH_SHORT).show();
            return false;
        }
        //TODO: добавить проверку паролей, они должны совпадать
       /* else if(password.getText().toString() != repeatPassword.getText().toString())
        {
            Toast.makeText(RegisterActivity.this, "Пароли не совпадают!", Toast.LENGTH_SHORT).show();
            return false;
        }

        */
        //TODO: добавить проверку принятия правил проекта
        else {
            return true;
        }
    }
}