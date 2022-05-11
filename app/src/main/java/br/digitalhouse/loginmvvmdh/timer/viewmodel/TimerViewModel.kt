package br.digitalhouse.loginmvvmdh.timer.viewmodel

import androidx.lifecycle.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TimerViewModel : ViewModel() {
    var timer1 = 0.0
    var timer2 = 0.0

    private val onTimer5sUpdate = MutableLiveData<Double>()
    val onTimer5sUpdateLiveData : LiveData<Double> = onTimer5sUpdate
    private val onTimer10sUpdate = MutableLiveData<Double>()
    val onTimer10sUpdateLiveData : LiveData<Double> = onTimer10sUpdate

    fun update5s(){
        viewModelScope.launch {
            delay(5000)
            timer1 += 5.0
            onTimer5sUpdate.value = timer1
        }
    }

    fun update10s(){
        viewModelScope.launch {
            delay(10000)
            timer2 += 10.0
            onTimer10sUpdate.value = timer2
        }
    }

    fun resetTimers(){
        timer1 = 0.0
        timer2 = 0.0
        onTimer5sUpdate.value = timer1
        onTimer10sUpdate.value = timer2
    }
}