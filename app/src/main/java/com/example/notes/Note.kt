package com.example.notes

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Note")
class Note(val text:String) {
   @PrimaryKey (autoGenerate = true) var id =0
}