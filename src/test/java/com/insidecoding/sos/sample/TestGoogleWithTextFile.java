package com.insidecoding.sos.sample;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.insidecoding.sos.junit.AbstractSoSBase;

public class TestGoogleWithTextFile extends AbstractSoSBase {

	@Test
	public void testGoogleFromTextFile() throws Exception {
		List<String> content = fileUtil.getFileAsList("content.txt", "UTF-8");
		driver.get("http://google.com");
		WebElement search = driver.findElement(By.name("q"));

		for (String elem : content) {
			search.sendKeys(elem);
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
