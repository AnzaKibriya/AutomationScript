package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
	public String GotoProfilePage() {
		String fetch_error = null;
		String display_error = "";
		try{
			driver.findElement(By.xpath("//*[@id='example-menu']/div[2]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='example-menu']/div[2]/ul/li[2]/ul/li/div[1]/div[1]/section[1]/ul/li[1]/a")).click();
			Extensions.WaitForPageFullyLoaded();
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
		
	public String GotoVenturePage(){
		String fetch_error = null;
		String display_error = "";
		try{
			driver.findElement(By.xpath("//*[@id='example-menu']/div[2]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='example-menu']/div[2]/ul/li[2]/ul/li/div[1]/div[1]/section[2]/ul/li[3]/a")).click();
			Extensions.WaitForPageFullyLoaded();
//			Actions action = new Actions(driver);
//			WebElement we = driver.findElement(By.xpath("//*[@id='example-menu']/div[2]/ul/li[5]/a/img"));//*[@id="example-menu"]/div[2]/ul/li[5]/a/img
//			action.moveToElement(we).perform();
//			Thread.sleep(1000);
//			WebElement path = driver.findElement(By.xpath("//*[@id='example-menu']/div[2]/ul/li[5]/ul/li[1]/a"));
//			action.moveToElement(path).click().perform();
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
	public String GoToNetworkPage(){
		String fetch_error = null;
		String display_error = "";
		try{
			driver.findElement(By.xpath("//*[@id='example-menu']/div[2]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='example-menu']/div[2]/ul/li[2]/ul/li/div[1]/div[1]/section[1]/ul/li[2]/a")).click();
			Extensions.WaitForPageFullyLoaded();
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
//	    	 System.out.println(error);
	    	 String[] errorarray = fetch_error.split("Command duration or timeout");
	    	 for(String w :errorarray){  
	         System.out.println(w);
	         display_error = w;
	         break;
	     }
			
		}
			}	return display_error;}
	
	public String GoToSearchPage(){
		String fetch_error = null;
		String display_error = "";
		try{
			driver.findElement(By.xpath("//*[@id='example-menu']/div[2]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='example-menu']/div[2]/ul/li[2]/ul/li/div[1]/div[1]/section[2]/ul/li[2]/a")).click();
			Extensions.WaitForPageFullyLoaded();
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
//	    	 System.out.println(error);
	    	 String[] errorarray = fetch_error.split("Command duration or timeout");
	    	 for(String w :errorarray){  
	         System.out.println(w);
	         display_error = w;
	         break;
	     }
			
		}
			}	return display_error;}
	
		
}
