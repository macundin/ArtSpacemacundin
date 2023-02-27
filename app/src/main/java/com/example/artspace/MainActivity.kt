package com.example.artspace

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ){
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    var idImagen by remember { mutableStateOf(1) }
    var imagen = R.drawable._00px_gioconda__copia_del_museo_del_prado_restaurada_
    var titulo = "La Gioconda"
    var artista = "Leonardo Da Vinci"
    var anio = "1503"

    when(idImagen){
        1-> {
            imagen = R.drawable._00px_gioconda__copia_del_museo_del_prado_restaurada_
            titulo = "La Gioconda"
            artista = "Leonardo Da Vinci"
            anio = "1503"
        }
        2-> {
            imagen = R.drawable.vincent_van_gogh_starry_night
            titulo = "La noche estrellada"
            artista = "Vincent Willem van Gogh"
            anio = "1889"
        }
        3-> {
            imagen = R.drawable._630997276806
            titulo = "Las meninas"
            artista = "Diego Velázquez"
            anio = "1656"
        }
        4-> {
            imagen = R.drawable.descripcion_de_el_beso_de_gustav_klimt_4570_0_600
            titulo = "El beso"
            artista = "Gustav Klimt"
            anio = "1907"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .padding(18.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Surface (
            modifier = Modifier
                .fillMaxWidth()
                .weight(3F)
                .wrapContentSize(align = Alignment.Center),
            elevation = 15.dp,
            border = BorderStroke(1.dp,color = Color.Black)
        ){
            Image(
                modifier = Modifier.padding(30.dp),
                painter = painterResource(id = imagen),
                contentDescription = null
            )
        }
        Column(
            modifier = Modifier.weight(2F)
        ){
            Surface(elevation = 15.dp){
                SpaceArtwork(titulo = titulo, artista = artista, anio = anio, modifier = Modifier.fillMaxWidth())
            }
            Spacer (modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.CenterHorizontally)
            ){

                Button(modifier = Modifier.padding(8.dp).weight(2F), onClick = { if(idImagen == 1) idImagen =5 else idImagen-- })
                {
                    Text(text = "Anterior")
                }
                Button(modifier = Modifier.padding(8.dp).weight(2F), onClick = { if(idImagen == 5) idImagen =1 else idImagen++ })
                {
                    Text(text = "Siguiente")
                }


            }
        }
    }
}

@Composable
fun SpaceArtwork(titulo: String, artista: String, anio: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(18.dp),
    ) {
        Text(text = titulo, fontWeight = FontWeight.Light, fontSize = 22.sp,)
        Row {
            Text(text = artista, fontWeight = FontWeight.Bold)
            Text(text = " (", fontWeight = FontWeight.Light)
            Text(text = anio, fontWeight = FontWeight.Light)
            Text(text = ")", fontWeight = FontWeight.Light)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme() {
        ArtSpaceApp()
    }
}