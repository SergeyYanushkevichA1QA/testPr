package by.a1qa.screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.ElementType;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import by.a1qa.models.Cities;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

public class CityScreen extends Screen {

    private final ILabel locationList = getElementFactory().getLabel(By.id("com.todaytix.TodayTix:id/location_list"), "Location list");
    private final By citiesLoc = By.xpath("//*[contains(@resource-id, 'com.todaytix.TodayTix:id/location_text')]");

    private static List<ILabel> cities;
    private static int randomNumber;

    public CityScreen() {
        super(By.className("android.widget.TextView"), "City Page");
    }

    public void selectRandomCity() {
        if(locationList.state().isDisplayed()) {
            getCities().get(getRandomNumber()).click();
        }
    }

    private List<ILabel> getCitiesList() {
        return getElementFactory().findElements(citiesLoc, ElementType.LABEL);
    }

    private void setCitiesList(List<ILabel> cities) {
        CityScreen.cities = cities;
    }

    private List<ILabel> getCities() {
        return CityScreen.cities;
    }

    public String getRandomCityName() {
        setCitiesList(getCitiesList());
        setRandomNumber(new Random().nextInt(getCities().size()));
        return getCities().get(getRandomNumber()).getText();
    }


    public void chooseCity(String cityName) {
        for(ILabel city: getCitiesList()) {
            if(city.getText().equals(cityName)){
                city.click();
                break;
            } else {
                AqualityServices.getLogger().debug("No such city");
            }
        }
    }

    public static int getRandomNumber() {
        return randomNumber;
    }

    public static void setRandomNumber(int randomNumber) {
        CityScreen.randomNumber = randomNumber;
    }
}
