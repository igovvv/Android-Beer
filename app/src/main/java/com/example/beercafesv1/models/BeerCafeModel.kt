package com.example.beercafesv1.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class BeerCafeItem(
        val Name: String = "Name",
        val city_name: String = "City",
        val B_Contact_email: String,
        val B_Contact_name: String,
        val B_Contact_phone: String,
        val Booking_groups_en: String,
        val Booking_groups_nl: String,


        val Email: String,
        val Group_access_en: String,
        val Group_access_nl: String,


        val Opening_times_en: String,
        val Opening_times_nl: String,
        val Province: String,

        val Street: String,
        val Website: String,
        val box_number: String,
        val copyrights: String,
        val description_en: String,
        val description_nl: String,
        val fax: String,
        val imagesURL: String,
        val mobile: String,
        val phone: String,

        val videoURL: String

):Parcelable

