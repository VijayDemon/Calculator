package com.example.calculator.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [EntityFile::class],version = 1,exportSchema = false)
abstract  class DatabaseFile : RoomDatabase() {

    abstract val DaoInstance: DaoFile


    companion object {
        @Volatile
        private var INSTANCE: DatabaseFile? = null

        fun getInstance(context: Context): DatabaseFile {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext, DatabaseFile::class.java, "Name")
                        .fallbackToDestructiveMigration().build()
                }
                return instance
            }

        }
    }
}
