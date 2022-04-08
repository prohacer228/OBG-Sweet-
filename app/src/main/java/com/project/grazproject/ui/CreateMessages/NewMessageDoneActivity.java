package com.project.grazproject.ui.CreateMessages;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.project.grazproject.R;

public class NewMessageDoneActivity extends AppCompatActivity {

    private ImageSwitcher imageSwitcher;
    TextView finalThemeMessage, incidentAddress, incidentSection;
    EditText setThemeMessage, mainMessageDone;
    ImageView photo, photoDone;
    View imageLayout;

    //TODO: передевать фото с предыдущей формы на эту

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message_done);

        finalThemeMessage = findViewById(R.id.MessageThemeDone);
        mainMessageDone = findViewById(R.id.MessageMainTextDone);
        photo = findViewById(R.id.Photos);
        imageLayout = findViewById(R.id.newMessageMain);
        incidentAddress = findViewById(R.id.message_done_address);
        incidentSection = findViewById(R.id.message_section_done);

        //Получение аргументов с предыдущей страницы
        Bundle arguments = getIntent().getExtras();
        String theme = arguments.get("theme").toString();
        String message = arguments.get("message").toString();
        Bitmap picture = (Bitmap) arguments.get("photo");

        //Установка темы и текста сообщения
        finalThemeMessage.setText(theme);
        mainMessageDone.setText(message);
        photo.setImageBitmap(picture);

      //  incidentSection.setText(section);

      //  photo.setImageBitmap(image);

    }


}

