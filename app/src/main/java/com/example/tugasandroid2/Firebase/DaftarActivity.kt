package com.example.tugasandroid2.Firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Toast
import com.example.tugasandroid2.R
import com.example.tugasandroid2.databinding.ActivityDaftarBinding
import com.example.tugasandroid2.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class DaftarActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDaftarBinding
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDaftarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.BtnSimpan.setOnClickListener{
            var Nama = binding.InputNama.text.toString()
            var Username = binding.InputUsername.text.toString()
            var Nomor = binding.InputNomor.text.toString()
            var Email = binding.InputEmail.text.toString()
            var Password = binding.InputPassword.text.toString()

            if(Nama.isEmpty()){
                binding.InputNama.error = "Nama wajib diisi"
                binding.InputNama.requestFocus()
                return@setOnClickListener
            }
            if(Username.isEmpty()){
                binding.InputUsername.error = "Username wajib diisi"
                binding.InputUsername.requestFocus()
                return@setOnClickListener
            }
            if(Nomor.isEmpty()){
                binding.InputNomor.error = "Nomor wajib diisi"
                binding.InputNomor.requestFocus()
                return@setOnClickListener
            }
            if(Email.isEmpty()){
                binding.InputEmail.error = "Email wajib diisi"
                binding.InputEmail.requestFocus()
                return@setOnClickListener
            }
            if(Password.isEmpty()){
                binding.InputPassword.error ="Password wajib diisi"
                binding.InputPassword.requestFocus()
                return@setOnClickListener
            }
            if(Password.length == 8){
                binding.InputPassword.error ="Password harus 8 karaktes"
                binding.InputPassword.requestFocus()
                return@setOnClickListener
            }
            RegiterFirebase(Email, Password)
        }

    }

    private fun RegiterFirebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this,"Register Berhasil",Toast.LENGTH_SHORT).show()
                    var Berhasil = Intent(this, LoginActivity::class.java)
                    startActivity(Berhasil)
                } else {
                    Toast.makeText(this, "${it.exception?.message}",Toast.LENGTH_SHORT).show()
                }
            }
    }
}