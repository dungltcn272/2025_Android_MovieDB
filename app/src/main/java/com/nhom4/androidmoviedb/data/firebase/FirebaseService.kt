package com.nhom4.androidmoviedb.data.firebase

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

object FirebaseService {
    val rtdb: DatabaseReference by lazy {
        FirebaseDatabase.getInstance().reference
    }

    /*
    val auth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }

    val firestore: FirebaseFirestore by lazy {
        FirebaseFirestore.getInstance()
    }

    val storage: FirebaseStorage by lazy {
        FirebaseStorage.getInstance()
    }
     */
}
/*
* GUIDE:
* val user = FirebaseService.auth.currentUser
FirebaseService.firestore.collection("users").get()
FirebaseService.rtdb.child("users").push().setValue("test")
* */
