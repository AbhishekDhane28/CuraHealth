package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HOMEPAGE {
	
	@FindBy(xpath = "//a[text()='Blog']")
	private WebElement Blog;
	
	
	
	public HOMEPAGE (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
    }
	
	
	
	public void clickonBlog()
	{
		Blog.click();
	}
}