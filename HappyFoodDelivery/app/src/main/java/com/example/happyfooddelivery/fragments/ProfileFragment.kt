package com.example.happyfooddelivery.fragments

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.happyfooddelivery.R
import com.example.happyfooddelivery.data.vos.UserVO
import com.example.happyfooddelivery.mvp.presenters.ProfilePresenter
import com.example.happyfooddelivery.mvp.presenters.impls.ProfilePresenterImpl
import com.example.happyfooddelivery.mvp.views.ProfileView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_profile.*
import java.io.IOException

class ProfileFragment : Fragment(), ProfileView {

    private lateinit var mContext : Context
    private lateinit var mView: View
    private lateinit var mPresenter : ProfilePresenter
    private val USER_ID = "USER_ID"
    private val PICK_IMAGE_REQUEST = 111

    private var userEmail = ""
    private var mImage : Bitmap ?= null
    private var mUsername : String = ""
    private var mPassword : String = ""
    private var mPhone : String = ""
    private var mCity : String = ""
    private var mCountry : String = ""

    companion object{
        fun newInstance(email : String) = ProfileFragment().apply {
            arguments = Bundle().apply {
                putString(USER_ID, email)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userEmail = it.getString(USER_ID, "")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mView=view
        setUpPresenter()
        mPresenter.onUiReady(userEmail)

        setUpListeners()
    }


    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(ProfilePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpListeners(){
        btnInsertPhoto.setOnClickListener {
            mPresenter.onTapPhotoUpload()
        }

        btnSave.setOnClickListener {
            mPresenter.onTapSave(mUsername, etEmail.text.toString(), etPassword.text.toString(), etPhone.text.toString(),
            etCity.text.toString(), etCountry.text.toString(), mImage)
        }

        btnCancel.setOnClickListener {
            mPresenter.onTapCancel()
        }
    }

    override fun displayProfileData(user : UserVO) {
        etEmail.setText(user.email)
        etPassword.setText(user.password)
        etPhone.setText(user.phone)
        etCity.setText(user.city)
        etCountry.setText(user.country)
        user.image?.let {
            Glide.with(mContext).load(user.image).circleCrop().into(ivProfile)
        } ?: kotlin.run {
            Glide.with(mContext).load(getString(R.string.empty_photo)).circleCrop().into(ivProfile)
        }


        mImage = ivProfile?.drawable?.toBitmap()
        mUsername = user.username
    }

    override fun navigateToHomeScreen() {
        
    }


    override fun openGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE_REQUEST)
    }

    override fun showError(error: String) {
        Snackbar.make(mView, error, Snackbar.LENGTH_LONG).show()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode==PICK_IMAGE_REQUEST && resultCode==Activity.RESULT_OK){
            if (data==null || data.data==null)  return
            val filepath = data.data
            try {
                filepath?.let {
                    if (Build.VERSION.SDK_INT>=29){
                        val source : ImageDecoder.Source = ImageDecoder.createSource(mContext.contentResolver, filepath)
                        mImage = ImageDecoder.decodeBitmap(source)
                    }
                    else{
                        mImage = MediaStore.Images.Media.getBitmap(mContext.contentResolver, filepath)
                    }
                }
            }
            catch (e : IOException){
                e.printStackTrace()
            }

            mImage?.let {
                Glide.with(mContext).load(mImage).circleCrop().into(ivProfile)
//                ivProfile.setImageBitmap(it)
//                ivProfile.setBackgroundDrawable(BitmapDrawable(resources, it))
            }
        }
    }
}