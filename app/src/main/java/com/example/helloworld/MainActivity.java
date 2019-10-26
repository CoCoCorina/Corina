package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.app.Dialog;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "哈哈哈", Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button2:
                        String inputText = editText.getText().toString();
                        Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT).show();
                        imageView.setImageResource(R.drawable.img_2);
                        break;
                    default:
                        break;
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.img_2);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.button4) {
                    int progress = progressBar.getProgress();
                    progress = progress + 10;
                    progressBar.setProgress(progress);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.miExit) {
            new AlertDialog.Builder(this)
                    .setTitle("关闭确认")
                    .setMessage("关闭程序?")
                    .setPositiveButton("是", (dialogInterface, i) -> finish())
                    .setNegativeButton("不", null).show();
        }
        return true;
    }

    @SuppressLint("Registered")
    public class Activity extends MainActivity {
        private Dialog progressDialog;

        /**
         * Called when the activity is first created.
         */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    progressDialog = new Dialog(MainActivity.this, R.style.progress_dialog);
                    progressDialog.setContentView(R.layout.dialog);
                    progressDialog.setCancelable(true);
                    progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                    TextView msg = (TextView) progressDialog.findViewById(R.id.id_tv_loadingmsg);
                    msg.setText("卖力加载中");
                    progressDialog.show();
                }
            });
        }

        public void cancel() {
            progressDialog.dismiss();
        }


    }
}
