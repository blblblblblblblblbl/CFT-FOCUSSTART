package blblblbl.cftfocus.search.data.model

import com.google.gson.annotations.SerializedName


data class Number(

    @SerializedName("length") var length: Int? = null,
    @SerializedName("luhn") var luhn: Boolean? = null

)