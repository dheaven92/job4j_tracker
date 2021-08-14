package ru.job4j.collection.bank;

import java.util.Objects;

/**
 * Класс описывет аккаунт пользователя, состоит из реквизитов и текущего баланса.
 * @author Daria V
 * @version 1.0
 */
public class Account {

    /**
     * хранение реквизитов в типе String
     */
    private String requisite;
    /**
     * хранение текущего баланса в типе double
     */
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод возращает реквизиты
     * @return возвращает реквизиты
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод устанавливает значение реквизитов
     * @param requisite значение реквизитов
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод возращает баланс
     * @return возвращает баланс
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод устанавилвает значение баланса
     * @param balance значение баланса
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод переопределяет сравнение объектов класса. При сравнении учитываются реквизиты.
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод возвращает хеш сумму объекта.
     * При расчете хеш суммы учитывается только поле реквизиты.
     * @return значение хеш суммы
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
