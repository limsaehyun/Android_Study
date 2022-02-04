package com.moizaandroid.socketexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.moizaandroid.socketexample.databinding.ActivityMainBinding
import io.socket.client.Socket
import io.socket.emitter.Emitter
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var mSocket: Socket

    private var data = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mSocket = SocketApplication.get()

        mSocket.connect()

        mSocket.on("messages", message)

        binding.btnSend.setOnClickListener {
            mSocket.emit("messages", binding.editText.text)
        }

        binding.rv.layoutManager= LinearLayoutManager(this)
        binding.rv.setHasFixedSize(true)
        binding.rv.adapter = MainAdapter(applicationContext, data)
    }

    var message = Emitter.Listener { args ->
        runOnUiThread {
            Toast.makeText(applicationContext, "on", Toast.LENGTH_SHORT).show()
            var data = args[0].toString()

            setData(data)
        }
    }

    private fun setData(message: String) {
        data.add(message)

        for(i: Int in 0..data.size) {
            data.add(data[i])
        }

        binding.rv.adapter?.notifyDataSetChanged()
    }
}