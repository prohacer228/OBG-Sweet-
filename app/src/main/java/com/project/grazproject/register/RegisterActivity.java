package com.project.grazproject.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
    CheckBox projectRules;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final Button RegisterButton = findViewById(R.id.registerButton);

        username = findViewById(R.id.usernameRegister);
        password = findViewById(R.id.passwordSet);
        repeatPassword = findViewById(R.id.repeatPasswordRegister);
        email = findViewById(R.id.emailRegister);
        rulesProject = findViewById(R.id.InvisibleRules);
        projectRules = findViewById(R.id.AgreementRulesCB);

       RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Проверка полей, они не должны быть пустыми
              if(isEmptyFields()) {

                // User createdUser = CreateUser(username.getText().toString(), email.getText().toString(), password.getText().toString());

                  Intent intent = new Intent(RegisterActivity.this, UserDataRegister.class);

                  if(!username.getText().toString().isEmpty() && !email.getText().toString().isEmpty()
                          && !password.getText().toString().isEmpty()) {
                      intent.putExtra("username", username.getText().toString());
                      intent.putExtra("email", email.getText().toString());
                      intent.putExtra("password", password.getText().toString());
                  }
                  startActivity(intent);
                  //Уничтожает активити с регистрацией, после перезода на дальнейшую страницу
                //  finish();
              }
            }
        });

       rulesProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

    }

   /* public User CreateUser(String username, String email, String password)
    {
        User newUser = new User();

        newUser.username = username;
        newUser.email = email;
        newUser.password = password;

        return newUser;
    }
    */

    boolean isEmptyFields()
    {
        //Поля не должны быть пустыми
        if(username.getText().toString().isEmpty() || password.getText().toString().isEmpty()
        || repeatPassword.getText().toString().isEmpty() || email.getText().toString().isEmpty())
        {
            Toast.makeText(RegisterActivity.this, "Заполните поля!", Toast.LENGTH_SHORT).show();
            return false;
        } else
            //TODO: Добавлена проеверка принятия правил проекта при регистрации
            if(!projectRules.isChecked()){
                Toast.makeText(RegisterActivity.this, "Необходимо принять правила проекта!", Toast.LENGTH_SHORT).show();
                return false;
            }
        //TODO: добавить проверку паролей, они должны совпадать
       /* else if(password.getText().toString() != repeatPassword.getText().toString())
        {
            Toast.makeText(RegisterActivity.this, "Пароли не совпадают!", Toast.LENGTH_SHORT).show();
            return false;
        }

        */

        else {
            return true;
        }
    }
}