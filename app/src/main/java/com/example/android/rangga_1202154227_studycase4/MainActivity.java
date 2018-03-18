package com.example.android.rangga_1202154227_studycase4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void MHS(View view) {
        Intent intent = new Intent(this,AsyncTaskActivity.class);
        startActivity(intent);
    }

    public void GMB(View view) {
        Intent intent = new Intent(this,CariGambarActivity.class);
        startActivity(intent);
    }
}
