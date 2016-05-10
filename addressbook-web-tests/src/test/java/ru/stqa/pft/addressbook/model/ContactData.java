package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id;
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
  private String group;

  public ContactData(String firstname, String middlename, String lastname, String nickname, String title, String company, String address, String homePhoneNumber, String mobilePhoneNumber, String workPhoneNumber, String faxNumber, String secondEmail, String thirdEmail, String homepage, String group) {
    this.id = Integer.MAX_VALUE;
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
    this.group = group;
  }

  public ContactData(int id, String firstname, String middlename, String lastname, String nickname, String title, String company, String address, String homePhoneNumber, String mobilePhoneNumber, String workPhoneNumber, String faxNumber, String secondEmail, String thirdEmail, String homepage, String group) {
    this.id = id;
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
    this.group = group;
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

  public void setId(int id) {
    this.id = id;
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
