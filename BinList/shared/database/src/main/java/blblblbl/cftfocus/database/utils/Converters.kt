package blblblbl.cftfocus.database.utils

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import blblblbl.cftfocus.database.model.BinInfo

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun toMeaningJson(photo: BinInfo) : String {
        return jsonParser.toJson(
            photo,
            BinInfo::class.java
        ) ?: "[]"
    }

    @TypeConverter
    fun fromMeaningsJson(json: String): BinInfo {
        return jsonParser.fromJson<BinInfo>(
            json,
            BinInfo::class.java
        ) ?: BinInfo()
    }
}