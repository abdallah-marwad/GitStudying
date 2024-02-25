package com.example.gitstudying

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import io.agora.agorauikit_android.AgoraConnectionData
import io.agora.agorauikit_android.AgoraSettings
import io.agora.agorauikit_android.AgoraVideoViewer
import io.agora.rtc2.Constants


class MainActivity : AppCompatActivity() {
    // Object of AgoraVideoVIewer class
    private var agView: AgoraVideoViewer? = null
    private val appId = "61b6251f1ffa47c68cf62dccb782be2c"
    private val channelName = "test"
    private val token = "007eJxTYNj+PjOsRq3DdXZO4J3T240FUuw3eDeIrTbSnFukt62ISUeBwcwwyczI1DDNMC0t0cQ82cwiOc3MKCU5Ocncwigp1Sg5/MfN1IZARoY5Vw4zMjJAIIjPwlCSWlzCwAAA9QIfWQ=="
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

//    private fun joinChannel() {
//        agView = AgoraVideoViewer(this , AgoraConnectionData(appId ,token))
//        this.addContentView(agView ,
//            FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT , FrameLayout.LayoutParams.MATCH_PARENT))
//        agView!!.join(channelName,  role = Constants.CLIENT_ROLE_BROADCASTER)
//    }


}