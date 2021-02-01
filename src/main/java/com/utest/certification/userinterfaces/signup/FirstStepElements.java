package com.utest.certification.userinterfaces.signup;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FirstStepElements {

public static final Target FIRST_STEP_USER_FORM = Target.the("User form from first step").locatedBy("//form[@name='userForm']/div");
public static final Target FIRST_NAME_FIELD = Target.the("Firs tname text field").located(By.id("firstName"));
public static final Target LASTNAME_FIELD = Target.the("Last name text field").located(By.id("lastName"));
public static final Target EMAIL_FIELD = Target.the("Email text field").located(By.id("email"));
public static final Target BIRTH_MONTH_FIELD = Target.the("Birth month dropdown").located(By.id("birthMonth"));
public static final Target BIRTH_DAY_FIELD = Target.the("Birth day dropdown").located(By.id("birthDay"));
public static final Target BIRTH_YEAR_FIELD = Target.the("Birth year dropdown").located(By.id("birthYear"));
public static final Target BIRTHDATE_FIELD = Target.the("Birthdate fields container").locatedBy("//*[@class='form-group-box']/div[3]/div[4]");
public static final Target GO_TO_SECOND_STEP = Target.the("Go to second step button").locatedBy("//*[@class='btn btn-blue']");
public static final Target LANGUAGES_FIELD = Target.the("Languages text field").located(By.id("languages"));
public static final Target LANGUAGES_INPUT = Target.the("Languages input field").locatedBy("//input[@type='search']");
//Select dropdown options
public static final Target YEAR_OPTIONS = Target.the("Birthdate year options").locatedBy("//select[@id='birthYear']/option");
public static final Target MONTH_OPTIONS = Target.the("Birthdate month options").locatedBy("//select[@id='birthMonth']/option");
public static final Target DAY_OPTIONS = Target.the("Birthdate day options").locatedBy("//select[@id='birthDay']/option");
}
