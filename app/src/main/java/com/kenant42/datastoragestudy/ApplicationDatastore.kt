package com.kenant42.datastoragestudy

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

class ApplicationDatastore(val context: Context) {

    val Context.ref: DataStore<Preferences> by preferencesDataStore("infos")

    companion object {
        val KEY_NAME = stringPreferencesKey("name")
        val KEY_SURNAME = stringPreferencesKey("surname")
        val KEY_HEIGHT = doublePreferencesKey("height")
        val KEY_WEIGHT = intPreferencesKey("weight")
        val KEY_AGE = intPreferencesKey("age")
        val KEY_ISMARRIED = booleanPreferencesKey("ismarried")
        val KEY_FRIENDSLIST = stringSetPreferencesKey("friendslist")
    }

    suspend fun saveName(name: String) {
        context.ref.edit {
            it[KEY_NAME] = name
        }
    }

    suspend fun getName():String{
        val data = context.ref.data.first()
        return data[KEY_NAME]?:"NA"
    }

    suspend fun deleteName(){
        context.ref.edit {
            it.remove(KEY_NAME)
        }
    }

    suspend fun saveSurname(surname:String){
        context.ref.edit {
            it[KEY_SURNAME] = surname
        }
    }

    suspend fun getSurname():String{
        val data= context.ref.data.first()
        return data[KEY_SURNAME]?:"NA"
    }

    suspend fun deleteSurname(){
        context.ref.edit {
            it.remove(KEY_SURNAME)
        }
    }


    suspend fun saveHeight(height:Double){
        context.ref.edit {
            it[KEY_HEIGHT] = height
        }
    }

    suspend fun getHeight():Double{
        val data = context.ref.data.first()
        return data[KEY_HEIGHT]?:0.0
    }

    suspend fun deleteHeight(){
        context.ref.edit {
            it.remove(KEY_HEIGHT)
        }
    }


    suspend fun saveWeight(weight:Int){
        context.ref.edit {
            it[KEY_WEIGHT] = weight
        }
    }

    suspend fun getWeight():Int{
        val data = context.ref.data.first()
        return data[KEY_WEIGHT]?:0
    }

    suspend fun deleteWeight(){
        context.ref.edit {
            it.remove(KEY_WEIGHT)
        }
    }

    suspend fun saveAge(age:Int){
        context.ref.edit {
            it[KEY_AGE] =age
        }
    }

    suspend fun getAge():Int{
        val data = context.ref.data.first()
        return data[KEY_AGE]?:0
    }

    suspend fun deleteAge(){
        context.ref.edit {
            it.remove(KEY_AGE)
        }
    }

    suspend fun saveMarriageStatus(isMarried:Boolean){
        context.ref.edit {
            it[KEY_ISMARRIED] = isMarried
        }
    }

    suspend fun getMarriageStatus():Boolean{
        val data = context.ref.data.first()
        return data[KEY_ISMARRIED]?:false
    }

    suspend fun deleteMarriageStatus(){
        context.ref.edit {
            it.remove(KEY_ISMARRIED)
        }
    }

    suspend fun saveFriendsList(friendsList:Set<String>){
        context.ref.edit {
            it[KEY_FRIENDSLIST] = friendsList
        }
    }

    suspend fun getFriendsList():Set<String>?{
       val data =  context.ref.data.first()
        return data[KEY_FRIENDSLIST]
    }

    suspend fun deleteFriendsList(){
        context.ref.edit {
            it.remove(KEY_FRIENDSLIST)
        }
    }
}