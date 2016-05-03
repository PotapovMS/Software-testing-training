package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Максим on 23.04.2016.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification (){
    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("one", "two", "three", "test1", "test2", "test3", "Moscow, str. test4", "+74950000000", "+79250000000", "+74962520000", "+74952620000", "one.threetwo.@test4", "one.threetwo.@test5.ru", "test@test.ru", "test1"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData("a", "b", "c", "d", "e", "f", "Moscow, str. test", "+74950000001", "+79250000001", "+74962520001", "+74952620001", "one.threetwo.@test1", "one.threetwo.@test2", "test@test7.ru", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}
