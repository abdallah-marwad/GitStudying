package com.example.gitstudying

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class ViewModelTest : ViewModel() {
    val _mutableLivedata = MutableLiveData<Int>()
    val mutableLivedata :  LiveData<Int> = _mutableLivedata
    private val _mutableStateFlow = MutableStateFlow(0)
    val mutableStateFlow: Flow<Int> = _mutableStateFlow

    val _channel = Channel<Boolean> { }
    val channel = _channel.receiveAsFlow()

    fun makeLoop() {
        viewModelScope.launch {
            for (i in 1..20) {
                delay(1000)
                _mutableLivedata.postValue(i)
            }
        }
    }
    fun makeLoopFlow() {
        viewModelScope.launch {
            for (i in 1..20) {
                delay(1000)
                _mutableStateFlow.emit(i)
            }
        }
    }

}