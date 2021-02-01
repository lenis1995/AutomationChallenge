package com.utest.certification.userinterfaces.homepage;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.utest.com/")
public class UTestLandingPage extends PageObject {

    public static UTestLandingPage UTestLanding(){
        return new UTestLandingPage();
    }
}
