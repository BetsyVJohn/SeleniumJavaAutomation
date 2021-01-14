package automation_coding_questions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
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

public class sort_VOD_Page {

	@Test
	public void sortMovies_BasedOn_YearOfRelease() throws InterruptedException, IOException, ParseException
	{

		//creating a dictionary of movie names and their years of release
		//LinkedHashMap<String,Integer> linkedHM = new LinkedHashMap<String,Integer>();

		//creating an Array List to store all movies with their Years Of Release
		List<String> movieAndYears = new ArrayList<String>();

		//Parsing data from JSON File
		JSONParser jsonParser = new JSONParser();
		FileReader fileReader = new FileReader(".\\jsonfiles\\VODPage.json");
		Object obj = jsonParser.parse(fileReader); //returns a java object
		JSONObject dropdownObject = (JSONObject)obj; //type casts the java object into JSON Object

		//Getting data from JSON file
		JSONArray movieNames_list = (JSONArray)dropdownObject.get("movie_list");
		int count = movieNames_list.size();

		//creating new array and storing JSONArray data into it.
		String[] movie_list = new String[count];
		for(int i=0; i<movieNames_list.size(); i++)
		{
			String language = (String)movieNames_list.get(i);
			movie_list[i] = language;
		}

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

		//Going to MXPlayer OTT Platform
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.mxplayer.in/movie-videos/malayalam-movies");

		//creating an Array List to store all movie names
		List<String> movieNames = new ArrayList<String>();


		//Getting movie names of all VOD
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> VODWidgetNames = driver.findElements(By.tagName("img"));
		//System.out.println(VODWidgetNames);
		Thread.sleep(3000);
		System.out.println("Movie Names Before Sorting:\n");
		int i = 1;
		for (WebElement VODWidgetName : VODWidgetNames) 
		{
			String movieName = VODWidgetName.getAttribute("title");
			if(!(movieName.equals("") || movieNames.contains(movieName)))
			{
				System.out.println("Movie name "+i+" is "+movieName);
				movieNames.add(movieName);
				i++;
			}

		}

		//
		//		//creating an Array List to store all movie names
		//		List<String> moviesYearsOfRelease = new ArrayList<String>();
		//
		//
		//		//Getting movie names of all VOD
		//		Thread.sleep(10000);
		//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//		List<WebElement> VODWidgetDescriptions = driver.findElements(By.className("text-overflow card-subheader"));
		//		System.out.println(VODWidgetDescriptions);
		//		
		//		Thread.sleep(3000);
		//		System.out.println("Movie Descriptions Before Sorting:\n");
		//		int j = 1;
		//		for (WebElement VODWidgetDescription : VODWidgetDescriptions) 
		//		{
		//			String movieDesc = VODWidgetDescription.getText();
		//			if(!(movieDesc.equals("")))
		//			{
		//				System.out.println("Description of movie "+j+" is "+movieDesc);
		//				String desc[] = movieDesc.split(",");
		//				String movieYearOfRelease = desc[2];
		//				moviesYearsOfRelease.add(movieYearOfRelease);
		//				j++;
		//			}
		//
		//		}
		System.out.println("\n\nMOVIES AND YEARS before sorting:\n");
		for (String movie : movie_list) 
		{

			Thread.sleep(3000);

			//click search button
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.mxplayer.in/");
			driver.findElement(By.cssSelector("#header > div > div > div > div.header-searchbox.inline-top > svg")).click();

			//enter text
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id=\"headerTopBar\"]/div/div/div/input[1]")).sendKeys(movie);
			driver.findElement(By.xpath("//*[@id=\"headerTopBar\"]/div/div/div/input[1]")).sendKeys(Keys.ENTER);

			//click Movies Tab
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id=\"headerTopBar\"]/div[3]/div[2]/a/div")).click();

			//click movie tile
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/div[2]/div[2]/div/div/div/div/div/a/div/div/div[2]/div[2]/div")).click();
			//driver.get("https://www.mxplayer.in/movie/watch-oru-adaar-love-movie-online-fb0b3309543dfbeb50b91f648603c840");



			List<WebElement> desc = driver.findElements(By.className("filter-url-color"));
			//String[] movieDesc = new String[10];

			//creating an Array List to store all image titles
			List<String> movieDesc = new ArrayList<String>();

			for (WebElement webElement : desc) 
			{
				String text = webElement.getText();

				if(!movieDesc.contains(text))
				{
					//System.out.println(webElement.getText());
					movieDesc.add(text);
				}
			}
			
			System.out.println("Movie Name: "+movie);
			System.out.println("Movie Year: "+movieDesc.get(2));
			Integer year = Integer.parseInt(movieDesc.get(2));
			String movieAndYear = movieDesc.get(2) + ":" + movie;
			movieAndYears.add(movieAndYear);

		}

		//sorting movies based on year
		Collections.sort(movieAndYears);
		System.out.println(movieAndYears);
		
		//printing ArrayList after sorting  
		int j=1;
		System.out.println("\nMovie Names and Years After Sorting in ascending order:\n");  
		for(String movieAndYear: movieAndYears)  
		{  
			String desc[] = movieAndYear.split(":");
			System.out.println("\nMovie name "+j+" is "+desc[1]);  
			System.out.println("Year of movie "+desc[1]+" is "+desc[0]);
			j++;
		}  



		//wait and quit
		Thread.sleep(3000);
		driver.quit();


	}

}
