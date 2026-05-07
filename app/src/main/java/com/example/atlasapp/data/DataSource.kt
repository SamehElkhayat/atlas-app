package com.example.atlasapp.data


import com.example.atlasapp.R
import com.example.atlasapp.model.Country

class DataSource {
    fun getCountriesData() = listOf(
        Country(R.string.canada, R.drawable.canada, 48.8423216, -135.4991366),
        Country(R.string.egypt, R.drawable.egypt, 26.8074358, 25.5841531),
        Country(R.string.morocco, R.drawable.morocco, 31.6914008, -12.4416121),
        Country(R.string.switzerland, R.drawable.switzerland, 46.8056098, 6.9050506),
        Country(R.string.canada, R.drawable.canada, 48.8423216, -135.4991366),
        Country(R.string.egypt, R.drawable.egypt, 26.8074358, 25.5841531),
        Country(R.string.morocco, R.drawable.morocco, 31.6914008, -12.4416121),
        Country(R.string.switzerland, R.drawable.switzerland, 46.8056098, 6.9050506)

    )
}