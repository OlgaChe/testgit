import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.apache.xpath.SourceTree;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestJava {

 /*   ArrayList<TestJava> cars = new ArrayList<TestJava>();
    static String name;
    static String dvd;

    public String getDvd() {
        return dvd;
    }

    public void setDvd(String dvd) {
        this.dvd = dvd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestJava(String name, String dvd) {
        setName(name);
        setDvd(dvd);
    }

    public void test() throws InterruptedException {
        TestJava mass = new TestJava(name, dvd);
        WebDriver ffdriver = new FirefoxDriver();
        System.out.println("Launch Firefox..");
        ffdriver.get("http://demos.telerik.com/aspnet-ajax/carrental/");
        System.out.println("FireFox is opened.");

        List<WebElement> list = ffdriver.findElements(By.cssSelector("img[id]"));
        for (WebElement i : list){
            i.click();
            Thread.sleep(2000);
            WebElement namec =  ffdriver.findElement(By.cssSelector("em"));
            name = namec.getText();
            System.out.println(name);
            ffdriver.switchTo().frame( "rwVehicleFleet" );
            // WebElement dvd = ffdriver.findElement(By.xpath("./*//*[@id='fvDetails_description']/ul/li[2]/span"));
            WebElement dvdc = ffdriver.findElement(By.cssSelector("div [id='fvDetails_description'] ul li:nth-child(2) span"));
            dvd = dvdc.getText();
            System.out.println(dvdc.getText());
            ffdriver.switchTo().defaultContent();
            Thread.sleep(2000);
            ffdriver.findElement(By.className("rwCloseButton")).click();
            mass.setName(name);
            mass.setDvd(dvd);
            mass.cars.add(this);

        }

        System.out.println(list.size());
    }

        public void out() {
        for (TestJava j:cars) {
            System.out.println(j.getName() + " " + j.getDvd());
        }
    }*/

   // }

    static public void main(String[] args) throws MalformedURLException, InterruptedException {
        /*String name = null;
        String dvd = null;
        TestJava test = new TestJava(name, dvd);
        test.test();
        test.out();*/
        int j = 0;

        WebDriver ffdriver = new FirefoxDriver();
        System.out.println("Launch Firefox..");
        ffdriver.get("http://demos.telerik.com/aspnet-ajax/carrental/");
        System.out.println("FireFox is opened.");

        List<WebElement> list = ffdriver.findElements(By.cssSelector(".rlvI a"));
        for (WebElement i : list){
            i.click();
            ffdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            WebElement namec =  ffdriver.findElement(By.cssSelector("em"));
            String name = namec.getText();

            ffdriver.switchTo().frame( "rwVehicleFleet" );
           // WebElement dvd = ffdriver.findElement(By.xpath("./*//*[@id='fvDetails_description']/ul/li[2]/span"));
            WebElement dvdc = ffdriver.findElement(By.cssSelector("div [id='fvDetails_description'] ul li:nth-child(2) span"));
            String dvd = dvdc.getText();

            ffdriver.switchTo().defaultContent();
            ffdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS) ;
            ffdriver.findElement(By.className("rwCloseButton")).click();
            if (dvd.equals("Yes"))
                j = j + 1;
            System.out.println(name + "  " + dvd);

        }
        System.out.println("Total number of cars with dvd: " + j);





//---------------------------------------DragAndDroptest-------------------------------------------/
    /*	WebDriver ffdriver = new FirefoxDriver();
        System.out.println("Launch Firefox..");
        ffdriver.get("http://demos.telerik.com/aspnet-ajax/listview/examples/itemdragdrop/defaultcs.aspx");
        System.out.println("FireFox is opened.");

        ///-------First Check
        try {
            ffdriver.findElement(By.id("ctl00_ContentPlaceHolder1_GenresRepeater_ctl01_GenreLink")).click();
            System.out.println("15");
            Thread.sleep(5000);
            ffdriver.findElement(By.xpath("//h3[contains(.,'\n" +
                    "                                \n" +
                    "                                Ave Maria')]"));

            System.out.println("Element found");
        }
        catch (Exception ex) {
            System.out.println("Element not found");
        }


        ///-------Second Check
        try {
            ffdriver.findElement(By.id("ctl00_ContentPlaceHolder1_GenresRepeater_ctl00_GenreLink")).click();
            Thread.sleep(5000);
            ffdriver.findElement(By.xpath("//h3[contains(.,'\n" +
                    "                                \n" +
                    "                                Ave Maria')]"));
            System.out.println("Element found");
        }
        catch (Exception ex) {
            System.out.println("Element not found");
        }


        Thread.sleep(5000);
        Actions builder = new Actions(ffdriver);

        builder.dragAndDrop(ffdriver.findElement(By.id("ctl00_ContentPlaceHolder1_RadListView1_ctrl5_RadListViewItemDragHandle1")), ffdriver.findElement(By.id("ctl00_ContentPlaceHolder1_GenresRepeater_ctl01_GenreLink"))).build().perform();
        System.out.println("Move Finished");

        //ffdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

       Thread.sleep(3000);



        ///-------Third Check
        try{
            ffdriver.findElement(By.id("ctl00_ContentPlaceHolder1_GenresRepeater_ctl01_GenreLink")).click();
            Thread.sleep(5000);
            ffdriver.findElement(By.xpath("//h3[contains(.,'\n" +
                    "                                \n" +
                    "                                Ave Maria')]"));

            System.out.println("Element found");
        }

        catch (Exception ex) {
            System.out.println("Element not found");
        }

        ///-------Fourth Check
        try {
            ffdriver.findElement(By.id("ctl00_ContentPlaceHolder1_GenresRepeater_ctl00_GenreLink")).click();
            Thread.sleep(5000);
            ffdriver.findElement(By.xpath("//h3[contains(.,'\n" +
                    "                                \n" +
                    "                                Ave Maria')]"));

            System.out.println("Element found");
        }
        catch (Exception ex) {
            System.out.println("Element not found");
        }*/
    	/*WebDriver ffdriver = new FirefoxDriver();
        System.out.println("Launch Firefox..");
        ffdriver.get("http://demos.telerik.com/aspnet-ajax/listview/examples/itemdragdrop/defaultcs.aspx");
        System.out.println("FireFox is opened.");


        ///-------First Check
        try {
        ffdriver.findElement(By.id("ctl00_ContentPlaceHolder1_GenresRepeater_ctl01_GenreLink")).click();
        System.out.println("15");
        Thread.sleep(5000);
        ffdriver.findElement(By.xpath("//h3[contains(.,'                  Ave Maria')]"));

        System.out.println("Element found");
        }
        catch (Exception ex) {
            System.out.println("Element not found");
        }


        ///-------Second Check
        try {
            ffdriver.findElement(By.id("ctl00_ContentPlaceHolder1_GenresRepeater_ctl00_GenreLink")).click();
            Thread.sleep(5000);
            ffdriver.findElement(By.xpath("//h3[contains(.,'                  Ave Maria')]"));

                System.out.println("Element found");
        }
        catch (Exception ex) {
                System.out.println("Element not found");
            }


        //Thread.sleep(5000);
        Actions builder = new Actions(ffdriver);

        builder.dragAndDrop(ffdriver.findElement(By.id("ctl00_ContentPlaceHolder1_RadListView1_ctrl5_RadListViewItemDragHandle1")), ffdriver.findElement(By.id("ctl00_ContentPlaceHolder1_GenresRepeater_ctl01_GenreLink"))).build().perform();


          ///-------Move Element
       builder.clickAndHold(ffdriver.findElement(By.id("ctl00_ContentPlaceHolder1_RadListView1_ctrl5_RadListViewItemDragHandle1"))).build().perform();
        builder.moveToElement(ffdriver.findElement(By.id("ctl00_ContentPlaceHolder1_GenresRepeater_ctl01_GenreLink"))).build().perform();
        builder.click(ffdriver.findElement(By.id("ctl00_ContentPlaceHolder1_GenresRepeater_ctl01_GenreLink"))).build().perform();

        System.out.println("Move Finished");
        //ffdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);//why not working?
        Thread.sleep(2000);


        ///-------Third Check
        try{
        ffdriver.findElement(By.id("ctl00_ContentPlaceHolder1_GenresRepeater_ctl01_GenreLink")).click();
        Thread.sleep(10000);
        ffdriver.findElement(By.xpath("//h3[contains(.,'                  Ave Maria')]"));

        System.out.println("Element found");
        }

        catch (Exception ex) {
        System.out.println("Element not found");
        }

        ///-------Fourth Check
        try {
            ffdriver.findElement(By.id("ctl00_ContentPlaceHolder1_GenresRepeater_ctl00_GenreLink")).click();
            Thread.sleep(5000);
            ffdriver.findElement(By.xpath("//h3[contains(.,'                  Ave Maria')]"));

            System.out.println("Element found");
        }
        catch (Exception ex) {
            System.out.println("Element not found");
        }
*/



       

/*-----------------------------------------------------Pop-up window---------------------------------------------------*/
 
/*WebDriver ffdriver = new FirefoxDriver();
System.out.println("Launch Firefox..");
ffdriver.get("http://my.rozetka.com.ua/signin/");
System.out.println("FireFox is opened.");
 
WebElement facebookButton = ffdriver.findElement(By.cssSelector("img[alt='facebook']"));
 
String windowHandler = ffdriver.getWindowHandle();
facebookButton.click();
 
for (String winHandler : ffdriver.getWindowHandles()) {
ffdriver.switchTo().window(winHandler);
}
 
WebElement email = (new WebDriverWait(ffdriver, 15))
.ignoring(NoSuchElementException.class)
.pollingEvery(1, TimeUnit.SECONDS)
.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#email")));
 
email.sendKeys("beetstroop@gmail.com");
//close window
ffdriver.close();
//return to main window
ffdriver.switchTo().window(windowHandler);
 
WebElement emailMainWindow = ffdriver.findElement(By.cssSelector(".input-text"));
emailMainWindow.sendKeys("beetstroop@gmail.com");*/
 
 
 
 
 
/*-----------------------------------------------------Pop-up div-------------------------------------------------------*/
 
/*WebDriver ffdriver = new FirefoxDriver();
System.out.println("Launch Firefox..");
ffdriver.get("http:///rozetka.com.ua");
System.out.println("FireFox is opened.");
 
WebElement link = ffdriver.findElement(By.cssSelector("a[href='http://my.rozetka.com.ua/signin/']"));
link.click();
ffdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
WebElement email = ffdriver.findElement(By.name("login"));
email.sendKeys("beetstroop@gmail.com");*/
 
 
 
/*-----------------------------------------------------Ajax wait-------------------------------------------------------*/
 
/*WebDriver ffdriver = new FirefoxDriver();
System.out.println("Launch Firefox..");
ffdriver.get("http://darom.kharkov.ua/automation/4/ajax/demo.html");
System.out.println("FireFox is opened.");
 
WebElement button = ffdriver.findElement(By.linkText("Page 2"));
button.click();
ffdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//Thread.sleep(4000);
WebElement text = ffdriver.findElement(By.cssSelector("div p[id='page2']"));
System.out.println(text.getText());*/
 
 
 
 
/*-----------------------------------------------------||||||||||||||--------------------------------------------------*/
 
/*WebDriver ffdriver = new FirefoxDriver();
System.out.println("Launch Firefox..");
ffdriver.get("http://darom.kharkov.ua/automation/3/findelements.html");
System.out.println("FireFox is opened.");
WebElement element = ffdriver.findElement(By.cssSelector("form input:first-of-type"));
//element.clear();
element.sendKeys("John");
WebElement element1 = ffdriver.findElement(By.cssSelector("form input:nth-of-type(2)"));
element1.sendKeys("Doe");
WebElement element3 = ffdriver.findElement(By.id("but"));
element3.click();
System.out.println("Done");*/
/*-----------------------------------------------------Dropdown combo-ttt-------------------------------------------------*/
      /*  WebDriver ffdriver = new FirefoxDriver();
        System.out.println("Launch Firefox..");
        ffdriver.get("http://darom.kharkov.ua/automation/3/combo.html");
        System.out.println("FireFox is opened.");

        WebElement select = ffdriver.findElement(By.id("combo"));
        List<WebElement> allOptions = select.findElements(By.tagName("option"));
        for (WebElement i : allOptions) {
            System.out.println(i.getText());
        }   */
/*-----------------------------------------------------GET QUOTES------------------------------------------------------*/
/*WebDriver ffdriver = new FirefoxDriver();
System.out.println("Launch Firefox..");
ffdriver.get("http:///devanswers.ru");
System.out.println("FireFox is opened.");
 
for (int i = 1; i<11; i++) {
WebElement quote = ffdriver.findElement(By.cssSelector("h1 a span"));
quote.click();
Thread.sleep(3000);
System.out.println(i + ". "+quote.getText());
 
}
 
 
/*-----------------------------------------------------Active/Passive--------------------------------------------------*/
/*
 
WebDriver ffdriver = new FirefoxDriver();
System.out.println("Launch Firefox..");
ffdriver.get("file:///Users/kovtunov/Dropbox/forsix/IT/Java%20Dev/Qracle%20academy%20java/tasks/task3.html");
System.out.println("FireFox is opened.");
 
List<WebElement> buttons = ffdriver.findElements(By.cssSelector("[type=button]"));
 
for (WebElement test : buttons) {
WebElement textarea = ffdriver.findElement(By.tagName("textarea"));
if (test.isEnabled()){
textarea.sendKeys("Active");
}
else
textarea.sendKeys("Not Active");
Thread.sleep(3000);
textarea.clear();
}
 
 
 
List<WebElement> checkboxes = ffdriver.findElements(By.cssSelector("[type=checkbox]"));
List<WebElement> textareas = ffdriver.findElements(By.cssSelector( "textarea:not([rows='5'])"));
 
for (int i = 0; i<checkboxes.size(); i++) {
if(checkboxes.get(i).isSelected()) {
textareas.get(i).sendKeys("Checked");
} else
textareas.get(i).sendKeys("Unchecked");
Thread.sleep(3000);
 
}
*/
 
/*-----------------------------------------------------Auto input, via findElementS--------------------------------------------------*/
 
/*WebDriver ffdriver = new FirefoxDriver();
System.out.println("Launch Firefox..");
ffdriver.get("http://darom.kharkov.ua/automation/3/findelements.html");
System.out.println("FireFox is opened.");
 
List<WebElement> elements = ffdriver.findElements(By.tagName("input"));
String[] names = {"John", "Doe"};
 
for (int i=0; i<names.length; i++ ) {
elements.get(i).sendKeys(names[i]);
 
}*/
 
/*-----------------------------------------------------||||||||||||||--------------------------------------------------*/
/* WebDriver ffdriver = new FirefoxDriver();
System.out.println("Launch Firefox..");
ffdriver.get("file:///Users/kovtunov/Dropbox/forsix/IT/Java%20Dev/Qracle%20academy%20java/tasks/task3.html");
System.out.println("FireFox is opened.");*/

//List<WebElement> buttons = ffdriver.findElements(By.tagName("input"));
//String[] names = {"Is Active", "Not Active"};
 
/*WebElement element = ffdriver.findElement(By.cssSelector("form input:first-of-type"));
//element.clear();
element.sendKeys("John");
WebElement element1 = ffdriver.findElement(By.cssSelector("form input:nth-of-type(2)"));
element1.sendKeys("Doe");
WebElement element3 = ffdriver.findElement(By.id("but"));
element3.click();
System.out.println("Done");*/
 
/*element1.click();
 
ffdriver.get("file:///Users/kovtunov/Dropbox/forsix/IT/Java%20Dev/Qracle%20academy%20java/tasks/task1.html");
WebElement comboBox = ffdriver.findElement(By.name("country"));
Select countries = new Select(comboBox);
countries.selectByVisibleText("Russia");*/
 
 
 
/*if (ffdriver != null) {
ffdriver.close();
ffdriver.quit();
}*/
/*System.out.println("Firefox is closed.");
 
*//*Chrome*//*
WebDriver chromeDriver = new ChromeDriver();
System.out.println("Launch Chrome..");
chromeDriver.get("http://oracle-academy.org.ua");
System.out.println("Chrome is opened.");
 
if (chromeDriver != null) {
chromeDriver.close();
chromeDriver.quit();
}
System.out.println("Chrome is closed.");
 
*//*Safari*//*
WebDriver safariDriver = new SafariDriver();
System.out.println("Launch Safari..");
safariDriver.get("http://oracle-academy.org.ua");
System.out.println("Safari is opened.");
 
if (safariDriver != null) {
safariDriver.close();
safariDriver.quit();
}
System.out.println("Safari is closed.");
 
System.out.println("Done!");*/
 
/*HtmlUnit*//*
HtmlUnitDriver htmlDriver = new HtmlUnitDriver(BrowserVersion.);
htmlDriver.setJavascriptEnabled(true);*//**//*
 
DesiredCapabilities capabilities = DesiredCapabilities.firefox();
capabilities.setCapability("version", "21");
capabilities.setCapability("platform", Platform.WIN8);
// Create the connection to Sauce Labs to run the tests
WebDriver driver = new RemoteWebDriver(
new URL("http://qovtunov:bd0315b4-d0d6-4155-a85a-52cd2c554e2a@ondemand.saucelabs.com:80/wd/hub"),
capabilities);
 
driver.get("http://ya.ru");*/


    }
}
