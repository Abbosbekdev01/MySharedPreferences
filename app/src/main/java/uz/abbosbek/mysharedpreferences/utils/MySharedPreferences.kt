package uz.abbosbek.mysharedpreferences.utils

import android.content.Context
import android.content.SharedPreferences

object MySharedPreferences {
    private const val NAME = "catch_list"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    fun init(context: Context){
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation:(SharedPreferences.Editor) -> Unit){
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var myName:String?
        /** get-> catch dan ma'lumotni o'qib oladi va qaytarib beradi */
    get() = preferences.getString("keyName", "")

        /** set -> catch ga ma'lumotni qo'shib yozib qo'yadi */
    set(value) = preferences.edit {
        if (value != null){
            it.putString("keyName", value)
        }
    }
}