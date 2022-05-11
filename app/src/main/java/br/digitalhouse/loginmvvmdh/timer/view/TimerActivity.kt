package br.digitalhouse.loginmvvmdh.timer.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import br.digitalhouse.loginmvvmdh.R
import br.digitalhouse.loginmvvmdh.timer.viewmodel.TimerViewModel

class TimerActivity : AppCompatActivity() {

    lateinit var timerViewModel: TimerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
        timerViewModel = ViewModelProvider(this).get(TimerViewModel::class.java)
        setupListeners()
        setupOberservers()

    }

    fun setupListeners(){
        var btn5S = findViewById<Button>(R.id.timer_1_start_btn)
        btn5S.setOnClickListener {
            timerViewModel.update5s()
        }
        var btn10S = findViewById<Button>(R.id.timer_2_start_btn)
        btn10S.setOnClickListener {
            timerViewModel.update10s()
        }
        var btnReset = findViewById<Button>(R.id.reset_timer_btn)
        btnReset.setOnClickListener {
            timerViewModel.resetTimers()
        }
    }

    fun setupOberservers(){
        timerViewModel.onTimer5sUpdateLiveData.observe(this,{
            var txt5s = findViewById<TextView>(R.id.timer_1_tv)
            var value = it.toString()
            txt5s.text = value
        })

        timerViewModel.onTimer10sUpdateLiveData.observe(this,{
            var txt10s = findViewById<TextView>(R.id.timer_2_tv)
            var value2 = it.toString()
            txt10s.text = value2
        })
    }
}