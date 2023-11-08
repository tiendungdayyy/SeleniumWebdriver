package BaiTapDemo;

import POM.CartPage;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import POM.IndexPage;

@Test
public class TC09 {
    public static void tc08() {
        //LoginPage
        String coupon = "GURU50";
        //  Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();

        // import function from POM
        IndexPage indexPage = new IndexPage(driver);

        try {
            // 1. Open target page
            driver.get("http://live.techpanda.org/");
            // Delay Web for Performance

            // 2. Go to Mobile and add IPHONE to cart
            indexPage.setMobileLink();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // 2a.add IPHONE to cart
            indexPage.setAddToCartLink();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // 3.Enter Coupon Code
            indexPage.setEnterCouponCode(coupon);
            indexPage.setApplyLink();

            //Verify Grand Total is changed
            WebElement ActualDiscount = driver
                    .findElement(By.xpath("(//td[@colspan='1'])[3]"));
            String ExpectedDiscount = "DISCOUNT (GURU50)";
            Assert.assertEquals(ActualDiscount.getText(), ExpectedDiscount);


        } catch (Exception e) {
            e.printStackTrace();
        }
        //  Quit browser session
        driver.quit();
    }
}