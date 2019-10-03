package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"BiuBiu~",
                        Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                switch (view.getId()){
//                    case R.id.button2:
//                        String inputText = editText.getText().toString();
//                        Toast.makeText(MainActivity.this,inputText,Toast.LENGTH_SHORT).show();
//                        imageView.setImageResource(R.drawable.img_2);
//                        break;
//                    default:
//                        break;
                if (view.getId() == R.id.button2) {
                    String inputText = editText.getText().toString();
                    Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT).show();
                    imageView.setImageResource(R.drawable.img_2);
                }
            }
        });
    }
}
