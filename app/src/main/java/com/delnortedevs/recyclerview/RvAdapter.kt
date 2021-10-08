package com.delnortedevs.recyclerview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.delnortedevs.recyclerview.databinding.ActivityMainBinding
import com.delnortedevs.recyclerview.databinding.ItemTodoBinding

class RvAdapter(val context: Context, var todos: List<Todo>) : RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.cardviewId.setOnClickListener{
                Log.i("Click","DESDE AQUI")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvAdapter.ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTodoBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RvAdapter.ViewHolder, position: Int) {


       // holder.binding.textViewTitle.text = todos[position].title
       // holder.binding.checkBoxState.isChecked = todos[position].isChecked

        holder.binding.apply {

            textViewTitle.text = todos[position].title
            checkBoxState.isChecked = todos[position].isChecked

            textViewTitle.setOnClickListener{
                Toast.makeText(context,"Position clicked: ${position+1}",Toast.LENGTH_SHORT).show()

                Log.i("Click",todos[position].title)
            }
        }
    }

    override fun getItemCount(): Int {

        return todos.size
    }


}