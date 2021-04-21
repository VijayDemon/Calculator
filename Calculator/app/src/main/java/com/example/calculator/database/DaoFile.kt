package com.example.calculator.database


import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao

@Dao
interface DaoFile{

    @Insert
    fun insertTheDataToTable(entry :EntityFile)

    @Query ("SELECT * FROM TableForData ")
    fun getAllTasks() : LiveData<List<EntityFile>>

    @Query ("DELETE FROM TableForData")
    fun clear()
}