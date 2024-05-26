package com.example.accuratehome

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

//{
//    "LotArea",
//    "YearBuilt",
//    "1stFlrSF",
//    "2ndFlrSF",
//    "FullBath",
//    "BedroomAbvGr"
//    "TotRmsAbvGrd"
//}

@Composable
fun HomeScreen(navController: NavHostController) {
    val apiViewModel = remember { ApiViewModel() }


    var LotArea by rememberSaveable { mutableStateOf("0") }
    var YearBuilt by rememberSaveable { mutableStateOf("0") }
    var FstFlrSF by rememberSaveable { mutableStateOf("0") }
    var SstFlrSF by rememberSaveable { mutableStateOf("0") }
    var FullBath by rememberSaveable { mutableStateOf("0") }
    var BedroomAbvGr by rememberSaveable { mutableStateOf("0") }
    var TotRmsAbvGrd by rememberSaveable { mutableStateOf("0") }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(16.dp, 16.dp)
            .verticalScroll(state = scrollState),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(id = R.string.fill_form),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.displaySmall
        )

        //LotArea
        TextxTextField(
            modifier = Modifier.fillMaxWidth(),
            formName = R.string.lot_area,
            value = LotArea,
            onValueChange = { LotArea = it },
            text = "LotArea"
        )

        //YearBuilt
        TextxTextField(
            modifier = Modifier.fillMaxWidth(),
            formName = R.string.year_built,
            value = YearBuilt,
            onValueChange = { YearBuilt = it },
            text = "YearBuilt"
        )

        //1stFlrSF
        TextxTextField(
            modifier = Modifier.fillMaxWidth(),
            formName = R.string.F_stFlrSF,
            value = FstFlrSF,
            onValueChange = { FstFlrSF = it },
            text = "YearBuilt"
        )

        //2ndFlrSF
        TextxTextField(
            modifier = Modifier.fillMaxWidth(),
            formName = R.string.S_stFlrSF,
            value = SstFlrSF,
            onValueChange = { SstFlrSF = it },
            text = "YearBuilt"
        )

        //FullBath
        TextxTextField(
            modifier = Modifier.fillMaxWidth(),
            formName = R.string.Full_Bath,
            value = FullBath,
            onValueChange = { FullBath = it },
            text = "Full Bath"
        )

        //BedroomAbvGr
        TextxTextField(
            modifier = Modifier.fillMaxWidth(),
            formName = R.string.Bedrooms,
            value = BedroomAbvGr,
            onValueChange = { BedroomAbvGr = it },
            text = "BedroomAbvGr"
        )

        //TotRmsAbvGrd
        TextxTextField(
            modifier = Modifier.fillMaxWidth(),
            formName = R.string.Total_Rooms,
            value = TotRmsAbvGrd,
            onValueChange = { TotRmsAbvGrd = it },
            text = "BedroomAbvGr"
        )
        val context = LocalContext.current
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .align(Alignment.CenterHorizontally),
            onClick = {
//                validateData(
//                    LotArea = LotArea.toInt(),
//                    YearBuilt = YearBuilt.toInt(),
//                    FstFlrSF = FstFlrSF.toInt(),
//                    SstFlrSF = SstFlrSF.toInt(),
//                    FullBath = FullBath.toInt(),
//                    BedroomAbvGr = BedroomAbvGr.toInt(),
//                    TotRmsAbvGrd = TotRmsAbvGrd.toInt(),
//                    onInvalidate = {
//                        Toast.makeText(
//                            context,
//                            context.getString(R.string.value_is_empty, context.getString(it)),
//                            Toast.LENGTH_LONG
//                        ).show()
//                    },
//                    onValidate = {
//                        Toast.makeText(
//                            context,
//                            context.getString(R.string.success),
//                            Toast.LENGTH_LONG
//                        ).show()
//                    }
//                )
                apiViewModel.sendApiRequest(LotArea.toInt(),
                    YearBuilt.toInt(),
                    FstFlrSF.toInt(),
                    SstFlrSF.toInt(),
                    FullBath.toInt(),
                    BedroomAbvGr.toInt(),
                    TotRmsAbvGrd.toInt())
                Toast.makeText(
                    context,
                    LotArea,
                    Toast.LENGTH_LONG
                ).show()
            }
        ){
            Text(
                text = stringResource(id = R.string.save),
                style = MaterialTheme.typography.bodyLarge
            )
        }

    }
}

@Composable
fun TextxTextField(modifier: Modifier, formName:Int, value: String, onValueChange: (String) -> Unit, text:String) {
    Text(
        text = stringResource(id = formName),
        style = MaterialTheme.typography.bodyLarge
    )

    TextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = text)},


    )
}

private fun validateData(
    LotArea: Int,
    YearBuilt: Int,
    FstFlrSF: Int,
    SstFlrSF: Int,
    FullBath: Int,
    BedroomAbvGr: Int,
    TotRmsAbvGrd: Int,
    onInvalidate: (Int)->Unit,
    onValidate: ()->Unit
){

}


