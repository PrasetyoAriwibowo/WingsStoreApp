package com.android.wingsstoreapp.module

import android.content.Context
import com.android.api_service.service.WingsStoreDatabase
import com.android.api_service.service.preference.AuthDbService
import com.android.api_service.service.preference.AuthDbServicePreference
import com.android.common.ext.AppExecutors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context) = WingsStoreDatabase.getInstance(context)

    @Provides
    @Singleton
    fun providesLoginDao(wingsStoreDatabase: WingsStoreDatabase) = wingsStoreDatabase.loginDao()

    @Provides
    @Singleton
    fun providesProductDao(wingsStoreDatabase: WingsStoreDatabase) = wingsStoreDatabase.productDao()

    @Provides
    @Singleton
    fun providesCheckoutDao(wingsStoreDatabase: WingsStoreDatabase) = wingsStoreDatabase.checkoutDao()

    @Provides
    @Singleton
    fun providesTransactionDao(wingsStoreDatabase: WingsStoreDatabase) = wingsStoreDatabase.transactionDao()

    @Provides
    @Singleton
    fun providesExecutor() = AppExecutors()

    @Provides
    @Singleton
    fun provideAuthDbService(@ApplicationContext context: Context): AuthDbService =
        AuthDbServicePreference(context)
}