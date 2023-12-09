package com.example.tugasandroid2.RecyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasandroid2.R

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var ClubList = listOf<ClubInggris>(
            ClubInggris(
                R.drawable.city,
                "Manchester City",
                "Pep Guardiola"
            ),
            ClubInggris(
                R.drawable.ipul,
                "Liverpool",
                "Jurgen Klopp"
            ),
            ClubInggris(
                R.drawable.senal,
                "Arsenal",
                "Mikel Arteta"
            ),
            ClubInggris(
                R.drawable.mu,
                "Manchester United",
                "Erig Ten Haq"
            ),
            ClubInggris(
                R.drawable.newcastle,
                "Newcastle United",
                "Eddie Howwe"
            ),
            ClubInggris(
                R.drawable.celsea,
                "Chelsea",
                "Mauricio Poccetino"
            ),
            ClubInggris(
                R.drawable.aston,
                "Aston Villa",
                "Unai Emery"
            ),
            ClubInggris(
                R.drawable.brigton,
                "Brighton & Hove Albion",
                "Roberto De Zerbi"
            ),
            ClubInggris(
                R.drawable.full,
                "Fulham",
                "Marco Silva"
            ),
            ClubInggris(
                R.drawable.leicester,
                "Leicester City",
                "Enzo Marrisca"
            ),
        )

        var Item = findViewById<RecyclerView>(R.id.Rv_Club)
        Item.layoutManager = LinearLayoutManager(this)
        Item.setHasFixedSize(true)
        Item.adapter = ClubAdapter(this,ClubList){

        }
    }
}