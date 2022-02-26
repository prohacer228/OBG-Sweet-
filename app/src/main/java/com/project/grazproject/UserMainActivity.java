package com.project.grazproject;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.project.grazproject.databinding.ActivityUserMainBinding;

public class UserMainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityUserMainBinding binding;

    /*
    TODO :  добавить поля "Уведомления", "Профиль", "Обратная связь", "Создать сообщение"
    TODO : добавить Экран Карты с переходом от рубрик
    TODO : добавить Экран Создания Сообщения с переходом от карт
    TODO : добавить Экран Готового Сообщения с переходом от создания сообщения
    TODO : добавить Экран Сообщений Пользователя с переходом от пункта меню.
     Здесь будет отображаться все сообщения пользователя в кратком виде: тема
    сообщения, адрес сообщения и главная фотография. Нажав на любое место сообщения – оно
    разворачивается в полный вид как на экране готового сообщения
    TODO : добавить Экран Всех Сообщений Пользователя с переходом от пункта меню
    Аналогично экрану сообщений, только без нижних конпок
    TODO : добавить экран уведомлений с переходом от пунтка меню
    TODO : добавить экран профиля пользователя
    На экране отображаются все данные пользователя, количество сообщений оставленных
    данным пользователем. Также имеется кнопка выхода из профиля проекта
    TODO : добавить работу с картами и связать работу с картами с БД
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUserMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarUserMain.toolbar);
        binding.appBarUserMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: изменить действие всплывающей кнопки, возможно стоит ее убрать
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_sections, R.id.nav_my_messages, R.id.nav_all_messages)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_user_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Добавление в меню присоенных пунктов
        getMenuInflater().inflate(R.menu.user_main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_user_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}