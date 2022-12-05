package com.david4vilac.lifecycle

import android.content.Context
import android.media.MediaPlayer
import android.os.Handler
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import com.david4vilac.lifecycle.SongPrefs.Companion.prefs

object AudioPlay {
    var mediaPlayer: MediaPlayer? = null
    var lastResource: Int? = null

    private lateinit var runnable: Runnable
    private var handler = Handler()

    fun createAudio(c: Context){
        mediaPlayer = MediaPlayer.create(c, prefs.getSong())
    }


    fun playAudio(c: Context, id: Int, isLooping: Boolean = true) {
        createMediaPlayer(c, prefs.getSong())

        mediaPlayer?.let {
            it.isLooping = isLooping

            if (!it.isPlaying) {
                it.start()
            }
        }
    }

    fun createMediaPlayer(c: Context, id: Int) {
        // in case it's already playing something
        mediaPlayer?.stop()

        mediaPlayer = MediaPlayer.create(c, id)
        lastResource = id
    }

    // usually used inside the Activity's onResume method
    fun continuePlaying(c: Context, specificResource: Int? = null) {
        specificResource?.let {
            if (lastResource != specificResource) {
                createMediaPlayer(c, specificResource)
            }
        }

        mediaPlayer?.let {
            if (!it.isPlaying) {
                it.start()
            }
        }
    }

    fun pauseAudio() {
        mediaPlayer?.pause()
    }

    fun stopButtonPlay(btnPlay: ImageButton){
        btnPlay.setOnClickListener{
            if(!mediaPlayer?.isPlaying!!){
                mediaPlayer?.start()
                btnPlay.setImageResource(R.drawable.ic_pause)
            }else{
                mediaPlayer?.pause()
                btnPlay.setImageResource(R.drawable.ic_play_arrow)
            }
        }
    }

    fun validator():Boolean{
        return mediaPlayer?.isPlaying!!
    }

    fun seekBarProcess(seekBar: SeekBar, tvProgress: TextView){
        //seekBar.progress = 0
        seekBar.max = mediaPlayer!!.duration
        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if(p2){
                    mediaPlayer?.seekTo(p1)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })

        runnable = Runnable{
            seekBar.progress = mediaPlayer?.currentPosition!!
            handler.postDelayed(runnable, 1000)
            tvProgress.text = createTimeProgress()
        }

        handler.postDelayed(runnable, 1000)
        mediaPlayer?.setOnCompletionListener {
            mediaPlayer?.pause()
        }

    }

    fun createTimeLabel():String{
        var timeLabel = ""
        val min = mediaPlayer?.duration!! / 1000 / 60
        val sec = mediaPlayer?.duration!! / 1000 % 60

        timeLabel = "$min:"
        if(sec < 10) timeLabel += "0"
        timeLabel += sec

        return timeLabel
    }

    fun createTimeProgress():String{
        var timeLabel = ""
        val min = mediaPlayer?.currentPosition!! / 1000 / 60
        val sec = mediaPlayer?.currentPosition!! / 1000 % 60

        timeLabel = "$min:"
        if(sec < 10) timeLabel += "0"
        timeLabel += sec

        return timeLabel
    }

    fun refreshSong(){
        mediaPlayer?.stop()



        //cargarNueva canción
    }

}