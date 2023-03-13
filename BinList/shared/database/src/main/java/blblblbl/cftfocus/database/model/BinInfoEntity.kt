package blblblbl.cftfocus.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BinsTable")
data class BinInfoEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "bin")
    val bin :String,
    @ColumnInfo(name = "binInfo")
    val binInfo: String
)
