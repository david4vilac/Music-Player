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
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import com.david4vilac.lifecycle.SongPrefs.Companion.prefs

class MainActivity : AppCompatActivity() {
    var i = prefs.getContador()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AudioPlay.createAudio(this)

        val nextButton: ImageButton = findViewById(R.id.nextButton)
        val backButton: ImageButton = findViewById(R.id.backButton)
        val queueButton: ImageButton = findViewById(R.id.queueButton)

        val SongList = SongList()
        val songArray = SongList.SongArray()
        val playButton: ImageButton = findViewById(R.id.btnPlay)

        setDataMusic(i)


        nextButton.setOnClickListener {
            i += 1
            if (i == songArray.size){
                i = 0
            }
            Toast.makeText(this,"$i", Toast.LENGTH_SHORT).show()
            prefs.saveSong(songArray[i].mediaPlayer)
            prefs.saveSongName(songArray[i].name)
            prefs.saveSongAuthor(songArray[i].author)
            prefs.saveImage(songArray[i].image)





            prefs.saveContador(i)
            AudioPlay.playAudio(applicationContext,songArray[i].mediaPlayer)
            setDataMusic(i)
            changeIconPlay()
        }

        backButton.setOnClickListener {
            i -= 1
            if (i < 0){
                i = songArray.size - 1
            }
            Toast.makeText(this,"${songArray.size}", Toast.LENGTH_SHORT).show()
            prefs.saveSong(songArray[i].mediaPlayer)
            prefs.saveSongName(songArray[i].name)
            prefs.saveSongAuthor(songArray[i].author)
            prefs.saveImage(songArray[i].image)
            prefs.saveContador(i)
            AudioPlay.playAudio(applicationContext,songArray[i].mediaPlayer)
            setDataMusic(i)
            changeIconPlay()
        }

        queueButton.setOnClickListener {
            startActivity(Intent(applicationContext, HomeActivity::class.java))
        }

        val randomButton: ImageButton = findViewById(R.id.randomButton)
        randomButton.setOnClickListener {
            val random1 = (songArray.indices).shuffled().last()
            Toast.makeText(this,"$random1", Toast.LENGTH_SHORT).show()
            prefs.saveSong(songArray[random1].mediaPlayer)
            prefs.saveSongName(songArray[random1].name)
            prefs.saveSongAuthor(songArray[random1].author)
            prefs.saveImage(songArray[random1].image)
            prefs.saveContador(random1)
            AudioPlay.playAudio(applicationContext,songArray[random1].mediaPlayer)
            setDataMusic(random1)
        }


    }

    fun setDataMusic(i:Int){
        val SongList = SongList()
        val songArray = SongList.SongArray()

        val seekBar: SeekBar = findViewById(R.id.sbMusic)
        val playButton: ImageButton = findViewById(R.id.btnPlay)
        val tvProgress: TextView = findViewById(R.id.tvProgress)
        val tvFinish: TextView = findViewById(R.id.tvFinish)
        val imageSong: ImageView = findViewById(R.id.imageView2)


        val tvAuthor: TextView = findViewById(R.id.tvAuthor)
        val tvSongName: TextView = findViewById(R.id.tvSongName)


        tvAuthor.text = prefs.getSongAuthor()
        tvSongName.text = prefs.getSongName()
        imageSong.setImageResource(prefs.getImage())

        //tvProgress.text = AudioPlay.createTimeProgress()
        tvFinish.text = AudioPlay.createTimeLabel()
        //AudioPlay.playAudio(applicationContext,songArray[i].mediaPlayer)

        AudioPlay.stopButtonPlay(playButton)
        AudioPlay.seekBarProcess(seekBar, tvProgress)

    }

    override fun onDestroy() {
        finish()
        AudioPlay.refreshSong()
        super.onDestroy()
    }

    override fun onResume() {
        Log.d("onResume","Probandoo")
        changeIconPlay()
        Toast.makeText(this,"${AudioPlay.validator()}", Toast.LENGTH_SHORT).show()
        setDataMusic(i)
        super.onResume()
    }

    override fun onPause() {
        Log.d("onPause","Hola")
        setDataMusic(i)
        super.onPause()

    }


    fun changeIconPlay(){
        val playButton: ImageButton = findViewById(R.id.btnPlay)
        if(!AudioPlay.validator()){
            playButton.setImageResource(R.drawable.ic_play_arrow)
        }else{
            playButton.setImageResource(R.drawable.ic_pause)
        }
    }


}
