package com.project.grazproject.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.project.grazproject.R;
import com.project.grazproject.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final Button RegisterButton = findViewById(R.id.registerButton);

        username = findViewById(R.id.usernameRegister);

       RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(RegisterActivity.this, UserDataRegister.class);
                startActivity(intent);
            }
        });
    }
}