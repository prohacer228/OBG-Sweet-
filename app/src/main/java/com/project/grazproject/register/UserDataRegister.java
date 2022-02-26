package com.project.grazproject.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.project.grazproject.R;
import com.project.grazproject.UserMainActivity;
import com.project.grazproject.ui.login.LoginActivity;

public class UserDataRegister extends AppCompatActivity {

    Button registerUserData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data_register);

        registerUserData = findViewById(R.id.saveRegUserData);

        registerUserData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserDataRegister.this, UserMainActivity.class);
                startActivity(intent);
            }
        });
    }
}