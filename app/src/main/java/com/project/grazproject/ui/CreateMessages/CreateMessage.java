package com.project.grazproject.ui.CreateMessages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.grazproject.R;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class CreateMessage extends AppCompatActivity {

    private ImageView addedPhoto;
    private final int Pick_image = 1;
    private TextView addedPhotosText;
    private Button PostMessageButton;
    private EditText setTheme, MainMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);

        //Связываемся с нашим ImageView:
        addedPhoto = (ImageView)findViewById(R.id.addPhotoImageNew);
        setTheme = findViewById(R.id.MessageThemeSet);
        MainMessage =findViewById(R.id.MessageMainText);

        PostMessageButton = findViewById(R.id.PostMessageButton);

        //При загрузке скрываем надпись и фото
        addedPhoto.setVisibility(View.INVISIBLE);

        //Связываемся с нашей кнопкой Button:
        TextView PickImage =  findViewById(R.id.addPhotoButton);

        //Настраиваем для нее обработчик нажатий OnClickListener:
        PickImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //Вызываем стандартную галерею для выбора изображения с помощью Intent.ACTION_PICK:
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                //Тип получаемых объектов - image:
                photoPickerIntent.setType("image/*");
                //Запускаем переход с ожиданием обратного результата в виде информации об изображении:
                startActivityForResult(photoPickerIntent, Pick_image);
            }
        });

        PostMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateMessage.this, NewMessageDoneActivity.class);
                //Передача текста темы на следующий экран
                intent.putExtra("theme", setTheme.getText().toString());
                intent.putExtra("message", MainMessage.getText().toString());

                startActivity(intent);
            }
        });

    }
    //TODO: добавить возможность добавлять несколько фото
    //TODO: изменить показ фото
    // TODO: добавить возможность фото с камеры
    //Обрабатываем результат выбора в галерее:
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch (requestCode) {
            case Pick_image:
                if (resultCode == RESULT_OK) {
                    try {

                        //Получаем URI изображения, преобразуем его в Bitmap
                        //объект и отображаем в элементе ImageView нашего интерфейса:
                        final Uri imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        addedPhoto.setImageBitmap(selectedImage);

                        //Снова делаем видимыми
                        addedPhoto.setVisibility(View.VISIBLE);



                      //  addedPhotosText.setText();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
        }
    }
}