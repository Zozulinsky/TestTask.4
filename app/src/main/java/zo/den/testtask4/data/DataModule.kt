package zo.den.testtask4.data

import dagger.Module

@Module(includes = [NetworkModule::class, DataBinder::class])
class DataModule {
}