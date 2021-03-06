package by.a1qa.utils;

import aquality.appium.mobile.application.AqualityServices;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ScreenshotProvider implements IScreenshotProvider {

    @Override
    public byte[] takeScreenshot() {
        Screenshot fpScreenshot = new AShot()
                .shootingStrategy(ShootingStrategies.simple())
                .takeScreenshot(AqualityServices.getApplication().getDriver());

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(fpScreenshot.getImage(), "png", baos);
            baos.flush();
            return baos.toByteArray();
        } catch (IOException ioe) {
            AqualityServices.getLogger()
                    .debug("IO Exception during preparing screenshot of full page%nException message", ioe);
            return new byte[] {};
        }
    }
}