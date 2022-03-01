package com.moizaandroid.socketexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.moizaandroid.socketexample.MessageType
import com.moizaandroid.socketexample.SocketApplication
import com.moizaandroid.socketexample.databinding.ActivityMainBinding
import com.moizaandroid.socketexample.model.Message
import com.moizaandroid.socketexample.model.MessageResponse
import io.socket.client.Socket
import io.socket.emitter.Emitter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var mSocket: Socket

    private var data = arrayListOf<Message>()

    val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rv.layoutManager= LinearLayoutManager(this)
        binding.rv.setHasFixedSize(true)
        binding.rv.adapter = MainAdapter(applicationContext, data)

        mSocket = SocketApplication.get()

        mSocket.connect()
        mSocket.on("messages", message)

        binding.btnSend.setOnClickListener {
            sendMessage(binding.editText.text.toString())
        }
    }

    var message = Emitter.Listener {
        try {
            val chat: MessageResponse = gson.fromJson(it[0].toString(), MessageResponse::class.java)
            val message = Message(chat.data.data, chat.client, MessageType.CHAT_PARTNER.index)
            setData(message)
        } catch (e: Exception) {
        }
    }

    private fun sendMessage(message: String) {
        mSocket.emit("messages", message)
        val message = Message(message, "나", MessageType.CHAT_MINE.index)
        setData(message)
    }

    private fun setData(message: Message) {
        runOnUiThread {
            data.add(message)
            binding.rv.adapter?.notifyDataSetChanged()
            binding.editText.text = null
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        mSocket.disconnect()
    }
}