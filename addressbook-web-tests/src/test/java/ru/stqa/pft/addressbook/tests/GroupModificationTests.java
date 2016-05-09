package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by Максим on 23.04.2016.
 */
public class GroupModificationTests extends TestBase {

  @Test
  public void testModificationGroup() {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", "test2", null));
      app.getGroupHelper().selectGroup();
      app.getGroupHelper().editGroup();
      app.getGroupHelper().fillGroupForm(new GroupData("a", "b", "c"));
      app.getGroupHelper().submitGroupModification();
      app.getGroupHelper().returnToGroupPage();
    }
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before);
  }
}

