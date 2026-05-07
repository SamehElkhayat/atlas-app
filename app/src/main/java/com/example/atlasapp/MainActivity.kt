package com.example.atlasapp

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import com.example.atlasapp.data.DataSource
import com.example.atlasapp.model.Country
import com.example.atlasapp.ui.theme.AtlasAppTheme
import com.example.atlasapp.ui.theme.SmokedSteel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AtlasAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CountiesList(Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Preview
@Composable
private fun CountiesListPreview(){
    CountiesList()
}
@Composable
private fun CountiesList(modifier: Modifier = Modifier){
    val countries = DataSource().getCountriesData()
    val configuration = LocalConfiguration.current
    if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
        LazyColumn(
            modifier = Modifier
                .paint(
                    painter = painterResource(R.drawable.background),
                    contentScale = ContentScale.Crop

                )
                .padding(horizontal = 16.dp, 16.dp)

        ) {
            items(countries) {
                CountryListItem(it)
            }
        }
    }
    else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(horizontal = 16.dp, 16.dp)
        ){
            items(countries) {
                CountryListItem(it)
            }
        }

    }
}
@Composable
private fun CountryListItem(country: Country, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
            .clickable{
                val i = Intent(
                    Intent.ACTION_VIEW,
                    "geo:${country.latitude},${country.longitude}?z=5".toUri()
                )
                context.startActivity(i)
            }
   ){
        Image(
            painter = painterResource(R.drawable.card),
            contentDescription = null
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painter = painterResource(country.flag),
                contentDescription = stringResource(country.name),
                modifier = Modifier
                    .size(140.dp,90.dp)
            )
            Text(
                text = stringResource(country.name),
                fontFamily = FontFamily(Font(R.font.handodle)),
                fontSize = 48.sp,
                color = SmokedSteel

            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun CountryListItemPreview() {
    AtlasAppTheme {
        CountryListItem(DataSource().getCountriesData()[0])
    }
}