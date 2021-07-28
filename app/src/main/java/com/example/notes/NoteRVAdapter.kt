package com.example.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteRVAdapter(private val context: Context, private val listener :IAdapter) : RecyclerView.Adapter<NoteViewHolder>() {
    private val allNotes= ArrayList<Note>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
     val viewHolder=NoteViewHolder(  LayoutInflater.from(context).inflate(R.layout.item,parent,false))

     viewHolder.deleteButton.setOnClickListener{
         listener.delete(allNotes[viewHolder.adapterPosition])
     }

        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val curr=allNotes[position]
        holder.textView.text=curr.text+"."
         val indexnumber=1+position
        holder.index.text=indexnumber.toString()+":-"
   }

    override fun getItemCount(): Int {
       return allNotes.size
    }
    fun updateList( newList: List<Note>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }
}


class NoteViewHolder(itmView: View) :RecyclerView.ViewHolder(itmView){
  val textView=itmView.findViewById<TextView>(R.id.textView)
  val deleteButton=itmView.findViewById<Button>(R.id.button)
  val index=itmView.findViewById<TextView >(R.id.textView3)
}

interface IAdapter{
    fun delete(note:Note)
}