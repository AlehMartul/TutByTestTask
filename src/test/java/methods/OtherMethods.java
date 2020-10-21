package methods;

import org.openqa.selenium.WebElement;

import java.util.List;

public class OtherMethods {

    public static boolean isElementContainsText(List<WebElement> movieList, String genre) {
        boolean isDesired = false;
        for (int i = 0; i < movieList.size(); i++) {
            isDesired = movieList.get(i).getText().contains(genre);
        }
        return isDesired;
    }
}
