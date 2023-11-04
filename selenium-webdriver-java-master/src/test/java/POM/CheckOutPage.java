package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage {
    WebDriver driver;


    By enterAddress = By.id("billing:street1");

    By enterCity = By.id("billing:city");

    By enterStates = By.id("billing:region_id");

    By enterZip = By.id("billing:postcode");

    By enterCountry = By.id("billing:country_id");

    By enterPhoneNumber = By.id("billing:telephone");

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterAddress(String address){
        WebElement addressElement = driver.findElement(enterAddress);
        addressElement.clear();
        addressElement.sendKeys(address);
    }

    public void enterCity(String city){
        WebElement enterCityElement = driver.findElement(enterCity);
        enterCityElement.clear();
        enterCityElement.sendKeys(city);

    }

    public void enterStates (String States){
        WebElement enterStatesElement = driver.findElement(enterStates);
        enterStatesElement.clear();
        enterStatesElement.sendKeys(States);
    }
    public void enterZip (String zip){
        WebElement enterZipElement = driver.findElement(enterZip);
        enterZipElement.clear();
        enterZipElement.sendKeys();
    }

    public void enterCountry (String country){
        WebElement enterCountryElement = driver.findElement(enterCountry);
        enterCountryElement.clear();
        enterCountryElement.sendKeys();
    }
    public void setEnterPhoneNumber (String phoneNumber){
        WebElement enterPhoneNumberElement = driver.findElement(enterPhoneNumber);
        enterPhoneNumberElement.clear();
        enterPhoneNumberElement.sendKeys();

    }
    public void countinueButton(){
        driver.findElement(By.xpath("//button[@onclick='shipping.save()']//span//span[contains(text(),'Continue')]")).click();
    }
}
