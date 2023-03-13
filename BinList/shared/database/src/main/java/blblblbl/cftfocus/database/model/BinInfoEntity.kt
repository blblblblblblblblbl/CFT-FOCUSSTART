package blblblbl.cftfocus.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "BinsTable")
data class BinInfoEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "bin")
    @SerializedName("bin")
    val bin :String,
    @ColumnInfo(name = "binInfo")
    @SerializedName("binInfo")
    val binInfo: BinInfo
)
