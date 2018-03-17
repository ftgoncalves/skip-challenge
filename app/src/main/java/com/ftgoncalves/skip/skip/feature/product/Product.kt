package com.ftgoncalves.skip.skip.feature.product

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    val id: Int,
    val storeId: Int,
    val name: String,
    val description: String,
    val price: Double
) : Parcelable
