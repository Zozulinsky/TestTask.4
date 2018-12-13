package zo.den.testtask4.data

import dagger.Binds
import dagger.Module
import zo.den.testtask4.data.dao.RssDao
import zo.den.testtask4.data.dao.impl.RssDaoImpl

@Module
abstract class DataBinder{
    @Binds
    abstract fun bindRssDao(dao: RssDaoImpl): RssDao
}