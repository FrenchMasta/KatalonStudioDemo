import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.BaseURL)

WebUI.waitForPageLoad(3)

WebUI.verifyElementClickable(findTestObject('Object Repository/Login OR/BurgerIcon Side Menu'))

WebUI.click(findTestObject('Object Repository/Login OR/BurgerIcon Side Menu'))

WebUI.verifyElementClickable(findTestObject('Object Repository/Login OR/Login Option (Side Menu)'))

WebUI.click(findTestObject('Object Repository/Login OR/Login Option (Side Menu)'))

WebUI.setText(findTestObject('Object Repository/Login OR/Input Username'), GlobalVariable.Username)

WebUI.setEncryptedText(findTestObject('Object Repository/Login OR/Input Password'), GlobalVariable.EncryptedPasword)

WebUI.verifyElementClickable(findTestObject('Object Repository/Login OR/Button Login'))

WebUI.click(findTestObject('Object Repository/Login OR/Button Login'))
