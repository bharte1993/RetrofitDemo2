 package com.example.black.retrofitdemo;

 import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.black.retrofitdemo.Model.Articles;
import com.example.black.retrofitdemo.Model.HeadlineResponse;
import com.example.black.retrofitdemo.network.demo.ApiClient;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


 public class MainActivity extends AppCompatActivity {
     private RecyclerView mRecyclerView;
     private RecyclerViewAdapter mAdapter;
     private RecyclerView.LayoutManager mlayoutmanager;

     public List <String> mTitlelist =new ArrayList<>();
     private List<String> murllist=new ArrayList<>();
     private List<String> mdescription=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=(RecyclerView)findViewById(R.id.id_RecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RecyclerViewAdapter();
        mRecyclerView.setAdapter(mAdapter);




    }



     public void download(final View view) {

         mRecyclerView.setVisibility(View.GONE);
         murllist.removeAll(murllist);
         mTitlelist.removeAll(mTitlelist);



         ApiClient.getClient().getData("espn","top","67adcfa31f234ed8b08b2577651df0f2")
                 .enqueue(new ApiClient.Callback<HeadlineResponse>() {
                     @Override
                     public void sucess(HeadlineResponse response) {
                         for(Articles articles: response.getArticles()){
                             String s;
                             String s1;
                         mTitlelist.add(articles.getTitle().toString());
                           murllist.add(articles.getUrl().toString());
                             mdescription.add(articles.getDescription().toString());




                         }

                         for(int i = 0;i < mTitlelist.size();i++){

                             Log.i("the contents are", mTitlelist.get(i)+" "+murllist.get(i));
                         }
                         mRecyclerView.setVisibility(View.VISIBLE);


                     }

                     @Override
                     public void failure(String error) {

                     }

                     @Override
                     public void sucessError(String reason) {

                     }
                 });

     }






     class RecyclerViewAdapter extends RecyclerView.Adapter<Holder>{

         @Override
         public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
             View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_view_layout,parent,false);

             return  new Holder(itemView);
         }

         @Override
         public void onBindViewHolder(Holder holder, int position) {
             holder.bindData(murllist.get(position),mTitlelist.get(position));
             Log.i("inside onbindviewholder","yes");

         }

         @Override
         public int getItemCount() {
             return murllist.size();

         }
     }

     private class Holder extends RecyclerView.ViewHolder{
         TextView mtextview;
         ImageView mimageView;


         public Holder(View itemView) {
             super(itemView);
             mtextview=(TextView)itemView.findViewById(R.id.id_textView);
             mimageView=(ImageView)itemView.findViewById(R.id.id_imageView);

             itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {

                     int pos = mRecyclerView.getChildLayoutPosition(v);
                     String s = mdescription.get(pos);
                     String s1=murllist.get(pos);

                     Intent intent = new Intent(MainActivity.this , SecondActivity.class);
                     intent.putExtra("key",s);
                     intent.putExtra("key1",s1);

                     MainActivity.this.startActivity(intent);

                 }
             });


         }
         public void bindData( final String url , final String text){
           //  Log.i("the title is",titleText);
             Log.i("inside binddata","Yes");
             Picasso.with(MainActivity.this).load(url).resize(150,150).into(mimageView, new Callback() {
                 @Override
                 public void onSuccess() {

                 }

                 @Override
                 public void onError() {

                 }
             });
             mtextview.setText(text);






         }


         }
     }




