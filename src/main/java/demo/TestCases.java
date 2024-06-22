package demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        //driver.close();
        //driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));

        driver.get("https://www.google.com");
        Thread.sleep(2000);

        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.contains("google")){
            System.out.println("URl is verified");

        }else{
            System.out.println("URl is not verified");

        }

        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys("calculator");

        WebElement submitButton = driver.findElement(By.xpath("(//input[@value='Google Search'])[1]"));
        submitButton.click();

       WebElement googleCalc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@jscontroller='qxNryb']")));
       
       if(googleCalc.isDisplayed()){
        System.out.println("Google Calculator is displayed");
       }else{
        System.out.println("Google Calculator is not displayed");

       }

       WebElement display = driver.findElement(By.id("cwos"));
       String displayText = display.getText();

       if(displayText.equals("0")){
        System.out.println("Initial display is zero");

       }else{
        System.out.println("Initial display is not zero");

       }

        System.out.println("end Test case: testCase01");
    }

    public  void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");
     
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement five = driver.findElement(By.xpath("//div[text()='5']"));
        five.click();

        WebElement addition = driver.findElement(By.xpath("//div[text()='+']"));
        addition.click();

        WebElement seven = driver.findElement(By.xpath("//div[text()='7']"));
        seven.click();
   
        WebElement equal = driver.findElement(By.xpath("//div[text()='=']"));
        equal.click();
       
        WebElement adddisplay = driver.findElement(By.id("cwos"));
        String adddisplayText = adddisplay.getText();
 
        if(adddisplayText.equals("12")){
         System.out.println("the displayed result is correct");
 
        }else{
         System.out.println("the displayed result is not correct");
 
        }
        Thread.sleep(2000);

        WebElement one = driver.findElement(By.xpath("//div[text()='1']"));
        one.click();

        WebElement onefive = driver.findElement(By.xpath("//div[text()='5']"));
        onefive.click();

        WebElement subtraction = driver.findElement(By.xpath("//div[@aria-label='minus']"));
        subtraction.click();

        WebElement eight = driver.findElement(By.xpath("//div[text()='8']"));
        eight.click();

        WebElement equals = driver.findElement(By.xpath("//div[text()='=']"));
        equals.click();

        WebElement subdisplay = driver.findElement(By.id("cwos"));
        String subdisplayText = subdisplay.getText();
 
        if(subdisplayText.equals("7")){
         System.out.println("the displayed result is correct");
 
        }else{
         System.out.println("the displayed result is not correct");
 
        }
   
    }

    public void testCase03(){
        System.out.println("Start Test case: testCase03");

        WebElement one = driver.findElement(By.xpath("//div[text()='1']"));
        one.click();

        WebElement zero = driver.findElement(By.xpath("//div[text()='0']"));
        zero.click();

        WebElement multiply = driver.findElement(By.xpath("//div[@aria-label='multiply']"));
        multiply.click();

        WebElement three = driver.findElement(By.xpath("//div[text()='3']"));
        three.click();

        WebElement equals = driver.findElement(By.xpath("//div[text()='=']"));
        equals.click();

        WebElement muldisplay = driver.findElement(By.id("cwos"));
        String muldisplayText = muldisplay.getText();
 
        if(muldisplayText.equals("30")){
         System.out.println("the displayed result is correct");
 
        }else{
         System.out.println("the displayed result is not correct");
 
        }

        WebElement allClear = driver.findElement(By.xpath("//div[@aria-label='all clear']"));
        allClear.click();

        WebElement cleardisplay = driver.findElement(By.id("cwos"));
        String cleardisplayText = cleardisplay.getText();
 
        if(cleardisplayText.equals("0")){
         System.out.println("All display is clear");
 
        }else{
         System.out.println("All display is not clear");
 
        }

   
    }

    public  void testCase04(){  

        System.out.println("Start Test case: testCase04");

        WebElement two = driver.findElement(By.xpath("//div[text()='2']"));
        two.click();

        WebElement zero = driver.findElement(By.xpath("//div[text()='0']"));
        zero.click();

        WebElement division = driver.findElement(By.xpath("//div[@aria-label='divide']"));
        division.click();

        WebElement four = driver.findElement(By.xpath("//div[text()='4']"));
        four.click();

        WebElement equals = driver.findElement(By.xpath("//div[text()='=']"));
        equals.click();

        WebElement divdisplay = driver.findElement(By.id("cwos"));
        String divdisplayText = divdisplay.getText();
 
        if(divdisplayText.equals("5")){
         System.out.println("the displayed result is correct");
 
        }else{
         System.out.println("the displayed result is not correct");
 
        }

    }

}
