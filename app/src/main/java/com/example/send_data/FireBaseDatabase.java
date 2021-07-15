package com.example.send_data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FireBaseDatabase {
    private static FirebaseDatabase firebaseDatabase;

    static FirebaseDatabase getInstance(){
        if (firebaseDatabase ==null){
            firebaseDatabase = FirebaseDatabase.getInstance();
        }

        return firebaseDatabase;
    }

    public static final String users = "Users";
    public static DatabaseReference getUserBranch(){
        return getInstance().getReference(users);
    }
}

