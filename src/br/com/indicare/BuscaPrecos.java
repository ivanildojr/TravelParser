package br.com.indicare;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BuscaPrecos {

	public static void main(String[] args) {
		String url = "https://book.latam.com/TAM/dyn/air/booking/upslDispatcher?"
				+ "B_LOCATION_1=NAT"
				+ "&"
				+ "E_LOCATION_1=YYZ"
				+ "&"
				+ "TRIP_TYPE=R"
				+ "&"
				+ "B_DATE_1=201709120000"
				+ "&"
				+ "B_DATE_2=201710100000"
				+ "&"
				+ "adults=2"
				+ "&"
				+ "children=2"
				+ "&"
				+ "infants=0"
				+ "&"
				+ "LANGUAGE=BR"
				+ "&"
				+ "SITE=JJBKJJBK"
				+ "&"
				+ "WDS_MARKET=BR"
				+ "&"
				+ "MARKETING_CABIN=E";
		
		DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);  
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\Users\\Ivanildo JR\\Downloads\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		
		
		WebDriver ghostDriver = new PhantomJSDriver(caps);
		try {
            ghostDriver.get(url);
			Document doc = null;
			doc = Jsoup.parse(ghostDriver.getPageSource());
			Element ida = doc.getElementById("outbound_list_flight");
			Element volta = doc.getElementById("inbound_list_flight");
			System.out.println("<html><head></head><body>");
			System.out.println(ida.toString());
			System.out.println(volta.toString());
			System.out.println("</body></html>");
		} catch (NullPointerException n){
			System.out.println("Document igual a null");
		} finally {
            ghostDriver.quit();
        }


	}

}
