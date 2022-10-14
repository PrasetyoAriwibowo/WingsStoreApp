package com.android.wingsstoreapp.module

import com.android.api_service.service.dao.CheckoutDao
import com.android.api_service.service.dao.LoginDao
import com.android.api_service.service.dao.ProductDao
import com.android.api_service.service.preference.AuthDbService
import com.android.api_service.service.repository.CheckoutRepository
import com.android.api_service.service.repository.LoginRepository
import com.android.api_service.service.repository.ProductRepository
import com.android.common.ext.AppExecutors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    fun providesLoginRepository(loginDao: LoginDao, appExecutors: AppExecutors, authDbService: AuthDbService) =
        LoginRepository(loginDao, appExecutors, authDbService)

    @Provides
    fun providesProductRepository(productDao: ProductDao, appExecutors: AppExecutors) =
        ProductRepository(productDao, appExecutors)

    @Provides
    fun providesCheckoutRepository(checkoutDao: CheckoutDao, appExecutors: AppExecutors, authDbService: AuthDbService) =
        CheckoutRepository(checkoutDao, appExecutors, authDbService)
}