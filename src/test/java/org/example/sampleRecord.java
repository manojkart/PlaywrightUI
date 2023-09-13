package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class sampleRecord {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();

            // Start tracing before creating / navigating a page.
            context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));
            Page page = context.newPage();
            page.navigate("https://automationintesting.online/");
            page.getByText("singleAenean porttitor mauris sit amet lacinia molestie. In posuere accumsan ali").click();
            page.getByTestId("ContactName").click();
            page.getByTestId("ContactName").fill("dsdsdsdsds");
            page.getByTestId("ContactEmail").click();
            page.getByTestId("ContactEmail").fill("sdsd");
            page.getByTestId("ContactPhone").click();
            page.getByTestId("ContactPhone").fill("sdsdsdd");
            page.getByTestId("ContactSubject").click();
            page.getByTestId("ContactSubject").fill("sdds");
            page.getByTestId("ContactDescription").click();
            page.getByTestId("ContactDescription").fill("dsds");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
            page.getByText("Subject must be between 5 and 100 characters.").click();
            page.getByText("Phone must be between 11 and 21 characters.").click();
            page.getByText("Message must be between 20 and 2000 characters.").click();
            page.getByText("must be a well-formed email address").click();


            BrowserContext context1 = browser.newContext();
            Page page1 = context1.newPage();
            page1.navigate("https://automationintesting.online/");
            page1.getByText("singleAenean porttitor mauris sit amet lacinia molestie. In posuere accumsan ali").click();
            page1.getByTestId("ContactName").click();
            page1.getByTestId("ContactName").fill("dsdsdsdsds");
            page1.getByTestId("ContactEmail").click();
            page1.getByTestId("ContactEmail").fill("sdsd");
            page1.getByTestId("ContactPhone").click();
            page1.getByTestId("ContactPhone").fill("sdsdsdd");
            page1.getByTestId("ContactSubject").click();
            page1.getByTestId("ContactSubject").fill("sdds");
            page1.getByTestId("ContactDescription").click();
            page1.getByTestId("ContactDescription").fill("dsds");
            page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
            page1.getByText("Subject must be between 5 and 100 characters.").click();
            page1.getByText("Phone must be between 11 and 21 characters.").click();
            page1.getByText("Message must be between 20 and 2000 characters.").click();
            page1.getByText("must be a well-formed email address").click();


            // Stop tracing and export it into a zip archive.
            context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
        }
    }
}
