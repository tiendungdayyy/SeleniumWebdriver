package BaiTapDemo;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import POM.LoginPage;

@Test
    public class TC06 {
    public static void tc06(){
        String email_address ="nguyendinhtiendung113@gmail.com";
        String password ="123456";
        String zip = "10000";
//1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //2. Open target page
            driver.get("http://live.techpanda.org/");
            LoginPage loginPage = new LoginPage(driver);

           // 3. Click on "My Account" link
            WebElement account = driver.findElement(By.xpath("//span[@class='label'][normalize-space()='Account']"));
            account.click();

            WebElement myAccountLink = driver.findElement(By.xpath("//div[@id='header-account']//a[@title='My Account'][normalize-space()='My Account']"));
            myAccountLink.click();
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            //4.Login in application using previously created credential
            loginPage.enterEmailAddress(email_address);
            loginPage.enterPassword(password);
            loginPage.loginButton();
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            //5. Click on wishlist
            WebElement myWishList = driver.findElement(By.xpath("//a[normalize-space()='My Wishlist']"));
            myWishList.click();

            //Go to add to cart
            WebElement addToCart = driver.findElement(By.xpath("//button[@title='Add to Cart']"));
            addToCart.click();

            //Choose country
            WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
            country.sendKeys("United States");

            WebElement states = driver.findElement(By.xpath("//select[@id='region_id']"));
            states.sendKeys("Texas");

            WebElement zipCode = driver.findElement(By.xpath("//input[@id='postcode']"));
            zipCode.clear();
            zipCode.sendKeys(zip);

            //click estimate
            WebElement estimateButton = driver.findElement(By.xpath("//span[contains(text(),'Estimate')]"));
            estimateButton.click();

                //verify
                WebElement flatRate = driver.findElement(By.xpath("//dt[normalize-space()='Flat Rate']"));
                String expectedFlatRate = "Flat Rate";

                try {
                    //Assert.assertEquals(expectedMessageWishlist, messageWishlist.getText());
                    Assert.assertEquals(expectedFlatRate, flatRate.getText());
                }catch (Exception e) {
                    e.printStackTrace();
                }
            // choose Fixed
            WebElement fixed = driver.findElement(By.xpath("//label[@for='s_method_flatrate_flatrate']"));
            fixed.click();

            WebElement updateTotal = driver.findElement(By.xpath("//span[contains(text(),'Update Total')]"));
            updateTotal.click();

            WebElement shipCost = driver.findElement(By.xpath("//strong[normalize-space()='Grand Total']"));
            String expectedTotal = "GRAND TOTAL";
            try {
                //Assert.assertEquals(expectedMessageWishlist, messageWishlist.getText());
                Assert.assertEquals(expectedTotal, shipCost.getText());
            }catch (Exception e) {
                e.printStackTrace();
            }

            WebElement checkOutButton = driver.findElement(By.xpath("//li[@class='method-checkout-cart-methods-onepage-bottom']//button[@title='Proceed to Checkout']"));
            checkOutButton.click();
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            WebElement company = driver.findElement(By.xpath("//input[@id='billing:company']"));
            company.clear();
            company.sendKeys("123");

            WebElement address = driver.findElement(By.xpath("//input[@id='billing:street1']"));
            address.clear();
            address.sendKeys("123 dasd");

            WebElement city = driver.findElement(By.xpath("//input[@id='billing:city']"));
            city.clear();
            city.sendKeys("Houston");


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
