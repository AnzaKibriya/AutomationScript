package framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.helper.Extensions;

import org.openqa.selenium.Keys;


public class CreateVenture {

	@FindBy(how = How.ID, using = "next-button")
	private WebElement btnNext;

	WebDriver driver;
	public CreateVenture(WebDriver Driver) {
		driver = Driver;
	}
	
	public String Ven_Title(String name){
		String fetch_error = null;
		String display_error = "";
		try{
			driver.findElement(By.id("project_title")).sendKeys(name);
			btnNext.click();
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
		}
		return display_error;
		
	}
	public String Ven_Business(String stage, String Type, String Location){
		String fetch_error = null;
		String display_error = "";
		try{
			List<WebElement> business_stage= driver.findElements(By.className("business_stage_group"));
			for (int i=0; i<= business_stage.size(); i++){
				String Value = business_stage.get(i).getAttribute("value");
				if (Value.contains(stage)){
					business_stage.get(i).click();
					break;
				}	
			}
			List<WebElement> venturetype= driver.findElements(By.className("business_type_group"));
			for (int j=0;j<= venturetype.size(); j++){
				String Value = venturetype.get(j).getAttribute("value");
				if (Value.contains(Type)){
					venturetype.get(j).click();
					break;
				}
			}
			WebElement loc= driver.findElement(By.id("project_location"));
			loc.sendKeys(Location);
		    loc.sendKeys(Keys.DOWN);
		    loc.sendKeys(Keys.ENTER);
		    btnNext.click();
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
		}
		return display_error;
	}

public String elevator_pitch(String elevator){
	String fetch_error = null;
	String display_error = "";
	try{
		driver.findElement(By.id("project_one_liner_about")).sendKeys(elevator);
		btnNext.click();
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
	}
	return display_error;
}
public String business_problem(String problem){
	String fetch_error = null;
	String display_error = "";
	try{
		 WebElement iframe = driver.findElement(By.xpath("//*[@id='project_problem_ifr']"));

		    driver.switchTo().frame(iframe);

		            WebElement itemdescription = driver.findElement(By.xpath("//*[@id='tinymce']"));
		    itemdescription.sendKeys(problem);
		    driver.switchTo().defaultContent();
		    btnNext.click();
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
	}
	return display_error;
}
public String business_solution(String solution){
	String fetch_error = null;
	String display_error = "";
	try{
		 WebElement iframe = driver.findElement(By.xpath("//*[@id='project_description_ifr']"));

		    driver.switchTo().frame(iframe);

		            WebElement itemdescription = driver.findElement(By.xpath("//*[@id='tinymce']"));
		    itemdescription.sendKeys(solution);
		    driver.switchTo().defaultContent();
		    btnNext.click();
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
	}
	return display_error;
}

public String interest_form(String [] interest){
	String fetch_error = null;
	String display_error = "";
	try{
		WebElement divinterest= driver.findElement(By.className("select-interests"));
		List<WebElement> interest_tag = divinterest.findElements(By.className("categories-check-box"));
		for (int i =0; i< interest.length; i++){
		for (int count = 0; count <= interest_tag.size(); count++){
			String Pstage = interest_tag.get(count).getText();
			if (Pstage.contains(interest[i])){
				interest_tag.get(count).click();
				break;
          }
		}
	}
		btnNext.click();
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
	}
	return display_error;	
}
public String Add_Teammember(String e_id, String position){
	String fetch_error = null;
	String display_error = "";
	try{
		driver.findElement(By.id("team_email")).sendKeys(e_id);
		driver.findElement(By.id("team_title_position")).sendKeys(position);
		driver.findElement(By.id("add-team-member")).click();
		Extensions.WaitForElementVisibleAndClickable(btnNext);
		btnNext.click();
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
	}
	return display_error;	
}
public String Add_Position(String position, String Description, String [] interest, String [] secinter){
	String fetch_error = null;
	String display_error = "";
	try{
		driver.findElement(By.id("venture_position")).sendKeys(position);
		 WebElement iframe = driver.findElement(By.xpath("//*[@id='venture_description_ifr']"));
		 driver.switchTo().frame(iframe);
		 WebElement itemdescription = driver.findElement(By.xpath("//*[@id='tinymce']"));
		 itemdescription.sendKeys(Description);
		 driver.switchTo().defaultContent();
		 WebElement divinterest= driver.findElement(By.className("select-interests"));
			List<WebElement> interest_tag = divinterest.findElements(By.className("categories-check-box"));
			for (int i =0; i< interest.length; i++){
			for (int count = 0; count <= interest_tag.size(); count++){
				String Pstage = interest_tag.get(count).getText();
				if (Pstage.contains(interest[i])){
					interest_tag.get(count).click();
					break;
	          }
			}
		}
			Extensions.ScrollDownPage();
			Thread.sleep(2000);
			 WebElement secinterest= driver.findElement(By.id("venture-skills-secondary-section"));
			 List<WebElement> secinterlist = secinterest.findElements(By.className("categories-check-box"));
			 for (int i =0; i< secinter.length; i++){
					for (int count = 0; count <= secinterlist.size(); count++){
						String Pstage = secinterlist.get(count).getText();
						if (Pstage.contains(secinter[i])){
							secinterlist.get(count).click();
							break;
			          }
					}
				}
			 driver.findElement(By.id("add-venture-position")).click();
			 btnNext.click();
		
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
	}
	return display_error;	
}
public String network_interest(){
	String fetch_error = null;
	String display_error = "";
	try{
		driver.findElement(By.id("project_interested_in_networking_1")).click();
		btnNext.click();
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
	}
	return display_error;	
}
public String Venture_website(String site){
	String fetch_error = null;
	String display_error = "";
	try{
		 driver.findElement(By.id("project_website")).sendKeys(site);
		 btnNext.click();
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
	}
	return display_error;
}
public String Venture_FilesUpload(){
	String fetch_error = null;
	String display_error = "";
	try{
		driver.findElement(By.id("project_venture_logo")).sendKeys("E:\\Projects\\sparkxyz\\IOData\\pic.jpeg");
		btnNext.click();
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
// System.out.println(error);
 String[] errorarray = fetch_error.split("Command duration or timeout");
 for(String w :errorarray){  
 System.out.println(w);
 display_error = w;
 break;
}

}
}
return display_error;
}
public String verify_venture(String V_Name){
	String fetch_error = null;
	String display_error = "";
	try{
		driver.findElement(By.id("next-button")).click();
		Extensions.WaitForPageFullyLoaded();
		String name = driver.findElement(By.tagName("h1")).getText();
		if (name.contains(V_Name)){
			System.out.println("Venture Saved");
		}
		else{
			display_error = "Venture not saved";
			
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
	// System.out.println(error);
	 String[] errorarray = fetch_error.split("Command duration or timeout");
	 for(String w :errorarray){  
	 System.out.println(w);
	 display_error = w;
	 break;
	}

	}
	}
	return display_error;
	}
	

}
	
	


