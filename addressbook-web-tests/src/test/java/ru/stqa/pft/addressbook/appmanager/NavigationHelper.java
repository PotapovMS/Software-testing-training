package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Максим on 22.04.2016.
 */
public class NavigationHelper extends HelperBase {

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }
}
