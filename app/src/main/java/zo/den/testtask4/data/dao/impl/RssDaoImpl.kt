package zo.den.testtask4.data.dao.impl

import zo.den.testtask4.data.dao.RssDao
import javax.inject.Inject
import io.reactivex.Completable
import io.reactivex.Observable
import zo.den.testtask4.data.database.LinkDB
import zo.den.testtask4.data.entity.LinkDataEntity


class RssDaoImpl @Inject constructor(private val linkDB: LinkDB): RssDao {
    override fun updateRssLink(linkEntity: LinkDataEntity): Completable {
        return Completable.fromAction {
            linkDB.updateLink(linkEntity)
        }
    }

    override fun removeRssLink(linkEntity: LinkDataEntity): Completable {
        return Completable.fromAction {
            linkDB.deleteLink(linkEntity)
        }
    }

    override fun addRssLink(linkEntity: LinkDataEntity): Completable {
        return Completable.fromAction {
            linkDB.insertLink(linkEntity)
        }
    }

    override fun getRssLinks(): Observable<LinkDataEntity> {
        return Observable.defer {
            Observable.fromIterable(
                    linkDB.getLinks()
            )
        }
    }
}