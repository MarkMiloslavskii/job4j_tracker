package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковской программы, которая может выполнять ограниченное
 * количество действий, каждое из которых представлено отдельным методом
 * @author Mark Miloslavskii
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных о пользователе происходит в коллекции users типа Map
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя банка
     * @param user является новым пользователем, имеющего пасспорт и имя
     * Метод позволяет добавить пользователя, ранее незарегистрированного в системе
     */
    public void addUser(User user) {
       users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя
     * @param passport позволяет точно определить удаляемого пользователя
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод при наличии пользователя в системе и отсутсвия вводимого счета
     * открывает пользователю новый счет
     * @param passport используется для идентификации пользователя
     * @param account является счетом (реквизиты + баланс)
     */
    public void addAccount(String passport, Account account) {
       User user = findByPassport(passport);
        if (user != null) {
            users.putIfAbsent(user, new ArrayList<>());
            List<Account> accounts = users.get(user);
                if (!accounts.contains(account)) {
                    accounts.add(account);
                }
            }
    }

    /**
     * Метод позволяет идентифицировать пользователя по паспорту
     * @param passport используется для индентификации
     * @return возвращает пользователя или null, если пользователь не найден
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод ищет банковский счет пользователя по реквизитам
     * @param passport используется для идентификации пользователя
     * @param requisite используется для поиска счета пользователя
     * @return возвращает аккаунт пользователя или null, если пользователя не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        } else {
            return users.get(user)
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
    }

    /**
     * Метод выполняет переводы между счетами
     * @param sourcePassport является паспортом пользователя, со счета которого
     *                       осуществляется транзакция
     * @param sourceRequisite является реквизитом счета, с которого осуществляется транзакция
     * @param destinationPassport явяется паспортом пользователя, в пользу которого
     *                            осуществляется транзакция
     * @param destinationRequisite является реквизитом счет, в пользу которого осуществлена транзакция
     * @param amount является суммой перевода (транзакции)
     * @return возращается true, если перевод состоялся, и false, если перевод осуществлен не был
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount != null && destinationAccount != null) {
            if (sourceAccount.getBalance() >= amount) {
                sourceAccount.setBalance(sourceAccount.getBalance() - amount);
                destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            }
            result = true;
        }
        return result;
    }

    /**
     * Метод возвращает список аккаунтов конкретного пользователя
     * @param user представляет конкретного пользователя
     * @return список счетов или null, если счетов нет
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
