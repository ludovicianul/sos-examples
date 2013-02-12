package com.insidecoding.sos.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.insidecoding.sos.junit.AbstractSoSBase;

public class TestEmag extends AbstractSoSBase {

	@Test
	public void testFrontPage() throws Exception {
		driver.get("http://emag.ro");

		WebElement search = driver.findElement(By.id("input_search"));
		search.sendKeys(fileUtil.readFromExcel("Values.xlsx", "Sheet1", 2, 0));

		driver.findElement(By.xpath("//form[@id='search-global']/div[2]"))
				.click();
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
