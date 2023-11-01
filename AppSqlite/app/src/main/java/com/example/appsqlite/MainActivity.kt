package com.example.appsqlite

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appsqlite.sampledata.DBHandler
import com.example.appsqlite.ui.theme.AppSqliteTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Preview
@Composable
fun AppPreview(){
    App()
}

@Composable
fun App(){
    AppSqliteTheme {
        // A surface container using the 'background' color from the theme
        //Adicionando as Variáveis para o Projeto

        Surface(
            modifier = Modifier.fillMaxSize(),

            ) {
            SimpleCenterAlignedTopAppBar()
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SimpleCenterAlignedTopAppBar() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xB4, 0x1, 0x4B, 0xFF)
                ),
                title = {
                    Text(
                        " Cadastro",
                        style = TextStyle(
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(1, 0, 0, 255),
                            fontSize = 30.sp
                        ),


                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Filled.AccountBox,
                            contentDescription = "Localized description"

                        )
                    }
                },

                )

        }


        ,content = { ProjetoConfig() }

    )
}


@Composable
fun ProjetoConfig (){
    Column(
        Modifier
            .background(color = Color(0, 0, 0, 255))
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally){

        Row{
            Banner()
        }
        Row{
            Formulario()
        }

    }



}


@Composable
fun Formulario(){
    val context = LocalContext.current
    val dbHandler = DBHandler(context)

    val activity = context as Activity

    val courseName = remember {
        mutableStateOf(TextFieldValue())
    }
    val courseEndereco = remember {
        mutableStateOf(TextFieldValue())
    }
    val coursebairro = remember {
        mutableStateOf(TextFieldValue())
    }
    val coursecep = remember {
        mutableStateOf(TextFieldValue())
    }
    val coursecidade = remember {
        mutableStateOf(TextFieldValue())
    }
    val courseestado = remember {
        mutableStateOf(TextFieldValue())
    }
    val coursetel = remember {
        mutableStateOf(TextFieldValue())
    }

    val coursecelular = remember {
        mutableStateOf(TextFieldValue())
    }


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        item{


            SimpleTextFieldSample("Nome:", courseName.value) {
                courseName.value = it
            }
            Spacer(modifier = Modifier.height(10.dp))
            SimpleTextFieldSample("Endereço:", courseEndereco.value) {
                courseEndereco.value = it
            }

            Spacer(modifier = Modifier.height(10.dp))
            SimpleTextFieldSample("Bairro:", coursebairro.value) {
                coursebairro.value = it
            }

            Spacer(modifier = Modifier.height(10.dp))
            SimpleTextFieldSample("Cep:", coursecep.value) {
                coursecep.value = it
            }

            Spacer(modifier = Modifier.height(10.dp))
            SimpleTextFieldSample("Cidade:", coursecidade.value) {
                coursecidade.value = it
            }

            Spacer(modifier = Modifier.height(10.dp))
            SimpleTextFieldSample("Estado:", courseestado.value) {
                courseestado.value = it
            }

            Spacer(modifier = Modifier.height(10.dp))
            SimpleTextFieldSample("Telefone:", coursetel.value) {
                coursetel.value = it
            }

            Spacer(modifier = Modifier.height(10.dp))
            SimpleTextFieldSample("Celular:", coursecelular.value) {
                coursecelular.value = it
            }


            Spacer(modifier = Modifier.height(10.dp))
            ButtonSample(
                dbHandler,
                courseName.value,
                courseEndereco.value,
                coursebairro.value,
                coursecep.value,
                coursecidade.value,
                courseestado.value,
                coursetel.value,
                coursecelular.value,
                context
            )
        }

    }

}

@Composable
fun ButtonSample(
    dbHandler: DBHandler,
    courseName:TextFieldValue,
    courseEndereco:TextFieldValue,
    coursebairro:TextFieldValue,
    coursecep: TextFieldValue,
    coursecidade: TextFieldValue,
    courseestado: TextFieldValue,
    coursetel: TextFieldValue,
    coursecelular: TextFieldValue,
    context: Context
) {
    Button(onClick = {  dbHandler.addEndereco(
        courseName.text,
        courseEndereco.text,
        coursebairro.text,
        coursecep.text,
        coursecidade.text,
        courseestado.text,
        coursetel.text,
        coursecelular.text,
    )
        Toast.makeText(context, "Cadastro realizado", Toast.LENGTH_SHORT).show()
    },colors = ButtonDefaults.filledTonalButtonColors(
        Color(182, 7, 82, 255),
    ),
        modifier = Modifier

            .padding(horizontal = 5.dp, vertical = 8.dp)
    ) { Text("Cadastrar") }


}

@Composable
fun Banner(){
    AppSqliteTheme() {
        val title = "Cadastro"

        Card( modifier = Modifier
            .height(200.dp)



        ) {

            Box(modifier = Modifier.height(200.dp)

            ){
                Image(painter = painterResource(id = R.drawable.spiderman),
                    contentDescription = "Banner",
                    //Mexe com todo container ao redor da imagem
                    modifier = Modifier
                        .fillMaxWidth(),
                    //ContentScale Mexe com as propriedades da Imagem
                    contentScale = ContentScale.FillWidth,
                )

                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 350f
                        )

                    )
                ){


                }

                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                    contentAlignment = Alignment.BottomCenter
                ){
                    Text(text = title, style = TextStyle(color= Color.White, fontSize = 36.sp
                    ))

                }

            }





        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTextFieldSample(campo: String, value:TextFieldValue, onValueChange:(TextFieldValue)-> Unit){
    var text by rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        TextField(
            value = value,
            onValueChange = {
                onValueChange(it)
            },
            label = {
                Text(campo)
            },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(52, 64, 107, 255),
                textColor = Color(254, 254, 254, 255),
                cursorColor = Color(254, 254, 254, 255),

                selectionColors = TextSelectionColors(
                    handleColor = Color(254, 254, 254, 255),
                    backgroundColor = Color(254, 254, 254, 255)),

                placeholderColor = Color(254, 254, 254, 255),
                focusedIndicatorColor = Color(170, 3, 75, 255),
                unfocusedIndicatorColor = Color(170, 3, 75, 255),

                focusedLabelColor = Color(254, 254, 254, 255),
                unfocusedLabelColor = Color(254, 254, 254, 255)
            )



        )
    }}