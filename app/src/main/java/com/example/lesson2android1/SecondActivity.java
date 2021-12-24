package com.example.lesson2android1;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView ipView;
    EditText edTitle;
    Button btnAdd;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ipView = findViewById(R.id.ip_image);
        btnAdd = findViewById(R.id.btn_second_activity_this);
        edTitle = findViewById(R.id.et_title);

        btnAdd.setOnClickListener(this);

        ipView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultLauncher.launch("image/*");
            }
        });
    }

    ActivityResultLauncher<String> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    uri = result;
                    ipView.setImageURI(uri);
                }
            });

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("name", edTitle.getText().toString());
        intent.setData(uri);
        startActivity(intent);
    }
}