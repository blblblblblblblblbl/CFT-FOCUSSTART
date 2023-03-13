package blblblbl.cftfocus.binlist.di.database

import android.content.Context
import androidx.room.Room
import blblblbl.cftfocus.database.BinDatabase
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataBaseCreator@Inject constructor(
    @ApplicationContext appContext: Context
) {
    private val db = Room.databaseBuilder(
        appContext,
        BinDatabase::class.java,
        "BinDB"
    ).build()
    fun getDB(): BinDatabase = db
}