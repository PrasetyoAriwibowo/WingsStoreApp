package com.android.api_service.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.api_service.service.dao.CheckoutDao
import com.android.api_service.service.dao.LoginDao
import com.android.api_service.service.dao.ProductDao
import com.android.api_service.service.dao.TransactionDao
import com.android.common.entity.*

@Database(
    entities = [LoginEntity::class, ProductEntity::class, TransactionHeaderEntity::class,
        TransactionDetailEntity::class, CheckoutEntity::class], version = 1, exportSchema = false
)
abstract class WingsStoreDatabase: RoomDatabase() {

    abstract fun loginDao(): LoginDao
    abstract fun productDao(): ProductDao
    abstract fun checkoutDao(): CheckoutDao
    abstract fun transactionDao() : TransactionDao

    companion object{
        @Volatile
        private var instance: WingsStoreDatabase? = null
        fun getInstance(context: Context): WingsStoreDatabase =
            instance?: synchronized(this){
                instance?: Room.databaseBuilder(
                    context.applicationContext,
                    WingsStoreDatabase::class.java,"WingsStore.db"
                ).build()
            }
    }

}