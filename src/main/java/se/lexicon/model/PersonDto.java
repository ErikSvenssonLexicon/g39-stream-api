package se.lexicon.model;

public class PersonDto {

    private int personId;
    private String fullName;

    public PersonDto(int personId, String fullName) {
        this.personId = personId;
        this.fullName = fullName;
    }

    public int getPersonId() {
        return personId;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "personId=" + personId +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
