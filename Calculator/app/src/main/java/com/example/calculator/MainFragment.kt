package com.example.calculator

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.calculator.databinding.MainFragmentBinding
import com.example.calculator.database.DatabaseFile
import com.example.calculator.database.EntityFile
import java.text.DecimalFormat
import java.text.NumberFormat


class MainFragment : Fragment()  {
    var appendingValue: String = ""
    var time =EntityFile()


    private lateinit var data :LiveData<List<EntityFile>>
    private lateinit var binding: MainFragmentBinding
    private lateinit var viewModel: MainViewModel
//    private lateinit var mainViewModel :MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       binding = DataBindingUtil.inflate(inflater,R.layout.main_fragment,container,false)
        val application = requireNotNull(this).requireActivity().application
        val dataSource = DatabaseFile.getInstance(application).DaoInstance
        val viewModelFactory = ViewModelFactory(dataSource)
         viewModel = ViewModelProviders.of(this,
             viewModelFactory).
         get(MainViewModel::class.java)

        viewModel.state.observe(viewLifecycleOwner, Observer {

            if(it == true){
                data = viewModel.dataList!!
                viewModel.state.value=false


            }
        })

        setListeners()





        return binding.root




    }
    fun Long.onTick() :String{
        val f: NumberFormat = DecimalFormat("00")
        val hr = (this) / 360000 % 60
        val min = (this / 60000) % 60
        val sec = (this / 1000) % 60
        var countDown :String = (f.format(hr)+ ":" + f.format(min) + ":" + f.format(sec))
        return countDown
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        var time =EntityFile()
        var start_time :Long= System.currentTimeMillis()
        var Start_time :String ="00:00:00"

        binding.buttonGo.setOnClickListener {
            var quest: String = binding.textView2.text.toString()
            var oprplace = 0
            var Operand1: Double = 0.0
            var Operand2: Double = 0.0
            var Ans: Double = 0.0
            if (quest.contains("+")) {
                oprplace = quest.indexOf("+")
                Log.i("found", "plus found")
                Log.i("plusIndex", "$oprplace")
            }
            if (quest.contains("-"))
                oprplace = quest.indexOf("-")

            if (quest.contains("*"))
                oprplace = quest.indexOf("*")

            if (quest.contains("/"))
                oprplace = quest.indexOf("/")

            Operand1 = quest.substring(0, oprplace).toDouble()
            Log.i("op1", "$Operand1")
            Operand2 = quest.substring(oprplace + 1).toDouble()

            //                Log.i("one","$Operand1")
            Log.i("two", "$Operand2")

            if (quest[oprplace] == '+') {
                Ans = Operand1 + Operand2

            }

            if (quest[oprplace] == '-') {
                Ans = Operand1 - Operand2

            }
            if (quest[oprplace] == '*') {
                Ans = Operand1 * Operand2

            }
            if (quest[oprplace] == '/') {
                Ans = Operand1 / Operand2

            }
//                    Log.i("answer", "$Ans")
            var zeroRemove: String = Ans.toString()
            if (zeroRemove.substring(zeroRemove.length - 2).equals(".0")) {
                zeroRemove = zeroRemove.substring(0, zeroRemove.length - 2)
                binding.textView3.text = zeroRemove
            } else {
                binding.textView3.text = Ans.toString()
            }
            var name = binding.textView2.text.toString()
            var res = binding.textView3.text.toString()
            time.End_time =  (System.currentTimeMillis() - start_time).onTick()
            viewModel.insert(name,res,Start_time,time.End_time)
        }

        }


    private fun setListeners() {

         val clickableViewsForNumbers: List<View> = listOf(
            binding.button0,
            binding.button1,
            binding.button2,
            binding.button3,
            binding.button4,
            binding.button5,
            binding.button6,
            binding.button7,
            binding.button8,
            binding.button9
        )
        val clickableViewsForSigns: List<View> = listOf(
            binding.buttonClear,
            binding.buttonDelete,
            binding.buttonDivide,
            binding.buttonDot,
            binding.buttonGo,
            binding.buttonMinus,
            binding.buttonMulti,
            binding.buttonPlus
        )

        for (item in clickableViewsForNumbers) {

            item.setOnClickListener {
                appendingValue += (it as Button).text
                binding.textView2.text = appendingValue
            }
        }
        for ( item in  clickableViewsForSigns){
            item.setOnClickListener{
            
            when(item) {
                binding.buttonClear -> {
                appendingValue = ""
                binding.textView2.text = ""
                binding.textView3.text = "0"
            }
            binding.buttonDelete -> {
                if (appendingValue.isNotEmpty()) {
                    appendingValue =
                        appendingValue.substring(0, binding.textView2.text.length - 1)
                }
                binding.textView2.text =appendingValue
                }

                 else -> {
                    appendingValue += (it as Button).text
                    binding.textView2.text = appendingValue



                    }
                }
            }
        }
    }
}

