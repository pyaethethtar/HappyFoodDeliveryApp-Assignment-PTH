package com.example.happyfooddelivery.network.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

object FirebaseAuthManager : AuthManager {

    private val mFirebaseAuth : FirebaseAuth = FirebaseAuth.getInstance()

    override fun register(
        username: String,
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful && it.isComplete){
                    mFirebaseAuth.currentUser?.updateProfile(
                        UserProfileChangeRequest.Builder().setDisplayName(username).build()
                    )
                    onSuccess()
                }
                else{
                    onFailure(it.exception?.message ?: "Please check Internet Connection")
                }
            }
    }

    override fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful && it.isComplete)   onSuccess()
                else onFailure(it.exception?.message ?: "Please check Internet Connection")
            }
    }

    override fun getEmail(): String {
        return mFirebaseAuth.currentUser?.email ?: ""
    }
}