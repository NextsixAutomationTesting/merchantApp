//first login
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

//reset merchant status
WS.sendRequest(findTestObject('HomePro - First Login/updateStatus'))

Mobile.startApplication('C:\\Users\\HP\\Downloads\\SDK49MerchantTesterv2.apk', true)

Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.Button - ACCEPT'), 0)

Mobile.setText(findTestObject('HomePro - First Login/android.widget.EditText - Username'), 'portfoliotest99@yopmail.com', 
    0)

Mobile.setEncryptedText(findTestObject('Object Repository/HomePro - First Login/android.widget.EditText - Password'), 'HeCM15nHKBI=', 
    0)

Mobile.tap(findTestObject('Object Repository/HomePro - First Login/android.widget.TextView -'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - First Login/android.widget.TextView - Sign In'), 0)

//input mandatory fields
Mobile.tap(findTestObject('Object Repository/HomePro - First Login/android.widget.TextView - Upload'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - First Login/android.widget.TextView - Choose Gallery Photo'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - First Login/android.widget.ImageView'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - First Login/android.widget.Button - CROP'), 0)

Mobile.scrollToText('Coverage State*')

companyDescription = RandomStringUtils.randomAlphanumeric(20)

Mobile.setText(findTestObject('Object Repository/HomePro - First Login/android.widget.EditText - Company Description'), 
    companyDescription, 0)

//verify service category cannot more than 3
Mobile.tap(findTestObject('Object Repository/HomePro - First Login/android.view.ViewGroup'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - First Login/android.widget.TextView - (2)'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - First Login/android.widget.TextView - (3)'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - First Login/android.widget.TextView - (4)'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - First Login/android.widget.TextView - (5)'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - First Login/android.widget.TextView - Select (3)'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/HomePro - First Login/android.widget.TextView - Please key in maximum only 3 service category'), 
    0)

Mobile.tap(findTestObject('Object Repository/HomePro - First Login/android.widget.Button - OK'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - First Login/android.widget.TextView - (6)'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - First Login/android.widget.TextView - Select (3)'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - First Login/android.widget.TextView - State (1)'), 0)

Mobile.tap(findTestObject('HomePro - First Login/android.widget.TextView - Wilayah Persekutuan Kuala Lumpur (2)'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - First Login/android.widget.EditText - Any (1)'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - First Login/android.widget.TextView - (7)'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - First Login/android.widget.TextView - (8)'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - First Login/android.widget.TextView - Select (3)'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - First Login/android.widget.TextView - Upload (1)'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - First Login/android.widget.TextView - Choose Gallery Photo (1)'), 
    0)

Mobile.tap(findTestObject('Object Repository/HomePro - First Login/android.widget.ImageView (1)'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - First Login/android.widget.Button - CROP (1)'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/HomePro - First Login/android.widget.TextView - Submit'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

//verify merchant details after submit first login page form
merchDetails = WS.sendRequest(findTestObject('HomePro - Edit Profile/merchantDetails'))

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(merchDetails.getResponseBodyContent())

description = result.description

WS.verifyElementsCount(merchDetails, 'category', 3)

state = result.coverage[0].state

WS.verifyElementsCount(merchDetails, 'coverage[0].area', 2)

WS.verifyElementsCount(merchDetails, 'portfolio.images', 1)

status = result.status

assert description == companyDescription

assert state == 'Wilayah Persekutuan Kuala Lumpur'

assert status == 'Active'

Mobile.closeApplication()

