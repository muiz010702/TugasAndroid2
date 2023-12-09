package com.example.tugasandroid2.RecyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasandroid2.R


class ClubAdapter(
    private val context: Context,
    private val clubList: List<ClubInggris>,
    private val listener: (ClubInggris) -> Unit
) : RecyclerView.Adapter<ClubAdapter.ClubInggrisViewHolder>() {

    inner class ClubInggrisViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var imgName: ImageView = itemView.findViewById(R.id.img_club)
        private var nameClub: TextView = itemView.findViewById(R.id.nameclub)
        private var pelatih: TextView = itemView.findViewById(R.id.pelatih)

        fun bind(club: ClubInggris) {
            imgName.setImageResource(club.ImgClub)
            nameClub.text = club.NameClub
            pelatih.text = club.Pelatih
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubInggrisViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.club_inggris, parent, false)
        return ClubInggrisViewHolder(view)
    }

    override fun getItemCount(): Int {
        return clubList.size
    }

    override fun onBindViewHolder(holder: ClubInggrisViewHolder, position: Int) {
        val club = clubList[position]
        holder.bind(club)
    }
}