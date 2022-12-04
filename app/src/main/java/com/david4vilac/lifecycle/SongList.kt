package com.david4vilac.lifecycle

class SongList {

    fun SongArray(): List<Song>
    {
        return listOf(
            Song("Nothing Compares 2 You", "Chist Cornell", R.raw.nothing_compares, R.drawable.nothing_compares),
            Song("11 y 6", "Fito Paez", R.raw.once_y_seis_fito, R.drawable.nothing_compares)
        )
    }
}