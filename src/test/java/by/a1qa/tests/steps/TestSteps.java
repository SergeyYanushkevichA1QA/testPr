package by.a1qa.tests.steps;

import by.a1qa.data.Constants;
import by.a1qa.screens.MainScreen;
import org.testng.Assert;

public class TestSteps {
    private static MainScreen mainScreen = new MainScreen();


    public static void onboarding() {
        Assert.assertEquals(mainScreen.getTitle(), Constants.getFirstTitle(), "Checking title of screen on 1st page indicator");
        mainScreen.clickNextButton();
        Assert.assertEquals(mainScreen.getTitle(), Constants.getSecondTitle(), "Checking title of screen on 2nd page indicator");
        mainScreen.clickNextButton();
        Assert.assertEquals(mainScreen.getTitle(), Constants.getThirdTitle(), "Checking title of screen on 3rd page indicator");
        mainScreen.clickNextButton();
        Assert.assertEquals(mainScreen.getTitle(), Constants.getFourthTitle(), "Checking title of screen on 4th page indicator");
        mainScreen.clickSelectButton();
    }
}
