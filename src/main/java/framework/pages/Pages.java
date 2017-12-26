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

}//On_Boadring_Process
