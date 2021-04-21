package com.example.calculator.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculator.database.DaoFile
import com.example.calculator.database.EntityFile
import kotlinx.coroutines.*


class HistoryViewModel (database : DaoFile): ViewModel() {

    lateinit var dataList :LiveData<List<EntityFile>>
    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    val state = MutableLiveData<Boolean>()
    init {
        state.value = false
        dataList =  database.getAllTasks()

    }


    override fun onCleared() {
        super.onCleared()
    }

}



