package com.example.calculator.history

import com.example.calculator.R
import com.example.calculator.databinding.FragmentHistoryBinding
import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.calculator.database.DatabaseFile
import com.example.calculator.database.EntityFile


class HistoryFragment:Fragment(){

    lateinit var data :LiveData<List<EntityFile>>
    lateinit var binding :FragmentHistoryBinding
  private  lateinit var viewModel :HistoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         binding = DataBindingUtil.inflate(inflater,R.layout.fragment_history,container,false)
        val application = requireNotNull(this).requireActivity().application
        val dataSource = DatabaseFile.getInstance(application).DaoInstance
        val historyviewModelFactory = HistoryViewModelFactory(dataSource)
        viewModel = ViewModelProvider(
            this,
            historyviewModelFactory).
        get(HistoryViewModel::class.java)

        viewModel.dataList.observe(viewLifecycleOwner , Observer {

               binding.hisView.setAdapter(HistoryAdapter(requireContext(),it))


        })

        return  binding.root
    }


}
