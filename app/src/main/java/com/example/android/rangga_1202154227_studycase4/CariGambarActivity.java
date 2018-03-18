package com.example.android.rangga_1202154227_studycase4;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class CariGambarActivity extends AppCompatActivity {
    ImageView gambar;
    EditText URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cari_gambar);

        gambar = (ImageView)findViewById(R.id.img);
        URL = (EditText)findViewById(R.id.cari);

    }
    public void CariGambar(View view){
        Picasso.with(CariGambarActivity.this).load(URL.getText().toString()).placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher).into(gambar);
    }
}
