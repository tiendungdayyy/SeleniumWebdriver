package BaiTapDemo;

import POM.CartPage;
import POM.LoginPage;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class TC08 {

    String emailAddress ="minhlevu1642003@gmail.com";
    String password ="Lemon@1604";

    public static void tc01() {

        //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        LoginPage loginPage = new LoginPage(driver);

        try {
            //2. Open target page
            driver.get("http://live.techpanda.org/");

            WebElement account = driver.findElement(By.xpath("//span[@class='label'][normalize-space()='Account']"));
            account.click();

            WebElement myAccount = driver.findElement(By.xpath("//div[@id='header-account']//a[@title='My Account'][normalize-space()='My Account']"));
            myAccount.click();

            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            loginPage.enterEmailAddress("minhlevu1642003@gmail.com");
            loginPage.enterPassword("Lemon@1604");
            loginPage.loginButton();

            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            WebElement reOrders = driver.findElement(By.xpath("//a[@class='link-reorder']"));
            reOrders.click();

            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // belong to 4. ( take first value)


            WebElement changeQTY = driver.findElement(By.xpath("//input[@title='Qty']"));
//            changeQTY.click();
            changeQTY.clear();
            changeQTY.sendKeys("10");

            WebElement firstValues = driver
                    .findElement(By.xpath("//td[@class='a-right']//span"));
            String grandTotalFirstValues = firstValues.getText();

            WebElement update = driver.findElement(By.xpath("//button[@title='Update']//span//span[contains(text(),'Update')]"));
            update.click();

            WebElement secondValues = driver
                    .findElement(By.xpath("//td[@class='a-right']//span"));
            String grandTotalSecondValues = secondValues.getText();
            Assert.assertNotEquals("Grand Total price not match", grandTotalFirstValues, grandTotalSecondValues);

            WebElement checkoutButton = driver.findElement(By.xpath("//li[@class='method-checkout-cart-methods-onepage-bottom']//button[@title='Proceed to Checkout']//span//span[contains(text(),'Proceed to Checkout')]"));
            checkoutButton.click();

            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            WebElement countinueButton = driver.findElement(By.xpath("//button[@onclick='billing.save()']//span//span[contains(text(),'Continue')]"));
            countinueButton.click();

            Thread.sleep(2000);
            WebElement  shipButton = driver.findElement(By.xpath("(//span[text()='Continue'])[3]"));
            shipButton.click();

            Thread.sleep(2000);
            WebElement checkButton = driver.findElement(By.xpath("//input[@id='p_method_checkmo']"));
            checkButton.click();

            Thread.sleep(2000);
            WebElement payButton = driver.findElement(By.xpath("//button[@onclick='payment.save()']"));
            payButton.click();

            Thread.sleep(2000);
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            WebElement orderReview = driver.findElement(By.xpath("//button[@title='Place Order']"));
            orderReview.click();
            Thread.sleep(2000);

            WebElement secondValuesForCheck = driver
                    .findElement(By.xpath("//h1[normalize-space()='Your order has been received.']"));
            String grandTotalSecondValuesForCheck = secondValues.getText();
            Assert.assertNotEquals("YOUR ORDER HAS BEEN RECEIVED.", grandTotalFirstValues, grandTotalSecondValues);



    }catch (Exception e){
        e.printStackTrace();
    }
        driver.quit();
    }
}
