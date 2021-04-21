package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.calculator.databinding.ActivityMainBinding
import androidx.lifecycle.ViewModelProvider
import com.example.calculator.database.DatabaseFile
import com.example.calculator.database.EntityFile



 class MainActivity : AppCompatActivity() {

     private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         val bindObj  :ActivityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main)

        val navController = this.findNavController(R.id.mynavmainfrag)
         NavigationUI.setupActionBarWithNavController(this, navController)

        val application = requireNotNull(this).application
        val dataSource = DatabaseFile.getInstance(application).DaoInstance
        val viewModelFactory = ViewModelFactory(dataSource)

        viewModel =ViewModelProviders.of(this,viewModelFactory).get(MainViewModel::class.java)


    }

     override fun onSupportNavigateUp(): Boolean {

         val navController = this.findNavController(R.id.mynavmainfrag)
         return  navController.navigateUp()
     }
 }
