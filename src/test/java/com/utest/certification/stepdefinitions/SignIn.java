package com.utest.certification.stepdefinitions;

import com.utest.certification.questions.AutoDetectFields;
import com.utest.certification.tasks.SetDay;
import com.utest.certification.tasks.SetMonth;
import com.utest.certification.tasks.SetYear;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

import static com.utest.certification.userinterfaces.homepage.HomePageObjects.JOIN_TODAY_BUTTON;
import static com.utest.certification.userinterfaces.signup.LastStepElements.*;
import static com.utest.certification.userinterfaces.signup.SecondStepElements.*;
import static com.utest.certification.userinterfaces.signup.FirstStepElements.*;
import static com.utest.certification.userinterfaces.homepage.UTestLandingPage.UTestLanding;
import static com.utest.certification.userinterfaces.signup.ThirdStepElements.*;
import static com.utest.certification.utils.Highlighter.highlightElement;
import static java.util.concurrent.TimeUnit.SECONDS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.openqa.selenium.Keys.*;

@SuppressWarnings("ALL")
public class SignIn {

    @Managed(driver = "chrome")
    private WebDriver hisBrowser;

    @Before
    public void setUp() throws IOException {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("User")
                .can(BrowseTheWeb.with(hisBrowser));
        hisBrowser.manage().timeouts().implicitlyWait(10, SECONDS);
        hisBrowser.manage().window().maximize();
        hisBrowser.manage().deleteAllCookies();
    }
    @Given("^that I get to UTest Page$")
    public void thatIGetToUTestPage() throws Exception {
        theActorInTheSpotlight().attemptsTo(Open.browserOn(UTestLanding()));
    }

    @And("^access to Sign Up form$")
    public void accessToSignUpForm() throws Exception {
      theActorInTheSpotlight().attemptsTo(WaitUntil.the(JOIN_TODAY_BUTTON,isClickable()));
      highlightElement(hisBrowser,JOIN_TODAY_BUTTON.resolveFor(theActorInTheSpotlight()));
      theActorInTheSpotlight().attemptsTo(Click.on(JOIN_TODAY_BUTTON));
    }
    @When("^I complete the first step$")
    public void iCompleteTheFirstStep() throws Exception {
        theActorInTheSpotlight().attemptsTo(WaitUntil.the(FIRST_STEP_USER_FORM, isVisible()));

        //Fill the first name
        highlightElement(hisBrowser,FIRST_NAME_FIELD.resolveFor(theActorInTheSpotlight()));
        theActorInTheSpotlight().attemptsTo(Enter.theValue("Ramiro").into(FIRST_NAME_FIELD));
        //Fill the last name
        highlightElement(hisBrowser,LASTNAME_FIELD.resolveFor(theActorInTheSpotlight()));
        theActorInTheSpotlight().attemptsTo(
                Click.on(LASTNAME_FIELD),
                Enter.theValue("Fernandez").into(LASTNAME_FIELD)
        );
        //Fill the email
        highlightElement(hisBrowser,EMAIL_FIELD.resolveFor(theActorInTheSpotlight()));
        theActorInTheSpotlight().attemptsTo(
                Click.on(EMAIL_FIELD),
                Enter.theValue("lautarom@inter.com.co").into(EMAIL_FIELD)
        );
        //Fill the birthdate
        highlightElement(hisBrowser,BIRTHDATE_FIELD.resolveFor(theActorInTheSpotlight()));
        theActorInTheSpotlight().attemptsTo(
                SetMonth.as(BIRTH_MONTH_FIELD),
                SetDay.as(BIRTH_DAY_FIELD),
                SetYear.as(BIRTH_YEAR_FIELD)
        );
        //Fill the languages
        highlightElement(hisBrowser,LANGUAGES_FIELD.resolveFor(theActorInTheSpotlight()));
        theActorInTheSpotlight().attemptsTo(
                Click.on(LANGUAGES_FIELD),
                WaitUntil.the(LANGUAGES_INPUT,isEnabled()),
                //Add spanish
                Enter.theValue("spa").into(LANGUAGES_INPUT),
                Hit.the(ENTER).into(LANGUAGES_INPUT),
                //Add portuguese (Brazil)
                Enter.theValue("por").into(LANGUAGES_INPUT),
                Hit.the(DOWN).into(LANGUAGES_INPUT),
                Hit.the(ENTER).into(LANGUAGES_INPUT)
        );
        highlightElement(hisBrowser,GO_TO_SECOND_STEP.resolveFor(theActorInTheSpotlight()));
        theActorInTheSpotlight().attemptsTo(Click.on(GO_TO_SECOND_STEP));
    }
    @And("^I complete the second step$")
    public void iCompleteTheSecondStep() throws Exception {
        theActorInTheSpotlight().should(
                seeThat(AutoDetectFields.areVisible(AUTO_DETECT_CITY,AUTO_DETECT_ZIP_CODE,AUTO_DETECT_COUNTRY,hisBrowser))
        );
        theActorInTheSpotlight().attemptsTo(Scroll.to(CITY_FIELD));
        highlightElement(hisBrowser, GO_TO_THIRD_STEP.resolveFor(theActorInTheSpotlight()));
        theActorInTheSpotlight().attemptsTo(Click.on(GO_TO_THIRD_STEP));
    }
    @And("^I complete the third step$")
    public void iCompleteTheThirdStep() throws Exception {
        theActorInTheSpotlight().should(
                seeThat(AutoDetectFields.areVisible(AUTO_DETECT_OS,AUTO_DETECT_OS_VERSION,AUTO_DETECT_OS_LANGUAGE,hisBrowser))
        );
        highlightElement(hisBrowser, GO_TO_LAST_STEP.resolveFor(theActorInTheSpotlight()));
        theActorInTheSpotlight().attemptsTo(Click.on(GO_TO_LAST_STEP));
    }
    @And("^I complete the last step$")
    public void iCompleteTheLastStep() throws Exception {
        //Fill the password
        highlightElement(hisBrowser,PASSWORD_FIELD.resolveFor(theActorInTheSpotlight()));
        theActorInTheSpotlight().attemptsTo(Enter.theValue("Abcdefghij123").into(PASSWORD_FIELD));

        //Fill the password conformation
        highlightElement(hisBrowser,CONFIRM_PASSWORD_FIELD.resolveFor(theActorInTheSpotlight()));
        theActorInTheSpotlight().attemptsTo(Enter.theValue("Abcdefghij123").into(CONFIRM_PASSWORD_FIELD));

        //Click on required checkboxes
        highlightElement(hisBrowser,TERMS_OF_USE_CHECKBOX.resolveFor(theActorInTheSpotlight()));
        theActorInTheSpotlight().attemptsTo(Click.on(TERMS_OF_USE_CHECKBOX));

        highlightElement(hisBrowser,PRIVACY_AND_SECURITY_CHECKBOX.resolveFor(theActorInTheSpotlight()));
        theActorInTheSpotlight().attemptsTo(Click.on(PRIVACY_AND_SECURITY_CHECKBOX));

        //Click on submit button
        theActorInTheSpotlight().attemptsTo(Scroll.to(PASSWORD_FIELD));
        highlightElement(hisBrowser,COMPLETE_SETUP_BUTTON.resolveFor(theActorInTheSpotlight()));
        theActorInTheSpotlight().attemptsTo(Click.on(COMPLETE_SETUP_BUTTON));
    }
    @Then("^I should see the welcome message$")
    public void iShouldSeeTheWelcomeMessage() throws Exception {
        //I couldn't do the final assertion because a image captcha is displayed
    }
}
