package zo.den.testtask4.data.database

import android.content.ContentValues
import zo.den.testtask4.data.entity.LinkDataEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LinkDB @Inject constructor() {

    companion object {
        private const val TABLE_NAME = "links"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_LINK = "link"
    }

    @Inject
    lateinit var sqLiteOpenHelper: LinkSQLiteOpenHelper

    fun getLinks(): List<LinkDataEntity> {

        return synchronized(this) {
            sqLiteOpenHelper.writableDatabase.use {
                it.query(TABLE_NAME, null, null, null,
                        null, null, COLUMN_NAME)
                        .use { cursor ->
                            val list = arrayListOf<LinkDataEntity>()
                            while (cursor.moveToNext()) {
                                val linkEntity = LinkDataEntity(cursor.getInt(cursor.getColumnIndex("id")),
                                        cursor.getString(cursor.getColumnIndex(COLUMN_NAME)),
                                        cursor.getString(cursor.getColumnIndex(COLUMN_LINK)))
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
                it.insert(TABLE_NAME, null, ContentValues().apply {
                    put(COLUMN_NAME, linkEntity.name)
                    put(COLUMN_LINK, linkEntity.link)
                })
            }
        }
    }

    fun updateLink(linkEntity: LinkDataEntity) {
        synchronized(this) {
            sqLiteOpenHelper.writableDatabase.use {
                it.update(TABLE_NAME, ContentValues().apply {
                    put(COLUMN_NAME, linkEntity.name)
                    put(COLUMN_LINK, linkEntity.link)
                }, "id=?", arrayOf(linkEntity.id.toString()))
            }
        }
    }

    fun deleteLink(linkEntity: LinkDataEntity) {
        synchronized(this) {
            sqLiteOpenHelper.writableDatabase.use {
                it.delete(TABLE_NAME, "id=?", arrayOf(linkEntity.id.toString()))
            }
        }
    }


}

