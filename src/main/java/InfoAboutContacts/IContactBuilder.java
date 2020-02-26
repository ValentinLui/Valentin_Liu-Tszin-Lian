package InfoAboutContacts;

public interface IContactBuilder {
    void setName(String Name);
    void setSurname(String Surname);
    void setPatronymic(String Patronymic);
    void setDayOfBirth(int Day);
    void setMonthOfBirth(int Month);
    void setYearOfBirth(int Year);
    void setSex(boolean Sex);
    void setCitizenship(String Citizenship);
    void setFamilyStatus(FamilyStatus Status);
    void setWebSite(String WebSite);
    void setEmail(String Email);
    void setWork(String Work);
    void setAddress();
}
