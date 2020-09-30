package uclass.mainbo.com.uclass_experiment.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ExcelBean(
    val a: String,
    val b: String,
    val c: String,
    val d: String,
    val e: String
) : Parcelable