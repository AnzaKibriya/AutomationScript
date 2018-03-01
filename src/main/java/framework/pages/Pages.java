package framework.pages;
import org.openqa.selenium.support.PageFactory;

import framework.helper.BaseCase;

public class Pages {
	public static On_Boadring_Process On_Boadring_Process() {
		On_Boadring_Process pg = new On_Boadring_Process(BaseCase.driver);
		PageFactory.initElements(BaseCase.driver, pg);
		return pg;
	}

	public static Login Login() {
		Login pg = new Login(BaseCase.driver);
		PageFactory.initElements(BaseCase.driver, pg);
		return pg;
	}
	public static Navigation_Page Navigation_Page() {
		Navigation_Page pg = new Navigation_Page(BaseCase.driver);
		PageFactory.initElements(BaseCase.driver, pg);
		return pg;
	}
	public static CreateVenture CreateVenture() {
		CreateVenture pg = new CreateVenture(BaseCase.driver);
		PageFactory.initElements(BaseCase.driver, pg);
		return pg;
	}
	public static User_Profile User_Profile() {
		User_Profile pg = new User_Profile(BaseCase.driver);
		PageFactory.initElements(BaseCase.driver, pg);
		return pg;
	}
	public static VenturePage VenturePage() {
		VenturePage pg = new VenturePage(BaseCase.driver);
		PageFactory.initElements(BaseCase.driver, pg);
		return pg;
	}
	public static  MyNetwork  MyNetwork() {
		 MyNetwork pg = new  MyNetwork(BaseCase.driver);
		PageFactory.initElements(BaseCase.driver, pg);
		return pg;
	}
	public static  Search_Page  Search_Page() {
		Search_Page pg = new  Search_Page(BaseCase.driver);
		PageFactory.initElements(BaseCase.driver, pg);
		return pg;
	}
	public static  Admin_login  Admin_login() {
		Admin_login pg = new  Admin_login(BaseCase.driver);
		PageFactory.initElements(BaseCase.driver, pg);
		return pg;
	}

}//Admin_login
