package com.example.myarsitektur.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.padding
import com.example.myarsitektur.model.DataJK.jenisK
import com.example.myarsitektur.view.FormSiswa
import com.example.myarsitektur.view.TampilSiswa
import com.example.myarsitektur.viewmodel.SiswaViewModel

enum class Navigasi {
    Formulir,
    Detail
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiswaApp(
    modifier: Modifier,
    viewModel: SiswaViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){