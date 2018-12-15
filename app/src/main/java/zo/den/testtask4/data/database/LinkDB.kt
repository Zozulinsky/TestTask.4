package zo.den.testtask4.data.database

import android.content.ContentValues
import zo.den.testtask4.data.entity.LinkDataEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LinkDB @Inject constructor() {

    @Inject
    lateinit var sqLiteOpenHelper: LinkSQLiteOpenHelper

    fun getLinks(): List<LinkDataEntity> {

        return synchronized(this) {
            sqLiteOpenHelper.writableDatabase.use {
                it.query("links", null, null, null,
                        null, null, "name")
                        .use { cursor ->
                            val list = arrayListOf<LinkDataEntity>()
                            while (cursor.moveToNext()) {
                                val linkEntity = LinkDataEntity(cursor.getInt(cursor.getColumnIndex("id")),
                                        cursor.getString(cursor.getColumnIndex("name")),
                                        cursor.getString(cursor.getColumnIndex("link")))
                                list.add(linkEntity)
                            }
                            list
                        }
            }
        }

    }


    fun insertLink(linkEntity: LinkDataEntity) {
        synchronized(this) {
            sqLiteOpenHelper.writableDatabase.use {
                it.insert("links", null, ContentValues().apply {
                    put("name", linkEntity.name)
                    put("link", linkEntity.link)
                })
            }
        }
    }

    fun updateLink(linkEntity: LinkDataEntity) {
        synchronized(this) {
            sqLiteOpenHelper.writableDatabase.use {
                it.update("links", ContentValues().apply {
                    put("name", linkEntity.name)
                    put("link", linkEntity.link)
                }, "id=?", arrayOf(linkEntity.id.toString()))
            }
        }
    }

    fun deleteLink(linkEntity: LinkDataEntity) {
        synchronized(this) {
            sqLiteOpenHelper.writableDatabase.use {
                it.delete("links", "id=?", arrayOf(linkEntity.id.toString()))
            }
        }
    }


}

