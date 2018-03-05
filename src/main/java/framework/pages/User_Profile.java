package framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.helper.Extensions;

public class User_Profile {
	WebDriver driver;
	public User_Profile(WebDriver Driver) {
		driver = Driver;
	}
public String Add_new_experience(String Title, String Company, String strtmonth, String strtyr, String endmonth, String endyr){
	String fetch_error = null;
	String display_error = "";
	int c=0;
	try{
		driver.findElement(By.cssSelector("a[data-reveal-id='modal-profile-experiences']")).click();
		WebElement Savebtn1 = driver.findElement(By.xpath("//*[@id='form_experience']/div[7]/button"));
		Savebtn1.click();
		try{
			WebElement titleerror = driver.findElement(By.id("experience-title-error"));
			WebElement comerror= driver.findElement(By.id("experience-company-error"));
			WebElement strtdateerr = driver.findElement(By.id("experience-start_month-error"));
			WebElement enddate = driver.findElement(By.id("experience-end_month-error"));
		}
		catch(Exception e){
		    System. out.println("In Exception block.");
		    fetch_error = e.getMessage();
		}
		driver.findElement(By.id("experience-title")).sendKeys(Title);
		driver.findElement(By.id("experience-company")).sendKeys(Company);
		WebElement Smon= driver.findElement(By.id("experience-start_month"));
		Smon.sendKeys(strtmonth);
		WebElement Syr= driver.findElement(By.id("experience-start_year"));
		Syr.sendKeys(strtyr);
		WebElement Emnth= driver.findElement(By.id("experience-end_month"));
		Emnth.sendKeys(endmonth);
		int negendyr= Integer.parseInt(strtyr);
		negendyr= negendyr-1;
		String negyr = String.valueOf(negendyr);
		WebElement Endyr= driver.findElement(By.id("experience-end_year"));
		Endyr.sendKeys(negyr);
		Savebtn1.click();
		
		try{
			WebElement endyrr= driver.findElement(By.id("experience-end_year-error"));
			String errorendyr= endyrr.getText();
			if (errorendyr.contains("Start date can't be bigger then end date")){
				System.out.println("Correct Error message is shown");
			}
			else{
			display_error= "Negative Scenario Error: End date is bigger than Start date";
			}
		}
		catch(Exception e){
		    System. out.println("In Exception block.");
		    fetch_error = e.getMessage();
		}
		Endyr.clear();
		Endyr.sendKeys(endyr);
		Savebtn1.click();
		Extensions.WaitForPageFullyLoaded();
		Thread.sleep(2000);
		WebElement experiencediv= driver.findElement(By.className("card__experience-card"));
		List<WebElement> headingexp= experiencediv.findElements(By.className("card__item-title"));
		for (int i=0 ; i< headingexp.size(); i++){
			String heading = headingexp.get(i).getText();
			if (heading.contains(Title)){
				System.out.println("Experience Record saved");
				c++;
				break;
			}
		}
		if (c==0){
			display_error= "Experience Record is not saved";
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
public String Add_new_education(String School, String Degree, String Field, String strtmonth, String strtyr, String endmonth, String endyr){
	String fetch_error = null;
	String display_error = "";
	int c=0;
	try{
		driver.findElement(By.cssSelector("a[data-reveal-id='modal-profile-education']")).click();
		WebElement Savebtn1 = driver.findElement(By.xpath("//*[@id='form_profile_education']/div[8]/button"));
		Savebtn1.click();
		try{
			WebElement scherr= driver.findElement(By.id("profile_education-name-error"));
			WebElement degerr= driver.findElement(By.id("profile_education-degree-error"));
			WebElement fielderr= driver.findElement(By.id("profile_education-name-error"));
			WebElement strterr= driver.findElement(By.id("profile_education-start_month-error"));
		}
		catch(Exception e){
		    System. out.println("In Exception block.");
		    fetch_error = e.getMessage();
		}
		WebElement sch= driver.findElement(By.id("profile_education-name"));
		sch.sendKeys(School);
		sch.sendKeys(Keys.DOWN);
		sch.sendKeys(Keys.ENTER);
		driver.findElement(By.id("profile_education-degree")).sendKeys(Degree);
		driver.findElement(By.id("profile_education-field_of_study")).sendKeys(Field);
		driver.findElement(By.id("profile_education-start_month")).sendKeys(strtmonth);
		driver.findElement(By.id("profile_education-start_year")).sendKeys(strtyr);
		driver.findElement(By.id("profile_education-end_month")).sendKeys(endmonth);
		WebElement endyear = driver.findElement(By.id("profile_education-end_year"));
		int negendyr= Integer.parseInt(strtyr);
		negendyr= negendyr-1;
		String negyr = String.valueOf(negendyr);
		endyear.sendKeys(negyr);
		Savebtn1.click();
		try{
			WebElement endyrr= driver.findElement(By.id("profile_education-end_year-error"));
			String errorendyr= endyrr.getText();
			if (errorendyr.contains("Start date can't be bigger then end date")){
				System.out.println("Correct Error message is shown");
			}
			else{
			display_error= "Negative Scenario Error: End date is bigger than Start date";
			}
		}
		catch(Exception e){
		    System. out.println("In Exception block.");
		    fetch_error = e.getMessage();
		}
		endyear.clear();
		endyear.sendKeys(endyr);
		Savebtn1.click();
		Extensions.WaitForPageFullyLoaded();
		Thread.sleep(2000);
		WebElement edudiv= driver.findElement(By.className("card__education-card"));
		List<WebElement> headingexp= edudiv.findElements(By.className("card__item-title"));
		for (int i=0 ; i< headingexp.size(); i++){
			String heading = headingexp.get(i).getText();
			if (heading.contains(School)){
				System.out.println("Education Record saved");
				c++;
				break;
			}
		}
		if (c==0){
			display_error= "Education Record is not saved";
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
public String Add_new_volunteerexp(String organization, String position, String cause, String strtmonth, String strtyr, String endmonth, String endyr){
	String fetch_error = null;
	String display_error = "";
	int c=0;
	try{
		driver.findElement(By.xpath("/html/body/section[2]/section/a[1]")).click();
		WebElement Savebtn = driver.findElement(By.xpath("//*[@id='form_volunteer_experience']/div[7]/button"));
		Savebtn.click();
		try{
			WebElement orgerr= driver.findElement(By.id("volunteer_experience-organization-error"));
			WebElement poserr= driver.findElement(By.id("volunteer_experience-role"));
			WebElement cauerr= driver.findElement(By.id("volunteer_experience-cause"));
			WebElement dateerr= driver.findElement(By.id("volunteer_experience-start_month-error"));
		}
		catch(Exception e){
		    System. out.println("In Exception block.");
		    fetch_error = e.getMessage();
		}
		driver.findElement(By.id("volunteer_experience-organization")).sendKeys(organization);
		driver.findElement(By.id("volunteer_experience-role")).sendKeys(position);
		driver.findElement(By.id("volunteer_experience-cause")).sendKeys(cause);
		driver.findElement(By.id("volunteer_experience-start_month")).sendKeys(strtmonth);
		driver.findElement(By.id("volunteer_experience-start_year")).sendKeys(strtyr);
		driver.findElement(By.id("volunteer_experience-end_month")).sendKeys(endmonth);
		int negendyr= Integer.parseInt(strtyr);
		negendyr= negendyr-1;
		String negyr = String.valueOf(negendyr);
		WebElement endyear = driver.findElement(By.id("volunteer_experience-end_year"));
		endyear.sendKeys(negyr);
		Savebtn.click();
		endyear.clear();
		endyear.sendKeys(endyr);
		Savebtn.click();
		Extensions.WaitForPageFullyLoaded();
		Thread.sleep(2000);
		WebElement experiencediv= driver.findElement(By.className("card__volunteer-card"));
		List<WebElement> headingexp= experiencediv.findElements(By.className("card__item-title"));
		for (int i=0 ; i< headingexp.size(); i++){
			String heading = headingexp.get(i).getText();
			if (heading.contains(organization)){
				System.out.println("Volunteer Experience Record saved");
				c++;
				break;
			}
		}
		if (c==0){
			display_error= "Volunteer Experience Record is not saved";
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
public String Add_new_group(String organization, String position, String strtmonth, String strtyr, String endmonth, String endyr){
	String fetch_error = null;
	String display_error = "";
	int c=0;
	try{
		driver.findElement(By.xpath("/html/body/section[2]/section/a[2]")).click();
		WebElement Savebtn= driver.findElement(By.xpath("//*[@id='form_profile_organization']/div[6]/button"));
		Savebtn.click();
		try{
			WebElement orgerr= driver.findElement(By.id("profile_organization-name-error"));
			WebElement posierr= driver.findElement(By.id("profile_organization-position_held-error"));
			WebElement dateerr= driver.findElement(By.id("profile_organization-start_month-error"));
		}
		catch(Exception e){
		    System. out.println("In Exception block.");
		    fetch_error = e.getMessage();
		}
		driver.findElement(By.id("profile_organization-name")).sendKeys(organization);
		driver.findElement(By.id("profile_organization-position_held")).sendKeys(position);
		driver.findElement(By.id("profile_organization-start_month")).sendKeys(strtmonth);
		driver.findElement(By.id("profile_organization-start_year")).sendKeys(strtyr);
		driver.findElement(By.id("profile_organization-end_month")).sendKeys(endmonth);
		int negendyr= Integer.parseInt(strtyr);
		negendyr= negendyr-1;
		String negyr = String.valueOf(negendyr);
		WebElement endyear = driver.findElement(By.id("profile_organization-end_year"));
		endyear.sendKeys(negyr);
		Savebtn.click();
		endyear.clear();
		endyear.sendKeys(endyr);
		Savebtn.click();
		Extensions.WaitForPageFullyLoaded();
		Thread.sleep(2000);
		WebElement experiencediv= driver.findElement(By.className("card__organization-card"));
		List<WebElement> headingexp= experiencediv.findElements(By.className("card__item-title"));
		for (int i=0 ; i< headingexp.size(); i++){
			String heading = headingexp.get(i).getText();
			if (heading.contains(position)){
				System.out.println("Group Record saved");
				c++;
				break;
			}
		}
		if (c==0){
			display_error= "Group Record is not saved";
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
public String Add_new_award(String award, String issueby, String month, String yr){
	String fetch_error = null;
	String display_error = "";
	int c=0;
	try{
		Extensions.ScrollDownPage();
		Extensions.ScrollDownPage();
		Extensions.ScrollDownPage();
		driver.findElement(By.xpath("/html/body/section[2]/section/a[4]")).click();///html/body/section[2]/section/a[2]
		WebElement Savebtn= driver.findElement(By.xpath("//*[@id='form_honor_award']/div[5]/button"));
		Savebtn.click();
		try{
			WebElement awarderr = driver.findElement(By.id("honor_award-title-error"));
			WebElement issueerr= driver.findElement(By.id("honor_award-issuer-error"));
			WebElement dateerr= driver.findElement(By.id("honor_award-year-error"));
		}
		catch(Exception e){
		    System. out.println("In Exception block.");
		    fetch_error = e.getMessage();
		}
		driver.findElement(By.id("honor_award-title")).sendKeys(award);
		driver.findElement(By.id("honor_award-issuer")).sendKeys(issueby);
		driver.findElement(By.id("honor_award-month")).sendKeys(month);
		driver.findElement(By.id("honor_award-year")).sendKeys(yr);
		Savebtn.click();
		Extensions.WaitForPageFullyLoaded();
		Thread.sleep(2000);
		WebElement experiencediv= driver.findElement(By.className("card__awards-card"));
		List<WebElement> headingexp= experiencediv.findElements(By.className("card__item-title"));
		for (int i=0 ; i< headingexp.size(); i++){
			String heading = headingexp.get(i).getText();
			if (heading.contains(award)){
				System.out.println("Award Record saved");
				c++;
				break;
			}
		}
		if (c==0){
			display_error= "Award Record is not saved";
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
public String delete_eduction(String Title){
	String fetch_error = null;
	String display_error = "";
	int i;
	try{
		WebElement edudiv= driver.findElement(By.className("card__education-card"));
		List<WebElement> headingexp= edudiv.findElements(By.className("card__item"));
		for ( i=0 ; i< headingexp.size(); i++){
			WebElement titleid = headingexp.get(i).findElement(By.className("card__item-title"));
			String gettitle= titleid.getText();
			if (gettitle.contains(Title)){
				break;
			}
		}
		headingexp.get(i).findElement(By.className("edit-item")).click();
		driver.findElement(By.xpath("//*[@id='form_profile_education']/div[9]/div[1]/a")).click();
		WebElement edudiv1= driver.findElement(By.className("card__education-card"));
		List<WebElement> headings= edudiv1.findElements(By.className("card__item-title"));
		for (int j=0 ; j< headings.size(); j++){
			String heading = headings.get(j).getText();
			if (heading.contains(Title)){
				System.out.println("Education Record not deleted");
				display_error= "Education Record is not deleted";
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
public String delete_experience(String Title){
	String fetch_error = null;
	String display_error = "";
	int i;
	try{
		WebElement experiencediv= driver.findElement(By.className("card__experience-card"));
		List<WebElement> headingexp= experiencediv.findElements(By.className("card__item"));
		for ( i=0 ; i< headingexp.size(); i++){
			WebElement titleid = headingexp.get(i).findElement(By.className("card__item-title"));
			String gettitle= titleid.getText();
			if (gettitle.contains(Title)){
				break;
			}
		}
		headingexp.get(i).findElement(By.className("edit-item")).click();
		driver.findElement(By.xpath("//*[@id='form_experience']/div[8]/div[1]/a")).click();
		WebElement experiencediv1= driver.findElement(By.className("card__experience-card"));
		List<WebElement> headings= experiencediv1.findElements(By.className("card__item-title"));
		for (int j=0 ; j< headings.size(); j++){
			String heading = headings.get(j).getText();
			if (heading.contains(Title)){
				System.out.println("Education Record not deleted");
				display_error= "Education Record is not deleted";
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
public String delete_voltuneerexperience(String Title){
	String fetch_error = null;
	String display_error = "";
	int i;
	try{
		WebElement experiencediv= driver.findElement(By.className("card__volunteer-card"));
		List<WebElement> headingexp= experiencediv.findElements(By.className("card__item"));
		for ( i=0 ; i< headingexp.size(); i++){
			WebElement titleid = headingexp.get(i).findElement(By.className("card__item-title"));
			String gettitle= titleid.getText();
			if (gettitle.contains(Title)){
				break;
			}
		}
		headingexp.get(i).findElement(By.className("edit-item")).click();
		driver.findElement(By.xpath("//*[@id='form_volunteer_experience']/div[8]/div[1]/a")).click();
		try{
		WebElement experiencediv1= driver.findElement(By.className("card__volunteer-card"));
		List<WebElement> headings= experiencediv1.findElements(By.className("card__item-title"));
		for (int j=0 ; j< headings.size(); j++){
			String heading = headings.get(j).getText();
			if (heading.contains(Title)){
				System.out.println("Education Record not deleted");
				display_error= "Education Record is not deleted";
			}
		}
		}
		catch(Exception e){
			WebElement voldiv= driver.findElement(By.xpath("/html/body/section[2]/section/a[1]"));
			String Volmessage= voldiv.getText();
			if (Volmessage.contains("Do you share your spare time?")){
			System.out.println("Education Record deleted");
			}
		else{
			display_error= "Education Record is not deleted";
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
public String delete_Award(String Title){
	String fetch_error = null;
	String display_error = "";
	int i;
	try{
		WebElement experiencediv= driver.findElement(By.className("card__awards-card"));
		List<WebElement> headingexp= experiencediv.findElements(By.className("card__item"));
		for ( i=0 ; i< headingexp.size(); i++){
			WebElement titleid = headingexp.get(i).findElement(By.className("card__item-title"));
			String gettitle= titleid.getText();
			if (gettitle.contains(Title)){
				break;
			}
		}
		headingexp.get(i).findElement(By.className("edit-item")).click();
		driver.findElement(By.xpath("//*[@id='form_honor_award']/div[6]/div[1]/a")).click();
		try{
		WebElement experiencediv1= driver.findElement(By.className("card__awards-card"));
		List<WebElement> headings= experiencediv1.findElements(By.className("card__item-title"));
		for (int j=0 ; j< headings.size(); j++){
			String heading = headings.get(j).getText();
			if (heading.contains(Title)){
				System.out.println("Award Record not deleted");
				display_error= "Award Record is not deleted";
			}
		}}
		catch(Exception e){
			WebElement awarddiv= driver.findElement(By.xpath("/html/body/section[2]/section/a[4]"));
			String MessAward = awarddiv.getText();
			if (MessAward.contains("You haven't added any awards.")){
				System.out.println("Award Record deleted");
			}
			else{
				display_error= "Award Record is not deleted";
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
//System.out.println(error);
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
	public String Delete_Organization(String organization){
		String fetch_error = null;
		String display_error = "";
		int i;
		try{
			
			Extensions.ScrollDownPage();
			WebElement experiencediv= driver.findElement(By.className("card__organization-card"));
			List<WebElement> headingexp= experiencediv.findElements(By.className("card__item-title"));
			for (i=0 ; i< headingexp.size(); i++){
				String heading = headingexp.get(i).getText();
				if (heading.contains(organization)){
					break;
				}
			}
//			WebElement editbtn = headingexp.get(i).findElement(By.className("edit-item"));
//			editbtn.click();
			driver.findElement(By.xpath("/html/body/section[2]/section/section[4]/section/div/div/div[3]/button/i")).click();///html/body/section[2]/section/section[4]/section/div/div/div[3]/button/i
			driver.findElement(By.xpath("//*[@id='form_profile_organization']/div[7]/div[1]/a")).click();
			WebElement orgdiv= driver.findElement(By.xpath("/html/body/section[2]/section/a[2]"));///html/body/section[2]/section/a[2]
			String Orgmessage= orgdiv.getText();
			if (Orgmessage.contains("Part of an established group?")){
				
				System.out.println("organization Record deleted");
			}
			else{
				display_error= "Group (Organizaion) is not deleted";
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
			//System.out.println(error);
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
	

