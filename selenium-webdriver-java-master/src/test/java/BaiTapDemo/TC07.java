package BaiTapDemo;

import POM.LoginPage;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class TC07 {
    public static void tc07() {
            String email_address ="nguyendinhtiendung113@gmail.com";
            String password ="123456";


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

            loginPage.enterEmailAddress(email_address);
            loginPage.enterPassword(password);
            loginPage.loginButton();
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            WebElement myOrders = driver.findElement(By.xpath("//a[normalize-space()='My Orders']"));
            myOrders.click();

            WebElement viewOrders = driver.findElement(By.xpath("//a[normalize-space()='View Order']"));
            viewOrders.click();

            WebElement printOrders = driver.findElement(By.xpath("//a[@class='link-print']"));
            printOrders.click();


        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}