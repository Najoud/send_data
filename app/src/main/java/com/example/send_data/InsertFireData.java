package com.example.send_data;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.example.send_data.databinding.ActivityInsertFireDataBinding;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.annotations.NotNull;

public class InsertFireData extends AppCompatActivity {



private ActivityInsertFireDataBinding binding ;
    UserModel user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_insert_fire_data);
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListen();
            }
        });


    }

            private void onClickListen() {

                user = new UserModel();
                user.setUserName(binding.edUserName.getText().toString());
                user.seteMail(binding.edUserEmail.getText().toString());
                user.setPassword(binding.edUserPassword.getText().toString());
                user.setPhone(Integer.parseInt(binding.edUserPhone.getText().toString()));
                UsersDao.addUser(user,onSuccessListener,onFailureListener);

            }

            OnSuccessListener onSuccessListener = new OnSuccessListener() {
                @Override
                public void onSuccess(Object o) {
                    Toast.makeText(InsertFireData.this,"user Added Successfully",Toast.LENGTH_SHORT).show();
                    finish();
                }
            };

            OnFailureListener onFailureListener = new OnFailureListener() {
                @Override
                public void onFailure(@NonNull @NotNull Exception e) {
                    Toast.makeText(InsertFireData.this,e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                }
            };
        }
