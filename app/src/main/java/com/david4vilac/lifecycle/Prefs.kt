package com.david4vilac.lifecycle
import android.content.Context

class Prefs(context: Context) {
    val SHARE_PREFERENCE = "Mydtb"
    val SHARE_NAME = "NAME"
    val SHARE_AUTHOR = "AUTHOR"
    val SHARE_SONG_MEDIA = "MEDIAPLAYER"
    val SHARE_IMAGE = "IMAGE"
    val SHARE_CONTADOR = "I"


    val storage = context.getSharedPreferences(SHARE_PREFERENCE, 0)

    fun saveSongName(name:String){
        storage.edit().putString(SHARE_NAME, name).apply()
    }

    fun getSongName():String{
        return storage.getString(SHARE_AUTHOR, "")!!
    }

    fun saveSongAuthor(author:String){
        storage.edit().putString(SHARE_AUTHOR, author).apply()
    }

    fun getSongAuthor():String{
        return storage.getString(SHARE_NAME, "")!!
    }

    fun saveImage(image:Int){
        storage.edit().putInt(SHARE_IMAGE, image).apply()
    }

    fun getImage():Int{
        return storage.getInt(SHARE_IMAGE, 0)
    }

    fun saveSong(mediaPlayer: Int){
        storage.edit().putInt(SHARE_SONG_MEDIA, mediaPlayer).apply()
    }

    fun getSong():Int{
        return storage.getInt(SHARE_SONG_MEDIA,0)!!
    }

    fun saveContador(i:Int){
        storage.edit().putInt(SHARE_CONTADOR, i).apply()
    }

    fun getContador():Int{
        return storage.getInt(SHARE_CONTADOR, 0)
    }






    fun wipe(){
        storage.edit().clear().apply()
    }
}