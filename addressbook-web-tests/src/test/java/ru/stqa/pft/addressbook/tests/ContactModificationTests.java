package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

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
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().editContact(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "a", "b", "c", "d", "e", "f", "Moscow, str. test", "+74950000001", "+79250000001", "+74962520001", "+74952620001", "one.threetwo.@test1", "one.threetwo.@test2", "test@test7.ru", null);
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
