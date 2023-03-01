package com.example.team_project.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.team_project.R;
import com.example.team_project.adapter.ShowAllAdapter;
import com.example.team_project.models.ShowAll;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ShowAllActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    ShowAllAdapter showAllAdapter;
    List<ShowAll> showAllList;
    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_show_all);

        //type
        String type = getIntent().getStringExtra("type");
        System.out.println(type);
        //toolbar
        toolbar = findViewById(R.id.toolbarShowAll);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        firestore = FirebaseFirestore.getInstance();

        recyclerView = findViewById(R.id.show_all_rec);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        showAllList = new ArrayList<>();
        showAllAdapter = new ShowAllAdapter(this,showAllList);
        recyclerView.setAdapter(showAllAdapter);



        if(type==null || type.isEmpty()){
            firestore.collection("ShowAll").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if(task.isSuccessful()){
                        for (DocumentSnapshot doc : task.getResult().getDocuments()){
                            ShowAll showAll = doc.toObject(ShowAll.class);
                            showAllList.add(showAll);
                            showAllAdapter.notifyDataSetChanged();
                        }
                    }
                }
            });
        }

        if (type!=null && type.equalsIgnoreCase("headphone")){
            getSupportActionBar().setTitle("Headphone");
            firestore.collection("ShowAll").whereEqualTo("type","headphone").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if(task.isSuccessful()){
                        for (DocumentSnapshot doc : task.getResult().getDocuments()){
                            ShowAll showAll = doc.toObject(ShowAll.class);
                            showAllList.add(showAll);
                            showAllAdapter.notifyDataSetChanged();
                        }
                    }
                }
            });
        }

        if (type!=null && type.equalsIgnoreCase("speaker")){
            getSupportActionBar().setTitle("Speaker");
            firestore.collection("ShowAll").whereEqualTo("type","speaker").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if(task.isSuccessful()){
                        for (DocumentSnapshot doc : task.getResult().getDocuments()){
                            ShowAll showAll = doc.toObject(ShowAll.class);
                            showAllList.add(showAll);
                            showAllAdapter.notifyDataSetChanged();
                        }
                    }
                }
            });
        }

        if (type!=null && type.equalsIgnoreCase("laptop")){
            getSupportActionBar().setTitle("Laptop");
            firestore.collection("ShowAll").whereEqualTo("type","laptop").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if(task.isSuccessful()){
                        for (DocumentSnapshot doc : task.getResult().getDocuments()){
                            ShowAll showAll = doc.toObject(ShowAll.class);
                            showAllList.add(showAll);
                            showAllAdapter.notifyDataSetChanged();
                        }
                    }
                }
            });
        }

        if (type!=null && type.equalsIgnoreCase("mouse")){
            getSupportActionBar().setTitle("Mouse");
            firestore.collection("ShowAll").whereEqualTo("type","mouse").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if(task.isSuccessful()){
                        for (DocumentSnapshot doc : task.getResult().getDocuments()){
                            ShowAll showAll = doc.toObject(ShowAll.class);
                            showAllList.add(showAll);
                            showAllAdapter.notifyDataSetChanged();
                        }
                    }
                }
            });
        }if (type!=null && type.equalsIgnoreCase("phone")){
            getSupportActionBar().setTitle("Phone");
            firestore.collection("ShowAll").whereEqualTo("type","phone").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if(task.isSuccessful()){
                        for (DocumentSnapshot doc : task.getResult().getDocuments()){
                            ShowAll showAll = doc.toObject(ShowAll.class);
                            showAllList.add(showAll);
                            showAllAdapter.notifyDataSetChanged();
                        }
                    }
                }
            });
        }if (type!=null && type.equalsIgnoreCase("keyboard")){
            getSupportActionBar().setTitle("Keyboard");
            firestore.collection("ShowAll").whereEqualTo("type","keyboard").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if(task.isSuccessful()){
                        for (DocumentSnapshot doc : task.getResult().getDocuments()){
                            ShowAll showAll = doc.toObject(ShowAll.class);
                            showAllList.add(showAll);
                            showAllAdapter.notifyDataSetChanged();
                        }
                    }
                }
            });
        }

    }


}