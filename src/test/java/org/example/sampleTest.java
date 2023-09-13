package org.example;

import com.microsoft.playwright.*;
import org.junit.Test;
import java.nio.file.Paths;

public class sampleTest {

    @Test
    public void playwrightSample() {
        //Defines playwright objects
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));

        //Page Definition
        Page page = context.newPage();
        page.navigate("https://academy.naveenautomationlabs.com/");
        System.out.println(page.title());
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("homePage.png")));
        Locator locator = page.locator("//*[contains(text(),'Log')]").first();
        int count = locator.count();
        System.out.println(count);
        locator.hover();
        locator.click();

        //Frames Handling
        page.frameLocator("//iframe[@id='microfe-popup-login']").locator("//*[text()='Sign up']").click();
        page.navigate("https://academy.naveenautomationlabs.com/s/store");
        Locator courses = page.locator("//div[@class='column scourse normal hidePackageRibbon']/a");

        for (int i = 0; i < courses.count(); i++) {
            String title = courses.nth(i).getAttribute("title");
            System.out.println(title);
        }

        // Stop tracing and export it into a zip archive.
        context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
    }
}
