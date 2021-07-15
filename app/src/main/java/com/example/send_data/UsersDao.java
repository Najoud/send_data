package com.example.send_data;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;

public class UsersDao {

    public static void addUser(UserModel user,
                               OnSuccessListener onSuccessListener,
                               OnFailureListener onFailureListener){

        DatabaseReference userNode = FireBaseDatabase.getUserBranch().push();
        user.setId(userNode.getKey());
        userNode.setValue(user).addOnSuccessListener(onSuccessListener)
                .addOnFailureListener(onFailureListener);

    }
}
