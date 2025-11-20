package com.example.myarsitektur.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.example.myarsitektur.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormSiswa(
    pilihanJK: List<String>,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier
){
    var txtNama by rememberSaveable { mutableStateOf("") }
    var txtAlamat by remember { mutableStateOf("") }
    var txtGender by remember { mutableStateOf("") }
    val listData: MutableList<String> = mutableListOf(txtNama, txtGender, txtAlamat)

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        color = colorResource(id = R.color.white)
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    colorResource(id = R.color.purple_500))
                    scrolledContainerColor = Color.Unspecified,
                    navigationIconContentColor = Color.Unspecified,
                    titleContentColor = Color.Unspecified,
                    actionIconContentColor = Color.Unspecified
                )
            )
        }
    ) { paddingValues -> // Menggunakan paddingValues untuk menghindari overlap
        val onNamaChange = null
        val onGenderSelected = null
        val onAlamatChange = null
        isiRuang(
            paddingValues,
            txtNama,
            onNamaChange,
            txtGender,
            onGenderSelected,
            pilihanJK,
            txtAlamat,
            onAlamatChange,
            isSubmitEnabled,
            onSubmitButtonClicked
        )
    }
}

@Composable
fun isiRuang(
    paddingValues: PaddingValues, // Menerima padding dari Scaffold
    txtNama: String,
    onNamaChange: (String) -> Unit,
    txtGender: String,
    onGenderSelected: (String) -> Unit,
    pilihanJK: List<String>,
    txtAlamat: String,
    onAlamatChange: (String) -> Unit,
    isSubmitEnabled: Boolean,
    onSubmitButtonClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(paddingValues) // Menerapkan padding dari Scaffold
            .padding(
                vertical = dimensionResource(id = R.dimen.isiRuang) // Asumsi R.dimen.isiRuang adalah padding vertical
            )
            .fillMaxSize(), // Menggunakan fillMaxSize agar konten mengisi ruang
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // --- 1. Field Nama ---
        OutlinedTextField(
            value = txtNama,
            onValueChange = onNamaChange,
            singleLine = true,
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.width(250.dp).padding(top = 20.dp), // Menggunakan 250.dp dan padding top 20.dp dari gambar
            label = { Text(text = "Nama lengkap") }
        )

        HorizontalDivider(
            modifier = Modifier
                .padding(all = 12.dp)
                .width(250.dp), // Menggunakan 250.dp dari gambar
            thickness = dimensionResource(id = R.dimen.thicknessResource), // Asumsi ada R.dimen.thicknessResource
            color = androidx.compose.ui.graphics.Color.Blue // Menggunakan Color.Blue dari gambar
        )

        // --- 2. Pilihan Jenis Kelamin ---
        Row(
            modifier = Modifier.width(250.dp).padding(top = 5.dp), // Memberi sedikit padding atas dan lebar
            horizontalArrangement = Arrangement.Start
        ) {
            pilihanJK.forEach { item ->
                Row(
                    modifier = Modifier
                        .selectable(
                            selected = (txtGender == item),
                            onClick = { onGenderSelected(item) }
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (txtGender == item),
                        onClick = { onGenderSelected(item) }
                    )
                    Text(text = item)
                }
            }
        }

        HorizontalDivider(
            modifier = Modifier
                .padding(all = 5.dp) // Padding 5.dp dari gambar
                .width(250.dp),
            thickness = dimensionResource(id = R.dimen.thicknessResource), // Asumsi ada R.dimen.thicknessResource
            color = androidx.compose.ui.graphics.Color.Blue
        )

        // --- 3. Field Alamat ---
        OutlinedTextField(
            value = txtAlamat,
            onValueChange = onAlamatChange,
            singleLine = true,
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.width(250.dp), // Menggunakan 250.dp dari gambar
            label = { Text(text = "Alamat lengkap") }
        )

        // --- 4. Tombol Submit ---
        Spacer(Modifier.height(20.dp))

        Button(
            modifier = Modifier.fillMaxWidth(fraction = 1f).padding(horizontal = 20.dp), // Menggunakan fillMaxWidth(1f) dari gambar, tambahkan padding horizontal agar tidak terlalu lebar
            enabled = isSubmitEnabled, // Menggunakan isSubmitEnabled dari gambar (asumsi itu setara dengan txtAlamat.isNotEmpty())
            onClick = onSubmitButtonClicked
        ) {
            Text(text = stringResource(id = R.string.Submit))
        }
    }
}