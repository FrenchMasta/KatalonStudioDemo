import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.exception.StepFailedException as StepFailedException
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

try {
    WebUI.callTestCase(findTestCase('Login Test Case'), [('shouldCloseBrowser') : false], FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForPageLoad(3)

	// Using a custom keyword to verify the current page URL
    CustomKeywords.'VerifyPage.verifyURL'(GlobalVariable.AppointmentURL)

    WebUI.verifyElementPresent(findTestObject('Object Repository/Book Appointment OR/Header Make Appointment'), 5)

    WebUI.verifyElementText(findTestObject('Object Repository/Book Appointment OR/Header Make Appointment'), 'Make Appointment')

    WebUI.selectOptionByValue(findTestObject('Object Repository/Book Appointment OR/Select Healthcare Facility'), 'Hongkong CURA Healthcare Center', true)

    WebUI.click(findTestObject('Object Repository/Book Appointment OR/Checkbox Hospital Readmission'))

    WebUI.verifyElementChecked(findTestObject('Object Repository/Book Appointment OR/Checkbox Hospital Readmission'), 5)

    WebUI.click(findTestObject('Object Repository/Book Appointment OR/RadioButton Medicaid Programs'))

    WebUI.click(findTestObject('Object Repository/Book Appointment OR/Button Calendar Toggle'))

    WebUI.click(findTestObject('Object Repository/Book Appointment OR/Calendar Day 28'))

    WebUI.setText(findTestObject('Object Repository/Book Appointment OR/Textarea Comment'), 'Comment')

    WebUI.click(findTestObject('Object Repository/Book Appointment OR/Button Book Appointment'))
	
	WebUI.waitForPageLoad(3)
	
	// Using a custom keyword to verify the current page URL
	CustomKeywords.'VerifyPage.verifyURL'(GlobalVariable.AppointmentConfirmationURL)

    verifyAppointmentOutput('Hongkong CURA Healthcare Center', 'Yes', 'Medicaid', 'Comment')

    WebUI.click(findTestObject('Object Repository/Book Appointment OR/Button Go to Homepage'))
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

private void verifyAppointmentOutput(String healthcareCenter, String readmission, String program, String comment) {
    WebUI.verifyElementPresent(findTestObject('Object Repository/Book Appointment OR/Header Appointment Confirmation'), 5)

    WebUI.verifyElementText(findTestObject('Object Repository/Book Appointment OR/Header Appointment Confirmation'), 'Appointment Confirmation')

    WebUI.verifyElementPresent(findTestObject('Object Repository/Book Appointment OR/Output Healthcare Center'), 5)

    WebUI.verifyElementText(findTestObject('Object Repository/Book Appointment OR/Output Healthcare Center'), healthcareCenter)

    WebUI.verifyElementPresent(findTestObject('Object Repository/Book Appointment OR/Output Hospital Readmission'), 5)

    WebUI.verifyElementText(findTestObject('Object Repository/Book Appointment OR/Output Hospital Readmission'), readmission)

    WebUI.verifyElementPresent(findTestObject('Object Repository/Book Appointment OR/Output Program'), 5)

    WebUI.verifyElementText(findTestObject('Object Repository/Book Appointment OR/Output Program'), program)

    WebUI.verifyElementPresent(findTestObject('Object Repository/Book Appointment OR/Output Comment'), 5)

    WebUI.verifyElementText(findTestObject('Object Repository/Book Appointment OR/Output Comment'), comment)
}