package com.david4vilac.lifecycle

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment


class CustomSong: DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,

    ): View {
        var rootView: View = inflater.inflate(R.layout.activity_custom_song, container, false)

        val btnPlayCustomView: Button = rootView!!.findViewById(R.id.btnPlayCustomView)
        btnPlayCustomView.setOnClickListener {
            Log.d("onResume", "Hola")
        }

        return rootView
    }

}
