package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.datalayer.DataSet;
import framework.helper.Extensions;

public class Admin_login {
	WebDriver driver;
	public Admin_login(WebDriver Driver) {
		driver = Driver;
	}
	public String logintoadminportal(String ID, String password){
		String fetch_error = null;
		String display_error = "";
		try{
			driver.get("http://spark-io-staging.herokuapp.com/admin");
			WebElement userid= driver.findElement(By.id("admin_email"));
			userid.sendKeys(ID);
			WebElement Pass= driver.findElement(By.id("admin_password"));
			Pass.sendKeys(password);
			driver.findElement(By.xpath("//*[@id='new_admin']/div[4]/input")).click();
			Extensions.WaitForPageFullyLoaded();
			WebElement titleverify = driver.findElement(By.xpath("/html/body/nav/div/div[1]/a"));
			String tiltlget= titleverify.getText();
			if (tiltlget.contains("Spark Io")){
				System.out.println("Pass");
			}
			else{
				display_error= "Not Login to admin portal";
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
		}	return display_error;
	}
}
