package com.insidecoding.sos.sample;

import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.insidecoding.sos.junit.AbstractSoSBase;

public class TestGoogleWithCSV extends AbstractSoSBase {

	@Test
	public void testGoogleSearchFromCSV() throws Exception {
		Map<String, List<String>> CSV = fileUtil.parseCSV("id,name,age",
				"config.csv", ",", "UTF-8");
		driver.get("http://google.com");
		WebElement search = driver.findElement(By.name("q"));

		List<String> toSearch = CSV.get("name");

		for (String name : toSearch) {
			search.sendKeys(name);
			search.submit();
			helper.waitForTextPresentWithinPage("seconds", 10);
			Assert.assertTrue(helper.isTextPresentInPage("seconds"));
		}

	}

	@Override
	protected void doAdditionalSetUp() {
		// no need
	}

	@Override
	protected void doAdditionalTearDown() {
		// no need
	}
}
