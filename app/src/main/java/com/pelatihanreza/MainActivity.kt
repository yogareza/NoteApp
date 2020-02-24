package com.pelatihanreza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.NoteDatabase
import com.NoteModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainActivity : AppCompatActivity() {

    var noteDatabase: NoteDatabase? = null
    lateinit var layoutManager: LinearLayoutManager
    lateinit var noteAdapter : NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteDatabase = NoteDatabase.getInstance(this)
        layoutManager = LinearLayoutManager(this)
        noteAdapter = NoteAdapter(ArrayList())
        ma_rv_note.layoutManager = layoutManager
        ma_rv_note.adapter = noteAdapter
        getAllNotes()
        ma_fab_add.onClick {
            startActivity(intentFor<addupdateActivity>())
        }

    }


    override fun onRestart() {
        super.onRestart()
        getAllNotes()
    }
    private fun getAllNotes() {
        GlobalScope.launch {
            val list: List<NoteModel>? =
                noteDatabase?.noteDao()?.getALLnote()
            runOnUiThread {
                showAllNotes(list)
            }
        }
    }
    private fun showAllNotes(list: List<NoteModel>?) {
        noteAdapter.setListOfNotes(list)
    }


}
