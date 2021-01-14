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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class choose_from_dropdown_list 
{

	@Test
	public void dropdown_choose_languages() throws IOException, ParseException, InterruptedException
	{
		//Parsing data from JSON File
		JSONParser jsonParser = new JSONParser();
		FileReader fileReader = new FileReader(".\\jsonfiles\\languageSettings.json");
		Object obj = jsonParser.parse(fileReader); //returns a java object
		JSONObject dropdownObject = (JSONObject)obj; //type casts the java object into JSON Object

		//Getting data from JSON file
		String emailValid1 = (String)dropdownObject.get("emailValid1");
		String passwordValid1 = (String)dropdownObject.get("passwordValid1");
		String display_language = (String)dropdownObject.get("display_language");

		JSONArray content_language_list = (JSONArray)dropdownObject.get("content_language");
		int count = content_language_list.size();

		//creating new array and storing JSONArray data into it.
		String[] language_list = new String[count];
		for(int i=0; i<content_language_list.size(); i++)
		{
			String language = (String)content_language_list.get(i);
			language_list[i] = language;
		}

		//setting browser options
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--enable-javascript");
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);

		//Creating WebDriver instance
		@SuppressWarnings("deprecation")
		WebDriver driver = new ChromeDriver(desiredCapabilities);

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

		//Selecting Language Settings button
		driver.findElement(By.id("languageBtn")).click();

		//Selecting Display_language tab
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div[3]/div[1]/div/div/div[1]/div[2]")).click();

		Thread.sleep(3000);
		//selecting display language
		if(display_language.equalsIgnoreCase("English"))
		{
			Thread.sleep(3000);
			WebElement elem = driver.findElement(By.xpath("//*[text()='English']"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			elem.click();
			Thread.sleep(3000);
			System.out.println("Display Language selected: "+display_language);
			
		}
		else if(display_language.equalsIgnoreCase("Hindi"))
		{
			Thread.sleep(3000);
			WebElement elem = driver.findElement(By.xpath("//*[text()='Hindi']"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			elem.click();
			Thread.sleep(3000);
			System.out.println("Display Language selected: "+display_language);
		}
		else if(display_language.equalsIgnoreCase("Bengali"))
		{
			Thread.sleep(3000);
			WebElement elem = driver.findElement(By.xpath("//*[text()='Bengali']"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			elem.click();
			Thread.sleep(3000);
			System.out.println("Display Language selected: "+display_language);
		}
		else if(display_language.equalsIgnoreCase("Malayalam"))
		{
			Thread.sleep(3000);
			WebElement elem = driver.findElement(By.xpath("//*[text()='Malayalam']"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			elem.click();
			Thread.sleep(3000);
			System.out.println("Display Language selected: "+display_language);
		}
		else if(display_language.equalsIgnoreCase("Tamil"))
		{
			Thread.sleep(3000);
			WebElement elem = driver.findElement(By.xpath("//*[text()='Tamil']"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			elem.click();
			Thread.sleep(3000);
			System.out.println("Display Language selected: "+display_language);
		}
		else if(display_language.equalsIgnoreCase("Telugu"))
		{
			Thread.sleep(3000);
			WebElement elem = driver.findElement(By.xpath("//*[text()='Telugu']"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			elem.click();
			Thread.sleep(3000);
			System.out.println("Display Language selected: "+display_language);
		}
		else if(display_language.equalsIgnoreCase("Kannada"))
		{
			Thread.sleep(3000);
			WebElement elem = driver.findElement(By.xpath("//*[text()='Kannada']"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			elem.click();
			Thread.sleep(3000);
			System.out.println("Display Language selected: "+display_language);
		}
		else if(display_language.equalsIgnoreCase("Marathi"))
		{
			Thread.sleep(3000);
			WebElement elem = driver.findElement(By.xpath("//*[text()='Marathi']"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			elem.click();
			Thread.sleep(3000);
			System.out.println("Display Language selected: "+display_language);
		}
		else if(display_language.equalsIgnoreCase("Odia"))
		{
			Thread.sleep(3000);
			WebElement elem = driver.findElement(By.xpath("//*[text()='Odia']"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			elem.click();
			Thread.sleep(3000);
			System.out.println("Display Language selected: "+display_language);
		}
		else if(display_language.equalsIgnoreCase("Bhojpuri"))
		{
			Thread.sleep(3000);
			WebElement elem = driver.findElement(By.xpath("//*[text()='Bhojpuri']"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			elem.click();
			System.out.println("Display Language selected: "+display_language);
		}
		else if(display_language.equalsIgnoreCase("Gujarati"))
		{
			Thread.sleep(3000);
			WebElement elem = driver.findElement(By.xpath("//*[text()='Gujarati']"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			elem.click();
			Thread.sleep(3000);
			System.out.println("Display Language selected: "+display_language);
		}
		else if(display_language.equalsIgnoreCase("Punjabi"))
		{
			Thread.sleep(3000);
			WebElement elem = driver.findElement(By.xpath("//*[text()='Punjabi']"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			elem.click();
			Thread.sleep(3000);
			System.out.println("Display Language selected: "+display_language);
		}	

		//selecting content language tab
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div[3]/div[1]/div/div/div[1]/div[3]")).click();

		//Disabling default languages
		Thread.sleep(3000);
		//disabling "Hindi"
		WebElement elem1 = driver.findElement(By.xpath("//*[text()='Hindi']"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		elem1.click();
		Thread.sleep(3000);
		//disabling "English"
		WebElement elem2 = driver.findElement(By.xpath("//*[text()='English']"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		elem2.click();
		Thread.sleep(3000);
		//disabling "Marathi"
		WebElement elem3 = driver.findElement(By.xpath("//*[text()='Marathi']"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		elem3.click();
		Thread.sleep(3000);
		
		
		//iterating through language_list and selecting content language
		for (String language : language_list) 
		{
			try
			{
				Thread.sleep(3000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}

			if(language.equalsIgnoreCase("English"))
			{
				WebElement elem = driver.findElement(By.xpath("//*[text()='English']"));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				elem.click();
				System.out.println("Content Language selected: "+language);
			}
			else if(language.equalsIgnoreCase("Hindi"))
			{
				WebElement elem = driver.findElement(By.xpath("//*[text()='Hindi']"));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				elem.click();
				System.out.println("Content Language selected: "+language);
			}
			else if(language.equalsIgnoreCase("Bengali"))
			{
				WebElement elem = driver.findElement(By.xpath("//*[text()='Bengali']"));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				elem.click();
				System.out.println("Content Language selected: "+language);
			}
			else if(language.equalsIgnoreCase("Malayalam"))
			{
				WebElement elem = driver.findElement(By.xpath("//*[text()='Malayalam']"));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				elem.click();
				System.out.println("Content Language selected: "+language);
			}
			else if(language.equalsIgnoreCase("Tamil"))
			{
				WebElement elem = driver.findElement(By.xpath("//*[text()='Tamil']"));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				elem.click();
				System.out.println("Content Language selected: "+language);
			}
			else if(language.equalsIgnoreCase("Telugu"))
			{
				WebElement elem = driver.findElement(By.xpath("//*[text()='Telugu']"));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				elem.click();
				System.out.println("Content Language selected: "+language);
			}
			else if(language.equalsIgnoreCase("Kannada"))
			{
				WebElement elem = driver.findElement(By.xpath("//*[text()='Kannada']"));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				elem.click();
				System.out.println("Content Language selected: "+language);
			}
			else if(language.equalsIgnoreCase("Marathi"))
			{
				WebElement elem = driver.findElement(By.xpath("//*[text()='Marathi']"));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				elem.click();
				System.out.println("Content Language selected: "+language);
			}
			else if(language.equalsIgnoreCase("Odia"))
			{
				WebElement elem = driver.findElement(By.xpath("//*[text()='Odia']"));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				elem.click();
				System.out.println("Content Language selected: "+language);
			}
			else if(language.equalsIgnoreCase("Bhojpuri"))
			{
				WebElement elem = driver.findElement(By.xpath("//*[text()='Bhojpuri']"));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				elem.click();
				System.out.println("Content Language selected: "+language);
			}
			else if(language.equalsIgnoreCase("Gujarati"))
			{
				WebElement elem = driver.findElement(By.xpath("//*[text()='Gujarati']"));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				elem.click();
				System.out.println("Content Language selected: "+language);
			}
			else if(language.equalsIgnoreCase("Punjabi"))
			{
				WebElement elem = driver.findElement(By.xpath("//*[text()='Punjabi']"));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				elem.click();
				System.out.println("Content Language selected: "+language);
			}	
		}
		
		//Click Apply button
		try 
		{
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div[3]/div[1]/div/div/div[3]/div[2]/div")).click();
	

		//wait for 5s
		Thread.sleep(5000);
		driver.quit();


	}


}
