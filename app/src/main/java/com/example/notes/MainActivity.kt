package com.example.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item.*

class MainActivity : AppCompatActivity(), IAdapter {
    lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager=LinearLayoutManager(this)

         val adapter=NoteRVAdapter(this,this)
         recyclerView.adapter=adapter

        viewModel=ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
        viewModel.allNotes.observe(this, Observer {list->
            list?.let {
                adapter.updateList(it)
            }

        })

    }


        fun submit(view: View) {
          val noteText = editText.text.toString()
            if (noteText.isNotEmpty())
              viewModel.addNote(Note(noteText))
            editText.text.clear()
        }


    override fun delete(note: Note) {
        viewModel.deleteNote(note)
    }
}