package by.a1qa.screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.ElementType;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import java.util.List;

public class CityScreen extends Screen {

    private final ILabel locationList = getElementFactory().getLabel(By.id("com.todaytix.TodayTix:id/location_list"), "Location list");
    private final By citiesLoc = By.className("android.widget.TextView");
    private final List<ILabel> citiesLbl = getElementFactory().findElements(By.className("android.widget.TextView"), ElementType.LABEL);

    public CityScreen() {
        super(By.id("com.todaytix.TodayTix:id/main_content"), "City Page");
    }

    public void selectRandomCity() {
        if(locationList.state().waitForDisplayed()) {
 //           List<ILabel> cities = getCitiesList();
            citiesLbl.get(0).click();
            System.out.println("Click");
        }
    }

    private List<ILabel> getCitiesList() {
        return getElementFactory().findElements(citiesLoc, ElementType.LABEL);
    }


    /*public void chooseCity(String cityName) {
        for(ILabel city: cities) {
            if(city.getText().equals(cityName)){
                city.click();
            } else {
                AqualityServices.getLogger().debug("No such city");
            }
        }
    }
*/

}
