package com.example.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculator.database.DaoFile
import com.example.calculator.database.EntityFile
import kotlinx.coroutines.*


class MainViewModel (private val database :DaoFile ): ViewModel() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    val state = MutableLiveData<Boolean>()
     init {
        state.value = false

    }

    var dataList :LiveData<List<EntityFile>>? =null

    override fun onCleared() {
        super.onCleared()
   }

    fun insert(Work: String, Result: String, Start_Time: String, End_Time: String) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                var AddingEntry = EntityFile()
                AddingEntry.OperationName = Work
                AddingEntry.Result = Result
                AddingEntry.Start_time = Start_Time
                AddingEntry.End_time = End_Time
                database.insertTheDataToTable(AddingEntry)
            }
        }
    }

    fun delete () {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                database.clear()
            }
        }
    }


 }























//        fun getInput(view :View){
//            when (view.id){
//
//
//            R.id.button_clear-> {
//                appendingValue = ""
//                R.id.textView2.text = ""
//                R.id.textView3.text = "0"
//            }
//
//            R.id.buttonDelete -> {
//                if (appendingValue.isNotEmpty()) {
//                    bindObj.textView2.text =
//                        appendingValue.substring(0, bindObj.textView2.text.length - 1)
////                        replace(appendingValue.substring(appendingValue.length - 1),"")
//                }
//            }
//            bindObj.button0 -> {
//
//                appendingValue += (v as Button).text
//                bindObj.textView2.text = appendingValue
//
//            }
//
//            bindObj.button1 -> {
//
//                appendingValue += (v as Button).text
//                bindObj.textView2.text = appendingValue
//            }
//
//            bindObj.button2 -> {
//
//                appendingValue += (v as Button).text
//                bindObj.textView2.text = appendingValue
//            }
//
//            bindObj.button3 -> {
//
//                appendingValue += (v as Button).text
//                bindObj.textView2.text = appendingValue
//            }
//
//            bindObj.button4 -> {
//
//                appendingValue += (v as Button).text
//                bindObj.textView2.text = appendingValue
//            }
//
//            bindObj.button5 -> {
//                appendingValue += (v as Button).text
//                bindObj.textView2.text = appendingValue
//
//            }
//
//            bindObj.button6 -> {
//                appendingValue += (v as Button).text
//                bindObj.textView2.text = appendingValue
//            }
//
//            bindObj.button7 -> {
//
//                appendingValue += (v as Button).text
//                bindObj.textView2.text = appendingValue
//            }
//
//            bindObj.button8 -> {
//
//                appendingValue += (v as Button).text
//                bindObj.textView2.text = appendingValue
//            }
//
//            bindObj.button9 -> {
//
//                appendingValue += (v as Button).text
//                bindObj.textView2.text = appendingValue
//
//            }
//
//            bindObj.buttonDot -> {
//                appendingValue += (v as Button).text
//                bindObj.textView2.text = appendingValue
//            }
//
//            bindObj.buttonPlus -> {
//                appendingValue += (v as Button).text
//                bindObj.textView2.text = appendingValue
//            }
//            bindObj.buttonMinus -> {
//                appendingValue += (v as Button).text
//                bindObj.textView2.text = appendingValue
//            }
//            bindObj.buttonMulti -> {
//                appendingValue += (v as Button).text
//                bindObj.textView2.text = appendingValue
//            }
//            bindObj.buttonDivide -> {
//                appendingValue += (v as Button).text
//                bindObj.textView2.text = appendingValue
//            }
//            bindObj.buttonSign -> {
//                Log.i("val", "${appendingValue.substring(0, 1)}")
//
//                if (appendingValue.substring(0, 1) == "+") {
//                    appendingValue = "-" + appendingValue.substring(1, appendingValue.length)
//                    bindObj.textView2.text = appendingValue
//
//                }
//                if (appendingValue.substring(0, 1) == "-") {
//                    appendingValue = "+" + appendingValue.substring(1, appendingValue.length)
//                    bindObj.textView2.text = appendingValue
//
//                }
//                if (appendingValue.substring(0, 1) != "-" && appendingValue.substring(
//                        0,
//                        1
//                    ) != "+"
//                ) {
//                    appendingValue = "-" + appendingValue
//                    bindObj.textView2.text = appendingValue
//                }
//
//            }
//
//            bindObj.buttonGo -> {
//
//                var quest: String = bindObj.textView2.text.toString()
//                var oprplace = 0
//                var Operand1: Double = 0.0
//                var Operand2: Double = 0.0
//                var Ans: Double = 0.0
//                if (quest.contains("+")) {
//                    oprplace = quest.indexOf("+")
//                    Log.i("found", "plus found")
//                    Log.i("plusIndex", "$oprplace")
//                }
//                if (quest.contains("-"))
//                    oprplace = quest.indexOf("-")
//
//                if (quest.contains("*"))
//                    oprplace = quest.indexOf("*")
//
//                if (quest.contains("/"))
//                    oprplace = quest.indexOf("/")
//
//                Operand1 = quest.substring(0, oprplace).toDouble()
//                Log.i("op1", "$Operand1")
//                Operand2 = quest.substring(oprplace + 1).toDouble()
//
////                Log.i("one","$Operand1")
//                Log.i("two", "$Operand2")
//
//                if (quest[oprplace] == '+') {
//                    Ans = Operand1 + Operand2
//
//                }
//
//                if (quest[oprplace] == '-') {
//                    Ans = Operand1 - Operand2
//
//                }
//                if (quest[oprplace] == '*') {
//                    Ans = Operand1 * Operand2
//
//                }
//                if (quest[oprplace] == '/') {
//                    Ans = Operand1 / Operand2
//
//                }
//                Log.i("answer", "$Ans")
//                var zeroRemove: String = Ans.toString()
//                if (zeroRemove.substring(zeroRemove.length - 2).equals(".0")) {
//                    zeroRemove = zeroRemove.substring(0, zeroRemove.length - 2)
//                    bindObj.textView3.text = zeroRemove
//                } else {
//                    bindObj.textView3.text = Ans.toString()
//
//                }
//            }
//        }
//    }
//}

//                        if (quest[i].equals("+")){
//                            oprplace = quest.indexOf("+")
//                        }
//                    if (quest[i].equals("-")){
//                        oprplace = quest.indexOf("-")
//                    }if (quest[i].equals("+")){
//                        oprplace = quest.indexOf("+")
//                    }if (quest[i].equals("+")){
//                        oprplace = quest.indexOf("+")
//                    }
//                        || quest.contains("-") || quest.contains("*") || quest.contains("/")){
//                    Log.i("It","contains operator")
//
//
//
//                    oprplace = quest.indexOf("+")
//                    oprplace = quest.indexOf("-")
//                    oprplace = quest.indexOf("*")
//                    oprplace = quest.indexOf("/")
//                    Log.i("this ","it has $oprplace")
//










