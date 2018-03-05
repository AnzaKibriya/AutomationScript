package framework.pages;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import framework.helper.Extensions;

public class MyNetwork {
	WebDriver driver;
	public MyNetwork(WebDriver Driver) {
		driver = Driver;
	}
	public String SearchNetwork(String ConnName){
		String fetch_error = null;
		String display_error = "";
		try{
			WebElement searchfield= driver.findElement(By.id("user_name"));
			searchfield.sendKeys(ConnName);
			driver.findElement(By.xpath("/html/body/main/section/div/form/button/i")).click();
			Extensions.WaitForPageFullyLoaded();
			WebElement Searchdiv= driver.findElement(By.id("search_results_container"));
			WebElement resultdiv = Searchdiv.findElement(By.id("search_results_list"));
			List<WebElement> resultlist = resultdiv.findElements(By.className("suggested-connections-block__item"));
			for (int i=0; i< resultlist.size();i++){
				WebElement suggestname= resultlist.get(i).findElement(By.tagName("h4"));
				String fetchname= suggestname.getText();
				if (fetchname.contains(ConnName)){
					resultlist.get(i).findElement(By.className("suggested-connections-block__connect")).click();
					break;
				}
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
	public String IgnoreRequest(String ConnName){
		String fetch_error = "";
//		String display_error = "";
		try{
			WebDriver driver2 = new ChromeDriver();
			driver2.get("https://spark-io-staging.herokuapp.com");
			driver2.findElement(By.xpath("//*[@id='example-menu']/div[2]/ul/li[4]/a")).click();		
			Extensions.WaitForPageFullyLoaded();
			Extensions.ScrollDownPage();
			WebElement elem1= driver2.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/a"));
			elem1.click();
			WebElement EmailElem = driver2.findElement(By.id("email"));
			EmailElem.sendKeys("lokatkohli@gmail.com");
			WebElement Pswd = driver2.findElement(By.id("pass"));
			Pswd.sendKeys("teamindia");
			WebElement Elembtn= driver2.findElement(By.id("loginbutton"));
			Elembtn.click(); 
			driver2.findElement(By.xpath("//*[@id='example-menu']/div[2]/ul/li[2]/a")).click();
			driver2.findElement(By.xpath("//*[@id='example-menu']/div[2]/ul/li[2]/ul/li/div[1]/div[1]/section[1]/ul/li[2]/a")).click();
			Extensions.WaitForPageFullyLoaded();
			Extensions.WaitForPageFullyLoaded();
			WebElement inviteblock = driver2.findElement(By.id("invitation_list"));
			List<WebElement> requestlist= inviteblock.findElements(By.className("invite-block__line"));
			for (int i=0; i< requestlist.size(); i++){
				WebElement namerequest = requestlist.get(i).findElement(By.tagName("h4"));
				String NameConnection= namerequest.getText();
				if (NameConnection.equals(ConnName)){
					 requestlist.get(i).findElement(By.className("invite-block__buttons--ignore")).click();
					 break;
				}
			}
			 driver2.close();
			 driver2.quit();
		}
		catch(Exception e){
		    System. out.println("In Exception block.");
		    fetch_error = e.getMessage();
		}
		return fetch_error;
	}
	
public String SendConnectionRequest(String Req_name){
	String fetch_error = null;
	String display_error = "";
	try{
		driver.navigate().refresh();
		WebElement suggestiondiv= driver.findElement(By.id("suggestion_list"));
		List<WebElement> suggestionlist= suggestiondiv.findElements(By.className("suggested-connections-block__item"));
		for (int i=0; i<= suggestionlist.size();i++){
			WebElement suggestname= suggestionlist.get(i).findElement(By.tagName("h4"));
			String fetchname= suggestname.getText();
			if (fetchname.equals(Req_name)){
				suggestionlist.get(i).findElement(By.className("suggested-connections-block__connect")).click();
				break;
			}
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
public String AcceptRequest(String ConnName){
	String fetch_error = null;
	String display_error = "";
	try{
		WebDriver driver2 = new ChromeDriver();
		driver2.get("https://spark-io-staging.herokuapp.com");
		driver2.findElement(By.xpath("//*[@id='example-menu']/div[2]/ul/li[4]/a")).click();		
		Extensions.WaitForPageFullyLoaded();
		Extensions.ScrollDownPage();
		WebElement elem1= driver2.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/a"));
		elem1.click();
		WebElement EmailElem = driver2.findElement(By.id("email"));
		EmailElem.sendKeys("lokatkohli@gmail.com");
		WebElement Pswd = driver2.findElement(By.id("pass"));
		Pswd.sendKeys("teamindia");
		WebElement Elembtn= driver2.findElement(By.id("loginbutton"));
		Elembtn.click(); 
		driver2.findElement(By.xpath("//*[@id='example-menu']/div[2]/ul/li[2]/a")).click();
		driver2.findElement(By.xpath("//*[@id='example-menu']/div[2]/ul/li[2]/ul/li/div[1]/div[1]/section[1]/ul/li[2]/a")).click();
		Extensions.WaitForPageFullyLoaded();
		Extensions.WaitForPageFullyLoaded();
		WebElement inviteblock = driver2.findElement(By.id("invitation_list"));
		List<WebElement> requestlist= inviteblock.findElements(By.className("invite-block__line"));
		for (int i=0; i< requestlist.size(); i++){
			WebElement namerequest = requestlist.get(i).findElement(By.tagName("h4"));
			String NameConnection= namerequest.getText();
			if (NameConnection.equals(ConnName)){
				 requestlist.get(i).findElement(By.className("invite-block__buttons--accept")).click();
				 break;
			}
		}
		 driver2.close();
		 driver2.quit();
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
//	 System.out.println(error);
	 String[] errorarray = fetch_error.split("Command duration or timeout");
	 for(String w :errorarray){  
     System.out.println(w);
     display_error = w;
     break;
 }
	
}
	}	return display_error;}
	
public String disconnectRequest(){
	String fetch_error = null;
	String display_error = "";
	try{
		driver.findElement(By.xpath("/html/body/main/sidebar[1]/section/div[1]/a")).click();
		WebElement reqblock= driver.findElement(By.className("connections-wrapper"));
//		driver.findElement(By.xpath("//*[@id='connection_line_298']/div[2]/div")).click();
		reqblock.findElement(By.className("invite-block__buttons--more-options")).click();
		reqblock.findElement(By.className("invite-block__line-options")).click();
	}//invite-block__buttons--more-options
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
//	 System.out.println(error);
	 String[] errorarray = fetch_error.split("Command duration or timeout");
	 for(String w :errorarray){  
     System.out.println(w);
     display_error = w;
     break;
 }
	
}
	}	return display_error;}
}

