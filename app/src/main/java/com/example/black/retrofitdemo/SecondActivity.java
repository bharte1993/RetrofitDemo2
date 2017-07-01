package com.example.black.retrofitdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


public class SecondActivity extends AppCompatActivity {

    TextView mtextdata;
    ImageView mimageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent=getIntent();
      //  ArrayList<String> mTitlelist = intent.getStringArrayListExtra("mTitlelist");
        String s = intent.getStringExtra("key");
        String s1 =intent.getStringExtra("key1");

     //  String string = intent.getStringExtra("mTitlelist");
        mtextdata=(TextView)findViewById(R.id.id_textDAta);
        mimageView=(ImageView)findViewById(R.id.id_imageView1);


        mtextdata.setText(s);
        Picasso.with(SecondActivity.this).load(s1).resize(2000,2000).into(mimageView, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError() {

            }
        });
    }
}
