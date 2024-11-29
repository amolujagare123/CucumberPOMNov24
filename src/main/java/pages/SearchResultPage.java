package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static stepdefinitions.SharedSD.getDriver;

public class SearchResultPage extends Base{

    By hotel = By.xpath("//div[@data-testid='title']");

    public ArrayList<String> getHotelsList()
    {
          return getElementTextList(hotel)  ;
    }

    By crossPopup = By.xpath("//button[@aria-label='Dismiss sign in information.']");

    public void clickClosePopUp()
    {
        clickOn(crossPopup);
    }

    By priceElements = By.xpath("//span[@data-testid='price-and-discounted-price']");

    public ArrayList<Integer> getPriceList()
    {
        ArrayList<String> txtList = getElementTextList(priceElements); // ₹ 25,000
        ArrayList<Integer> priceList = new ArrayList<>();
        for (String rawPrice:txtList) // ₹ 25,000
        {
            String priceWithComma = rawPrice.substring(2); // 25,000
            String priceStr = priceWithComma.replace(",","");// 25000
            int price = Integer.parseInt(priceStr);
            priceList.add(price);
        }

        return priceList;
    }

    public  void clickRating(String star) // 5
    {
       By rating = By.xpath("//input[@name='class="+star+"']");
      // clickOn(rating);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();",webAction(rating));
    }

    By allRatingsElements = By.xpath("//div[contains(@aria-label,'out of 5')]");

    public ArrayList<Integer> getAllRatings()
    {
        ArrayList<Integer> ratingList = new ArrayList<>();
        List<WebElement> wbList = getDriver().findElements(allRatingsElements);

        for(WebElement wb:wbList)
        {
            String ratingStr = wb.getAttribute("aria-label").substring(0, 1);            // 5 out of 5 stars

            ratingList.add(Integer.parseInt(ratingStr));
        }

        return ratingList;
    }

}
