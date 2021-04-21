package com.example.calculator.database


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TableForData")
data class EntityFile (

    @PrimaryKey(autoGenerate = true)
    val EntryId :Long =0L,

    @ColumnInfo(name = "Operation")
    var OperationName :String ="",

    @ColumnInfo(name = "Result")
    var Result :String ="",

    @ColumnInfo(name ="Operation_Start_time")
    var Start_time :String ="",


    @ColumnInfo(name ="Operation_End_time")
    var End_time :String =""

)
