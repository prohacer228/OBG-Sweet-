package com.project.grazproject.resetPassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toolbar;

import com.project.grazproject.R;
import com.project.grazproject.databinding.ActivityLoginBinding;
import com.project.grazproject.databinding.ActivityResetPasswordBinding;
import com.project.grazproject.register.RegisterActivity;
import com.project.grazproject.ui.login.LoginActivity;

public class ResetPasswordActivity extends AppCompatActivity {

    private ActivityResetPasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

       /* final TextView registerPR = binding.registerPR;

        registerPR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ResetPasswordActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        *
        */
    }

}