package suites.sanity;
import org.testng.annotations.Test;
import framework.datalayer.DataSet;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;

import framework.helper.BaseCase;
import framework.pages.Pages;

import javax.mail.MessagingException;
import java.io.IOException;

public class Test_Users  extends BaseCase {
	@Test(priority = 1, enabled = true)
	public void Test_LoginValidation() throws InterruptedException {

		System.out.println("===========================================================");
		System.out.println("======================= Test UserLogin ====================");
		System.out.println("===========================================================");

		logger = report.startTest(" User Login Validation");
		logger.log(LogStatus.INFO, "Go to Website");
		logger.log(LogStatus.INFO, "Sign In through FB");
		Pages.Login().LogintoSpark();;
		logger.log(LogStatus.PASS, "Log in to SparkXYZ successfuly");
		
	}
	@Test(priority = 2, enabled = true)
	public void Test_OnboardValidation() throws InterruptedException {
		System.out.println("===========================================================");
		System.out.println("================= Test_OnboardValidation  =================");
		System.out.println("===========================================================");
		logger.log(LogStatus.INFO, "On-Boarding Process");
//		logger.log(LogStatus.INFO, "Negative Location form On-Boarding Process");
//		String Neglocation= Pages.On_Boadring_Process().Negative_location();
//		if (Neglocation !=""){
//			logger.log(LogStatus.FAIL, Neglocation);
//			}
//			else{
//				logger.log(LogStatus.PASS, "Location Page is successful");
//				}
//		logger.log(LogStatus.INFO, "Fill Location form On-Boarding Process");
//		String Statuslocation= Pages.On_Boadring_Process().Location_form("Anza.kibriya@kualitatem.com", "Pakistan", "5400");
//		if (Statuslocation !=""){
//			logger.log(LogStatus.FAIL, Statuslocation);
//			}
//			else{
//				logger.log(LogStatus.PASS, "Location Page is successful");
//				}
		logger.log(LogStatus.INFO, "Negative Education form On-Boarding Process");
		String Negedu= Pages.On_Boadring_Process().Negative_Edu();
		if (Negedu !=""){
			logger.log(LogStatus.FAIL,Negedu);
			}
			else{
				logger.log(LogStatus.PASS, "Education Page is successful");
				}
		logger.log(LogStatus.INFO, "Fill Education form On-Boarding Process");
		String Statusedu= Pages.On_Boadring_Process().Education_Form("GCU", "BSCS", "CS", "8", "2012", "12", "2016");
		if (Statusedu !=""){
			logger.log(LogStatus.FAIL, Statusedu);
			}
			else{
				logger.log(LogStatus.PASS, "Education Page is successful");
				}
		logger.log(LogStatus.INFO, "Fill Career form On-Boarding Process");
	   String Statuscar= Pages.On_Boadring_Process().Career_Form("QA", "KTM", "Lahore", "5", "2017", "", "");
	   if (Statuscar !=""){
			logger.log(LogStatus.FAIL, Statuscar);
			}
			else{
				logger.log(LogStatus.PASS, "Education Page is successful");
				}
	   logger.log(LogStatus.INFO, "Fill Skill Stage form On-Boarding Process");
	   String Statusskill = Pages.On_Boadring_Process().Skills_form("Education", "Lecturing");
	   if (Statusskill !=""){
			logger.log(LogStatus.FAIL, Statusskill);
			}
			else{
				logger.log(LogStatus.PASS, "skill Page is successful");
				}
	   logger.log(LogStatus.INFO, "Fill Business Stage form On-Boarding Process");
	   String Statusbusiness = Pages.On_Boadring_Process().BusinessStage_form("idea", "lifestyle", "Graduate");
	   if (Statusbusiness !=""){
			logger.log(LogStatus.FAIL, Statusbusiness);
			}
			else{
				logger.log(LogStatus.PASS, "business stage Page is successful");
				}
	   logger.log(LogStatus.INFO, "Fill Passion Page On-Boarding Process");
	   String[] passionArray = new String[]{"Design","Energy","Agriculture","Art", "PR"};
	   String Statuspassion= Pages.On_Boadring_Process().passion_form(passionArray);
	   if (Statuspassion !=""){
			logger.log(LogStatus.FAIL, Statuspassion);
			}
			else{
				logger.log(LogStatus.PASS, "Passion Page is successful");
				}
	   logger.log(LogStatus.INFO, "Fill Import Connection Page On-Boarding Process");
	   String Statusimport= Pages.On_Boadring_Process().import_connection();
	   if (Statusimport !=""){
			logger.log(LogStatus.FAIL, Statusimport);
			}
			else{
				logger.log(LogStatus.PASS, "Import page is successful");
				}
	   logger.log(LogStatus.INFO, "Fill fill Connection Page On-Boarding Process");
	   String Statusinvite= Pages.On_Boadring_Process().invite_connection();
	   if (Statusinvite !=""){
			logger.log(LogStatus.FAIL, Statusinvite);
			}
			else{
				logger.log(LogStatus.PASS, "Invite page is successful");
				}
	   logger.log(LogStatus.INFO, "Fill Reason Page On-Boarding Process");
	   String Statusreason= Pages.On_Boadring_Process().Reason_to_join("Looking to join a startup");
	   if (Statusreason !=""){
			logger.log(LogStatus.FAIL, Statusreason);
			}
			else{
				logger.log(LogStatus.PASS, "Reason page is successful");
				}
		}
	
}
