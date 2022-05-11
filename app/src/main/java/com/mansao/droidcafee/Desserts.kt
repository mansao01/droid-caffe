package com.mansao.droidcafee

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Desserts(
    var image: Int = 0,
    var name: String = "",
    var description: String = ""
) : Parcelable
