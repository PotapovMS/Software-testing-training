package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Максим on 21.05.2016.
 */
public class ContactDetailsTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    //если нет контакта, то создать его
    if (app.contact().all().size() == 0) {
      app.goTo().goToAddNewContactPage();
      app.contact().createContact(new ContactData().withFirstname("Maks").withLastname("Potapov").withHomePhoneNumber("+7(495)8587485").withMobilePhoneNumber("22-22").withWorkPhoneNumber("123 45 97").withAddress("This\nis my\n\naddress").withFirstEmail("Maks@gmail.com").withThirdEmail("test mail"));
      app.goTo().homePage();
    }
  }

  @Test//(enabled = false)
  public void testContactDetails() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    String contactInfoFromDetailsPage = app.contact().infoFromDetailsPage(contact);

    assertThat((cleanedPhones(cleanedMails(withoutEmptyLines(contactInfoFromDetailsPage)))), equalTo(withoutEmptyLines(mergeContactInfoFromEditForm(contactInfoFromEditForm))));
    int f = 0;
  }

  private String mergeContactInfoFromEditForm(ContactData contact) {
    String mergedName = Arrays.asList(contact.getFirstname(), contact.getLastname())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining(" "));

    String mergedAddress = Arrays.asList(contact.getAddress())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));

    String mergedPhones = Arrays.asList(cleanedPhones(contact.getHomePhoneNumber()), contact.getMobilePhoneNumber(), contact.getWorkPhoneNumber())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));

    return Arrays.asList(mergedName, mergedAddress, mergedPhones,
            contact.getFirstEmail(), contact.getSecondEmail(), contact.getThirdEmail())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  public static String cleanedPhones(String s) {
    return s.replaceAll("\n[HWM]: ", "\n");
  }

  public static String cleanedMails(String s) {
    return s.replaceAll(" \\(w{3}.*\\)", "");
  }

  public static String withoutEmptyLines(String s) {
    return s.replaceAll("\n\n", "\n");
  }
}

