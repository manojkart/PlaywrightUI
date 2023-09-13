package org.example;

import com.microsoft.playwright.*;
import org.junit.Test;

import java.nio.file.Paths;

public class AppTest {
    @Test
    public void playwrightSample() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();

        //Start the trace
        context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));

        Page page = context.newPage();
        page.navigate("https://automationintesting.online/");
        System.out.println(page.title());
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("booking.png")));
        page.type("//input[@id='name']", "John Peter");
        page.type("//input[@id='email']", "johnpeter@gmail.com");
        page.type("//input[@id='email']", "+61768767678");
        page.type("//input[@id='subject']", "Sample booking request");
        page.type("//textarea[@id='description']", "booking request");
        page.click("//button[text()='Submit']");
        page.click("//button[text()='Book this room']");
        page.click("//button[text()='Book']");

        // Stop tracing and export it into a zip archive.
        context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));

        page.close();
        browser.close();
    }
}
