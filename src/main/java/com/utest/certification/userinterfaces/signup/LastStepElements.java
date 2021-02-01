package com.utest.certification.userinterfaces.signup;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LastStepElements {

    public static final Target PASSWORD_FIELD = Target.the("Password field").located(By.id("password"));
    public static final Target CONFIRM_PASSWORD_FIELD = Target.the("Confirm Password field").located(By.id("confirmPassword"));
    public static final Target TERMS_OF_USE_CHECKBOX = Target.the("Terms of use checkbox").locatedBy("//input[@id='termOfUse']/following-sibling::span[@class='checkmark signup-consent__checkbox error']");
    public static final Target PRIVACY_AND_SECURITY_CHECKBOX = Target.the("Privacy and Security checkbox").locatedBy("//input[@id='privacySetting']/following-sibling::span[@class='checkmark signup-consent__checkbox error']");
    public static final Target COMPLETE_SETUP_BUTTON = Target.the("Complete sign up button").located(By.id("laddaBtn"));
}
