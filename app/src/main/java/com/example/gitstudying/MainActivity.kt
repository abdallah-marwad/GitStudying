package com.example.gitstudying

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        print("5 Commit")
        print("5 Stash")
        print("Experimental  commit")
        print("Second Commit")
    }
}