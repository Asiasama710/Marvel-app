package com.example.marvelapp.utilities

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

object Constants {
    const val BASE_URL ="https://gateway.marvel.com:443"
    const val API_KEY="02632b3839af05e273dcabaaa31766a3"
    const val HASH = "395e6844f7c84fd6ed49f947684b4fc1"
    const val limit = 20
    const val timestamp= "1"

//    fun hash():String{
//        return ("$timestamp$PRIVATE_KEY$PUBLIC_KEY").toMD5()
//        //val md5= MessageDigest.getInstance("MD5")
//        //return BigInteger(1,md5.digest(input.toByteArray())).toString(16).padStart(32,'0')
//    }
    const val DATA_IS_NULL_ERROR_MESSAGE = "Something went wrong while trying to retrieve data!"

}




















