package br.com.indicare;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuscaGOL {

	public static void main(String[] args) throws InterruptedException {
	
	String url = "https://compre2.voegol.com.br/Search.aspx";
	
//	DesiredCapabilities caps = new DesiredCapabilities();
//	
//	String[] phantomArgs = new  String[] {
//		    "--webdriver-loglevel=NONE"
//		};
//	
//    caps.setJavascriptEnabled(true);
//    caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\Users\\Ivanildo JR\\Downloads\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
//    caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,phantomArgs);
//    caps.setCapability(PhantomJSDriverService.PHANTOMJS_GHOSTDRIVER_CLI_ARGS, "--webdriver-loglevel=NONE");
//    
//    Logger.getLogger(PhantomJSDriverService.class.getName()).setLevel(Level.OFF);
//    Logger.getLogger(ProtocolHandshake.class.getName()).setLevel(Level.OFF);
    
//	WebDriver ghostDriver = new PhantomJSDriver(caps);
	
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ivanildo JR\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver ghostDriver = new ChromeDriver();

	
	
	
	try {
        ghostDriver.get(url);
	
        Actions actions = new Actions(ghostDriver);
    	actions.moveToElement(ghostDriver.findElement(By.name("ControlGroupSearchView$AvailabilitySearchInputSearchView$TextBoxMarketOrigin1"))).build().perform();
    	new WebDriverWait(ghostDriver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.name("ControlGroupSearchView$AvailabilitySearchInputSearchView$TextBoxMarketOrigin1"))).click();
        
        
        
        Document doc = null;
		doc = Jsoup.parse(ghostDriver.getPageSource());
		Elements origem = doc.getElementsByAttributeValue("name", "ControlGroupSearchView$AvailabilitySearchInputSearchView$TextBoxMarketOrigin1");
		Elements destino = doc.getElementsByAttributeValue("name", "ControlGroupSearchView$AvailabilitySearchInputSearchView$TextBoxMarketDestination1");
		Elements dateIda = doc.getElementsByAttributeValue("id", "dateIda");
		Elements dateVolta = doc.getElementsByAttributeValue("id", "dateVolta");
		Elements adultosSelect = doc.getElementsByAttributeValue("name", "ControlGroupSearchView$AvailabilitySearchInputSearchView$DropDownListPassengerType_ADT");
		Elements criancasSelect = doc.getElementsByAttributeValue("name", "ControlGroupSearchView$AvailabilitySearchInputSearchView$DropDownListPassengerType_CHD");
		Elements botao = doc.getElementsByAttributeValue("name", "ControlGroupSearchView$ButtonSubmit");
		
		Document adultosDoc = Jsoup.parse(adultosSelect.toString());
//		Elements adultosOpcoes = adultosDoc.getElementsByTag("option");
		Elements adultosOpcoes = adultosDoc.getElementsByAttributeValue("value", "2");
		
		Document criancasDoc = Jsoup.parse(adultosSelect.toString());
//		Elements criancasOpcoes = adultosDoc.getElementsByTag("option");
		Elements criancasOpcoes = adultosDoc.getElementsByAttributeValue("value", "2");

		


		
		Select select = new Select(ghostDriver.findElement(
				By.name("ControlGroupSearchView$AvailabilitySearchInputSearchView$DropDownListPassengerType_ADT")));
		select.selectByValue("2");
		
		
		
//		List<WebElement> allOptions = select.findElements(By.tagName("option"));
//		for (WebElement option : allOptions) {
//		    
//		    if(option.getAttribute("value").equalsIgnoreCase("2")){
//		    	System.out.println(String.format("Value is: %s", option.getAttribute("value")));
//		    	
//		    	option.click();	
//		    }
//		    
//		}
		
		
		
//		List lista = new ArrayList();
//		
//		lista.add(origem);
//		lista.add(destino);
//		lista.add(dateIda);
//		lista.add(dateVolta);
//		lista.add(adultosSelect);
//		lista.add(adultosOpcoes);
//		lista.add(criancasSelect);
//		lista.add(botao);
//		
//		for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
//			Elements object = (Elements) iterator.next();
//			System.out.println(object.toString());	
//		}
		
		
	} catch (NullPointerException n){
		System.out.println("Document igual a null");
	} finally {
        ghostDriver.quit();
    }


}

}
