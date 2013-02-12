package com.insidecoding.sos.sample;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.insidecoding.sos.junit.AbstractSoSBase;

/**
 * Test class for some simple functionalities.
 * 
 * @author ludovicianul
 * 
 */
public class TestGoogleSearch extends AbstractSoSBase {

	private static final Logger LOG = Logger.getLogger(TestGoogleSearch.class);

	@Test
	public void testSimpleSearch() throws Exception {
		LOG.info("Driver received: " + driver);

		driver.get("http://google.com");

		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys(fileUtil.getPropertyAsString("configuration",
				"toSearch"));

		// We use the helper in order to wait for an element to be present
		helper.waitForElementPresent(By.id("ires"), 10);

		Assert.assertTrue(helper.isTextPresentInPage("seconds"));
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
