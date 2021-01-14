package automation_coding_questions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class delete_item_from_list 
{
	@Test
	public void delete_from_watchlist() throws IOException, ParseException, InterruptedException
	{
		//Parsing data from JSON file
		JSONParser jsonParser = new JSONParser();
		FileReader fileReader = new FileReader(".\\jsonfiles\\watchList.json"); //parsing the JSON file
		Object obj = jsonParser.parse(fileReader);	//returns a java object
		JSONObject watchListObj = (JSONObject)obj; //type casts the java object into JSON object

		//Getting data from JSON file
		String emailValid1 = (String)watchListObj.get("emailValid1");
		String passwordValid1 = (String)watchListObj.get("passwordValid1");

		//		//Getting data from JSON file
		//		JSONArray moviesToAdd_list = (JSONArray)watchListObj.get("moviesToAdd");
		//		//creating new array and storing JSONArray data into it.
		//		int count = moviesToAdd_list.size();
		//		String[] movies_list = new String[count];
		//		
		//		//extracting each movie from the list and storing it in the newly created array
		//		for(int i=0; i<moviesToAdd_list.size(); i++)
		//		{
		//			String movie = (String)moviesToAdd_list.get(i);
		//			movies_list[i] = movie;
		//		}

		//Setting browser options
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--enable-javascript");

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		@SuppressWarnings("deprecation")
		WebDriver driver = new ChromeDriver(capabilities);

		//maximize browser window
		driver.manage().window().maximize();

		//clear browser cache
		driver.manage().deleteAllCookies();
		driver.get("chrome://settings/clearBrowserData");
		driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);

		//Going to Zee5 OTT Platform
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.zee5.com/");

		//Going to sign in page
		driver.get("https://www.zee5.com/signin");
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//Enter Email id in text field
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("userName")).sendKeys(emailValid1);
		driver.findElement(By.name("userName")).sendKeys(Keys.ENTER);

		//Enter Password in text field
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/div[2]/div[5]/div[2]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/div[2]/div[5]/div[2]/input")).sendKeys(passwordValid1);

		//Click Login Button
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/div[2]/div[7]/div[1]/div/button/span")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//Click Search button
		driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div[1]/div/a[3]")).click();

		//enter text in search bar
		driver.findElement(By.id("searchInput")).sendKeys("Christmas In New York");		
		driver.findElement(By.id("searchInput")).sendKeys(Keys.RETURN);

		//Click movies Tab
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"movies\"]")).click();

		//click corresponding movie
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/div/div[3]/div/div/div[1]/div/div[1]/figure/a/img")).click();	

		//click "Add to Watchlist" button
		Thread.sleep(3000);
		WebElement elem = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/div"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);
		Thread.sleep(3000);
		jse.executeScript("arguments[0].click()", elem);

		//Click Search button
		driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div[1]/div/a[3]")).click();

		//enter text in search bar
		driver.findElement(By.id("searchInput")).sendKeys("alexander the great");		
		driver.findElement(By.id("searchInput")).sendKeys(Keys.RETURN);

		//Click movies Tab
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"movies\"]")).click();

		//click corresponding movie
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/div/div[3]/div/div/div[1]/div/div[1]/figure/a/img")).click();	

		//click "Add to Watchlist" button
		Thread.sleep(3000);
		WebElement elem1 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/div"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem1);
		Thread.sleep(3000);
		jse.executeScript("arguments[0].click()", elem1);
		
		//click profile icon
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(".headerWrap > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > button:nth-child(2)")).click();
		
		//click "My WatchList" tab
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div[1]/div/div[2]/div[2]/div[1]/nav/div[2]/a[1]")).click();
		
		//Click "Movies" tab
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		WebElement moviesTab = driver.findElement(By.xpath("//*[@id=\"movies\"]"));
		Thread.sleep(3000);
		jse.executeScript("arguments[0].click()", moviesTab);
		
		//remove "Alexander the great" movie from watchlist
		Thread.sleep(3000);
		WebElement alexanderMovie = driver.findElement(By.cssSelector("div.watchlistContentWrapper:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > h3:nth-child(1) > a:nth-child(1)"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", alexanderMovie);
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElement(By.id("0-0-144573")).click();
		//jse.executeScript("return document.getElementById('0-0-144573').remove();");


		//wait and quit browser
		Thread.sleep(5000);
		driver.quit();


	}
}
