package hwPart3;

import java.util.HashSet;
import java.util.Set;

public class DataBase {
    private final Set<Passport> passports = new HashSet<>();

    public void addPassport(Passport passport) {
        if (passport == null) {
            throw new IllegalArgumentException("Паспорт не может быть null!");
        }

        for (Passport p : passports) {
            if (passport.equals(p)) {
                passports.remove(p);
                passports.add(passport);
                return;
            }
        }

        passports.add(passport);
    }

    public Passport getPassport(String number) {
        if (number == null || number.isBlank()) {
            return null;
        }

        for (Passport p : passports) {
            if (p.getNumber().equals(number)) {
                return p;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Passport p : passports) {
            sb.append(p).append('\n');
        }
        return "База данных содержит паспорта:\n" + sb;
    }
}
