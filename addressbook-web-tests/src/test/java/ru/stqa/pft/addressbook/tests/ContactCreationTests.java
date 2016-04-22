package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {

    app.getNavigationHelper().goToAddNewContactPage();
    app.getContactHelper().fillContactForm(new ContactData("one", "two", "three", "test1", "test2", "test3", "Moscow, str. test4", "+74950000000", "+79250000000", "+74962520000", "+74952620000", "one.threetwo.@test4", "one.threetwo.@test5", "test@test.ru"), "Moscow, str. test 6", "7", "none");
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }
}
