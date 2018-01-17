package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.helper.Extensions;

public class Navigation_Page {
	WebDriver driver;
	public Navigation_Page(WebDriver Driver) {
		driver = Driver;
	}
	public String GotoVentureCreation() {
		String fetch_error = null;
		String display_error = "";
		try{
			Extensions.WaitForPageFullyLoaded();
			driver.findElement(By.linkText("+ New Venture")).click();
			Extensions.WaitForPageFullyLoaded();
			WebElement header1 =  driver.findElement(By.className("header"));
			String Header = header1.getText();
			if (Header.contains("Create a New Venture")){
				System.out.println("On Create Venture Successfully");
			}
			else{
				display_error= "Error: Can't reach on Venture Creation Page";
			}
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