
package com.example.myapplication.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.data.Message
import com.example.myapplication.utils.Constants.RECEIVE_ID
import com.example.myapplication.utils.Constants.SEND_ID
import com.example.myapplication.utils.BotResponse
import com.example.myapplication.utils.Constants.OPEN_GOOGLE
import com.example.myapplication.utils.Constants.OPEN_SEARCH
import com.example.myapplication.utils.Time
import kotlinx.android.synthetic.main.activity_main_bot.*
import kotlinx.coroutines.*

class MainActivityBot : AppCompatActivity() {
    private val TAG = "MainActivity"


    var messagesList = mutableListOf<Message>()

    private lateinit var adapter: MessagingAdapter
    private val botList = listOf("SecureBot")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_bot)

        recyclerView()

        clickEvents()

        val random = (0..3).random()
        customBotMessage("Hola! Estas hablando con SegureBot, cómo puedo ayudarte?")
    }

    private fun clickEvents() {

        //Enviar mensaje
        btn_send.setOnClickListener {
            sendMessage()
        }

        //Scroll a la ultima posicion
        et_message.setOnClickListener {
            GlobalScope.launch {
                delay(100)

                withContext(Dispatchers.Main) {
                    rv_messages.scrollToPosition(adapter.itemCount - 1)

                }
            }
        }
    }

    private fun recyclerView() {
        adapter = MessagingAdapter()
        rv_messages.adapter = adapter
        rv_messages.layoutManager = LinearLayoutManager(applicationContext)

    }

    override fun onStart() {
        super.onStart()
        //Si hay un mensaje en el chat, cuando volvamos a entrar nos llevara al ultimo mensaje
        GlobalScope.launch {
            delay(100)
            withContext(Dispatchers.Main) {
                rv_messages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }

    private fun sendMessage() {
        val message = et_message.text.toString()
        val timeStamp = Time.timeStamp()

        if (message.isNotEmpty()) {
            //Agrega el mensaje a la lista
            messagesList.add(Message(message, SEND_ID, timeStamp))
            et_message.setText("")

            adapter.insertMessage(Message(message, SEND_ID, timeStamp))
            rv_messages.scrollToPosition(adapter.itemCount - 1)

            botResponse(message)
        }
    }

    private fun botResponse(message: String) {
        val timeStamp = Time.timeStamp()

        GlobalScope.launch {
            //Delay de la respuesta
            delay(1000)

            withContext(Dispatchers.Main) {
                //Obtiene la respuesta
                val response = BotResponse.basicResponses(message)

                //Agrega mensaje a la lista
                messagesList.add(Message(response, RECEIVE_ID, timeStamp))

                //Coloca nuestro mensaje en pantalla
                adapter.insertMessage(Message(response, RECEIVE_ID, timeStamp))

                //Auto scroll que nos posiciona sobre el ultimo mensaje
                rv_messages.scrollToPosition(adapter.itemCount - 1)

                //Abre google
                when (response) {
                    OPEN_GOOGLE -> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://www.google.com/")
                        startActivity(site)
                    }
                    OPEN_SEARCH -> {
                        val site = Intent(Intent.ACTION_VIEW)
                        val searchTerm: String? = message.substringAfterLast("search")
                        site.data = Uri.parse("https://www.google.com.ar$searchTerm")
                        startActivity(site)
                    }

                }
            }
        }
    }

    private fun customBotMessage(message: String) {

        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main) {
                val timeStamp = Time.timeStamp()
                messagesList.add(Message(message, RECEIVE_ID, timeStamp))
                adapter.insertMessage(Message(message, RECEIVE_ID, timeStamp))

                rv_messages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }
}