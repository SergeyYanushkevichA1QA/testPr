package by.a1qa.screens;

import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.elements.ElementType;
import aquality.appium.mobile.elements.interfaces.IElement;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

import java.util.List;

public class DiscoverScreen extends Screen {

    private final String xpathContainer = "android.widget.LinearLayout[@index='1']//android.view.ViewGroup";
    private final ILabel test = getElementFactory().getLabel(By.xpath("//" + xpathContainer), "scroll");
    private final ILabel headerLbl = getElementFactory().getLabel(By.id("com.todaytix.TodayTix:id/discover_header"), "Header lbl");
    private final By posterNameLoc = By.xpath("//"+xpathContainer+"//*[contains(@resource-id, 'com.todaytix.TodayTix:id/show_name')]");
    private final By posterCostLoc = By.xpath("//"+xpathContainer+"//*[contains(@resource-id, 'com.todaytix.TodayTix:id/price_amount_label')]");

    public DiscoverScreen() {
        super(By.xpath("//android.view.ViewGroup[@content-desc='Fan Favourites The shows that our audience love']"), "Discover Page");
    }

    public boolean isOnDiscoverScreen() {
        headerLbl.state().waitForDisplayed();
        return headerLbl.getElement().isDisplayed();
    }

    private List<ILabel> getPosterNameList() {
        return getElementFactory().findElements(posterNameLoc, ElementType.LABEL);
    }

    public void swipeToElement() {
        test.getTouchActions().scrollToElement(SwipeDirection.DOWN);
    }

    private List<ILabel> getPosterCostList() {
        return getElementFactory().findElements(posterCostLoc, ElementType.LABEL);
    }

    public void check() {
        System.out.println(getPosterNameList().get(0).getText());
        System.out.println(getPosterCostList().get(0).getText());
    }






}
