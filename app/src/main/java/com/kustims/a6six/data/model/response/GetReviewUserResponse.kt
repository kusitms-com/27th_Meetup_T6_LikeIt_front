package com.kustims.a6six.data.model.response

import android.provider.ContactsContract.RawContacts.Data
import com.google.gson.annotations.SerializedName

import com.kustims.a6six.domain.model.Review
import kotlinx.serialization.json.JsonNull.content

data class GetReviewUserResponse(
    val data: Data,
    val message: String
) {
    data class Data(
        @SerializedName("id")
        val id: Int = 0,
        @SerializedName("img")
        val img: String = "",
        @SerializedName("name")
        val name: String = "",
    )
}
