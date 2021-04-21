package com.example.calculator.history


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.example.calculator.database.DaoFile
import java.lang.IllegalArgumentException


class HistoryViewModelFactory(

    private val dataSource :DaoFile ): ViewModelProvider.Factory{

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if ( modelClass.isAssignableFrom(HistoryViewModel::class.java)){
            return HistoryViewModel(dataSource) as T
        }
        throw  IllegalArgumentException("Unknown ViewModel Class")
    }
}
