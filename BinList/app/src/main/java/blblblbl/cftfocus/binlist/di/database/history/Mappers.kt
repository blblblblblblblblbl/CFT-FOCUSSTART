package blblblbl.cftfocus.binlist.di.database.history

import blblblbl.cftfocus.history.data.model.Bank as HistoryBank
import blblblbl.cftfocus.database.model.Bank as DBBank
import blblblbl.cftfocus.history.data.model.Country as HistoryCountry
import blblblbl.cftfocus.database.model.Country as DBCountry
import blblblbl.cftfocus.history.data.model.Number as HistoryNumber
import blblblbl.cftfocus.database.model.Number as DBNumber
import blblblbl.cftfocus.history.data.model.BinInfo as HistoryBinInfo
import blblblbl.cftfocus.database.model.BinInfo as DBBinInfo
import blblblbl.cftfocus.history.data.model.HistoryElement as HistoryHistoryElement
import blblblbl.cftfocus.database.model.BinInfoEntity as DBHistoryElement

fun HistoryBank?.mapToDB():DBBank?{
    val domainBank: DBBank =
        DBBank(
            this?.name,
            this?.url,
            this?.phone,
            this?.city
        )
    return domainBank
}
fun HistoryCountry?.mapToDB():DBCountry?{
    val domainCountry: DBCountry =
        DBCountry(
            this?.numeric,
            this?.alpha2,
            this?.name,
            this?.emoji,
            this?.currency,
            this?.latitude,
            this?.longitude
        )
    return domainCountry
}

fun HistoryNumber?.mapToDB():DBNumber?{
    val domainNumber: DBNumber =
        DBNumber(
            this?.length,
            this?.luhn
        )
    return domainNumber
}
fun HistoryBinInfo?.mapToDB():DBBinInfo?{
    val domainBinInfo: DBBinInfo =
        DBBinInfo(
            this?.number.mapToDB(),
            this?.scheme,
            this?.type,
            this?.brand,
            this?.prepaid,
            this?.country.mapToDB(),
            this?.bank.mapToDB(),
        )
    return domainBinInfo
}

fun HistoryHistoryElement?.mapToDB():DBHistoryElement?{
    if (this?.query!=null&&this?.binInfo!= null){
        val domainHistoryElement: DBHistoryElement =
            DBHistoryElement(
                this?.query!!,
                this?.binInfo!!.mapToDB()!!
            )
        return domainHistoryElement
    }
    return null
}

fun DBBank?.mapToHistory():HistoryBank?{
    val domainBank: HistoryBank =
        HistoryBank(
            this?.name,
            this?.url,
            this?.phone,
            this?.city
        )
    return domainBank
}
fun DBCountry?.mapToHistory():HistoryCountry?{
    val domainCountry: HistoryCountry =
        HistoryCountry(
            this?.numeric,
            this?.alpha2,
            this?.name,
            this?.emoji,
            this?.currency,
            this?.latitude,
            this?.longitude
        )
    return domainCountry
}

fun DBNumber?.mapToHistory():HistoryNumber?{
    val domainNumber: HistoryNumber =
        HistoryNumber(
            this?.length,
            this?.luhn
        )
    return domainNumber
}
fun DBBinInfo?.mapToHistory():HistoryBinInfo?{
    val domainBinInfo: HistoryBinInfo =
        HistoryBinInfo(
            this?.number.mapToHistory(),
            this?.scheme,
            this?.type,
            this?.brand,
            this?.prepaid,
            this?.country.mapToHistory(),
            this?.bank.mapToHistory(),
        )
    return domainBinInfo
}