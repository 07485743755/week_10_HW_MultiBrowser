package MultiBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Barclay {

    static String baseUrl = "https://www.barclays.co.uk/";
    static WebDriver driver;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Browser : ");
        String browser = scan.nextLine();

        if (browser.equalsIgnoreCase("chrome")) {

            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {

            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("internet explorer")) {

            System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();

        } else if (browser.equalsIgnoreCase("microsoft edge")) {

            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            driver = new EdgeDriver();

        } else {

            System.out.println("Invalid Browser name");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);

        String title=driver.getTitle();
        System.out.println("Title : " + title);
        System.out.println("Length of title : "+ title.length());
        driver.close();

    }
}
