package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String title;
  private final String company;
  private final String address;
  private final String homePhoneNumber;
  private final String mobilePhoneNumber;
  private final String workPhoneNumber;
  private final String faxNumber;
  private final String secondEmail;
  private final String thirdEmail;
  private final String homepage;

  public ContactData(String firstname, String middlename, String lastname, String nickname, String title, String company, String address, String homePhoneNumber, String mobilePhoneNumber, String workPhoneNumber, String faxNumber, String secondEmail, String thirdEmail, String homepage) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.homePhoneNumber = homePhoneNumber;
    this.mobilePhoneNumber = mobilePhoneNumber;
    this.workPhoneNumber = workPhoneNumber;
    this.faxNumber = faxNumber;
    this.secondEmail = secondEmail;
    this.thirdEmail = thirdEmail;
    this.homepage = homepage;
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
}
