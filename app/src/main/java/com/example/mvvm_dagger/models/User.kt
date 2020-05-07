package com.example.mvvm_dagger.models

import com.example.mvvm_dagger.networkadapter.apiconstants.ApiConstants
import com.google.gson.annotations.SerializedName

/**
 *  {
"id": 1,
"name": "Leanne Graham",
"username": "Bret",
"email": "Sincere@april.biz",
"address": {
"street": "Kulas Light",
"suite": "Apt. 556",
"city": "Gwenborough",
"zipcode": "92998-3874",
"geo": {
"lat": "-37.3159",
"lng": "81.1496"
}
},
"phone": "1-770-736-8031 x56442",
"website": "hildegard.org",
"company": {
"name": "Romaguera-Crona",
"catchPhrase": "Multi-layered client-server neural-net",
"bs": "harness real-time e-markets"
}
}
 */
data class User(

    private val id: String? = "",
    private val name: String? = "",

    @SerializedName(ApiConstants.UserName)
    private val userName: String? = "",

    @SerializedName(ApiConstants.EmailId)
    private val emailId: String? = "",

    @SerializedName(ApiConstants.PhoneNumber)
    private val phoneNumber: String? = "",

    @SerializedName(ApiConstants.WebSite)
    private val webSite: String? = "",

    @SerializedName(ApiConstants.Address)
    private val address: Address? = null
)

data class Address(
    private val street: String? = "",
    private val suite: String? = "",
    private val city: String? = "",

    @SerializedName(ApiConstants.ZipCode)
    private val zipCode: String? = ""
)