package com.project.grazproject.ui.CreateMessages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.project.grazproject.R;

public class NewMessageDoneActivity extends AppCompatActivity {

    private ImageSwitcher imageSwitcher;
    TextView finalThemeMessage;
    EditText setThemeMessage, mainMessageDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message_done);

        finalThemeMessage = findViewById(R.id.MessageThemeDone);
        mainMessageDone = findViewById(R.id.MessageMainTextDone);

        //Получение аргументов с предыдущей страницы
        Bundle arguments = getIntent().getExtras();
        String theme = arguments.get("theme").toString();
        String message = arguments.get("message").toString();
        //Установка темы и текста сообщения
        finalThemeMessage.setText(theme);
        mainMessageDone.setText(message);


        // TODO: переделать показ фото. Надо получать картинки с предыдущей активи
         /* imageSwitcher = findViewById(R.id.imageSwitcher);

        imageSwitcher = findViewById(R.id.imageSwitcher);
        imageView = findViewById(R.id.addPhotoImageNew);
        imageSwitcher.setImageDrawable(imageView.getDrawable());

        */
    }


}

