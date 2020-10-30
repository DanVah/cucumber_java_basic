package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() {
        driver.get("https://kristinek.github.io/site");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() {
        driver.get("https://kristinek.github.io/site/examples/age");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I should see menu$")
    public void iShouldSeeMenu() {
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

    @And("^I click the result checkbox button$")
    public void iClickTheResultCheckboxButton() {
        driver.findElement(By.id("result_button_checkbox")).click();
    }

    @When("^I clicked on checkboxes:$")
    public void iClickedOnCheckboxes(List<String> values) {
        for (String value : values) {
            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
        }
    }

    @Then("^message for checkboxes \"([^\"]*)\" is seen$")
    public void messageForCheckboxesIsSeen(String message) {
        assertEquals(message, driver.findElement(By.id("result_checkbox")).getText());
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }


    @Given("^Go to url \"([^\"]*)\"$")
    public void goToUrl(String arg0) {
        driver.get(arg0);
    }

    @And("^I enter number \"([^\"]*)\" in the field$")
    public void iEnterNumberInTheField(String arg0) {
        WebElement numberField = driver.findElement(By.xpath("//*[@id=\"numb\"]"));
        numberField.sendKeys(arg0);
    }

    @And("^Press submit$")
    public void pressSubmit() {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button")).click();
    }

    @Then("^Check the text \"([^\"]*)\" is displayed$")
    public void checkTheTextIsDisplayed(String arg0) {
        assertEquals(arg0, driver.findElement(By.id("ch1_error")).getText());
    }

    @Then("^Check that popup displays \"([^\"]*)\"$")
    public void checkThatPopupDisplays(String arg0) {
        String popUpText = driver.switchTo().alert().getText();
        assertEquals(arg0,popUpText);
    }

    @And("^I press Add person button$")
    public void iPressAddPersonButton() {
        driver.findElement(By.xpath("//*[@id=\"addPersonBtn\"]")).click();
    }

    @And("^I enter \"([^\"]*)\" in the name field$")
    public void iEnterInTheNameField(String arg0) {
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(arg0);
    }

    @And("^I enter \"([^\"]*)\" in the Job field$")
    public void iEnterInTheJobField(String arg0) {
        driver.findElement(By.xpath("//*[@id=\"job\"]")).sendKeys(arg0);
    }

    @And("^I press the Add button$")
    public void iPressTheAddButton() {
        driver.findElement(By.xpath("//*[@id=\"modal_button\"]")).click();
    }

    @Then("^I check that \"([^\"]*)\" is here$")
    public void iCheckThatIsAdded(String arg0) {
        String textToXpath = ("//span[contains(text(),'" + arg0 + "')]");
        assertTrue(driver.findElement(By.xpath(textToXpath)).isDisplayed());
        assertEquals("w3-xlarge name", driver.findElement(By.xpath(textToXpath)).getAttribute("class"));
    }

    @And("^with job \"([^\"]*)\"$")
    public void withJob(String arg0) {
        String textToXpath = ("//span[contains(text(),'" + arg0 + "')]");
        assertTrue(driver.findElement(By.xpath(textToXpath)).isDisplayed());
        assertEquals("job", driver.findElement(By.xpath(textToXpath)).getAttribute("class"));
    }

    @And("^I press edit person button$")
    public void iPressEditPersonButton() {
        driver.findElement(By.xpath("//*[@id=\"person0\"]/span[2]/i")).click();
    }

    @And("^I press the Edit button$")
    public void iPressTheEditButton() {
        driver.findElement(By.xpath("//*[@id=\"modal_button\"]")).click();
    }

    @And("^I press remove person button$")
    public void iPressRemovePersonButton() {
        driver.findElement(By.xpath("//*[@id=\"person1\"]/span[1]")).click();
    }

    @And("^Check that now there is \"([^\"]*)\" persons left$")
    public void checkThatNowThereIsPersonsLeft(int arg0) {
        List<WebElement> elements = driver.findElements(By.tagName("div"));
        int nonPersonDivCount = 8; // The page contains 11 elements with tagName div, and 8 of then are not persons.
        assertEquals(arg0,(elements.size()-nonPersonDivCount));
    }

    @And("^I press the Reset List button$")
    public void iPressTheResetListButton() throws InterruptedException {
        driver.findElement(By.xpath("//body/div[4]/button[2]")).click();
    }
}