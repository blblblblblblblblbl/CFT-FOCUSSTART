package blblblbl.cftfocus.binlist.ui.detailed

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import blblblbl.cftfocus.detailed.domain.model.Bank
import blblblbl.cftfocus.detailed.domain.model.BinInfo
import blblblbl.cftfocus.detailed.domain.model.Country
import blblblbl.cftfocus.detailed.ui.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BinInfoViewTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()


    @Test
    fun BankInfoViewAllElementsIsShown(){
        val textPhone = hasTestTag("textBankPhone")
        val textBankCity = hasTestTag("textBankCity")
        val textBankUrl= hasTestTag("textBankUrl")
        val textBankName = hasTestTag("textBankName")
        val bank = Bank("aaaaaaaaa","aaaaaaaaa","aaaaaaaaa","aaaaaaaaa")
        composeTestRule.setContent {
            BankInfoView(bank = bank, urlOnClick = { /*TODO*/ }, phoneOnClick = {})
        }
        composeTestRule.onNode(textPhone).assertExists()
        composeTestRule.onNode(textBankCity).assertExists()
        composeTestRule.onNode(textBankUrl).assertExists()
        composeTestRule.onNode(textBankName).assertExists()
    }
    @Test
    fun CardInfoViewAllElementsIsShown(){
        val textCardInfoScheme = hasTestTag("textCardInfoScheme")
        val textCardInfoType = hasTestTag("textCardInfoType")
        val textCardInfoBrand= hasTestTag("textCardInfoBrand")
        val textCardInfoPrepaid = hasTestTag("textCardInfoPrepaid")
        composeTestRule.setContent {
            CardInfoView(
                scheme = "aaaaaaaaa",
                type = "aaaaaaaaa",
                brand = "aaaaaaaaa",
                prepaid = true,
            )
        }
        composeTestRule.onNode(textCardInfoScheme).assertExists()
        composeTestRule.onNode(textCardInfoType).assertExists()
        composeTestRule.onNode(textCardInfoBrand).assertExists()
        composeTestRule.onNode(textCardInfoPrepaid).assertExists()
    }
    @Test
    fun CountryInfoViewAllElementsIsShown(){
        val textCountryName= hasTestTag("textCountryName")
        val textCountryEmoji = hasTestTag("textCountryEmoji")
        val buttonLocation = hasTestTag("locationButton") and hasClickAction()

        val country = Country("aaaaaaaaa","aaaaaaaaa","aaaaaaaaa","aaaaaaaaa","aaaaaaaaa",24,56)
        composeTestRule.setContent {
            CountryInfoView(country = country, locationOnClick = {})
        }
        composeTestRule.onNode(textCountryName).assertExists()
        composeTestRule.onNode(textCountryEmoji).assertExists()
        composeTestRule.onNode(buttonLocation).assertExists()
    }
    @Test
    fun CountryInfoViewLocationButtonIsntShown(){
        val buttonLocation = hasTestTag("locationButton") and hasClickAction()
        val country = Country("aaaaaaaaa","aaaaaaaaa","aaaaaaaaa","aaaaaaaaa","aaaaaaaaa",null,56)
        composeTestRule.setContent {
            CountryInfoView(country = country, locationOnClick = {})
        }
        composeTestRule.onNode(buttonLocation).assertDoesNotExist()
    }
    @Test
    fun NumberInfoViewAllElementsIsShown(){
        val textNumberInfoLength= hasTestTag("textNumberInfoLength")
        val textNumberInfoLuhn = hasTestTag("textNumberInfoLuhn")
        val number = blblblbl.cftfocus.detailed.domain.model.Number(16,true)
        composeTestRule.setContent {
            NumberInfoView(number = number)
        }
        composeTestRule.onNode(textNumberInfoLength).assertExists()
        composeTestRule.onNode(textNumberInfoLuhn).assertExists()

    }

    @Test
    fun allElementsIsShown(){
        val elBankInfoView= hasTestTag("BankInfoView")
        val elCountryInfoView= hasTestTag("CountryInfoView")
        val elCardInfoView= hasTestTag("CardInfoView")
        val elNumberInfoView= hasTestTag("NumberInfoView")
        val bank = Bank("aaaaaaaaa","aaaaaaaaa","aaaaaaaaa","aaaaaaaaa")
        val country = Country("aaaaaaaaa","aaaaaaaaa","aaaaaaaaa","aaaaaaaaa","aaaaaaaaa",24,56)
        val number = blblblbl.cftfocus.detailed.domain.model.Number(16,true)
        val binInfo = BinInfo(
            number = number,
            scheme = "aaaaaaaaa",
            type = "aaaaaaaaa",
            brand = "aaaaaaaaa",
            prepaid = true,
            country = country,
            bank = bank
        )
        composeTestRule.setContent {
            BinInfoView(
                binInfo = binInfo,
                urlOnClick = {},
                phoneOnClick = { },
                locationOnClick = {}
            )
        }
        composeTestRule.onNode(elBankInfoView).assertExists()
        composeTestRule.onNode(elCountryInfoView).assertExists()
        composeTestRule.onNode(elCardInfoView).assertExists()
        composeTestRule.onNode(elNumberInfoView).assertExists()
    }

}