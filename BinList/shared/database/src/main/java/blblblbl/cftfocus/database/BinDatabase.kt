package blblblbl.cftfocus.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import blblblbl.cftfocus.database.dao.BinDao
import blblblbl.cftfocus.database.model.BinInfoEntity
import blblblbl.cftfocus.database.utils.Converters


@TypeConverters(Converters::class)
@Database(entities = [BinInfoEntity::class], version = 1)
abstract class BinDatabase: RoomDatabase() {
    abstract fun binDao(): BinDao
}