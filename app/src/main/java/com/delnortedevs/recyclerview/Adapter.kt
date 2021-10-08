package com.delnortedevs.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter (var todos: List<Todo>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        //Define elements

        val textView_titulo : TextView = view.findViewById(R.id.textView_title)
        val chk : CheckBox = view.findViewById(R.id.checkBox_state)

        init{

            view.setOnClickListener{
              val  index = layoutPosition
                Log.i("Click",index.toString())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_todo,parent,false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView_titulo.text = todos[position].title
        holder.chk.isChecked = todos[position].isChecked
    }

    override fun getItemCount(): Int {
       return todos.size
    }


}