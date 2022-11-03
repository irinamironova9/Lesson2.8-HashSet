package hwPart3;

import java.time.LocalDate;
import java.util.Objects;

public class Passport {
    private final String number;
    private final String surname;
    private final String name;
    private final String middleName;
    private final LocalDate birthDate;

    public Passport(String number,
                    String surname,
                    String name,
                    String middleName,
                    LocalDate birthDate) {

        this.number = parse(number);
        this.surname = parse(surname);
        this.name = parse(name);
        this.middleName = middleName == null || middleName.isBlank() ?
        "" : middleName;

        if (birthDate != null && !birthDate.isAfter(LocalDate.now())) {
            this.birthDate = birthDate;
        } else {
            throw new IllegalArgumentException("Заполните все поля корректными данными!");
        }
    }

    public static String parse(String value) {
        if (value != null && !value.isBlank()) {
            return value;
        } else {
            throw new IllegalArgumentException("Заполните все поля корректными данными!");
        }
    }

    @Override
    public String toString() {
        return String.format("Номер паспорта: %s\n" +
                "ФИО: %s %s %s\n" +
                "Дата рождения: %s",
                number,
                surname, name, middleName,
                birthDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return Objects.equals(number, passport.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public String getNumber() {
        return number;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
