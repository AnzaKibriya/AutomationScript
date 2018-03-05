package framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.helper.Extensions;

public class VenturePage {
	@FindBy(how = How.ID, using = "next-button")
	private WebElement btnNext;
	WebDriver driver;
	public VenturePage(WebDriver Driver) {
		driver = Driver;
	}
	public String open_Venture(String VentureName){
		String fetch_error = null;
		String display_error = "";
		try{
		driver.findElement(By.linkText(VentureName)).click();
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
	public String VentureProblem(String Problem){
		String fetch_error = null;
		String display_error = "";
		try{
			WebElement problemdiv= driver.findElement(By.className("venture-details__problem"));
			problemdiv.findElement(By.className("ion-edit")).click();
			 WebElement iframe = driver.findElement(By.xpath("//*[@id='project_problem_ifr']"));

			    driver.switchTo().frame(iframe);

			            WebElement itemdescription = driver.findElement(By.xpath("//*[@id='tinymce']"));
			            itemdescription.clear();
			    itemdescription.sendKeys(Problem);
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
	public String VentureSolution(String solution){
		String fetch_error = null;
		String display_error = "";
		try{
			WebElement soldiv= driver.findElement(By.className("venture-details__solution"));
			soldiv.findElement(By.className("ion-edit")).click();
			 WebElement iframe = driver.findElement(By.xpath("//*[@id='project_description_ifr']"));

			    driver.switchTo().frame(iframe);

			            WebElement itemdescription = driver.findElement(By.xpath("//*[@id='tinymce']"));
			            itemdescription.clear();
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
	
	public String Venturebusinessstage(String stage, String Type, String Location){
		String fetch_error = null;
		String display_error = "";
		try{
			WebElement busdiv= driver.findElement(By.className("venture-details__business-stage"));
			busdiv.findElement(By.className("ion-edit")).click();
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
			loc.clear();
			loc.sendKeys(Location);
		    loc.sendKeys(Keys.DOWN);
		    loc.sendKeys(Keys.ENTER);
//		    btnNext.click();
			
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
	}	return display_error;
	
}
	public String VentureCategories(String [] interest){
		String fetch_error = null;
		String display_error = "";
		try{
//			WebElement maindiv= driver.findElement(By.className("large-4"));
//			WebElement catdiv= maindiv.findElement(By.className("venture-details__positions"));
//			catdiv.findElement(By.className("ion-edit")).click();
			driver.findElement(By.xpath("/html/body/section[4]/div[2]/div[6]/header/a/i")).click();
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
//		 System.out.println(error);
		 String[] errorarray = fetch_error.split("Command duration or timeout");
		 for(String w :errorarray){  
	     System.out.println(w);
	     display_error = w;
	     break;
	 }
		
	}
		}	return display_error;
		
	}
	public String EditTeam(String e_id, String position){
		String fetch_error = null;
		String display_error = "";
		try{
			WebElement catdiv= driver.findElement(By.className("venture-details__team"));
			catdiv.findElement(By.className("ion-edit")).click();
			try{
				WebElement Memdiv= driver.findElement(By.className("team-member"));
				Memdiv.findElement(By.className("ion-ios-close-outline")).click();
			}
			catch(Exception e){
			    System. out.println("In Exception block.");
			    fetch_error = e.getMessage();
			}
			WebElement Eid= driver.findElement(By.id("team_email"));
			Eid.clear();
			Eid.sendKeys(e_id);
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
//		 System.out.println(error);
		 String[] errorarray = fetch_error.split("Command duration or timeout");
		 for(String w :errorarray){  
	     System.out.println(w);
	     display_error = w;
	     break;
	 }
		
	}
		}	return display_error;
		
	}
	public String VentureImage(){
		String fetch_error = null;
		String display_error = "";
		try{
			WebElement backimagediv= driver.findElement(By.className("venture-details__top-contact-background"));
			backimagediv.click();
			driver.findElement(By.id("project_image")).sendKeys("E:\\Projects\\sparkxyz\\IOData\\pic.jpeg");
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
	public String WebsiteVenture(String site){
		String fetch_error = null;
		String display_error = "";
		try{
			WebElement webdiv= driver.findElement(By.className("venture-details__margin-right"));
			webdiv.findElement(By.className("ion-edit")).click();
			WebElement V_web=  driver.findElement(By.id("project_website"));
			V_web.clear();
			V_web.sendKeys(site);
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
	public String VentureOneliner(String Oneline){
		String fetch_error = null;
		String display_error = "";
		try{
//			WebElement headerdiv= driver.findElement(By.className("venture-details__name-about"));
//			headerdiv.findElement(By.className("venture-details__margin-left")).click();
			driver.findElement(By.xpath("/html/body/section[2]/section/figure/figcaption/div[2]/a/i")).click();
//			elevatordiv.findElement(By.className("ion-edit")).click();
			WebElement ele = driver.findElement(By.id("project_one_liner_about"));
			ele.clear();
			ele.sendKeys(Oneline);
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
	public String VenPostion(String position, String Description, String [] interest, String [] secinter){
		String fetch_error = null;
		String display_error = "";
		try{
			WebElement posdiv= driver.findElement(By.className("venture-details__positions"));
			posdiv.findElement(By.className("ion-edit")).click();
			driver.findElement(By.xpath("//*[@id='delete-venture-position']/img")).click();
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
