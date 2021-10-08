package com.delnortedevs.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.delnortedevs.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var todoList = mutableListOf(
            Todo("RH", false),
            Todo("Administrativo", true),
            Todo("Permiso 3", false),
            Todo("Permiso 4", false),
            Todo("Permiso 5", false),
            Todo("Permiso 6", true),
            Todo("Permiso 7", false),
            Todo("Permiso 8", false),
            Todo("Permiso 9", false),
            Todo("Permiso 10", false),
            Todo("Permiso 11", true),
            Todo("Permiso 12", false),
            Todo("Permiso 13", false)

        )

        //  val adapter = Adapter(todoList)
        val adapter = RvAdapter(this, todoList)
        binding.rvTodos.adapter = adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(this)


        binding.buttonTodo.setOnClickListener {

            todoList.add(Todo(binding.editTextTodo.text.toString(),false))
            adapter.notifyItemInserted(todoList.size-1)

            Toast.makeText(this,"New item added",Toast.LENGTH_SHORT).show()
        }

    }
}