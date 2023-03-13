package blblblbl.cftfocus.search.data.utils

import blblblbl.cftfocus.search.data.model.Bank as DataBank
import blblblbl.cftfocus.search.domain.model.Bank as DomainBank
import blblblbl.cftfocus.search.data.model.Country as DataCountry
import blblblbl.cftfocus.search.domain.model.Country as DomainCountry
import blblblbl.cftfocus.search.data.model.Number as DataNumber
import blblblbl.cftfocus.search.domain.model.Number as DomainNumber
import blblblbl.cftfocus.search.data.model.BinInfo as DataBinInfo
import blblblbl.cftfocus.search.domain.model.BinInfo as DomainBinInfo

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