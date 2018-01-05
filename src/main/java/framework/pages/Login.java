package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.datalayer.DataSet;
import framework.helper.Extensions;

public class Login {
	WebDriver driver;
	public Login(WebDriver Driver) {
		driver = Driver;
	}
	public String LogintoSpark() {
		String fetch_error = null;
		String display_error = "";
		try{
		driver.get(DataSet.baseURL);
		WebElement Elem = driver.findElement(By.linkText("Apply to Spark xyz"));
		Elem.click();
		Extensions.WaitForPageFullyLoaded();
		Extensions.ScrollDownPage();
		WebElement elem1= driver.findElement(By.className("facebook-btn"));
		elem1.click();
		WebElement EmailElem = driver.findElement(By.id("email"));
		EmailElem.sendKeys("anzakibria@outlook.com");
		WebElement Pswd = driver.findElement(By.id("pass"));
		Pswd.sendKeys("126131ANZ@");
		WebElement Elembtn= driver.findElement(By.id("loginbutton"));
		Elembtn.click(); 
		}
		catch(Exception e){
		    System. out.println("In Exception block.");
		    fetch_error = e.getMessage();
		}
		finally{
			try{
				driver.findElement(By.className("error-message"));
				System.out.println("On Error page '404 error' ");
			}
			catch(Exception e){
				System.out.println("blah");
			}
    	 //System.out.println(error);
    	 if (fetch_error != null){
    	 fetch_error = fetch_error.toString();
//    	 System.out.println(error);
    	 String[] errorarray = fetch_error.split("Command duration or timeout");
    	 for(String w :errorarray){  
         System.out.println(w);
         display_error = w;
         break;
     }
		
	}
		}	return display_error;}

}
