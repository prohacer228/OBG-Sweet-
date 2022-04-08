package com.project.grazproject.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.project.grazproject.R;
import com.project.grazproject.User.User;
import com.project.grazproject.UserMainActivity;
import com.project.grazproject.databinding.ActivityLoginBinding;
import com.project.grazproject.newPassword.ResetPasswordActivity;
import com.project.grazproject.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private ActivityLoginBinding binding;

  //  public static List<User> users;

    EditText usernameEditText;
    EditText passwordEditText;
    Button loginButton;
    Button registerButton;
    ProgressBar loadingProgressBar;
    TextView forgotPassword;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

       usernameEditText = binding.username;
       passwordEditText = (EditText) binding.password;
       loginButton = binding.login;
       registerButton = binding.registerButtonLog;
       loadingProgressBar = binding.loading;
       forgotPassword = binding.forgotPassword;

      //  forgotPassword = findViewById(R.id.forgotPassword);

        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                loginButton.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getUsernameError() != null) {
                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });

        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                loadingProgressBar.setVisibility(View.GONE);
                if (loginResult.getError() != null) {
                    showLoginFailed(loginResult.getError());
                }
                if (loginResult.getSuccess() != null) {
                    updateUiWithUser(loginResult.getSuccess());
                }
                setResult(Activity.RESULT_OK);

                User loggedUser = new User();
                loggedUser.username = usernameEditText.getText().toString();
                loggedUser.password = passwordEditText.getText().toString();

                /*
                if(CheckUser(loggedUser))
                {
                    //Complete and destroy login activity once successful
                    Intent intent = new Intent(LoginActivity.this, UserMainActivity.class);
                    startActivity(intent);

                    finish();
                }
                else {
                    Toast.makeText(LoginActivity.this, "Пользователя не существует", Toast.LENGTH_SHORT).show();
                }

                 */

                Intent intent = new Intent(LoginActivity.this, UserMainActivity.class);
                startActivity(intent);

                finish();


            }
        });


        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };

        // TODO : добавлен глаз, но надо исправить некотректность отобржения замечания о длине пароля
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(usernameEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                loginViewModel.login(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());

            }

        });

        //Переход на страницу регистрации
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        //Переход на станицу "Забыли пароль"
       forgotPassword.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(LoginActivity.this, ResetPasswordActivity.class);
               startActivity(intent);

           }
       });
    }


    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();

    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }

    //переделать проверку на совпадение юзера
   /* boolean checkUserBol;
    public boolean CheckUser(User loggedUser)
    {
        for(int i =0;i<users.size(); i++) {
            User user = users.get(i);
            checkUserBol = user.username.contains(loggedUser.username);

        }
        return checkUserBol;
    }

    */
}