package com.example.atlasapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Country(
  @StringRes val name: Int,
  @DrawableRes val flag: Int,
  val latitude: Double,
  val longitude: Double
)