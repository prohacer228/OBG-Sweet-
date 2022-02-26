package com.project.grazproject.newPassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.project.grazproject.R;
import com.project.grazproject.UserMainActivity;
import com.project.grazproject.databinding.ActivityResetPasswordBinding;
import com.project.grazproject.register.RegisterActivity;
import com.project.grazproject.ui.login.LoginActivity;

public class ResetPasswordActivity extends AppCompatActivity {

    //TODO : добавить отправку сообщения на email с инструкциями по изменению пароля
    private ActivityResetPasswordBinding binding;

    TextView registerLink;
    Button resetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        registerLink = findViewById(R.id.registerPR);
        resetPassword = findViewById(R.id.resetPassword);

        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResetPasswordActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        //TODO : добавить проверку существования email
        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String resetInfo = getString(R.string.reset_email_mes);
                Toast.makeText(getApplicationContext(), resetInfo, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(ResetPasswordActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

}