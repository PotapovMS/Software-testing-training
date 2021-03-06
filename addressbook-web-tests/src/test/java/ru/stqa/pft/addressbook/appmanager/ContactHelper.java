package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Максим on 22.04.2016.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhoneNumber());
    type(By.name("mobile"), contactData.getMobilePhoneNumber());
    type(By.name("work"), contactData.getWorkPhoneNumber());
    type(By.name("fax"), contactData.getFaxNumber());
    click(By.name("email2"));
    click(By.name("email"));
    type(By.name("email2"), contactData.getSecondEmail());
    type(By.name("email3"), contactData.getThirdEmail());
    type(By.name("homepage"), contactData.getHomepage());

    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[1]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[1]")).click();
    }
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get (index).click();
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id +"']")).click();
  }

  public void submitContactDeletion() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }

  public void editContact(int index) {
    wd.findElements(By.xpath(".//*[@name='entry']//a[contains(@href,'edit.php')]")).get(index).click();
  }

  public void editContactById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cell = row.findElements(By.tagName("td"));
    cell.get(7).findElement(By.tagName("a")).click();
  }

  private void initContactViewById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='view.php?id=%s']", id))).click();
    }

  public void modify(ContactData contact){
    selectContactById(contact.getId());
    editContactById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    contactCashe = null;
    returnToHomePage();
  }

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[1]"));
  }

  public void delete(ContactData contact){
    selectContactById(contact.getId());
    submitContactDeletion();
    contactCashe = null;
    returnToHomePage();
  }

  public void goToAddNewContactPage() {
    if (wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")){
      return;
    }
    click(By.linkText("add new"));
  }

  public void createContact(ContactData contact) {
    goToAddNewContactPage();
    fillContactForm(contact, true);
    submitContactCreation();
    contactCashe = null;
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
   return wd.findElements(By.name("selected[]")).size();
  }
  private Contacts contactCashe = null;

  public Contacts all() {
    if (contactCashe != null){
      return new Contacts(contactCashe);
    }

    contactCashe = new Contacts();
    List<WebElement> elements = wd.findElements(By.name ("entry"));
    for (WebElement element: elements){
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String allPhones = element.findElement(By.xpath(".//td[6]")).getText();
      String allEmail = wd.findElement(By.xpath(".//td[5]")).getText();
      String address = element.findElement(By.xpath("(.//td[not(child::*)])[3]")).getText();      contactCashe.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
              .withAllPhones(allPhones).withAllEmails(allEmail).withAddress(address));
    }
    return new Contacts(contactCashe);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    editContactById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String middleName = wd.findElement(By.name("middlename")).getAttribute("value");
    String title = wd.findElement(By.name("title")).getAttribute("value");
    String company = wd.findElement(By.name("company")).getAttribute("value");
    String homePhone = wd.findElement(By.name("home")).getAttribute("value");
    String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
    String workPhone = wd.findElement(By.name("work")).getAttribute("value");
    String fax = wd.findElement(By.name("fax")).getAttribute("value");
    String address = wd.findElement(By.xpath("//textarea[@name='address']")).getText();
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email_2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email_3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData()
            .withId(contact.getId())
            .withFirstname(firstname)
            .withLastname(lastName)
            .withMiddlename(middleName)
            .withTitle(title)
            .withCompany(company)
            .withHomePhoneNumber(homePhone)
            .withMobilePhoneNumber(mobilePhone)
            .withWorkPhoneNumber(workPhone)
            .withFaxNumber(fax)
            .withAddress(address)
            .withFirstEmail(email)
            .withSecondEmail(email_2)
            .withThirdEmail(email_3);
  }

  public String infoFromDetailsPage(ContactData contact) {
    initContactViewById(contact.getId());
    String contactContent = wd.findElement(By.id("content")).getText();
    wd.navigate().back();
    return contactContent;
    }
  }
