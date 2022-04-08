package com.project.grazproject.ui.CreateMessages;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.project.grazproject.R;

import java.io.IOException;

public class CreateMessage extends AppCompatActivity {

    private ImageView addedPhoto, photoDone;
    private TextView addedPhotosText;
    private Button PostMessageButton;
    private EditText setTheme, MainMessage;
    private Bitmap selectedImage;

     //TODO: изменить показ фото на несколько фото
    // TODO: исправить добавление фото с камеры

    private static final int REQUEST_IMAGE_GALLERY = 0;
    private static final int REQUEST_TAKE_PHOTO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);

        //Связываемся с нашим ImageView:
        addedPhoto = (ImageView)findViewById(R.id.addPhotoImageNew);
        setTheme = findViewById(R.id.MessageThemeSet);
        MainMessage =findViewById(R.id.MessageMainText);

        PostMessageButton = findViewById(R.id.PostMessageButton);
        photoDone = findViewById(R.id.Photos);

        //При загрузке скрываем надпись и фото
        addedPhoto.setVisibility(View.INVISIBLE);

        //Связываемся с нашей кнопкой Button:
        TextView PickImage =  findViewById(R.id.addPhotoButton);

        //Настраиваем для нее обработчик нажатий OnClickListener:
        PickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showPictureDialog();
            }
        });



        PostMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateMessage.this, NewMessageDoneActivity.class);

                //Передача текста темы на следующий экран
             if(!setTheme.getText().toString().isEmpty() && !MainMessage.getText().toString().isEmpty()) {
                 intent.putExtra("theme", setTheme.getText().toString());
                 intent.putExtra("message", MainMessage.getText().toString());
                 intent.putExtra("photo", selectedImage);

                 startActivity(intent);
             }
             else
             {
                 Toast.makeText(CreateMessage.this, "Заполните форму!", Toast.LENGTH_SHORT).show();
             }
            }
        });

    }



    private void showPictureDialog(){
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
        pictureDialog.setTitle("Выбор действия:");
        String[] pictureDialogItems = {
                "Галерея",
                "Камера" };
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int state) {
                        switch (state) {
                            case 0:
                                choosePhotoFromGallery();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }
    public void choosePhotoFromGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, REQUEST_IMAGE_GALLERY);
    }

    private void takePhotoFromCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_TAKE_PHOTO);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == this.RESULT_CANCELED) {
            return;
        }
        if (requestCode == REQUEST_IMAGE_GALLERY) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                    Toast.makeText(CreateMessage.this, "Фото обновлено", Toast.LENGTH_SHORT).show();
                    addedPhoto.setImageBitmap(bitmap);
                    addedPhoto.setVisibility(View.VISIBLE);

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(CreateMessage.this, "Failed!", Toast.LENGTH_SHORT).show();
                }
            }

        } else if (requestCode == REQUEST_TAKE_PHOTO) {

            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            addedPhoto.setImageBitmap(thumbnail);
            selectedImage = thumbnail;
           Toast.makeText(CreateMessage.this, "Фото обновлено", Toast.LENGTH_SHORT).show();
            addedPhoto.setVisibility(View.VISIBLE);
        }
    }


}