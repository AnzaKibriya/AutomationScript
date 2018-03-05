package framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.helper.Extensions;

public class Search_Page {
	WebDriver driver;
	public Search_Page(WebDriver Driver) {
		driver = Driver;
	}
	public String OpenFilter(String filter){
		String fetch_error = null;
		String display_error = "";
		int i;
		try{
			WebElement sidebarholder = driver.findElement(By.className("sidebar-holder"));
			List<WebElement> filterlist = sidebarholder.findElements(By.className("sidebar-column"));
			for (i=0; i < filterlist.size(); i++){
				String filtername= filterlist.get(i).getText();
				if (filtername.equals(filter)){
					filterlist.get(i).click();
					break;
				}
			}
			if (filter.equals("Passions")){
			driver.findElement(By.xpath("//*[@id='load_passion']")).click();
			WebElement SelectedFilter = filterlist.get(0);///html/body/form/div/div/div[1]/div/div[1]
			List<WebElement> filteroptions= SelectedFilter.findElements(By.tagName("li"));
			driver.findElement(By.xpath("/html/body/form/div/div/div[1]/div/div[1]/ul/li[2]/label/span")).click();
			Extensions.WaitForPageFullyLoaded();
			driver.findElement(By.xpath("/html/body/form/div/div/div[1]/div/div[1]/ul/li[7]/label/span")).click();
			Extensions.WaitForPageFullyLoaded();
			driver.findElement(By.xpath("/html/body/form/div/div/div[1]/div/div[1]/ul/li[11]/label/span")).click();}
			if (filter.equals("Education")){
				driver.findElement(By.xpath("/html/body/form/div/div/div[1]/div/div[2]/ul/li[2]/label/span")).click();
			}
			if (filter.equals("City")){
				driver.findElement(By.xpath("/html/body/form/div/div/div[1]/div/div[5]/ul/li[5]/label/span")).click();
			}
			if (filter.equals("Business phase")){
				driver.findElement(By.xpath("/html/body/form/div/div/div[1]/div/div[3]/ul/li[4]/label/span")).click();
			}
			if (filter.equals("Type of venture")){
				driver.findElement(By.xpath("/html/body/form/div/div/div[1]/div/div[4]/ul/li[1]/label/span")).click();
			}
			if (filter.equals("Skill")){
				driver.findElement(By.xpath("//*[@id='load_skill']")).click();
				driver.findElement(By.xpath("/html/body/form/div/div/div[1]/div/div[6]/ul/li[8]/label/span")).click();
					
				}
			driver.navigate().refresh();
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
//	for (int j =0; j<  filtervalues.length; j++){
////driver.findElement(By.xpath("//*[@id='load_passion']")).click();
//SelectedFilter = filterlist.get(i);
//Thread.sleep(5000);
//try{
//WebElement sidebarholder1 = driver.findElement(By.className("sidebar-holder"));
//List<WebElement> filterlist1 = driver.findElements(By.className("sidebar-column"));
//for (i=0; i < filterlist.size(); i++){
//	WebElement fillist= filterlist.get(i).findElement(By.tagName("h2"));
//	String filtername= fillist.getText();
//	if (filtername.equals(filter)){
//		 filteroptions =filterlist.get(i).findElements(By.tagName("li"));
//		 break;
//		}
//	}
//}
//catch (Exception e){
//	WebElement sidebarholder1 = driver.findElement(By.className("sidebar-holder"));
//	List<WebElement> filterlist1 = driver.findElements(By.className("sidebar-column"));
//	for (i=0; i < filterlist.size(); i++){
//		WebElement fillist= filterlist.get(i).findElement(By.tagName("h2"));
//		String filtername= fillist.getText();
//		if (filtername.equals(filter)){
//			 filteroptions =filterlist.get(i).findElements(By.tagName("li"));
//			 break;
//			}
//		}
//}
//for (int count = 0; count <=  filteroptions.size(); count++){
////	String Pstage 
//	System.out.println(count);
//	WebElement filvalue=  filteroptions.get(count).findElement(By.tagName("label"));
////	WebElement fetchvalue= filvalue.findElement(By.tagName("span"));
//	String Pstage = filvalue.getText();
//	System.out.println(Pstage);
//	if (Pstage.contains(filtervalues[j])){
//		filteroptions.get(count).findElement(By.tagName("span")).click();
//		Extensions.WaitForPageFullyLoaded();
//		driver.navigate().refresh();
//		break;
//  }
//}
//}

}
