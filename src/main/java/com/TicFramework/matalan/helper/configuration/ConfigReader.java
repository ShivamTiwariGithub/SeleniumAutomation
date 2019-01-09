package com.TicFramework.matalan.helper.configuration;

import com.TicFramework.matalan.helper.browserConfiguration.BrowserType;
/**
 * 
 * @author Shivam Tiwari
 *
 */
public interface ConfigReader {
	
	public int getImpliciteWait();
	public int getExplicitWait();
	public int getPageLoadTime();
	public BrowserType getBrowserType();
	public String getUrl();
	public String getUserName();
	public String getPassword();

}
