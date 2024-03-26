package com.example.practiceapp.person.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.practiceapp.R
import com.example.practiceapp.databinding.RegisterPersonActivityBinding
import com.example.practiceapp.person.model.Person

class PersonActivity:AppCompatActivity() {
    private lateinit var dataBinding: RegisterPersonActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding=DataBindingUtil.setContentView(this, R.layout.register_person_activity)

        var personModel:Person

        dataBinding.personform.saveBtn.setOnClickListener {
            personModel = Person(
                id = 123,
                name = dataBinding.personform.pName.text.toString(),
                email = dataBinding.personform.pEmail.text.toString(),
                contactNumber = dataBinding.personform.pContactNumber.text.toString(),
                dateOfBirth = dataBinding.personform.pDoB.text.toString(),
                gender = dataBinding.personform.pGender.text.toString(),
                address = dataBinding.personform.pAddress.text.toString(),
                cnic = dataBinding.personform.pCNIC.text.toString(),
            )
            Log.e("TAG", "Data= $personModel", )
        }
}
}