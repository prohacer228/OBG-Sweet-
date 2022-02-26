package com.project.grazproject.newPassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.project.grazproject.R;
import com.project.grazproject.databinding.ActivityResetPasswordBinding;
import com.project.grazproject.register.RegisterActivity;

public class ResetPasswordActivity extends AppCompatActivity {

    private ActivityResetPasswordBinding binding;

    TextView registerLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        registerLink = findViewById(R.id.registerPR);

        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResetPasswordActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

}