package com.utest.certification.questions;

import com.utest.certification.utils.Highlighter;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

import static com.utest.certification.utils.Highlighter.highlightElement;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AutoDetectFields implements Question<Boolean> {

    public AutoDetectFields(Target element1, Target element2, Target element3, WebDriver driver) {
        this.element1 = element1;
        this.element2 = element2;
        this.element3 = element3;
        this.driver = driver;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        int i = 0;
        Target[] elements = {element1,element2,element3};
        List<Target> listElements = Arrays.asList(elements);

        for (Target element : listElements) {
            WaitUntil.the(element,isVisible());
            highlightElement(driver,element.resolveFor(actor));
            if(element.resolveFor(actor).isVisible()){
                i++;
            }
        }
        return i == 3;

    }

    public static AutoDetectFields areVisible(Target element1,Target element2,Target element3,WebDriver driver) {
        return new AutoDetectFields(element1,element2,element3,driver);
    }

    private final Target element1;
    private final Target element2;
    private final Target element3;
    private final WebDriver driver;
}
