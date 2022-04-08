package com.project.grazproject.ui.CreateMessages;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.project.grazproject.R;
import com.project.grazproject.ui.sections.SectionsFragment;

import java.io.FileOutputStream;
import java.io.IOException;

public class NewMessageDoneActivity extends AppCompatActivity {

    TextView finalThemeMessage, incidentAddress, incidentSection;
    EditText setThemeMessage, mainMessageDone;
    ImageView photo, photoDone;
    View imageLayout;

    FloatingActionButton downloadButton;

    private final static String FILE_NAME = "Report.txt";

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

        downloadButton = findViewById(R.id.downloadButton);

        //Получение аргументов с предыдущей страницы
        Bundle arguments = getIntent().getExtras();
        String theme = arguments.get("theme").toString();
        String message = arguments.get("message").toString();
        Bitmap picture = (Bitmap) arguments.get("photo");

        //Установка темы и текста сообщения
        finalThemeMessage.setText(theme);
        mainMessageDone.setText(message);
        photo.setImageBitmap(picture);
        incidentSection.setText(SectionsFragment.section);


        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               saveText(v);
            }
        });

    }

    // сохранение файла
    public void saveText(View view){

        FileOutputStream fos = null;
        try {
            String MessageText = mainMessageDone.getText().toString() + "\n";
            String MessageTheme = finalThemeMessage.getText().toString()+"\n";

            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);

            fos.write(MessageTheme.getBytes());
            fos.write(MessageText.getBytes());
            Toast.makeText(this, "Файл сохранен", Toast.LENGTH_SHORT).show();
        }
        catch(IOException ex) {

            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{
            try{
                if(fos!=null)
                    fos.close();
            }
            catch(IOException ex){

                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    //TODO: сюда можно дбавить, чтобы брались данные с темы и сообщения и сохранялиьс в бд, как сообщение пользователя
    // открытие файла
   /* public void openText(View view){

        FileInputStream fin = null;

        try {
            fin = openFileInput(FILE_NAME);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String (bytes);
            mainMessageDone.setText(text);
        }
        catch(IOException ex) {

            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{

            try{
                if(fin!=null)
                    fin.close();
            }
            catch(IOException ex){

                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
    */
}

