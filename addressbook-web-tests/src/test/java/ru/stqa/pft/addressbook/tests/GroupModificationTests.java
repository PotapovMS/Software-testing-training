package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by Максим on 23.04.2016.
 */
public class GroupModificationTests extends TestBase {

  @Test
  public void testModificationGroup() {
  app.getNavigationHelper().gotoGroupPage();
  app.getGroupHelper().selectGroup();
  app.getGroupHelper().editGroup();
  app.getGroupHelper().fillGroupForm(new GroupData("a", "b", "c"));
  app.getGroupHelper().submitGroupModification();
  app.getGroupHelper().returnToGroupPage();
  }
}
