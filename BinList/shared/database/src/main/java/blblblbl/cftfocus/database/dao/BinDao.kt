package blblblbl.cftfocus.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import blblblbl.cftfocus.database.model.BinInfoEntity

@Dao
interface BinDao {
    @Query("SELECT * FROM BinsTable")
    fun getBinInfoPagingSource(): PagingSource<Int,BinInfoEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(binInfo: BinInfoEntity)
    @Query("DELETE FROM BinsTable")
    suspend fun clear()
}