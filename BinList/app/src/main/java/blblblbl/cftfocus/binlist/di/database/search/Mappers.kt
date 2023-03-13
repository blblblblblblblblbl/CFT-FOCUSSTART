package blblblbl.cftfocus.binlist.di.database.search

import blblblbl.cftfocus.search.data.model.Bank as SearchBank
import blblblbl.cftfocus.database.model.Bank as DBBank
import blblblbl.cftfocus.search.data.model.Country as SearchCountry
import blblblbl.cftfocus.database.model.Country as DBCountry
import blblblbl.cftfocus.search.data.model.Number as SearchNumber
import blblblbl.cftfocus.database.model.Number as DBNumber
import blblblbl.cftfocus.search.data.model.BinInfo as SearchBinInfo
import blblblbl.cftfocus.database.model.BinInfo as DBBinInfo

fun SearchBank?.mapToDB():DBBank?{
    val domainBank: DBBank =
        DBBank(
            this?.name,
            this?.url,
            this?.phone,
            this?.city
        )
    return domainBank
}
fun SearchCountry?.mapToDB():DBCountry?{
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

fun SearchNumber?.mapToDB():DBNumber?{
    val domainNumber: DBNumber =
        DBNumber(
            this?.length,
            this?.luhn
        )
    return domainNumber
}
fun SearchBinInfo?.mapToDB():DBBinInfo?{
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



fun DBBank?.mapToSearch():SearchBank?{
    val domainBank: SearchBank =
        SearchBank(
            this?.name,
            this?.url,
            this?.phone,
            this?.city
        )
    return domainBank
}
fun DBCountry?.mapToSearch():SearchCountry?{
    val domainCountry: SearchCountry =
        SearchCountry(
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

fun DBNumber?.mapToSearch():SearchNumber?{
    val domainNumber: SearchNumber =
        SearchNumber(
            this?.length,
            this?.luhn
        )
    return domainNumber
}
fun DBBinInfo?.mapToSearch():SearchBinInfo?{
    val domainBinInfo: SearchBinInfo =
        SearchBinInfo(
            this?.number.mapToSearch(),
            this?.scheme,
            this?.type,
            this?.brand,
            this?.prepaid,
            this?.country.mapToSearch(),
            this?.bank.mapToSearch(),
        )
    return domainBinInfo
}
