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
    app.getContactHelper().selectContact();
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData("a", "b", "c", "d", "e", "f", "Moscow, str. test", "+74950000001", "+79250000001", "+74962520001", "+74952620001", "one.threetwo.@test1", "one.threetwo.@test2", "test@test7.ru"), "Moscow, str. test 4", "8", "a");
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}
