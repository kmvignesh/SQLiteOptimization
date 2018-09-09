package com.example.vicky.sqliteoptimization

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

const val DATABASE_NAME ="MyDB"
const val TABLE_NAME="CountryCode"
const val COL_NAME = "name"
const val COL_CODE = "code"
const val COL_ID = "rowId"

class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context,DATABASE_NAME,null,1){
    override fun onCreate(db: SQLiteDatabase?) {

        val createTable = "CREATE TABLE " + TABLE_NAME +" (" +
                COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NAME + " VARCHAR(256) UNIQUE," +
                COL_CODE +" VARCHAR(16))"
        Log.d("DataBaseHandler" , " Create : $createTable")
        db?.execSQL(createTable)

    }

    override fun onUpgrade(db: SQLiteDatabase?,oldVersion: Int,newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun getCount() : Int{
        var result = 0
        val db = this.readableDatabase
        val queryResult = db.rawQuery("SELECT $COL_ID from $TABLE_NAME" , null)
        result = queryResult.count
        db.close()
        return result
    }

    fun update(country : CountryDTO){
        val db = this.writableDatabase
        val query = "Select $COL_ID from $TABLE_NAME where $COL_NAME = '${country.country}'"
        val result = db.rawQuery(query,null)

        val cv = ContentValues()
        cv.put(COL_NAME , country.country)
        cv.put(COL_CODE , country.calling_code)
        if(result.count == 0){
            //Insert country
            db.insert(TABLE_NAME,null,cv)
        }else{
            //Update country
            db.update(TABLE_NAME,cv,"$COL_NAME=?", arrayOf(country.country))
        }
        db.close()
    }

    fun insertOrUpdate(country: CountryDTO){
        val db = this.writableDatabase
        val query = " INSERT OR REPLACE INTO $TABLE_NAME ($COL_NAME,$COL_CODE) VALUES ('${country.country}','${country.calling_code}')"
//        db.rawQuery() // Need to use only for reading data
        db.execSQL(query)
        db.close()
    }

    fun InsertOrUpdateTransaction(countries : MutableList<CountryDTO>){

        val db = this.writableDatabase
        db.beginTransaction()
        countries.forEach {
            val query = " INSERT OR REPLACE INTO $TABLE_NAME ($COL_NAME,$COL_CODE) VALUES ('${it.country}','${it.calling_code}')"
            Log.d("DataBaseHandler" , "$query")
            db.execSQL(query)
        }
        db.setTransactionSuccessful()
        db.endTransaction()
        db.close()
    }

}














