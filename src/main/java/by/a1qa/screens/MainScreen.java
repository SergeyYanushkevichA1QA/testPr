package by.a1qa.screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.Attributes;
import aquality.appium.mobile.elements.ElementType;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

public class MainScreen extends Screen {

    public MainScreen() {
        super(By.id("android:id/content"), "Main Page");
    }

    private final ILabel titleOnPage = getElementFactory().getLabel(By.id("com.todaytix.TodayTix:id/title"), "Title");
    private final IButton nextButton = getElementFactory().getButton(By.id("com.todaytix.TodayTix:id/next_button"), "Next Button");
    private final ILabel pageIndicator = getElementFactory().getLabel(By.id("com.todaytix.TodayTix:id/pager_indicator"), "Page indicator");
    private final IButton selectButton = getElementFactory().getButton(By.id("com.todaytix.TodayTix:id/secondary_button"), "Select Manually button");


    public void clickNextButton() {
        nextButton.click();
    }

    public String getTitle() {
        return titleOnPage.getText();
    }

    public void clickSelectButton() {
        selectButton.click();
    }

/*
    public boolean isOnPage(int number) {
        boolean flag = false;
        System.out.println(pageIndicator.getAttribute("index"));
        if(pageIndicator.getAttribute("index").equals(Integer.toString(number))) {
            flag = true;
        }
        return flag;
    }
*/




}
