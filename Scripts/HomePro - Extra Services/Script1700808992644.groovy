//extra service
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils

Mobile.startApplication('C:\\Users\\HP\\Downloads\\SDK49MerchantTesterv2.apk', true)

Mobile.tap(findTestObject('Object Repository/HomePro - Extra Services/android.widget.Button - ACCEPT'), 0)

//login with 'active' merchant
Mobile.setText(findTestObject('Object Repository/HomePro - Extra Services/android.widget.EditText - Username'), 'pumpkinmonster99@yopmail.com', 
    0)

Mobile.setEncryptedText(findTestObject('Object Repository/HomePro - Extra Services/android.widget.EditText - Password'), 
    'HeCM15nHKBI=', 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Extra Services/android.widget.TextView - tickbox'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Extra Services/android.widget.TextView - Sign In'), 0)

//verify DB with existing extra service
xtra = WS.sendRequest(findTestObject('HomePro - Extra Services/merchantData'))

def xTraCount = WS.getElementsCount(xtra, 'extraService')

if (xTraCount == 2) {
    Mobile.tap(findTestObject('Object Repository/HomePro - Extra Services/android.widget.TextView - delete1'), 0)
	
	Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)
} else if (xTraCount == 3) {
    Mobile.tap(findTestObject('Object Repository/HomePro - Extra Services/android.widget.TextView - delete2'), 0)

    Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

    Mobile.tap(findTestObject('Object Repository/HomePro - Extra Services/android.widget.TextView - delete1'), 0)
	Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)
}

xtraServ = WS.sendRequest(findTestObject('HomePro - Extra Services/merchantData'))

WS.verifyElementsCount(xtraServ, 'extraService', 1)

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(xtraServ.getResponseBodyContent())

xtraTitle1 = result.extraService[0].title

println(xtraTitle1)

servTitle1 = Mobile.getText(findTestObject('HomePro - Extra Services/android.widget.TextView - pie'), 0)

assert servTitle1 == xtraTitle1

//add extra service
Mobile.tap(findTestObject('Object Repository/HomePro - Extra Services/android.widget.TextView - add xtra'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Extra Services/android.widget.TextView - add xtra2'), 0)

//edit extra service
Mobile.tap(findTestObject('Object Repository/HomePro - Extra Services/android.widget.TextView - edit 2'), 0)

def extraTitle = RandomStringUtils.randomAlphabetic(8)

def extraDesc = RandomStringUtils.randomAlphabetic(10)

Mobile.setText(findTestObject('Object Repository/HomePro - Extra Services/android.widget.EditText - Service Available'), 
    extraTitle, 0)

Mobile.setText(findTestObject('Object Repository/HomePro - Extra Services/android.widget.EditText - Description'), extraDesc, 
    0)

Mobile.tap(findTestObject('Object Repository/HomePro - Extra Services/android.widget.TextView - Save'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Extra Services/android.widget.TextView - edit 3'), 0)

def extraTitle1 = RandomStringUtils.randomAlphabetic(8)

def extraDesc1 = RandomStringUtils.randomAlphabetic(10)

Mobile.setText(findTestObject('Object Repository/HomePro - Extra Services/android.widget.EditText - Service Available'), 
    extraTitle1, 0)

Mobile.setText(findTestObject('Object Repository/HomePro - Extra Services/android.widget.EditText - Description'), extraDesc1, 
    0)

Mobile.tap(findTestObject('Object Repository/HomePro - Extra Services/android.widget.TextView - Save'), 0)

//close extra service page
Mobile.tap(findTestObject('Object Repository/HomePro - Extra Services/android.widget.TextView - edit 3'), 0)

Mobile.tap(findTestObject('HomePro - Extra Services/android.widget.ImageView - x'), 0)

xtraServ1 = WS.sendRequest(findTestObject('HomePro - Extra Services/merchantData'))

WS.verifyElementsCount(xtraServ1, 'extraService', 3)

def slurper1 = new groovy.json.JsonSlurper()

def result1 = slurper.parseText(xtraServ1.getResponseBodyContent())

title2 = result1.extraService[1].title

title3 = result1.extraService[2].title

description2 = result1.extraService[1].description

description3 = result1.extraService[2].description

//assert extra service in DB
assert title2 == extraTitle

assert title3 == extraTitle1

assert description2 == extraDesc

assert description3 == extraDesc1

//delete extra service
Mobile.tap(findTestObject('Object Repository/HomePro - Extra Services/android.widget.TextView - delete2'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/HomePro - Extra Services/android.widget.TextView - delete1'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

//assert extra service in DB
xtraServ2 = WS.sendRequest(findTestObject('HomePro - Extra Services/merchantData'))

WS.verifyElementsCount(xtraServ2, 'extraService', 1)

Mobile.delay(1, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

