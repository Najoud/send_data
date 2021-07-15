package com.example.send_data;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.send_data.databinding.ItemUserBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UserFireBase  extends RecyclerView.Adapter<UserFireBase.ViewHolder>{
    List<UserModel> userList;

    public UserFireBase(List<UserModel> userList) {
        this.userList = userList;
    }



    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public UserFireBase.ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent,int viewType) {
        ItemUserBinding itemUserFirebaseBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_user,parent,false);
        return new ViewHolder(itemUserFirebaseBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull UserFireBase.ViewHolder holder,int position) {
        UserModel user =  userList.get(position);
        holder.binding.tvUserNameData.setText(user.getUserName());
        holder.binding.tvUserEmailData.setText(user.geteMail());
        holder.binding.tvUserPasswordData.setText(user.getPassword());
        holder.binding.tvUserPhoneData.setText(String.valueOf(user.getPhone()));

    }


    @Override
    public int getItemCount() {
        if (userList==null){
            return 0;
        }else {
            return userList.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemUserBinding binding;

        public ViewHolder(@NonNull @NotNull ItemUserBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
    }
