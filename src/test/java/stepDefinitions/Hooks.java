package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.testConceptSetup;

public class Hooks {
	
testConceptSetup testconceptsetup;
	
	public Hooks(testConceptSetup testconceptsetup)
	{
		this.testconceptsetup=testconceptsetup;
	}

	@After
	public void tearDown() throws IOException
	{
		testconceptsetup.baseTest.WebDriverManager().quit();
	}
	
	@AfterStep
	public void addScreenShot(Scenario scenario) throws IOException
	{
		WebDriver driver=testconceptsetup.baseTest.WebDriverManager();
		if(scenario.isFailed())
		{
		//screenshot
			File sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent=FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");
		}
	}
	
}
