package com.david4vilac.lifecycle

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val SongList = SongList()
        val songArray = SongList.SongArray()


        val mediaPlayer = MediaPlayer.create(applicationContext, R.raw.nothing_compares)


        val seekBar: SeekBar = findViewById(R.id.sbMusicActivityTwo)
        val tvSongNameTwo: TextView = findViewById(R.id.tvSongNameTwo)
        val btnPlay2: ImageButton = findViewById(R.id.btnPlay2)



        AudioPlay.stopButtonPlay(btnPlay2)
        AudioPlay.seekBarProcess(seekBar)





    }

}