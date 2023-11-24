//Edit Profile
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

Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.Button - ACCEPT'), 0)

Mobile.setText(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.EditText - Username'), 'portfoliotest99@yopmail.com', 
    0)

Mobile.setEncryptedText(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.EditText - Password'), 'HeCM15nHKBI=', 
    0)

Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.TextView -'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.TextView - Sign In'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.TextView - Account'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.TextView - Edit Profile'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

merchantName = Mobile.getText(findTestObject('HomePro - Edit Profile/android.widget.TextView - Home Reno Portfolio 1'), 
    0)

merchantAdd = Mobile.getText(findTestObject('HomePro - Edit Profile/android.widget.TextView - 312ddsad, Bertam, Melaka, 47500, Melaka'), 
    0)

//verify company name and address match with DB
merchantDetails = WS.sendRequest(findTestObject('HomePro - Edit Profile/merchantDetails'))

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(merchantDetails.getResponseBodyContent())

merchName = result.name

merchAdd = ((((((((result.address.line1 + ', ') + result.address.area) + ', ') + result.address.city) + ', ') + result.address.postcode) + 
', ') + result.address.state)

assert merchantName == merchName

assert merchantAdd == merchAdd

portfolioCount = WS.getElementsCount(merchantDetails, 'portfolio.images')

//edit profile
Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.TextView - Others Info'), 0)

companyDescription = RandomStringUtils.randomAlphanumeric(20)

Mobile.setText(findTestObject('HomePro - Edit Profile/android.widget.EditText - iqdEeyHSZOFbxw1dgYUw'), companyDescription, 
    0)

comDescription = Mobile.getText(findTestObject('HomePro - Edit Profile/android.widget.EditText - iqdEeyHSZOFbxw1dgYUw'), 
    0)

Mobile.scrollToText('Coverage State*')

Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.view.ViewGroup'), 0)

//verify service category cannot more than 3
Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.TextView - (2)'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.TextView - (3)'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.TextView - (4)'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.TextView - (5)'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.TextView - (1)'), 2)

Mobile.delay(1, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.TextView - Select'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.TextView - Please key in maximum only 3 service category'), 
    0)

Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.Button - OK'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.TextView - (5)'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.TextView - (1)'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.TextView - Select'), 0)

//change state
Mobile.tap(findTestObject('HomePro - Edit Profile/android.widget.TextView - Wilayah Persekutuan Kuala Lumpur'), 0)

Mobile.tap(findTestObject('HomePro - Edit Profile/android.view.ViewGroup (2)'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.view.ViewGroup (3)'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.TextView - (9)'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.TextView - (6)'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.TextView - (7)'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.TextView - (8)'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.TextView - Select (1)'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.TextView - Upload'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.TextView - Choose Gallery Photo'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.ImageView (1)'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.Button - CROP (1)'), 0)

Mobile.scrollToText('Submit')

Mobile.tap(findTestObject('Object Repository/HomePro - Edit Profile/android.widget.TextView - Submit'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

//verify merchant details updated in DB
updateDetails = WS.sendRequest(findTestObject('HomePro - Edit Profile/merchantDetails'))

def slurper1 = new groovy.json.JsonSlurper()

def result1 = slurper1.parseText(updateDetails.getResponseBodyContent())

description = result1.description

WS.verifyElementsCount(updateDetails, 'category', 2)

state = result1.coverage[0].state

WS.verifyElementsCount(updateDetails, 'coverage[0].area', 3)

WS.verifyElementsCount(updateDetails, 'portfolio.images', portfolioCount + 1)

assert description == comDescription

assert state == 'Johor'

Mobile.closeApplication()

