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
import java.util.List;

public class CreateMessage extends AppCompatActivity {

    private ImageView addedPhoto;
    private TextView addedPhotosText;
    private Button PostMessageButton;
    private EditText setTheme, MainMessage;
    private List<Bitmap> selectedImages;

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

        //При загрузке скрываем надпись и фото
        addedPhoto.setVisibility(View.INVISIBLE);

        //Связываемся с нашей кнопкой Button:
        TextView PickImage =  findViewById(R.id.addPhotoButton);

        //Настраиваем для нее обработчик нажатий OnClickListener:
        PickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showPictureDialog();

             /*   String title = "Выбор изображений";
                String message = "Загрузить изображения";
                String buttonCamera = "Камера";
                String buttonGallery = "Галерея";

                AlertDialog.Builder builder = new AlertDialog.Builder(CreateMessage.this);
                builder.setTitle(title);  // заголовок
                builder.setMessage(message); // сообщение
                builder.setPositiveButton(buttonCamera, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        try{
                            startActivityForResult(intentCamera, REQUEST_TAKE_PHOTO);
                        }catch (ActivityNotFoundException e){
                            e.printStackTrace();
                        }
                    }

                });
                builder.setNegativeButton(buttonGallery, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id){
                        //Вызываем стандартную галерею для выбора изображения с помощью Intent.ACTION_PICK:
                        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                        //Тип получаемых объектов - image:
                        photoPickerIntent.setType("image/*");
                        photoPickerIntent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);

                        //Запускаем переход с ожиданием обратного результата в виде информации об изображении:
                        startActivityForResult(photoPickerIntent, REQUEST_IMAGE_GALLERY);

                    }
                });
                builder.setCancelable(true);

                builder.create();
                builder.show();
              /*  Intent intent = new Intent();
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Picture"), 1);

               */
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
               //  Bitmap bitmap = ((BitmapDrawable) addedPhoto.getDrawable()).getBitmap();
               //  intent.putExtra("image", bitmap);

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
        pictureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {
                "Gallery",
                "Camera" };
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
          //  saveImage(thumbnail);
           Toast.makeText(CreateMessage.this, "Фото обновлено", Toast.LENGTH_SHORT).show();
            addedPhoto.setVisibility(View.VISIBLE);
        }
    }

   /*
    //Обрабатываем результат выбора в галерее:
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch (requestCode) {
            case REQUEST_IMAGE_GALLERY:
                if (resultCode == RESULT_OK) {
                    try {

                        //Получаем URI изображения, преобразуем его в Bitmap
                        //объект и отображаем в элементе ImageView нашего интерфейса:
                       final ClipData images = imageReturnedIntent.getClipData();

                        final Uri imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
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
          /*  case REQUEST_TAKE_PHOTO:
                if (resultCode == RESULT_OK) {
                    try {  Bundle extras = imageReturnedIntent.getExtras();
                    Bitmap thumbnailBitmap = (Bitmap) extras.get("data");
                    addedPhoto.setImageBitmap(thumbnailBitmap);

                    addedPhoto.setVisibility(View.VISIBLE);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


        }

    }
    */

}