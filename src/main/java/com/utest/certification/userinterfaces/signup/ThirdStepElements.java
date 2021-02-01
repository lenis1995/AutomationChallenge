package com.utest.certification.userinterfaces.signup;

import net.serenitybdd.screenplay.targets.Target;

public class ThirdStepElements {
    public static final Target AUTO_DETECT_OS = Target.the("Auto detect OS flag").locatedBy("//span[@ng-show='autoDetectDevice.webDevice.osId']");
    public static final Target AUTO_DETECT_OS_VERSION = Target.the("Auto detect OS Version flag").locatedBy("//span[@ng-show='autoDetectDevice.webDevice.osVersionId']");
    public static final Target AUTO_DETECT_OS_LANGUAGE = Target.the("Auto detect OS Language flag").locatedBy("//span[@ng-show='autoDetectDevice.webDevice.osLanguageId']");
    public static final Target GO_TO_LAST_STEP = Target.the("Go to last step button").locatedBy("//a[@class='btn btn-blue pull-right']");
}
