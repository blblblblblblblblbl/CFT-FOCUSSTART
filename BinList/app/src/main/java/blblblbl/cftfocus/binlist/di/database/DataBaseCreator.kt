package blblblbl.cftfocus.binlist.di.database

import android.content.Context
import androidx.room.Room
import blblblbl.cftfocus.database.BinDatabase
import blblblbl.cftfocus.database.utils.Converters
import blblblbl.cftfocus.database.utils.GsonParser
import com.google.gson.GsonBuilder
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataBaseCreator@Inject constructor(
    @ApplicationContext appContext: Context
) {
    private val gson = GsonBuilder().setLenient().create()
    private val db = Room.databaseBuilder(
        appContext,
        BinDatabase::class.java,
        "BinDB"
    ).addTypeConverter(Converters(GsonParser(gson))).build()
    fun getDB(): BinDatabase = db
}