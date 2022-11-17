package com.amitb.a23a_10357_l04;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import com.bumptech.glide.Glide;

public class RaceActivity extends AppCompatActivity {

    Button toast;
    EditText name;
    AppCompatImageView race_IMG_background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race);
        findViews();
        initViews();
    }

    private void initViews() {
        Glide
                .with(this)
                .load("https://soccerprime.com/wp-content/uploads/2020/08/soccer-field.jpg")
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(race_IMG_background);

        toast.setOnClickListener(view->toast());
    }

    private void toast() {
        String input = name.getText().toString();
        Toast.makeText(this,"Hello " + input,Toast.LENGTH_SHORT).show();
    }

    private void findViews() {
        race_IMG_background = findViewById(R.id.race_IMG_background);
        toast = findViewById(R.id.race_BTN_toast);
        name = findViewById(R.id.race_ET_name);

    }
}