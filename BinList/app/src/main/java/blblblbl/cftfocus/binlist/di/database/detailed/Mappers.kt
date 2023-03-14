package blblblbl.cftfocus.binlist.di.database.detailed

import blblblbl.cftfocus.detailed.data.model.Bank as DetailedBank
import blblblbl.cftfocus.database.model.Bank as DBBank
import blblblbl.cftfocus.detailed.data.model.Country as DetailedCountry
import blblblbl.cftfocus.database.model.Country as DBCountry
import blblblbl.cftfocus.detailed.data.model.Number as DetailedNumber
import blblblbl.cftfocus.database.model.Number as DBNumber
import blblblbl.cftfocus.detailed.data.model.BinInfo as DetailedBinInfo
import blblblbl.cftfocus.database.model.BinInfo as DBBinInfo
import blblblbl.cftfocus.database.model.BinInfoEntity as DBDetailedElement

fun DetailedBank?.mapToDB():DBBank?{
    val domainBank: DBBank =
        DBBank(
            this?.name,
            this?.url,
            this?.phone,
            this?.city
        )
    return domainBank
}
fun DetailedCountry?.mapToDB():DBCountry?{
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

fun DetailedNumber?.mapToDB():DBNumber?{
    val domainNumber: DBNumber =
        DBNumber(
            this?.length,
            this?.luhn
        )
    return domainNumber
}
fun DetailedBinInfo?.mapToDB():DBBinInfo?{
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

fun DBBank?.mapToDetailed():DetailedBank?{
    val domainBank: DetailedBank =
        DetailedBank(
            this?.name,
            this?.url,
            this?.phone,
            this?.city
        )
    return domainBank
}
fun DBCountry?.mapToDetailed():DetailedCountry?{
    val domainCountry: DetailedCountry =
        DetailedCountry(
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

fun DBNumber?.mapToDetailed():DetailedNumber?{
    val domainNumber: DetailedNumber =
        DetailedNumber(
            this?.length,
            this?.luhn
        )
    return domainNumber
}
fun DBBinInfo?.mapToDetailed():DetailedBinInfo?{
    val domainBinInfo: DetailedBinInfo =
        DetailedBinInfo(
            this?.number.mapToDetailed(),
            this?.scheme,
            this?.type,
            this?.brand,
            this?.prepaid,
            this?.country.mapToDetailed(),
            this?.bank.mapToDetailed(),
        )
    return domainBinInfo
}