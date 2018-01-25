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
		logger.log(LogStatus.INFO, "Sign In through FB");
		Pages.Login().LogintoSpark();
		logger.log(LogStatus.PASS, "Log in to SparkXYZ successfuly");
		
	}
	@Test(priority = 2, enabled = false)
	public void Test_OnboardValidation() throws InterruptedException {
		System.out.println("===========================================================");
		System.out.println("================= Test_OnboardValidation  =================");
		System.out.println("===========================================================");
		logger = report.startTest("Test On-Boarding Process Validation");
		logger.log(LogStatus.INFO, "On-Boarding Process");
		logger.log(LogStatus.INFO, "Negative Location form On-Boarding Process");
		String Neglocation= Pages.On_Boadring_Process().Negative_location();
		if (Neglocation !=""){
			logger.log(LogStatus.FAIL, Neglocation);
			}
			else{
				logger.log(LogStatus.PASS, "Location Page is successful");
				}
		logger.log(LogStatus.INFO, "Fill Location form On-Boarding Process");
		String Statuslocation= Pages.On_Boadring_Process().Location_form("Anza.kibriya@kualitatem.com", "Pakistan", "5400");
		if (Statuslocation !=""){
			logger.log(LogStatus.FAIL, Statuslocation);
			}
			else{
				logger.log(LogStatus.PASS, "Location Page is successful");
				}
		logger.log(LogStatus.INFO, "Negative Education form On-Boarding Process");
		String Negedu= Pages.On_Boadring_Process().Negative_Edu();
		if (Negedu !=""){
			logger.log(LogStatus.FAIL,Negedu);
			}
			else{
				logger.log(LogStatus.PASS, "Education Page is successful");
				}
		logger.log(LogStatus.INFO, "Fill Education form On-Boarding Process");
		String Statusedu= Pages.On_Boadring_Process().Education_Form("UCLA", "BSCS", "CS", "8", "2012", "12", "2016");
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
	@Test(priority = 3, enabled = false)
	public void Test_VentureCreation() throws InterruptedException {
		System.out.println("===========================================================");
		System.out.println("================= Test_VentureCreation ====================");
		System.out.println("===========================================================");
		logger = report.startTest("Test_Venture Creation");
		logger.log(LogStatus.INFO, "Venture Creation Process");
		String Navigation = Pages.Navigation_Page().GotoVentureCreation();
		if (Navigation !=""){
			logger.log(LogStatus.FAIL, Navigation);
			}
			else{
				logger.log(LogStatus.PASS, "Goto Venture Creation page is successful");
				}
		logger.log(LogStatus.INFO, "Negative Venture Name");
		String NegTitle = Pages.CreateVenture().Neg_Ven_Title();
		if ( NegTitle !=""){
			logger.log(LogStatus.FAIL, NegTitle);
			}
			else{
				logger.log(LogStatus.PASS, "Negative Venture Title is successful");
				}
		logger.log(LogStatus.INFO, "Add Venture Name");
		String Title = "TestingVenture";
		String VenTitle = Pages.CreateVenture().Ven_Title(Title);
		if ( VenTitle !=""){
			logger.log(LogStatus.FAIL, VenTitle);
			}
			else{
				logger.log(LogStatus.PASS, " Venture Title  is successful");
				}
		logger.log(LogStatus.INFO, "Negative Venture Business Stage");
		String NegBusinessStage = Pages.CreateVenture().Neg_Ven_Bus();
		if (NegBusinessStage !=""){
			logger.log(LogStatus.FAIL,  NegBusinessStage);
			}
			else{
				logger.log(LogStatus.PASS, "Negative Venture Business Stage is successful");
				}
		logger.log(LogStatus.INFO, "Venture Business Stage");
		String VenBusinessStage = Pages.CreateVenture().Ven_Business("Business plan mapped out", "Venture Capital Backed", "Lahore");
		if (VenBusinessStage !=""){
			logger.log(LogStatus.FAIL,  VenBusinessStage);
			}
			else{
				logger.log(LogStatus.PASS, "Venture Business Stage is successful");
				}
		logger.log(LogStatus.INFO, "Negative Venture Elevator Pitch");
		String NegElevatorpitch = Pages.CreateVenture().Neg_ele_pit();
		if (NegElevatorpitch !=""){
			logger.log(LogStatus.FAIL,  NegElevatorpitch);
			}
			else{
				logger.log(LogStatus.PASS, "Negative Venture Elevator Pitch is successful");
				}
		logger.log(LogStatus.INFO, "Venture Elevator Pitch");
		String VenElevatorpitch = Pages.CreateVenture().elevator_pitch("if opportunity doesn't knock, build a door.- Milton Berle");
		if (VenElevatorpitch !=""){
			logger.log(LogStatus.FAIL,  VenElevatorpitch);
			}
			else{
				logger.log(LogStatus.PASS, "Venture Elevator Pitch is successful");
				}
		logger.log(LogStatus.INFO, "Negative Venture for Problem");
		String NegProblem = Pages.CreateVenture().Neg_business_Problem();
		if (NegProblem !=""){
			logger.log(LogStatus.FAIL,  NegProblem);
			}
			else{
				logger.log(LogStatus.PASS, "Negatuve Venture for Problem is successful");
				}
		logger.log(LogStatus.INFO, "Venture for Problem");
		String VenProblem = Pages.CreateVenture().business_problem("Spark xyz helps students and entrepreneurs connect across disciplines to create better teams,network, and avoid the pitfalls of founding.");
		if (VenProblem !=""){
			logger.log(LogStatus.FAIL,  VenProblem);
			}
			else{
				logger.log(LogStatus.PASS, "Venture for Problem successful");
				}
		logger.log(LogStatus.INFO, "Negative Proposed Solution for Venture");
		String NegSolution = Pages.CreateVenture().Neg_business_solution();
		if ( NegSolution !=""){
			logger.log(LogStatus.FAIL, NegSolution);
			}
			else{
				logger.log(LogStatus.PASS, "Negative Proposed Solution for Venture is successful");
				}
		logger.log(LogStatus.INFO, "Proposed Solution for Venture");
		String VenSolution = Pages.CreateVenture().business_solution("Spark xyz helps students and entrepreneurs connect across disciplines to create better teams,network, and avoid the pitfalls of founding.");
		if ( VenSolution !=""){
			logger.log(LogStatus.FAIL, VenSolution);
			}
			else{
				logger.log(LogStatus.PASS, "Proposed Solution for Venture is successful");
				}
		logger.log(LogStatus.INFO, "Negative Interest of Venture");
		String Neginterest = Pages.CreateVenture().Neg_interest_form();
		if ( Neginterest !=""){
			logger.log(LogStatus.FAIL, Neginterest);
			}
			else{
				logger.log(LogStatus.PASS, "Negative Interest of Venture is successful");
				}
		String[] interestArray = new String[]{"DESIGN","ENERGY","ART","PR"};
		logger.log(LogStatus.INFO, "Interest of Venture");
		String Veninterest = Pages.CreateVenture().interest_form(interestArray);
		if ( Veninterest !=""){
			logger.log(LogStatus.FAIL, Veninterest);
			}
			else{
				logger.log(LogStatus.PASS, "Interest of Venture is successful");
				}
		logger.log(LogStatus.INFO, "Negative Add Team Member");
		String NegTeamMember = Pages.CreateVenture().Neg_Add_Teammember();
		if ( NegTeamMember !=""){
			logger.log(LogStatus.FAIL,NegTeamMember);
			}
			else{
				logger.log(LogStatus.PASS, "Negative Add Team Member is successful");
			}
		logger.log(LogStatus.INFO, "Add Team Member");
		String VenTeamMember = Pages.CreateVenture().Add_Teammember("lokatkholi@gmail.com", "QA");
		if ( VenTeamMember !=""){
			logger.log(LogStatus.FAIL,VenTeamMember);
			}
			else{
				logger.log(LogStatus.PASS, "Add Team Member is successful");
			}
		logger.log(LogStatus.INFO, "Add Position");
		String[] primaryArray = new String[]{"BUSINESS","EDUCATION"};
		String[] secondaryArray = new String[]{"KYC","RESEARCH"};
		String VenPosition = Pages.CreateVenture().Add_Position("QA", "Spark xyz helps students and entrepreneurs connect across disciplines to create better teams,network, and avoid the pitfalls of founding.", primaryArray, secondaryArray);
		if ( VenPosition !=""){
			logger.log(LogStatus.FAIL,VenPosition);
			}
			else{
				logger.log(LogStatus.PASS, "Add Position is successful");
			}	
		logger.log(LogStatus.INFO, "Networking Venture");
		String Vennetwork = Pages.CreateVenture().network_interest();
		if ( Vennetwork !=""){
			logger.log(LogStatus.FAIL,Vennetwork);
			}
			else{
				logger.log(LogStatus.PASS, "Networking Venture is successful");
			}
		logger.log(LogStatus.INFO, "Venture Website");
		String Venwebsite = Pages.CreateVenture().Venture_website("spark-io-staging.herokuapp.com");
		if ( Venwebsite !=""){
			logger.log(LogStatus.FAIL,Venwebsite);
			}
			else{
				logger.log(LogStatus.PASS, "Venture Website is successful");
			}
		logger.log(LogStatus.INFO, "Upload files");
		String Venupload = Pages.CreateVenture().Venture_FilesUpload();
		if ( Venupload !=""){
			logger.log(LogStatus.FAIL,Venupload);
			}
			else{
				logger.log(LogStatus.PASS, "Upload files is successful");
			}
		logger.log(LogStatus.INFO, "Verify Venture");
		String Venverify = Pages.CreateVenture().verify_venture(Title);
		if ( Venverify !=""){
			logger.log(LogStatus.FAIL,Venverify);
			}
			else{
				logger.log(LogStatus.PASS, "Verify Venture is successful");
			}
	}
	
	@Test(priority = 4, enabled = true)
	public void Test_UserProfile() throws InterruptedException {
		System.out.println("===========================================================");
		System.out.println("================= Test_UserProfile ====================");
		System.out.println("===========================================================");
		logger = report.startTest("Test_UserProfile");
		String Navigation = Pages.Navigation_Page().GotoProfilePage();
		if (Navigation !=""){
			logger.log(LogStatus.FAIL, Navigation);
			}
			else{
				logger.log(LogStatus.PASS, "Goto User Profile page is successful");
				}
		logger.log(LogStatus.INFO, "Verifying both Negative Positive Scenarios of Adding Experience to User Profile");
//		String Expmessgae = Pages.User_Profile().Add_new_experience("TestingExp", "KTM", "2", "2010", "5", "2015");
//		if (Expmessgae != ""){
//			if (Expmessgae.contains("Negative Scenario Error:")){
//				logger.log(LogStatus.FAIL,Expmessgae);
//				logger.log(LogStatus.PASS, "Experience Record gets saved");	
//			}
//			else{
//				logger.log(LogStatus.PASS, "Negative Scenarios of Experience Record are passed");	
//				logger.log(LogStatus.FAIL,Expmessgae);
//			}	
//		}
//		else{
//			logger.log(LogStatus.PASS, "Negative Scenarios of Experience Record are passed");
//			logger.log(LogStatus.PASS, "Experience Record gets saved");
//		}
//		logger.log(LogStatus.INFO, "Verifying both Negative Positive Scenarios of Adding Education to User Profile");
		String SchoolTitle= "Ghirardelli Square";
		String Edumessgae = Pages.User_Profile().Add_new_education(SchoolTitle, "CS", "CS","2", "2010", "5", "2015");
		if (Edumessgae != ""){
			if (Edumessgae.contains("Negative Scenario Error:")){
				logger.log(LogStatus.FAIL,Edumessgae);
				logger.log(LogStatus.PASS, "Education Record gets saved");	
			}
			else{
				logger.log(LogStatus.PASS, "Negative Scenarios of Education Record are passed");	
				logger.log(LogStatus.FAIL,Edumessgae);
			}	
		}
		else{
			logger.log(LogStatus.PASS, "Negative Scenarios of Education Record are passed");
			logger.log(LogStatus.PASS, "Education Record gets saved");
		}
		String deledu = Pages.User_Profile().delete_eduction(SchoolTitle);
		if ( deledu !=""){
			logger.log(LogStatus.FAIL,deledu);
			}
			else{
				logger.log(LogStatus.PASS, "Venture Website is successful");
			}
//		logger.log(LogStatus.INFO, "Verifying both Negative Positive Scenarios of Adding Volunteer Experience to User Profile");
//		String VolExpmessgae = Pages.User_Profile().Add_new_volunteerexp("bbl", "Test", "Test", "11", "2016", "5", "2017");
//		if (VolExpmessgae != ""){
//			if (VolExpmessgae.contains("Negative Scenario Error:")){
//				logger.log(LogStatus.FAIL,VolExpmessgae);
//				logger.log(LogStatus.PASS, "Volunteer Experience Record gets saved");	
//			}
//			else{
//				logger.log(LogStatus.PASS, "Negative Scenarios of Volunteer Experience Record are passed");	
//				logger.log(LogStatus.FAIL,VolExpmessgae);
//			}	
//		}
//		else{
//			logger.log(LogStatus.PASS, "Negative Scenarios of Volunteer Experience Record are passed");
//			logger.log(LogStatus.PASS, "Volunteer Experience Record gets saved");
//		}
//		logger.log(LogStatus.INFO, "Verifying both Negative Positive Scenarios of Adding Group to User Profile");
//		String groupmessgae = Pages.User_Profile().Add_new_group("BBL", "QA", "5", "2000", "2", "2001");
//		if (groupmessgae != ""){
//			if (groupmessgae.contains("Negative Scenario Error:")){
//				logger.log(LogStatus.FAIL,groupmessgae);
//				logger.log(LogStatus.PASS, "Group Record gets saved");	
//			}
//			else{
//				logger.log(LogStatus.PASS, "Negative Scenarios of Group Record are passed");	
//				logger.log(LogStatus.FAIL,groupmessgae);
//			}	
//		}
//		else{
//			logger.log(LogStatus.PASS, "Negative Scenarios of Group Record are passed");
//			logger.log(LogStatus.PASS, "Group Record gets saved");
//		}
//		logger.log(LogStatus.INFO, "Verifying both Negative Positive Scenarios of Adding AWard to User Profile");
//		String awardmessgae = Pages.User_Profile().Add_new_award("Rising Talent", "KTM", "12", "2017");
//		if (awardmessgae != ""){
//			if (awardmessgae.contains("Negative Scenario Error:")){
//				logger.log(LogStatus.FAIL,awardmessgae);
//				logger.log(LogStatus.PASS, "AWard Record gets saved");	
//			}
//			else{
//				logger.log(LogStatus.PASS, "Negative Scenarios of Award Record are passed");	
//				logger.log(LogStatus.FAIL,awardmessgae);
//			}	
//		}
//		else{
//			logger.log(LogStatus.PASS, "Negative Scenarios of Award Record are passed");
//			logger.log(LogStatus.PASS, "Award Record gets saved");
//		}
	}	
}
