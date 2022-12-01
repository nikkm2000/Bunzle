package com.eperium.jumpstart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Solr extends Setup{

	public static WebDriver driver = null;
	public static WebDriver driver1;
	private String solrPriceUuid;
	
	 @Test(description="setting UuID for price change in solr")
	    public void setUuidForPriceChangeInSolr() throws InterruptedException
	    {
	    	moduleName = "SolrPrice";
		    methodName = "setUuidForPriceChangeInSolr";
		    channelLocator="specChannel";
		    initialize(moduleName,methodName, channelLocator);
		    String articleNo=driver.findElement(By.xpath("//table//tr[2]/td[3]/div/div[3]")).getText();
	        String[] s=articleNo.split(": ",2);
	        String solrProductSku =s[1];
	        System.out.println(solrProductSku);
	        
	        String headerDeliveryID=driver.findElement(By.xpath("//*[@id='container']/header/div[3]/div[2]/div[1]")).getText();
	        String DeliveryID = headerDeliveryID.substring(headerDeliveryID.indexOf("(")+1,headerDeliveryID.indexOf(")"));
	        System.out.println(DeliveryID);
	        solrPriceUuid=DeliveryID+"_"+solrProductSku;
	        System.out.println(solrPriceUuid);
	    }
	    
	    @Test(description="go to solr ax price query section")
	    public void goToSolrPriceQuery() throws InterruptedException
	   {
	   	    moduleName = "SolrPrice";
		    methodName = "goToSolrPriceQuery";
		    channelLocator="specChannel";
		    initialize(moduleName,methodName, channelLocator);
	        driver1.get("http://10.5.8.80:8080/solr/#/Bunzl-King-AX_price/query");
		    testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver1, channelLocator);
	    
	   }
	    
	    
	    @Test(description="check EAN Sales unit of UUID on solr ax price query section")
	    public void checkSalesUnitOfUuid() throws InterruptedException
	   {
	   	    moduleName = "SolrPrice";
		    methodName = "checkSalesUnitOfUuid";
		    channelLocator="specChannel";
		    initialize(moduleName,methodName, channelLocator);
		    Thread.sleep(10000);
	        driver1.findElement(By.id("q")).clear();
	        driver1.findElement(By.id("q")).sendKeys("UUID"+":"+solrPriceUuid);
	        driver1.findElement(By.xpath("//*[@type='submit']")).click();
		    testCaseUtil.checkAllTextMsgs(moduleName, methodName, noClick, driver1,channelLocator);
	    
	   }
	    

	    @Test(description="check EAN Sales unit of UUID on solr ax price query section")
	    public void createQueryToChangePrice() throws InterruptedException
	   {
	   	    moduleName = "SolrPrice";
		    methodName = "createQueryToChangePrice";
		    channelLocator="specChannel";
		    initialize(moduleName,methodName, channelLocator);
		    String[] sa = new String[5];
		    String UUID;
		    String pInfo;
		    String ean;
		    String salesUnit;
		    String timeStamp;
		    String query;
	        
		    UUID=solrPriceUuid;
		    	
		    	for(int i=6,j=0;i<13;i=i+2,j++)
			    {
		    	System.out.println(( driver1.findElement(By.xpath("//*[@id='response']/pre/code/span[4]/span[6]/span["+i+"]"))).getText());
		        String a=driver1.findElement(By.xpath("//*[@id='response']/pre/code/span[4]/span[6]/span["+i+"]")).getText();
		        sa[j]=a;
		        System.out.println(sa[j]);
			    }
		    	for(int i=0;i<4;i++)
		    	{
		    		System.out.println(sa[i]);
		    	}
	        
	        query="{\"UUID\":"+"\"" +UUID+ "" +"\",price\":\""+"10.02"+"\""  + ",timestamp\":"+sa[0]+""  +",\"salesUnit\":"+sa[1]+"\""   +"\",ean\":"+sa[2]+"\""   +"\"packagingInfo\":"+sa[2]+"\""  ;
	        System.out.println(query);
	    
	   }

}
