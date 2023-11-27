 //signup
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

//get fake data for sign up new account
fakeUser = WS.sendRequest(findTestObject('HomePro - Sign Up/FakeUser'))

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(fakeUser.getResponseBodyContent())

first = result.address.Full_Name

//random contact with MY format
def contact = ('1' + (new Random().nextInt((19 - 2) + 1) + 2)) + RandomStringUtils.randomNumeric(7)

//fake data username as email address
String username = result.address.Username

email = (username.toLowerCase() + '@yopmail.com')

company = (first + ' Sdn. Bhd.')

address = result.address.Address

city = result.address.City

//go to app sign up page
Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.Button - ACCEPT'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Sign Up/android.widget.TextView - Join Now'), 0)

//input fake data
Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.EditText - first'), 0)

Mobile.sendKeys(findTestObject('HomePro - Sign Up/android.widget.EditText - first'), first)

Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.EditText - last'), 0)

Mobile.sendKeys(findTestObject('HomePro - Sign Up/android.widget.EditText - last'), 'Testing')

Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.EditText - Contact'), 0)

//input used contact
Mobile.sendKeys(findTestObject('HomePro - Sign Up/android.widget.EditText - Contact'), '123456789')

Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.TextView - Contact No'), 0)

Mobile.verifyElementExist(findTestObject('HomePro - Sign Up/android.widget.TextView - Sorry, this contact number has been taken'), 
    0)

//input invalid contact
Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.EditText - Contact'), 0)

Mobile.sendKeys(findTestObject('HomePro - Sign Up/android.widget.EditText - Contact'), '1459681')

Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.TextView - Contact No'), 0)

Mobile.verifyElementExist(findTestObject('HomePro - Sign Up/android.widget.TextView - Please enter a valid contact no'), 
    0)

//input random generated contact
Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.EditText - Contact'), 0)

Mobile.sendKeys(findTestObject('HomePro - Sign Up/android.widget.EditText - Contact'), contact)

Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.EditText - last'), 0)

Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.EditText - Contact'), 0)

Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.TextView - Contact No'), 0)

Mobile.verifyElementNotExist(findTestObject('HomePro - Sign Up/android.widget.TextView - Please enter a valid contact no'), 
    2)

//input invalid email
Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.EditText - Email'), 0)

Mobile.sendKeys(findTestObject('HomePro - Sign Up/android.widget.EditText - EmailwKey'), 'blablabla')

Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.TextView - Email'), 0)

Mobile.verifyElementExist(findTestObject('HomePro - Sign Up/android.widget.TextView - Please enter a valid email'), 0)

//input used email
Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.EditText - Email'), 0)

Mobile.sendKeys(findTestObject('HomePro - Sign Up/android.widget.EditText - EmailwKey'), 'gggg@gmail.com')

Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.TextView - Email'), 0)

Mobile.verifyElementExist(findTestObject('HomePro - Sign Up/android.widget.TextView - Sorry, this email has been taken'), 
    0)

//input random generated email
Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.EditText - Email'), 0)

Mobile.sendKeys(findTestObject('HomePro - Sign Up/android.widget.EditText - EmailwKey'), email)

Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.TextView - Email'), 0)

Mobile.verifyElementNotExist(findTestObject('HomePro - Sign Up/android.widget.TextView - Sorry, this email has been taken'), 
    2)

Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.TextView - Next'), 0)

//upload business cert (max 3)
Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.TextView - Upload'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Sign Up/android.widget.TextView - Choose Gallery Photo'), 0)

Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.ImageView'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Sign Up/android.widget.Button - CROP'), 0)

Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.TextView - Upload'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Sign Up/android.widget.TextView - Choose Gallery Photo'), 0)

Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.ImageView'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Sign Up/android.widget.Button - CROP'), 0)

Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.TextView - Upload'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Sign Up/android.widget.TextView - Choose Gallery Photo'), 0)

Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.ImageView'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Sign Up/android.widget.Button - CROP'), 0)

Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.TextView - Upload'), 0)

Mobile.verifyElementNotExist(findTestObject('Object Repository/HomePro - Sign Up/android.widget.TextView - Choose Gallery Photo'), 
    2)

//input form
Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.TextView - ChooseTYpe'), 0)

Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.TextView - Interior Design'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Sign Up/android.widget.EditText - Company Name'), 0)

Mobile.sendKeys(findTestObject('Object Repository/HomePro - Sign Up/android.widget.EditText - Company Name'), company)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Object Repository/HomePro - Sign Up/android.widget.EditText - Company Address'), 0)

Mobile.sendKeys(findTestObject('Object Repository/HomePro - Sign Up/android.widget.EditText - Company Address'), address)

Mobile.hideKeyboard()

//scroll to bottom
dHeight = Mobile.getDeviceHeight()

dWidth = Mobile.getDeviceWidth()

int startX = dWidth / 2

int endX = startX

int startY = dHeight * 0.3

int endY = dHeight * 0.7

Mobile.swipe(startX, endY, endX, startY)

//input remaining fields
Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.EditText - City (1)'), 0)

Mobile.sendKeys(findTestObject('HomePro - Sign Up/android.widget.EditText - City (1)'), city)

Mobile.tap(findTestObject('Object Repository/HomePro - Sign Up/android.widget.EditText - Postcode (2)'), 0)

Mobile.sendKeys(findTestObject('Object Repository/HomePro - Sign Up/android.widget.EditText - Postcode (2)'), '123')

Mobile.tap(findTestObject('Object Repository/HomePro - Sign Up/android.widget.TextView - Postcode (1)'), 0)

Mobile.verifyElementExist(findTestObject('HomePro - Sign Up/android.widget.TextView - Postcode required (1)'), 0)

postcode = (RandomStringUtils.randomNumeric(3) + '00')

Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.EditText - 123'), 0)

Mobile.sendKeys(findTestObject('HomePro - Sign Up/android.widget.EditText - 123'), postcode)

Mobile.tap(findTestObject('Object Repository/HomePro - Sign Up/android.widget.TextView - Postcode (1)'), 0)

Mobile.verifyElementNotExist(findTestObject('HomePro - Sign Up/android.widget.TextView - Postcode required (1)'), 2)

Mobile.tap(findTestObject('Object Repository/HomePro - Sign Up/android.widget.TextView - Choose (2)'), 0)

Mobile.tap(findTestObject('Object Repository/HomePro - Sign Up/android.widget.TextView - Wilayah Persekutuan Kuala Lumpur (1)'), 
    0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.TextView - Choosearea (1)'), 0)

Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.TextView - Ampang'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.TextView - Submit'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('HomePro - Sign Up/android.widget.TextView - Thank You'), 0)

//assert created account in DB
merchant = WS.sendRequest(findTestObject('HomePro - Sign Up/MerchantData', [('Name') : company]))

def resultDB = slurper.parseText(merchant.getResponseBodyContent())

companyName = resultDB.documents[0].name

println(companyName)

assert company == companyName

Mobile.tap(findTestObject('HomePro - Sign Up/android.widget.TextView - Got It'), 0)

Mobile.closeApplication()

