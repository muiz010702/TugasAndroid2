package com.example.tugasandroid2.Firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.tugasandroid2.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity(){

    private lateinit var binding : ActivityLoginBinding
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.text1.setOnClickListener{
            var Daftar = Intent(this@LoginActivity, DaftarActivity::class.java)
            startActivity(Daftar)
        }
        binding.BtnMasuk.setOnClickListener{
            var Email = binding.InputUser.text.toString()
            var Password = binding.InputPass.text.toString()

            if(Email.isEmpty()){
                binding.InputUser.error = "Email wajib diisi"
                binding.InputUser.requestFocus()
                return@setOnClickListener
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
                binding.InputUser.error = "Email tidak sesuai"
                binding.InputUser.requestFocus()
                return@setOnClickListener
            }
            if(Password.isEmpty()){
                binding.InputPass.error ="Password tidak sesuai"
                binding.InputPass.requestFocus()
                return@setOnClickListener
            }

            LoginFirebase(Email, Password)
        }
    }

    private fun LoginFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this,"Login Berhasil", Toast.LENGTH_SHORT).show()
                    var Berhasil = Intent(this, MainActivity2::class.java)
                    startActivity(Berhasil)
                } else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}