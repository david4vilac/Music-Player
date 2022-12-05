package com.david4vilac.lifecycle

class SongList {

    fun SongArray(): List<Song>
    {
        return listOf(
            Song("To Be With You", "Mr Big", R.raw.to_be_with_you, R.drawable.image_to_be_with_you),
            Song("Every Rose Has Its Thorn", "Poison", R.raw.every_rose_has_its_thorn, R.drawable.image_every_rose_has_its_thorn),
            Song("Something to belive In", "Poison", R.raw.something_to_believe_in, R.drawable.image_something_to_believe_in),
            Song("Don't Know What You Got", "Cinderella", R.raw.dont_know_what_you, R.drawable.image_dont_know_what_you),
            Song("Stop Crying Your Heart Out", "Oasis", R.raw.stop_crying_your_heart_out, R.drawable.image_stop_crying_your_heart_out),
            Song("Beautiful Girl", "INXS", R.raw.beautiful_girl, R.drawable.image_beautiful_girl),
            Song("Love of My Life", "Queen", R.raw.love_of_my_life, R.drawable.image_love_of_my_life),
            Song("Nothing Compares 2 You", "Chist Cornell", R.raw.nothing_compares, R.drawable.nothing_compares),
            Song("11 y 6", "Fito Paez", R.raw.once_y_seis_fito, R.drawable.image_once_y_seis_fito),
        )
    }
}