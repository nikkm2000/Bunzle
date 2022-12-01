package com.eperium.jumpstart.testframework.utils;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.eperium.jumpstart.testframework.xml.*;


 
public class AdvanceXMLUtil {
 
	static Channel channel = null;
	static Channel specChannel = null;
	static Channel comChannel = null;
	
	
	public static String getValueForTimeOutById (String moduleName, String method,String nodeName,String channelLocator) 
	{
		XMLMethod xmlMethod=getxmlMethod (moduleName, method,channelLocator);
		if(xmlMethod!=null)
		{	
			System.out.println("Timeout value for method "+method+": "+xmlMethod.getTimeOut().toString());
			return xmlMethod.getTimeOut().toString();
		}
		else
		{
				return new String("120"); //default timeout of 120 seconds
		}
	}
	
	public static XMLMethod getxmlMethod (String moduleName, String method,String channelLocator) 
	{
		if(channelLocator.contains("specChannel")){
			channel=specChannel;
		}else channel=comChannel;
		for(Module module:channel.getModules())
		{
			if(module.getName().equals(moduleName))
			{
				for(XMLMethod xmlMethod:module.getXmlMethods())
				{
					if(xmlMethod.getName().equals(method))
					{
						return 	xmlMethod;
					}
				}
			}
		}
		return 	null;
	}
	
	public static List<? extends ValidateableXMLElement> getAllVerifyTextForClick(String moduleName, String method,String buttonId,String paramType,String channelLocator) 
	{
		List<? extends ValidateableXMLElement> verifyTextDataList = null;
		XMLMethod xmlMethod=getxmlMethod (moduleName, method,channelLocator);
		if(xmlMethod.getClick()!=null)
		{
			for(Click click:xmlMethod.getClick())
			{
				Button button=getClickButtonById(click,buttonId);
				
				if(button!=null && button.getVerifyTexts()!=null)
				{
					for(VerifyText verifyText :button.getVerifyTexts())
					{
						verifyTextDataList=getVerifyTextData(verifyText,paramType);
					}
				}
			}
		}
		
		System.out.println(paramType+" list to validate after click= "+verifyTextDataList);
		return verifyTextDataList;
	}
	
	private static List<? extends ValidateableXMLElement>  getVerifyTextData(VerifyText verifyText,String paramType)
	{
		List<? extends ValidateableXMLElement> textDataList = null;
		if (LoopMsg.NODE_NAME.equalsIgnoreCase(paramType)) {
			textDataList = verifyText.getLoopMessage();
		} else if (Mandatory.NODE_NAME.equalsIgnoreCase(paramType)) {
			textDataList = verifyText.getMandatory();
		} else if (NonMandatory.NODE_NAME.equalsIgnoreCase(paramType)) {
			textDataList = verifyText.getNonMandatory();
		} else if (Never.NODE_NAME.equalsIgnoreCase(paramType)) {
			textDataList = verifyText.getNever();
		} else if (VisibleTextElement.NODE_NAME.equalsIgnoreCase(paramType)) {
			textDataList = verifyText.getVisibleTextElement();
		} else if (JavascriptElement.NODE_NAME.equalsIgnoreCase(paramType)){
			textDataList = verifyText.getJavascriptElement();
		}
		return textDataList;
	}

	
	public static List<? extends ValidateableXMLElement> getAllVerifyTextForMethodByParamType(String moduleName,String method,String paramType,String channelLocator) 
	{
		List<? extends ValidateableXMLElement> verifyTextDataList=null;
		 
		XMLMethod xmlMethod=getxmlMethod (moduleName, method,channelLocator);
		if(xmlMethod.getVerifyTexts()!=null)
		{
			for(VerifyText verifyText:xmlMethod.getVerifyTexts())
			{
				verifyTextDataList=getVerifyTextData(verifyText,paramType);
			}
				
		}
	
		System.out.println(paramType+" list to validate on page load = "+verifyTextDataList);
		return verifyTextDataList;
		
	}
	private static Button getClickButtonById(Click click,String buttonId) 
	{
		if(click.getButtons()!=null)
		{
			for(Button button: click.getButtons())
			{
				if(button.getId()!=null && button.getId().equals(buttonId))
				{
					return button;
				}
			}
		}
		return null;
	}
	
