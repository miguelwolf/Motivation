package br.com.miguelwolf.motivation.infra

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(val context: Context) {

    private val mSharedPreferences = context.getSharedPreferences("motivation_app", Context.MODE_PRIVATE)

    companion object {
        val NAME: String = "NAME"
    }

    fun storeString(key: String, value: String) {
        mSharedPreferences.edit().putString(key, value).apply()
    }


    fun getString(key: String) {



    }

}