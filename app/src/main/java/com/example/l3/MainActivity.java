package com.example.l3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.example.l3.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.provider.MediaStore;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //    Toast.makeText(getApplicationContext(), "Kliknięto przycisk button", Toast.LENGTH_SHORT).show();

                //Intencje
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }

            }
        });
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;

    public void kliknij(View view){
        //obsluga interakcji
     //   Toast.makeText(getApplicationContext(), "Kliknięto przycisk button", Toast.LENGTH_SHORT).show();
        //intencje
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    //zadanie 2- zmiana wlasciwosci kontrolek
    public void changeIcon(View view) {
        Integer random = new Random().nextInt();
        FloatingActionButton button = findViewById(R.id.fab);
        if (random % 2 == 0) {
            button.setImageResource(R.drawable.ic_launcher_background);
        } else {
            button.setImageResource(R.drawable.pingwin);
        }
    }



    //obsluga danych powracajacych z intencji
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bundle extras = data.getExtras(); //przechwytywanie zdjecia
        Bitmap imageBitmap = (Bitmap) extras.get("data"); //konwertowanie danych do bitmapy
        ConstraintLayout layout = findViewById(R.id.constraintlayout);
        layout.setBackground(new BitmapDrawable(getResources(), imageBitmap));
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();




        //noinspection SimplifiableIfStatement
      /*  if (id == R.id.action_settings) {
            return true;
        }*/
      switch (id){
          case R.id.action_item1:
              Toast.makeText(getApplicationContext(), "Kliknięto wybór 1", Toast.LENGTH_SHORT).show();
              break;
          case R.id.action_item2:
              Toast.makeText(getApplicationContext(), "Kliknięto wybór 2", Toast.LENGTH_SHORT).show();
              break;
          case R.id.action_item3:
              Toast.makeText(getApplicationContext(), "Kliknięto wybór 3", Toast.LENGTH_SHORT).show();
              break;
          default: return true;
      }

        return super.onOptionsItemSelected(item);
    }
}