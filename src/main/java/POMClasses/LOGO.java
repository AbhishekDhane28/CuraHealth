package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LOGO {
	@FindBy(xpath = "//div[@class='navigation-logo']/child::a[@href='https://company.cura.healthcare/en']")
	private WebElement Logo;
	
	
	
	public LOGO (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
    }
	
	
	
	public void clickonlogo()
	{
		Logo.click();
	}


}
