package tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomationPracticeIndexPageTest {

    private WebDriver driver;
    
   
    
    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1366, 768));
    }
    
    @Test
    public void buyDress() {

    	// sometimes the test fails for no apparent reason, just re-run the test and it should work
    	
    	driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.linkText("DRESSES")).click();
        driver.findElement(By.linkText("Printed Dress")).click();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        String shirtTitle = driver.findElement(By.tagName("h1")).getText();
        driver.findElement(By.name("Submit")).click();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        driver.switchTo().activeElement().findElement(By.className("button-medium")).click();
        assertEquals(shirtTitle, driver.findElement(By.linkText("Printed Dress")).getText());
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        driver.switchTo().activeElement().findElement(By.linkText("Proceed to checkout")).click();
        driver.findElement(By.id("email_create")).sendKeys("adjraasdanobpowkokokdfdajljoyowfjwai@gmail.com"); // change this if already registered
        driver.findElement(By.id("SubmitCreate")).click();
        driver.findElement(By.id("uniform-id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("raphael");
        driver.findElement(By.id("customer_lastname")).sendKeys("fywell");
        driver.findElement(By.id("passwd")).sendKeys("password567");
        Select day = new Select(driver.findElement(By.id("days")));
        day.selectByIndex(28);
        Select month = new Select(driver.findElement(By.id("months")));
        month.selectByIndex(4);
        Select year = new Select(driver.findElement(By.id("years")));
        year.selectByIndex(23);
        driver.findElement(By.id("company")).sendKeys("QA");
        driver.findElement(By.id("address1")).sendKeys("10 Park Lane");
        driver.findElement(By.id("city")).sendKeys("London");
        Select state = new Select(driver.findElement(By.id("id_state")));
        state.selectByIndex(2);
        driver.findElement(By.id("postcode")).sendKeys("90210");
        driver.findElement(By.id("phone_mobile")).sendKeys("07999666333");
        driver.findElement(By.id("alias")).sendKeys("the palace");
        driver.findElement(By.id("submitAccount")).click();
        driver.findElement(By.name("processAddress")).click();
        driver.findElement(By.id("cgv")).click();
        driver.findElement(By.name("processCarrier")).click();
        driver.findElement(By.className("cheque")).click();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        driver.switchTo().activeElement().findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
        assertEquals("Your order on My Store is complete.", driver.findElement(By.className("alert-success")).getText());



    }
}