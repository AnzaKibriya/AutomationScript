package framework.pages;
import framework.helper.Extensions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//import DataLayer.DataSet;

import org.openqa.selenium.support.How;

import framework.datalayer.DataSet;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class On_Boadring_Process {
	WebDriver driver;
	public On_Boadring_Process(WebDriver Driver) {
		driver = Driver;

	}
	public String Negative_location(){
		String fetch_error = null;
		String display_error = "";
		try{
			WebElement on_boardemail= driver.findElement(By.id("onboarding_email"));
			on_boardemail.clear();
			WebElement countryboard= driver.findElement(By.id("onboarding_country"));
			countryboard.clear();
			WebElement codeboard= driver.findElement(By.id("onboarding_zip_code"));
			codeboard.clear();
			WebElement btn= driver.findElement(By.name("button"));
			btn.click();
			try {
				WebElement em = driver.findElement(By.id("onboarding_email-error"));
				WebElement cou = driver.findElement(By.id("onboarding_country-error"));
				WebElement loc = driver.findElement(By.id("onboarding_zip_code-error"));
				
			}
			catch(Exception e){
			    System. out.println("Error message not found");
			    fetch_error = e.getMessage();
			}
			on_boardemail.sendKeys("asd23");
			try {
				WebElement em = driver.findElement(By.id("onboarding_email-error"));
				String S= em.getText();
				if (S.contains("Please enter a valid email address.")){
					System.out.println("Working Fine Email message");
				}
				else {
					display_error= "email error is not working properly";
					
				}
						}		
			catch(Exception e){
			    System. out.println("Email Error message not found");
			    fetch_error = e.getMessage();
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
		}
		return display_error;
		
	}
		
	public String Location_form(String email, String country, String code){
		String fetch_error = null;
		String display_error = "";
		try{
//			Extensions.WaitForPageFullyLoaded();
			WebElement on_boardemail= driver.findElement(By.id("onboarding_email"));
			on_boardemail.clear();
			on_boardemail.sendKeys(email);
			WebElement countryboard= driver.findElement(By.id("onboarding_country"));
			countryboard.clear();
			countryboard.sendKeys(country);
			WebElement codeboard= driver.findElement(By.id("onboarding_zip_code"));
			codeboard.clear();
			codeboard.sendKeys(code);
			WebElement btn= driver.findElement(By.name("button"));
			btn.click();
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
	
	public String Negative_Edu(){
		String fetch_error = null;
		String display_error = "";
		try{
			WebElement sch= driver.findElement(By.id("onboarding_school"));
			sch.clear();
			WebElement deg = driver.findElement(By.id("onboarding_degree"));
			deg.clear();
			WebElement fedsty= driver.findElement(By.id("onboarding_field_of_study"));
			fedsty.clear();
			WebElement srtmnth= driver.findElement(By.id("profile_education-start_month"));
			srtmnth.clear();
			WebElement srtyr= driver.findElement(By.id("profile_education-start_year"));
			srtyr.clear();
			WebElement endmnth= driver.findElement(By.id("profile_education-end_month"));
			endmnth.clear();
			WebElement endyr= driver.findElement(By.id("profile_education-end_year"));
			endyr.clear();
			WebElement btn= driver.findElement(By.name("button"));
			btn.click();
			try {
				WebElement em = driver.findElement(By.id("onboarding_school-error"));
				WebElement cou = driver.findElement(By.id("onboarding_degree-error"));
				WebElement loc = driver.findElement(By.id("onboarding_field_of_study-error"));
				WebElement montdate = driver.findElement(By.id("profile_education-start_month-error"));
	
				
			}
			catch(Exception e){
			    System. out.println("Error message not found");
			    fetch_error = e.getMessage();
			}
			srtmnth.sendKeys("1");
			srtyr.sendKeys("2016");
			endmnth.sendKeys("2");
			endyr.sendKeys("2012");
			btn.click();
			try{
				String verify = driver.findElement(By.id("profile_education-start_month-error")).getText();
				if (verify.contains("Start date can't be bigger then end date")){
					
				}
				else{
                        display_error= "email error is not working properly";
					
				}
						}		
			catch(Exception e){
			    System. out.println("Email Error message not found");
			    fetch_error = e.getMessage();
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
		}
		return display_error;
		
	}
	public String Education_Form(String school, String degree, String fieldstudy, String start_month, String start_year, String end_month, String end_year){
		String fetch_error = null;
		String display_error = "";
		try{
		WebElement sch= driver.findElement(By.id("onboarding_school"));
		sch.clear();
		sch.sendKeys(school);
		sch.sendKeys(Keys.DOWN);
	    sch.sendKeys(Keys.ENTER);
		WebElement deg = driver.findElement(By.id("onboarding_degree"));
		deg.clear();
		deg.sendKeys(degree);
		WebElement fedsty= driver.findElement(By.id("onboarding_field_of_study"));
		fedsty.clear();
		fedsty.sendKeys(fieldstudy);
		WebElement srtmnth= driver.findElement(By.id("profile_education-start_month"));
		srtmnth.clear();
		srtmnth.sendKeys(start_month);
		WebElement srtyr= driver.findElement(By.id("profile_education-start_year"));
		srtyr.clear();
		srtyr.sendKeys(start_year);
		WebElement endmnth= driver.findElement(By.id("profile_education-end_month"));
		endmnth.clear();
		endmnth.sendKeys(end_month);
		WebElement endyr= driver.findElement(By.id("profile_education-end_year"));
		endyr.clear();
		endyr.sendKeys(end_year);
		WebElement btn= driver.findElement(By.name("button"));
		btn.click();
				
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
	public String Career_Form(){
		String fetch_error = null;
		String display_error = "";
		try{
			WebElement jbt= driver.findElement(By.id("onboarding_job_title"));
			jbt.clear();
			WebElement cmpy= driver.findElement(By.id("onboarding_company"));
			cmpy.clear();
			WebElement lct = driver.findElement(By.id("onboarding_company_location"));
			lct.clear();
			WebElement srtmnth= driver.findElement(By.id("experience-start_month"));
			srtmnth.clear();
			WebElement srtyr= driver.findElement(By.id("experience-start_year"));
			srtyr.clear();
			WebElement endmnth= driver.findElement(By.id("experience-end_month"));
			endmnth.clear();
			WebElement endyr= driver.findElement(By.id("experience-end_year"));
			endyr.clear();
			  WebElement btn= driver.findElement(By.name("button"));
			   btn.click();
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
	
	
	public String Career_Form(String job_title, String company, String location, String start_month, String start_year, String end_month, String end_year){
		String fetch_error = null;
		String display_error = "";
		try{ 
			WebElement jbt= driver.findElement(By.id("onboarding_job_title"));
			jbt.clear();
			jbt.sendKeys(job_title);
			WebElement cmpy= driver.findElement(By.id("onboarding_company"));
			cmpy.clear();
			cmpy.sendKeys(company);
			WebElement lct = driver.findElement(By.id("onboarding_company_location"));
			lct.clear();
			lct.sendKeys(location);
			lct.sendKeys(Keys.DOWN);
		    lct.sendKeys(Keys.ENTER);
			WebElement srtmnth= driver.findElement(By.id("experience-start_month"));
			srtmnth.clear();
			srtmnth.sendKeys(start_month);
			WebElement srtyr= driver.findElement(By.id("experience-start_year"));
			srtyr.clear();
			srtyr.sendKeys(start_year);
			WebElement endmnth= driver.findElement(By.id("experience-end_month"));
			endmnth.clear();
			endmnth.sendKeys(end_month);
			WebElement endyr= driver.findElement(By.id("experience-end_year"));
			endyr.clear();
			endyr.sendKeys(end_year);
			if (end_month == ""){
				WebElement mark= driver.findElement(By.id("experience_current"));
				mark.click();
			}
		   WebElement btn= driver.findElement(By.name("button"));
		   btn.click();
			
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
	public String Skills_form(String Primary, String Secondary){
		String fetch_error = null;
		String display_error = "";
		try{ 
			WebElement prim_skill_div= driver.findElement(By.id("onboarding-skills-primary"));
			List<WebElement> List_primsk= prim_skill_div.findElements(By.className("onboarding-skills__option"));
			for (int count = 0; count <= List_primsk.size(); count++){
				String Pskill =List_primsk.get(count).getText();
				if (Pskill.contains(Primary)){
					List_primsk.get(count).click();
					break;
	          }
			}
			WebElement sec_skill_div= driver.findElement(By.id("onboarding-skills-secondary"));
			List<WebElement> List_secsk= sec_skill_div.findElements(By.className("onboarding-skills__option"));
			for (int count = 0; count <= List_secsk.size(); count++){
				String Sskill =List_secsk.get(count).getText();
				if (Sskill.contains(Secondary)){
					List_secsk.get(count).click();
					break;
	          }
			}
			driver.findElement(By.cssSelector("button[type='submit']")).click();
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
	public String BusinessStage_form(String business_stage, String venture_type, String interested_connection){
		String fetch_error = null;
		String display_error = "";
		try{ 
//			WebElement frmId = driver.findElement(By.id("onboarding-parameters-form"));
//			List<WebElement> fetchdivs = frmId.findElements(By.className("row"));
//			WebElement fetchBusinessStage= fetchdivs.get(2);
			List<WebElement> bus_stage = driver.findElements(By.cssSelector("input[class='business_stage_group']"));
			for (int count = 0; count <= bus_stage.size(); count++){
				String Bstage = bus_stage.get(count).getAttribute("value");
				if (Bstage.contains(business_stage)){
					bus_stage.get(count).click();
					break;
				}
			}
			List<WebElement> ven_type = driver.findElements(By.cssSelector("input[class='interested_type_group']"));
			for (int count = 0; count <= ven_type.size(); count++){
				String Vtype = ven_type.get(count).getAttribute("value");
				if (Vtype.contains(venture_type)){
					ven_type.get(count).click();
					break;
				}
			}
			if (interested_connection.equals("Graduate")){
				driver.findElement(By.id("onboarding_connection_interest_graduate")).click();
			}
			else{
				driver.findElement(By.id("onboarding_connection_interest_undergraduate")).click();
			}
			driver.findElement(By.cssSelector("button[type='submit']")).click();
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
	public String passion_form(String [] passion){
		String fetch_error = null;
		String display_error = "";
		try{
			WebElement divpassion= driver.findElement(By.className("onboarding-passions"));
			List<WebElement> passion_tag = divpassion.findElements(By.className("onboarding__text"));
			for (int i =0; i< passion.length; i++){
			for (int count = 0; count <= passion_tag.size(); count++){
				String Pstage = passion_tag.get(count).getText();
				if (Pstage.contains(passion[i])){
					passion_tag.get(count).click();
					break;
	          }
			}
		}
			driver.findElement(By.cssSelector("button[type='submit']")).click();
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
    public String import_connection(){
    	String fetch_error = null;
		String display_error = "";
		try{
			driver.findElement(By.cssSelector("input[type='submit']")).click();
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
    public String invite_connection(){
    	String fetch_error = null;
		String display_error = "";
		try{
			driver.findElement(By.cssSelector("input[type='submit']")).click();
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
    public String Reason_to_join(String reason){
    	String fetch_error = null;
		String display_error = "";
		try{
			WebElement divreason= driver.findElement(By.id("onboarding-feedback"));
			List<WebElement> List_reason = divreason.findElements(By.className("onboarding_feedback_group"));
			for (int i=0;i<=List_reason.size();i++){
				String re= List_reason.get(i).getAttribute("value");
				if (re.contains(reason)){
					List_reason.get(i).click();
					break;
				}
			}
			driver.findElement(By.cssSelector("button[type='submit']")).click();			
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
 public String UclaUser(){
	 String fetch_error = null;
		String display_error = "";
		try{
			driver.findElement(By.linkText("View Ventures")).click();
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
		}
		return display_error;
	}
}
//List<WebElement> Location_Form_tag = Location_form_ID.findElements(By.tagName("input"));

