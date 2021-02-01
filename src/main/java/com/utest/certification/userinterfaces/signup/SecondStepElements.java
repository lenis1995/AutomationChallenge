package com.utest.certification.userinterfaces.signup;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SecondStepElements {

    public static final Target CITY_FIELD = Target.the("City input field").located(By.id("city"));
    public static final Target ZIP_CODE_FIELD = Target.the("City input field").located(By.id("zip"));
    public static final Target COUNTRY_TEXT_FIELD = Target.the("City input field").located(By.name("countryId"));
    //Auto detects fields
    public static final Target AUTO_DETECT_CITY = Target.the("Auto detect city flag").locatedBy("//span[@ng-show='autoDetectAddress.city']");
    public static final Target AUTO_DETECT_ZIP_CODE = Target.the("Auto detect city flag").locatedBy("//span[@ng-show='autoDetectAddress.zip']");
    public static final Target AUTO_DETECT_COUNTRY = Target.the("Auto detect city flag").locatedBy("//span[@ng-show='autoDetectAddress.country']");
    //Next Step Button
    public static final Target GO_TO_THIRD_STEP = Target.the("Go to third step button").locatedBy("//a[@class='btn btn-blue pull-right']");
}
