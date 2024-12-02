package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BLOGPAGE {
	
	@FindBy(xpath = "//a[text()='Public Health']")
	private WebElement PublicHealth;
	
	@FindBy(xpath="//ul[@class='sidebar-categories-list']/descendant::a[text()='News']")
	private WebElement News;
	
	
	
	public BLOGPAGE (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
    }
	
	
	public void clickonPublicHealth()
	{
		PublicHealth.click();
	}

    public void clickonNews()
    {
    	News.click();    }
}
