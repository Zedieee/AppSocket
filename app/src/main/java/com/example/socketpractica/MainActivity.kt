package com.example.socketpractica

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val msg = findViewById<EditText>(R.id.msg)
        val send = findViewById<Button>(R.id.send)

        SocketHandler.setSocket()
        SocketHandler.establishConnection()


        val mSocket = SocketHandler.getSocket()

        mSocket.connect()

        send.setOnClickListener {
            mSocket.emit("mensaje", msg.text.toString())


        }


        mSocket.on("connection") {
            runOnUiThread {
                Log.d("mensaje", "conectado")
            }
                }
        }


            }


