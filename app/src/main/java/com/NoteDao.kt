package com

import androidx.appcompat.widget.DialogTitle
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import java.security.MessageDigest

@Dao
interface NoteDao {

    @Query(value = "SELECT * from note")
    fun getALLnote():List<NoteModel>

    @Insert(onConflict = REPLACE)
    fun insertNote(note: NoteModel)

    @Delete
    fun deleteNote(note: NoteModel)

    @Query(value="UPDATE note SET title =:noteTitle, message=:noteMessage WHERE id=:noteId")
    fun updateNote(noteTitle: String, noteMessage: String, noteId:Long)
}