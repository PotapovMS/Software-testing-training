package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.List;

/**
 * Created by Максим on 23.04.2016.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.goTo().goToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData().withFirstname("FirstName").withLastname("LastName").withGroup("a"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().submitContactDeletion();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
      Assert.assertEquals(before, after);
    }
  }
