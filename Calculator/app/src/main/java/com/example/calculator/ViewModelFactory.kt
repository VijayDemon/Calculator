package com.example.calculator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.example.calculator.database.DaoFile
import java.lang.IllegalArgumentException


class ViewModelFactory(

    private val dataSource :DaoFile ): ViewModelProvider.Factory{

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if ( modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(dataSource) as T
        }
        throw  IllegalArgumentException("Unknown ViewModel Class")
    }
}

