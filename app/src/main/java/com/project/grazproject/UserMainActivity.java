package com.project.grazproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.project.grazproject.about.AboutActivity;
import com.project.grazproject.databinding.ActivityUserMainBinding;
import com.project.grazproject.ui.sections.SectionsFragment;

public class UserMainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityUserMainBinding binding;

    /*
    TODO : "Создать сообщение", изменить функционал "рубрик"
    TODO : добавить Экран Карты с переходом от рубрик
    TODO : добавить Экран Создания Сообщения с переходом от карт
    TODO : добавить Экран Готового Сообщения с переходом от создания сообщения
    TODO : настроить Экран Сообщений Пользователя с переходом от пункта меню.
     Здесь будет отображаться все сообщения пользователя в кратком виде: тема
    сообщения, адрес сообщения и главная фотография. Нажав на любое место сообщения – оно
    разворачивается в полный вид как на экране готового сообщения
    TODO : настроить Экран Всех Сообщений Пользователя с переходом от пункта меню
    Аналогично экрану сообщений, только без нижних конпок
    TODO : настроить экран уведомлений с переходом от пунтка меню
    TODO : настроить экран профиля пользователя
    На экране отображаются все данные пользователя, количество сообщений оставленных
    данным пользователем. Также имеется кнопка выхода из профиля проекта
    TODO : добавить работу с картами и связать работу с картами с БД
     */

    // TODO: сделать конпку закрытия на боковой панели, после чего перемещаться на панель рубрик

    TextView aboutProg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUserMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarUserMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        //наш view's drawer
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_sections, R.id.nav_my_messages, R.id.nav_all_messages, R.id.nav_user_profile,
                R.id.nav_notifications, R.id.nav_feedback)
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