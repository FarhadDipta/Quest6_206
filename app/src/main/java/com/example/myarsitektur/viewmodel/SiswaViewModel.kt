package com.example.myarsitektur.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myarsitektur.model.Siswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SiswaViewModel : ViewModel() {
    private val _StatusUI = MutableStateFlow(value=Siswa())
    val statusUI: StateFlow<Siswa> = _StatusUI.asStateFlow()

    fun setSiswa(ls:MutableList<String>){
        _StatusUI.update { statusSaatIni ->
            statusSaatIni.copy(nama=ls[0],gender=ls[1],alamat=ls[2])
        }
    }
}