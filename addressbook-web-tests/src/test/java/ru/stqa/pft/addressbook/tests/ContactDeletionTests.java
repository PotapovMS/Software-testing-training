package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Максим on 23.04.2016.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion (){
  app.getNavigationHelper().goToHomePage();
  app.getContactHelper().selectContact();
  app.getContactHelper().submitContactDeletion();
  app.getContactHelper().returnToHomePage();
  }
}
