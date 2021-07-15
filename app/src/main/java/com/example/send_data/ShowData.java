package com.example.send_data;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.example.send_data.databinding.ActivityShowDataBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ShowData extends AppCompatActivity {
ActivityShowDataBinding binding ;
    UserFireBase adapter;
    RecyclerView.LayoutManager layoutManager;
    UserModel user;
    List<UserModel> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_show_data);
        adapter = new UserFireBase(null);
        layoutManager = new LinearLayoutManager(this);
        binding.include.recyclerViewShowData.setAdapter(adapter);
        binding.include.recyclerViewShowData.setLayoutManager(layoutManager);
        FireBaseDatabase.getUserBranch().addValueEventListener(valueEventListener);



        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowData.this , InsertFireData.class );
                startActivity(intent);
            }
        });

    }


    ValueEventListener valueEventListener =  new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
            users = new ArrayList<>();
            for (DataSnapshot snapshot1:snapshot.getChildren()){
                user = snapshot1.getValue(UserModel.class);
                users.add(user);
                adapter = new UserFireBase(users);
                binding.include.recyclerViewShowData.setAdapter(adapter);

            }

        }

        @Override
        public void onCancelled(@NonNull @NotNull DatabaseError error) {
            Toast.makeText(ShowData.this, error.getMessage(), Toast.LENGTH_SHORT).show();
        }
    };


}
