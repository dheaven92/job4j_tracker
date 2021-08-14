package ru.job4j.collection.bank;

import java.util.Objects;

/**
 * Класс описывет пользователя, состоит из паспортных данных и имени пользователя.
 * @author Daria V
 * @version 1.0
 */
public class User {

    /**
     * хранение паспортных данных (номер и серия) в типе String
     */
    private String passport;
    /**
     * хранение имени пользователя в типе String
     */
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод возвращает паспортные данные
     * @return возвращает паспортные данные
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод устанавливает значение паспортных данных (номер и серия)
     * @param passport паспортные данные (номер и серия)
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод возвращает имя пользователся
     * @return возвращает имя пользоавтеля
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод устанавливает значение имени пользователя
     * @param username значение имени
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод переопределяет сравнение объектов класса. При сравнении учитываются паспортные данные.
     * @param o объект класса
     * @return возвращает 1 в случае, если текущий объект больше сравниваемого,
     * возвращаеет -1, если текущий объект меньше сравниваемого,
     * возвращает 0, если объекты равны
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод возвращает хеш сумму объекта.
     * При расчете хеш суммы учитывается только паспортные данные.
     * @return значение хеш суммы
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
