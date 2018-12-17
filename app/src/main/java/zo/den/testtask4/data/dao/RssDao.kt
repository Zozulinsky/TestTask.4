package zo.den.testtask4.data.dao

import io.reactivex.Completable
import io.reactivex.Observable
import zo.den.testtask4.data.entity.LinkDataEntity

interface RssDao {
    fun updateRssLink(linkEntity: LinkDataEntity) : Completable

    fun removeRssLink(linkEntity: LinkDataEntity): Completable

    fun addRssLink(linkEntity: LinkDataEntity): Completable

    fun getRssLinks() : Observable<LinkDataEntity>


}