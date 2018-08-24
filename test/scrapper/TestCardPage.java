package scrapper;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.WebDriver;

import io.DriverUtilities;

public class TestCardPage {

	@Test
	public void TestCard(){
		String url = "https://yuyu-tei.jp/game_ws/carddetail/cardpreview.php?VER=saekano&CID=10096&MODE=sell";
		WebDriver driver = DriverUtilities.createDriver(true);
		new CardPage(url,driver); 
		driver.quit();
	}
}
