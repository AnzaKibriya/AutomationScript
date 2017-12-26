package framework.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Extensions {

	public static void WaitForTheTitle(String expectedTitle) {
		WebDriverWait wait = new WebDriverWait(BaseCase.driver, 120);
		wait.until(ExpectedConditions.titleIs(expectedTitle));
	}

	public static void WaitForPageFullyLoaded() {
		WebDriverWait wait = new WebDriverWait(BaseCase.driver, 120);

		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver wdriver) {
				return ((JavascriptExecutor) BaseCase.driver).executeScript("return document.readyState")
						.equals("complete");
			}
		});

	}

	public static WebElement GetParentElement(WebElement childElement) {
		WebElement parent = null;
		parent = (WebElement) ((JavascriptExecutor) BaseCase.driver).executeScript("return arguments[0].parentNode;",
				childElement);

		return parent;

	}

	public static WebElement GetGrandParentElement(WebElement childElement) {
		WebElement grandParent = null;

		grandParent = GetParentElement(GetParentElement(childElement));

		return grandParent;

	}

	public static void ScrollDownPage() {

		JavascriptExecutor executor = (JavascriptExecutor) BaseCase.driver;
		Long value = (Long) executor.executeScript("return window.scrollY;");

		String jsScript = "window.scrollBy(" + value + ",350)"; // "scroll"
																// +value
																// +",350)";
		// ((JavascriptExecutor)
		// driver).executeScript("window.scrollBy(0,500)");
		((JavascriptExecutor) BaseCase.driver).executeScript(jsScript);

	}

	public static void WaitForElementInvisible(By locator) {
		WebDriverWait wait = new WebDriverWait(BaseCase.driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public static void WaitForElementVisibleAndClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(BaseCase.driver, 30);
		wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(element),
				ExpectedConditions.elementToBeClickable(element)));
	}

}
