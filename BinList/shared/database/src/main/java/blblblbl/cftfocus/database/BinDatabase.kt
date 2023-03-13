package blblblbl.cftfocus.database

import androidx.room.Database
import androidx.room.RoomDatabase
import blblblbl.cftfocus.database.dao.BinDao
import blblblbl.cftfocus.database.model.BinInfoEntity


@Database(entities = [BinInfoEntity::class], version = 1)
abstract class BinDatabase: RoomDatabase() {
    abstract fun binDao(): BinDao
}