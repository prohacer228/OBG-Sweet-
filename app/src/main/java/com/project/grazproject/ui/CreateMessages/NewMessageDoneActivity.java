package com.project.grazproject.ui.CreateMessages;

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
    ImageView photo;
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
      //  String section = arguments.get("Section").toString();

      //  Bitmap image = (Bitmap) arguments.get("image");
        //Установка темы и текста сообщения
        finalThemeMessage.setText(theme);
        mainMessageDone.setText(message);
      //  incidentSection.setText(section);

      //  photo.setImageBitmap(image);


        // TODO: переделать показ фото. Надо получать картинки с предыдущей активи
         /* imageSwitcher = findViewById(R.id.imageSwitcher);

        imageSwitcher = findViewById(R.id.imageSwitcher);
        imageView = findViewById(R.id.addPhotoImageNew);
        imageSwitcher.setImageDrawable(imageView.getDrawable());

        */
    }


}

