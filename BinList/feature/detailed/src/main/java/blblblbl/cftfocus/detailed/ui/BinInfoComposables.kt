package blblblbl.cftfocus.detailed.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NetworkCheck
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import blblblbl.cftfocus.detailed.R
import blblblbl.cftfocus.detailed.domain.model.Bank
import blblblbl.cftfocus.detailed.domain.model.BinInfo
import blblblbl.cftfocus.detailed.domain.model.Country


@Composable
fun BinInfoView(
    binInfo: BinInfo,
    urlOnClick: () -> Unit,
    phoneOnClick: () -> Unit,
    locationOnClick: () -> Unit
) {
    Column(
        Modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        binInfo.bank?.let { bank ->
            BankInfoView(bank = bank, urlOnClick = urlOnClick, phoneOnClick = phoneOnClick)
        }
        binInfo.country?.let { country ->
            CountryInfoView(country = country, locationOnClick = locationOnClick)
        }
        CardInfoView(
            scheme = binInfo.scheme,
            type = binInfo.type,
            brand = binInfo.brand,
            prepaid = binInfo.prepaid
        )
        binInfo.number?.let { number ->
            NumberInfoView(number = number)
        }

    }
}

@Composable
fun BankInfoView(
    bank: Bank,
    urlOnClick: () -> Unit,
    phoneOnClick: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(10.dp)) {
        bank.name?.let { name ->
            Text(
                text = name,
                style = MaterialTheme.typography.headlineLarge.copy(textAlign = TextAlign.Center),
                modifier = Modifier.fillMaxWidth()
            )
        }
        bank.url?.let { url ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = stringResource(id = R.string.website), style = MaterialTheme.typography.headlineMedium)
                Text(
                    text = url,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .clickable {
                            urlOnClick()
                        }
                )
            }
        }
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            bank.city?.let {city->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = stringResource(id = R.string.city), style = MaterialTheme.typography.headlineMedium)
                    Text(text = city, style = MaterialTheme.typography.bodyMedium)
                }
            }
            bank.phone?.let {phone->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = stringResource(id = R.string.phone), style = MaterialTheme.typography.headlineMedium)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = phone,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.clickable { phoneOnClick() }
                        )
                    }
                }
            }
        }
    }
}
@Composable
fun CountryInfoView(
    country: Country,
    locationOnClick:()->Unit
){

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        country.name?.let {name->
            Text(text = stringResource(id = R.string.country), style = MaterialTheme.typography.headlineMedium)
            Row(verticalAlignment = Alignment.CenterVertically) {
                country.name?.let {name->
                    Text(text = name, style = MaterialTheme.typography.bodyMedium)
                }
                country.emoji?.let { emoji->
                    Text(text = emoji)
                }
                if (country.latitude!=null&&country.longitude!=null){
                    LocationButton(
                        onClick = {locationOnClick()}
                    )
                }
            }
        }

        
    }
}
@Composable
fun CardInfoView(
    scheme: String? = null,
    type: String? = null,
    brand: String? = null,
    prepaid: Boolean? = null){
    Column(
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            scheme?.let {scheme->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = stringResource(id = R.string.scheme), style = MaterialTheme.typography.headlineMedium)
                    Text(text = scheme, style = MaterialTheme.typography.bodyMedium)
                }
            }
            type?.let {type->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = stringResource(id = R.string.type), style = MaterialTheme.typography.headlineMedium)
                    Text(text = type, style = MaterialTheme.typography.bodyMedium)
                }

            }

        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            brand?.let {brand->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = stringResource(id = R.string.brand), style = MaterialTheme.typography.headlineMedium)
                    Text(text = brand, style = MaterialTheme.typography.bodyMedium)
                }
            }
            prepaid?.let {prepaid->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = stringResource(id = R.string.prepaid), style = MaterialTheme.typography.headlineMedium)
                    Row {
                        Text(text = stringResource(id = R.string.yes), style = MaterialTheme.typography.bodyMedium, modifier = Modifier.alpha(if (prepaid) 1f else 0.5f))
                        Text(text = "/", style = MaterialTheme.typography.bodyMedium)
                        Text(text = stringResource(id = R.string.no), style = MaterialTheme.typography.bodyMedium, modifier = Modifier.alpha(if (!prepaid) 1f else 0.5f))
                    }
                }

            }

        }

    }
}
@Composable
fun NumberInfoView(number: blblblbl.cftfocus.detailed.domain.model.Number){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        number.length?.let {length->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = stringResource(id = R.string.length), style = MaterialTheme.typography.headlineMedium)
                Text(text = "$length", style = MaterialTheme.typography.bodyMedium)
            }
        }
        number.luhn?.let {luhn->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = stringResource(id = R.string.luhn), style = MaterialTheme.typography.headlineMedium)
                Row {
                    Text(text = stringResource(id = R.string.yes), style = MaterialTheme.typography.bodyMedium, modifier = Modifier.alpha(if (luhn) 1f else 0.5f))
                    Text(text = "/", style = MaterialTheme.typography.bodyMedium)
                    Text(text = stringResource(id = R.string.no), style = MaterialTheme.typography.bodyMedium, modifier = Modifier.alpha(if (!luhn) 1f else 0.5f))
                }
            }

        }
    }
}
@Composable
fun LocationButton(
    onClick: () -> Unit
) {
    IconButton(modifier = Modifier.testTag("locationButton"),
        onClick = { onClick() })
    {
        Icon(
            Icons.Outlined.LocationOn,
            contentDescription = "location icon",
        )
    }
}

@Composable
fun PhoneButton(
    onClick: () -> Unit
) {
    IconButton(modifier = Modifier.testTag("phoneButton"),
        onClick = { onClick() })
    {
        Icon(
            Icons.Default.Phone,
            contentDescription = "phone icon",
        )
    }
}

@Composable
fun UrlButton(
    onClick: () -> Unit
) {
    IconButton(modifier = Modifier.testTag("urlButton"),
        onClick = { onClick() })
    {
        Icon(
            Icons.Default.NetworkCheck,
            contentDescription = "url icon",
        )
    }
}

@Preview
@Composable
fun IconPreviewLocation() {
    Icon(
        Icons.Outlined.LocationOn,
        contentDescription = "icon",
        tint = Color.Black
    )
}

@Preview
@Composable
fun IconPreviewPhone() {
    Icon(
        Icons.Default.Phone,
        contentDescription = "icon",
        tint = Color.Black
    )
}
