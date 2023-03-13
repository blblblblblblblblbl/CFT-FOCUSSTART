package blblblbl.cftfocus.history.data.utils

import blblblbl.cftfocus.history.data.model.Bank as DataBank
import blblblbl.cftfocus.history.domain.model.Bank as DomainBank
import blblblbl.cftfocus.history.data.model.Country as DataCountry
import blblblbl.cftfocus.history.domain.model.Country as DomainCountry
import blblblbl.cftfocus.history.data.model.Number as DataNumber
import blblblbl.cftfocus.history.domain.model.Number as DomainNumber
import blblblbl.cftfocus.history.data.model.BinInfo as DataBinInfo
import blblblbl.cftfocus.history.domain.model.BinInfo as DomainBinInfo
import blblblbl.cftfocus.history.data.model.HistoryElement as DataHistoryElement
import blblblbl.cftfocus.history.domain.model.HistoryElement as DomainHistoryElement

fun DataBank?.mapToDomain():DomainBank?{
    val domainBank: DomainBank =
        DomainBank(
            this?.name,
            this?.url,
            this?.phone,
            this?.city
        )
    return domainBank
}
fun DataCountry?.mapToDomain():DomainCountry?{
    val domainCountry: DomainCountry =
        DomainCountry(
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

fun DataNumber?.mapToDomain():DomainNumber?{
    val domainNumber: DomainNumber =
        DomainNumber(
            this?.length,
            this?.luhn
        )
    return domainNumber
}
fun DataBinInfo?.mapToDomain():DomainBinInfo?{
    val domainBinInfo: DomainBinInfo =
        DomainBinInfo(
            this?.number.mapToDomain(),
            this?.scheme,
            this?.type,
            this?.brand,
            this?.prepaid,
            this?.country.mapToDomain(),
            this?.bank.mapToDomain(),
        )
    return domainBinInfo
}

fun DataHistoryElement?.mapToDomain():DomainHistoryElement?{
    val domainHistoryElement: DomainHistoryElement =
        DomainHistoryElement(
            this?.query,
            this?.binInfo.mapToDomain()
        )
    return domainHistoryElement
}