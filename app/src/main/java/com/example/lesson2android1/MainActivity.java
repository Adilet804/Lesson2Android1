package com.example.lesson2android1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imImage;
    Button btnAdilet;
    TextView tvText;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imImage = findViewById(R.id.im_image);
        tvText = findViewById(R.id.tv_text);
        btnAdilet = findViewById(R.id.btn_adilet);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        tvText.setText(name);

        Uri getImage = intent.getData();
        imImage.setImageURI(getImage);

        btnAdilet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}