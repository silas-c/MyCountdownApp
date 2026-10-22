package com.example.mycountdownapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CVM : ViewModel() {
    val counterStart = 100
    var counter by mutableIntStateOf(0)
}
