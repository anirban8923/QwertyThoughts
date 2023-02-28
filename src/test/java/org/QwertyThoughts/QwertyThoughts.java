package org.QwertyThoughts;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class QwertyThoughts
{

    public static WebDriver driver;


    @BeforeMethod
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\Ani\\SeleniumTesting\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize(); //To maximize the window
        driver.get("https://practicetestautomation.com/practice-test-login/");

    }

    @Test(description = "TC_001-Enter the Incorrect userName and Correct Password ", priority = 1)
    public void loginTest1() throws IOException {
        WebElement userName= driver.findElement(By.xpath("/html/body/div/div/section/section/div[1]/div[1]/input"));
                     userName.sendKeys("Test");

        WebElement password= driver.findElement(By.xpath("/html/body/div/div/section/section/div[1]/div[2]/input"));
                      password.sendKeys("Password123");


        WebElement submit=driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        submit.click();


        String actualTitle="Your username is invalid!" ;
        String expectedTitle=driver.findElement(By.xpath("//*[@id=\"error\"]")).getText();
        System.out.println("expected Title " +expectedTitle);

        Assert.assertEquals(actualTitle,expectedTitle,"Correct username and correct password Logged In");




        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File("Screenshots/" + System.currentTimeMillis()
                + ".png");
        FileUtils.copyFile(sourceFile, destFile);

    }
    @Test(description = "TC_002-Enter the Correct userName and In-Correct Password ", priority = 2)
    public void loginTest2() throws IOException {
        WebElement userName= driver.findElement(By.xpath("//*[@id=\"username\"]"));
        userName.sendKeys("student");

        WebElement password= driver.findElement(By.xpath("/html/body/div/div/section/section/div[1]/div[2]/input"));
        password.sendKeys("Test123");


        WebElement submit=driver.findElement(By.xpath("//*[@id=\"submit\"]"));
                    submit.click();


                    String actualTitle="Your password is invalid!" ;
                    String expectedTitle=driver.findElement(By.xpath("//*[@id=\"error\"]")).getText();

        Assert.assertEquals(actualTitle,expectedTitle,"Correct username and correct password Logged In");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File("Screenshots/" + System.currentTimeMillis()
                + ".png");
        FileUtils.copyFile(sourceFile, destFile);

    }


    @Test(description = "TC_003-Enter the Correct userName and Correct Password ", priority = 3)
    public void loginTest3() throws IOException {
        WebElement userName= driver.findElement(By.xpath("//*[@id=\"username\"]"));
        userName.sendKeys("student");

        WebElement password= driver.findElement(By.xpath("/html/body/div/div/section/section/div[1]/div[2]/input"));
        password.sendKeys("Password123");


        WebElement submit=driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        submit.click();



        String expectedTitle="Logged In Successfully";


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        String actualTitle= (driver.findElement(By.xpath("//h1[contains(text(),'Logged In Successfully')]")).getText());

        System.out.println("Actual Title "+actualTitle);

        Assert.assertEquals(actualTitle,expectedTitle,"Succesfully Logged In");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));


        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File("Screenshots/" + System.currentTimeMillis()
                + ".png");
        FileUtils.copyFile(sourceFile, destFile);

    }




    @AfterMethod
    public static void end()
    {
        driver.quit();
    }


}
