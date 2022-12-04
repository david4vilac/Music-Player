package com.david4vilac.lifecycle

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val nextButton: ImageButton = findViewById(R.id.nextButton)
        val queueButton: ImageButton = findViewById(R.id.queueButton)

        val SongList = SongList()
        val songArray = SongList.SongArray()
        val playButton: ImageButton = findViewById(R.id.btnPlay)

        var i = 0

        // mediaplayer
        //val mediaPlayer =
        playButton.setOnClickListener {
            AudioPlay.playAudio(applicationContext,songArray[i].mediaPlayer)
            setDataMusic(i)
        }




        queueButton.setOnClickListener {
            startActivity(Intent(applicationContext, HomeActivity::class.java))
        }
        nextButton.setOnClickListener {
            //val dialog = CustomSong()
            //dialog.show(supportFragmentManager, "List Song")
            //finish()
            i += 1
            Toast.makeText(this,"$i", Toast.LENGTH_SHORT).show()
            setDataMusic(i)
        }



    }

    fun setDataMusic(i:Int){
        val SongList = SongList()
        val songArray = SongList.SongArray()

        val seekBar: SeekBar = findViewById(R.id.sbMusic)
        val playButton: ImageButton = findViewById(R.id.btnPlay)
        val tvProgress: TextView = findViewById(R.id.tvProgress)
        val tvFinish: TextView = findViewById(R.id.tvFinish)

        val tvAuthor: TextView = findViewById(R.id.tvAuthor)
        val tvSongName: TextView = findViewById(R.id.tvSongName)

        val mediaPlayer = MediaPlayer.create(applicationContext, songArray[i].mediaPlayer)
        tvAuthor.text = songArray[i].author
        tvSongName.text = songArray[i].name


        tvFinish.text = "${AudioPlay.createTimeLabel()}"
        //AudioPlay.playAudio(applicationContext,songArray[i].mediaPlayer)

        AudioPlay.stopButtonPlay(playButton)
        AudioPlay.seekBarProcess(seekBar)

    }

    override fun onRestart() {
        Log.d("Restart","Hola")
        super.onRestart()
    }

    override fun onResume() {
        Log.d("onResume","Hola")
        super.onResume()
    }

    override fun onPause() {
        Log.d("onPause","Hola")
        super.onPause()
    }


}
