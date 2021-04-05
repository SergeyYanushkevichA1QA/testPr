package by.a1qa.tests;

import aquality.appium.mobile.application.AqualityServices;
import by.a1qa.data.Constants;
import by.a1qa.models.City;
import by.a1qa.screens.CityScreen;
import by.a1qa.screens.DiscoverScreen;
import by.a1qa.screens.MainScreen;
import by.a1qa.screens.ShowsScreen;
import by.a1qa.tests.steps.TestSteps;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OnboardingTest {

    private static MainScreen mainScreen = new MainScreen();
    private static CityScreen cityScreen = new CityScreen();
    private static ShowsScreen showsScreen = new ShowsScreen();
    private static DiscoverScreen discoverScreen = new DiscoverScreen();

    @BeforeClass
    public void setup() {
        AqualityServices.getApplication();
    }

    @Test
    public void onboardingTest() {
        TestSteps.onboarding();
        City city = new City();
        city.setName(cityScreen.getRandomCityName());
        cityScreen.selectRandomCity();
        Assert.assertEquals(mainScreen.getTitle(), Constants.getFifthTitle(), "Checking title after chose city");
        mainScreen.clickSelectButton();
        Assert.assertTrue(showsScreen.isShowsScreen(), "Checking if on shows screen");
        City locCity = new City();
        locCity.setName(showsScreen.getLocName());
        Assert.assertEquals(city, locCity, "Checking location on shows screen with chosen");
    }

    @Test
    public void addTicketsToBasketTest() {
        TestSteps.onboarding();
        cityScreen.chooseCity(Constants.getCityName());
        Assert.assertEquals(mainScreen.getTitle(), Constants.getFifthTitle(), "Checking title after chose city");
        mainScreen.clickSelectButton();
        //-----------------
        showsScreen.clickDiscoverButton();
        Assert.assertTrue(discoverScreen.isOnDiscoverScreen(), "Isn't discover screen");
        discoverScreen.swipeToElement();
        discoverScreen.check();

    }


    @AfterClass
    public void tearDown() {
        if (AqualityServices.isApplicationStarted())
            AqualityServices.getApplication().quit();
    }
}
