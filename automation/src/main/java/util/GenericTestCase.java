package util;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

    /**
     *
     * Created by Ovidiu Moscaliuc on 06/05/2017.
     *
     * Generic testcase class that contains:
     * -Setup and Tear down methods inherited by all tests
     * -Load of webdriver and environment properties
     *
     */
    public class GenericTestCase {

        private static final Properties testProperties = new Properties();
        public ChromeDriver driver;

        @Before
        public void setUp(){
            setChromeDriverPath();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            URL(getFrontendBaseUrl());
        }

        @After
        public void tearDown()
        {
            driver.quit();
        }

        public void URL(String pageURL)
        {
            driver.get(pageURL);
        }

        static {
            try (InputStream is = GenericTestCase.class.getClassLoader().getResourceAsStream("environment.properties")) {
                testProperties.load(is);
                testProperties.putAll(System.getProperties());
            } catch (IOException e) {
                throw new NoSuchElementException("'/environment.properties' resource");
            }
        }

        public String getFrontendBaseUrl() {
            return getTestProperty("frontend.baseUrl");
        }

        private static String getTestProperty(String key) {
            if (testProperties.containsKey(key))
                return testProperties.getProperty(key);
            if (testProperties.containsKey("env"))
                if (testProperties.containsKey(testProperties.get("env") + "." + key))
                    return testProperties.getProperty(testProperties.get("env") + "." + key);
            throw new NoSuchElementException("environment.properties " + key + " not found!");
        }

        private void setChromeDriverPath() {
            String driverExecutableLocation ="./src/main/resources/win_chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverExecutableLocation);
        }
    }
