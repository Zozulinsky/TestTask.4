package zo.den.testtask4.data.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LinkSQLiteOpenHelper @Inject constructor(context: Context)
    : SQLiteOpenHelper(context, "links.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE links(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "name TEXT, link TEXT)")
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }


}