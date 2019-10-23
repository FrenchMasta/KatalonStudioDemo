import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.exception.StepFailedException as StepFailedException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

try {
    WebUI.openBrowser('')

    WebUI.navigateToUrl(GlobalVariable.BaseURL)

    WebUI.maximizeWindow()

    WebUI.waitForPageLoad(3)

	// Using a custom keyword to verify the current page URL
    CustomKeywords.'VerifyPage.verifyURL'(GlobalVariable.BaseURL)

    WebUI.verifyElementClickable(findTestObject('Object Repository/Login OR/BurgerIcon Side Menu'))

    WebUI.click(findTestObject('Object Repository/Login OR/BurgerIcon Side Menu'))

    WebUI.verifyElementClickable(findTestObject('Object Repository/Login OR/Login Option (Side Menu)'))

    WebUI.click(findTestObject('Object Repository/Login OR/Login Option (Side Menu)'))

    WebUI.setText(findTestObject('Object Repository/Login OR/Input Username'), GlobalVariable.Username)

    WebUI.setEncryptedText(findTestObject('Object Repository/Login OR/Input Password'), GlobalVariable.EncryptedPasword)

    WebUI.verifyElementClickable(findTestObject('Object Repository/Login OR/Button Login'))

    WebUI.click(findTestObject('Object Repository/Login OR/Button Login'))
}
catch (StepFailedException sfe) {
    throw sfe
} 
catch (Exception e) {
    throw e
} 
finally { 
    // Regardless of test outcome/state determine if browser should be closed
    if (shouldCloseBrowser) {
        WebUI.closeBrowser()
    }
}