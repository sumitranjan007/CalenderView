package com.athentech.srcalender

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.athentech.srcalender.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
         calenderView.updateDuration(20)
         calenderView.updateCalander()

         calenderView.setEventHandler(object:EventHandler{
             override fun longPressed(date: Date) {

             }

             override fun clicked(date: Date) {

             }

             override fun dayViewClicked() {

             }

         })
        }
    }
}