	public static LinkedHashMap<String,String> getAllChildrenForDropDown(String moduleName, String method, String channelLocator)
	{
		LinkedHashMap<String,String> dropdownMap=new LinkedHashMap<String, String>();
		XMLMethod xmlMethod=getxmlMethod (moduleName, method,channelLocator);
		String key,value=null;
		if(xmlMethod.getDropdowns()!=null)
		{
			for(Dropdown dropdown:xmlMethod.getDropdowns())
			{
				if(dropdown.getSelected()!=null)
				{
					for(Selected selected: dropdown.getSelected())
					{
						if(selected.getId()!=null)
						{
							key=selected.getId();
							value=selected.getIndex()!=null?selected.getIndex():selected.getValue();
							dropdownMap.put(key,value);				
						}
					}
				}	
			}
		}
		System.out.println("Dropdown map to select= "+dropdownMap);
		return dropdownMap;
	}
	public static LinkedHashMap<String,String> getAllChildrenForTextbox(String moduleName,String method,String channelLocator)
	{
		LinkedHashMap<String,String> textboxMap=new LinkedHashMap<String, String>();
		XMLMethod xmlMethod=getxmlMethod (moduleName, method,channelLocator);
		String key,value=null;
		if(xmlMethod.getTextBoxs()!=null)
		{
			for(TextBox textBox:xmlMethod.getTextBoxs())
			{
				if(textBox.getTextElements()!=null)
				{
					for(Text text: textBox.getTextElements())
					{
						if(text.getId()!=null)
						{
							key=text.getId();
							value=text.getXmlValue()!=null?text.getXmlValue():text.getValue();
							textboxMap.put(key,value);				
						}
					}
				}	
			}
		}
		System.out.println("Textbox map to type= "+textboxMap);
		return textboxMap;
	}
	public static LinkedHashMap<String,String> getAllChildrenForClick(String moduleName, String method, String channelLocator)
	{	
		LinkedHashMap<String,String> clickMap=new LinkedHashMap<String, String>();
		XMLMethod xmlMethod=getxmlMethod (moduleName, method, channelLocator);
		String key,value=null;
		if(xmlMethod.getClick()!=null)
		{
			for(Click click:xmlMethod.getClick())
			{
				if(click.getButtons()!=null)
				{
					for(Button button: click.getButtons())
					{
						if(button.getId()!=null)
						{
							key=button.getId();
							value=button.getValue()!=null?button.getValue():button.getXmlValue();
							value=value.replace("&", "&amp;");
							clickMap.put(key,value);				
						}
					}
				}	
			}
		}
		System.out.println("Element map to click = "+clickMap);
		return clickMap;
	}
	
	public static LinkedHashMap<String,String> getAllChildrenForMouseOver(String moduleName, String method,String channelLocator) 
	{
		LinkedHashMap<String,String> mouseOverMap=new LinkedHashMap<String, String>();
		XMLMethod xmlMethod=getxmlMethod (moduleName, method,channelLocator);
		String key,value=null;
		if(xmlMethod.getMouseOver()!=null)
		{
			for(MouseOver mouseOver:xmlMethod.getMouseOver())
			{
				if(mouseOver.getButtons()!=null)
				{
					for(Button button: mouseOver.getButtons())
					{
						if(button.getId()!=null)
						{
							key=button.getId();
							value=button.getValue()!=null?button.getValue():button.getXmlValue();
							mouseOverMap.put(key,value);				
						}
					}
				}	
			}
		}
		System.out.println("Element map to mouseover = "+mouseOverMap);
		return mouseOverMap;
	}
	//Return Elements from locator list
	public static LinkedHashMap<String,String> getAllChildrenForElements(String moduleName, String methodName,String channelLocator)
	 { 
	  LinkedHashMap<String,String> elementMap=new LinkedHashMap<String, String>();
	  XMLMethod xmlMethod=getxmlMethod (moduleName, methodName, channelLocator);
	  String key,value=null;
	  if(xmlMethod.getElements()!=null)
	  {
	   for(Elements elements:xmlMethod.getElements())
	   {
	    if(elements.getElement()!=null)
	    {
	     for(Element element: elements.getElement())
	     {
	      if(element.getId()!=null)
	      {
	       key=element.getId();
	       value=element.getValue()!=null?element.getValue():element.getXmlValue();
	       value=value.replace("&", "&amp;");
	       elementMap.put(key,value);    
	      }
	     }
	    } 
	   }
	  }
	  System.out.println("Element map to webElements = "+elementMap);
	  return elementMap;
	
	 }
	
	public static void loadXml(String xmlFileName) 
		{
		try{
			String xmlFile = PropertyLoader.getXMLResources().getProperty(xmlFileName);
			if (xmlFile != null) {
				JAXBContext jaxbContext = JAXBContext.newInstance(Channel.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				InputStream in = PropertyLoader.class.getResourceAsStream(xmlFile);
				specChannel = (Channel) jaxbUnmarshaller.unmarshal(in);
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void loadCommonXml(String xmlComFileName) 
	{
	try{
		String xmlComFile = PropertyLoader.getXMLResources().getProperty(xmlComFileName);
		if (xmlComFile != null) {
			JAXBContext jaxbContext = JAXBContext.newInstance(Channel.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			InputStream in = PropertyLoader.class.getResourceAsStream(xmlComFile);
			comChannel = (Channel) jaxbUnmarshaller.unmarshal(in);
		}
	} catch (JAXBException e) {
		e.printStackTrace();
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}


}
