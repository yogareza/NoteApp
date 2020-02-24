package com

import android.os.Parcelable
import androidx.appcompat.widget.DialogTitle
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.security.MessageDigest

@Parcelize
@Entity(tableName = "note")
data class NoteModel(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    var id:Long=0,

    @ColumnInfo(name = "title")
    var title: String?= null,

    @ColumnInfo(name = "message")
    var message: String?= null,

    @ColumnInfo(name = "created_at")
    var createdAt:String? = null

) : Parcelable