package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String middlename;
  private String lastname;
  private String nickname;
  private String title;
  private String company;
  private String address;
  private String homePhoneNumber;
  private String mobilePhoneNumber;
  private String workPhoneNumber;
  private String faxNumber;
  private String secondEmail;
  private String thirdEmail;
  private String homepage;
  private String group;

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withHomePhoneNumber(String homePhoneNumber) {
    this.homePhoneNumber = homePhoneNumber;
    return this;
  }

  public ContactData withMobilePhoneNumber(String mobilePhoneNumber) {
    this.mobilePhoneNumber = mobilePhoneNumber;
    return this;
  }

  public ContactData withWorkPhoneNumber(String workPhoneNumber) {
    this.workPhoneNumber = workPhoneNumber;
    return this;
  }

  public ContactData withFaxNumber(String faxNumber) {
    this.faxNumber = faxNumber;
    return this;
  }

  public ContactData withSecondEmail(String secondEmail) {
    this.secondEmail = secondEmail;
    return this;
  }

  public ContactData withThirdEmail(String thirdEmail) {
    this.thirdEmail = thirdEmail;
    return this;
  }

  public ContactData withHomepage(String homepage) {
    this.homepage = homepage;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public int getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhoneNumber() {
    return homePhoneNumber;
  }

  public String getMobilePhoneNumber() {
    return mobilePhoneNumber;
  }

  public String getWorkPhoneNumber() {
    return workPhoneNumber;
  }

  public String getFaxNumber() {
    return faxNumber;
  }

  public String getSecondEmail() {
    return secondEmail;
  }

  public String getThirdEmail() {
    return thirdEmail;
  }

  public String getHomepage() {
    return homepage;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }
}
