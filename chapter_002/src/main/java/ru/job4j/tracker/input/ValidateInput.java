package ru.job4j.tracker.input;

import ru.job4j.tracker.exception.*;
import java.util.*;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 13.08.2018
 */

/**
 * Класс ValidateInput реализует валидацию данных, введенных из консоли.
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Метод спросить пользователя.
     * @param question вопрос пользователю.
     * @param range массив со значениями ключа.
     * @return ответ пользователя (ключ).
	 * try - блок, в котором происходят исключительные ситуации.
	 * catch - блоки обработки исключительных ситуаций.
     */
    @Override
    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please, select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please, enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}
