package com.azad.networking

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.azad.networking.interfaces.ActionPerformer

class NetworkingActivity : AppCompatActivity() {
    private lateinit var actionPerformer: ActionPerformer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_networking)
        actionPerformer = this as ActionPerformer



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun callAnotherModuleMethods(){
        // Perform the action from the network
        actionPerformer.performActionFromNetwork()
    }


}