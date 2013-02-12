package com.insidecoding.sos.sample;

import java.io.File;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.insidecoding.sos.junit.AbstractSoSBase;
import com.insidecoding.sos.xml.XMLUtils;

public class TestGoogleWithXMLFile extends AbstractSoSBase {

	@Test
	public void testGoogleFromXMLFile() throws Exception {
		driver.get("http://google.com");
		WebElement search = driver.findElement(By.name("q"));

		XMLUtils xmlUtils = new XMLUtils();

		String toSearch = xmlUtils.getTagText(new File("myXML.xml"), "UTF-8",
				"name");
		search.sendKeys(toSearch);
		search.submit();
		helper.waitForTextPresentWithinPage("seconds", 10);
		Assert.assertTrue(helper.isTextPresentInPage("seconds"));

		String attrToSearch = xmlUtils.getValueOfTagAttribute(new File(
				"myXML.xml"), "UTF-8", "name", "hobby");
		search.sendKeys(attrToSearch);
		search.submit();
		helper.waitForTextPresentWithinPage("seconds", 10);
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
