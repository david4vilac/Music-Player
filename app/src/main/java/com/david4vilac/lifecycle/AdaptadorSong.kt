package com.david4vilac.lifecycle

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.david4vilac.lifecycle.SongPrefs.Companion.prefs


class AdaptadorSong (val songs: List<Song>, val con: HomeActivity)
    :RecyclerView.Adapter<AdaptadorSong.ViewHolder>(){

    class ViewHolder(v: View): RecyclerView.ViewHolder(v){
        var songName: TextView
        var ivSong: ImageView
        var rowSongLinear: ConstraintLayout
        init {
            songName = v.findViewById(R.id.tvSongNameView)
            ivSong = v.findViewById(R.id.ivSong)
            rowSongLinear = v.findViewById(R.id.rowSongLinear)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptadorSong.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_song, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: AdaptadorSong.ViewHolder, position: Int) {
        val p = songs[position]
        holder.songName.text = p.name
        holder.ivSong.setImageResource(p.image)

        val homeActivity = HomeActivity()


        with(holder){
            rowSongLinear.setOnClickListener {
                prefs.saveSongName(p.name)
                prefs.saveSongAuthor(p.author)
                prefs.saveImage(p.image)
                prefs.saveSong(p.mediaPlayer)

                AudioPlay.playAudio(con, prefs.getSong())
                //homeActivity.setData()
                con.showMessage(p.name)
                con.setData()
                Log.d("Cancion","${p.mediaPlayer}")
            }
        }

    }


    override fun getItemCount(): Int {
        return songs.size
    }


}