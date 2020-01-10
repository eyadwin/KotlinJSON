package com.example.kotlinjson

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.koushikdutta.ion.Ion
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun todoClick(view: View){
        Ion.with(this)
            .load("https://jsonplaceholder.typicode.com/todos/1")
            //.asJsonObject()
            .asString()
            .setCallback({ e, result ->
                // do stuff with the result or error
                Log.d("Iyad","The JSON data is \n$result")
                processTodoData(result)
            })
    }
    /*This function pulls data from jsonplaceholder
    The data is in the following format:
    {
      "userId": 1,
      "id": 1,
      "title": "delectus aut autem",
      "completed": false
    }*/
    fun processTodoData(result:String){
        val json = JSONObject(result)
        val title = json.getString("title")
        val completed = json.getString("completed")
        //show result
        todoTitle.text=title
        todoCompleted.text=completed
    }
}
