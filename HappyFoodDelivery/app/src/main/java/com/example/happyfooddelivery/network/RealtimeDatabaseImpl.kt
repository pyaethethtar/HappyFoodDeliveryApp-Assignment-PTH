package com.example.happyfooddelivery.network

import android.graphics.Bitmap
import android.provider.ContactsContract
import android.util.Log
import com.example.happyfooddelivery.data.vos.*
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import java.io.ByteArrayOutputStream
import java.util.*
import kotlin.collections.ArrayList

object RealtimeDatabaseImpl : FirebaseApi {

    private val database : DatabaseReference = Firebase.database.reference
    private val storage = FirebaseStorage.getInstance()
    private val storageReference = storage.reference

    override fun getCategories(onSuccess: (List<CategoryVO>) -> Unit, onFailure: (String) -> Unit) {
        database.child("categories").addValueEventListener(object : ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                onFailure(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                var categories : ArrayList<CategoryVO> = arrayListOf()
                snapshot.children.forEach {datasnapshot->
                    datasnapshot.getValue(CategoryVO::class.java)?.let {
                        categories.add(it)
                    }
                }
                onSuccess(categories)
            }

        })
    }

    override fun getRestaurants(
        onSuccess: (List<RestaurantVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        database.child("restaurants").addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var restaurantList : ArrayList<RestaurantVO> = arrayListOf()
                snapshot.children.forEach {datasnapshot->
                    datasnapshot.getValue(RestaurantVO::class.java)?.let {
                        restaurantList.add(it)
                    }
                }
                onSuccess(restaurantList)
            }

            override fun onCancelled(error: DatabaseError) {
                onFailure(error.message)
            }
        })

    }

    override fun getRestaurantById(id: Int, onSuccess: (RestaurantVO) -> Unit) {
        database.child("restaurants").child(id.toString()).addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.getValue(RestaurantVO::class.java)?.let {
                    onSuccess(it)
                }

            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("error", error.message)
            }
        })
    }

    override fun getCartItems(onSuccess: (List<CartVO>) -> Unit, onFailure: (String) -> Unit) {
        database.child("cart").addValueEventListener(object : ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                onFailure(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                var itemList : ArrayList<CartVO> = arrayListOf()
                snapshot.children.forEach { datasnapshot->
                    datasnapshot.getValue(CartVO::class.java)?.let {
                        itemList.add(it)
                    }
                }
                onSuccess(itemList)
            }

        })
    }

    override fun addToCart(itemId: Int, itemName: String, price: Int, amount: Int) {
        database.child("cart").child(itemId.toString()).setValue(CartVO(itemId, itemName, price, amount))
    }

    override fun clearCart() {
        database.child("cart").removeValue()
    }

    override fun getCurrentUserInfo(
        email: String,
        onSuccess: (UserVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        database.child("users").child(email.substringBefore('@'))
            .addValueEventListener(object : ValueEventListener{
                override fun onCancelled(error: DatabaseError) {
                    onFailure(error.message)
                }

                override fun onDataChange(snapshot: DataSnapshot) {
                    snapshot.getValue(UserVO::class.java)?.let {
                        onSuccess(it)
                    }
                }

            })
    }

    override fun updateUserInfo(
        username: String,
        email: String,
        password: String,
        phone: String,
        city: String,
        country: String,
        image: Bitmap?
    ) {
        uploadImage(image, onComplete = {
            addUser(username, email, password, phone, city, country, it)
        })

    }

    override fun addUser(username: String, email: String, password: String, phone: String, city: String?, country: String?, image: String?){
        database.child("users").child(email.substringBefore('@')).setValue(UserVO(username,email, password, phone, image, city, country))
    }

    private fun uploadImage(image: Bitmap?, onComplete:(String) -> Unit){
        val baos = ByteArrayOutputStream()
        image?.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val data = baos.toByteArray()
        val imageRef = storageReference.child("images/${UUID.randomUUID()}")
        val uploadTask = imageRef.putBytes(data)
        uploadTask.continueWithTask {
            return@continueWithTask imageRef.downloadUrl
        }.addOnCompleteListener {task ->
            val imageUrl = task.result?.toString()
            imageUrl?.let {
                onComplete(it)
            }

        }

    }
}