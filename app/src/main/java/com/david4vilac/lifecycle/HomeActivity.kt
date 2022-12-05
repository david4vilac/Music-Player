package com.david4vilac.lifecycle

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.david4vilac.lifecycle.SongPrefs.Companion.prefs

class HomeActivity : AppCompatActivity() {
    val SongList = SongList()
    val songArray = SongList.SongArray()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val seekBar: SeekBar = findViewById(R.id.sbMusicActivityTwo)

        val tvProgressTwo: TextView = findViewById(R.id.tvProgressTwo)
        val btnPlay2: ImageButton = findViewById(R.id.btnPlay2)
        val ivFooterSong: ImageView = findViewById(R.id.ivFooterSong)


        setData()
        AudioPlay.stopButtonPlay(btnPlay2)
        AudioPlay.seekBarProcess(seekBar, tvProgressTwo)

        ivFooterSong.setOnClickListener {
            finish()
        }
    }

    fun setData(){
        val ivFooterSong: ImageView = findViewById(R.id.ivFooterSong)
        val tvSongNameTwo: TextView = findViewById(R.id.tvSongNameTwo)
        val tvAuthorFooter: TextView = findViewById(R.id.tvAuthorFooter)

        tvAuthorFooter.text = prefs.getSongAuthor()
        ivFooterSong.setImageResource(prefs.getImage())
        tvSongNameTwo.text = prefs.getSongName()
    }

    override fun onResume() {
        Log.d("onResume","Hola")
        //AudioPlay.continuePlaying(this)
        changeIconPlay()
        super.onResume()
    }

    override fun onStart() {
        super.onStart()
        val rv = findViewById<RecyclerView>(R.id.rvSong)
        rv.adapter = AdaptadorSong(songArray, this)
        rv.layoutManager = LinearLayoutManager(this)
        changeIconPlay()
        rv.setOnClickListener{
            Toast.makeText(this,"${AudioPlay.validator()}", Toast.LENGTH_SHORT).show()
        }
    }

    fun changeIconPlay(){
        val btnPlay2: ImageButton = findViewById(R.id.btnPlay2)
        if(!AudioPlay.validator()){
            btnPlay2.setImageResource(R.drawable.ic_play_arrow_white)
        }else{
            btnPlay2.setImageResource(R.drawable.ic_pause_white)
        }
    }

    fun showMessage(msg: String){
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
    }

}