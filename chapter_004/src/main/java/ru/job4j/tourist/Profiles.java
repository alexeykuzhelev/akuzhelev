package ru.job4j.tourist;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 14.07.2019
 */

/**
 * Класс позволяет получить список адресов клиентов используя Stream API.
 */
public class Profiles {
    /**
     * Метод получает список адресов клиентов из списка их профилей.
     * @param profiles - список профилей клиентов.
     * @return - список адресов клиентов.
     */
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(profile -> profile.getAddress()).collect(Collectors.toList());
    }

    /**
     * Метод получает список адресов клиентов из списка их профилей
     * в отосртированном по городу порядке и исключая одинаковые адреса.
     * @param profiles - список профилей клиентов.
     * @return - список адресов клиентов.
     **/
    List<Address> getSortedByCityDistinctListOfAddresses(List<Profile> profiles) {
        return profiles.stream()
                .map(profile -> profile.getAddress())
                .sorted(Comparator.comparing(addres -> addres.getCity()))
                .distinct()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Profiles profiles = new Profiles();
        Address address1 = new Address("Yaroslavl", "Volgogradskaya", 24, 25);
        Address address2 = new Address("Yaroslavl", "Volgogradskaya", 24, 25);
        Address address3 = new Address("Moskva", "Smolenskaya", 56, 86);
        Profile profile1 = new Profile(address1);
        Profile profile2 = new Profile(address2);
        Profile profile3 = new Profile(address3);
        List<Profile> profilesClients = Arrays.asList(profile1, profile2, profile3);
        List<Address> addresses =  profiles.getSortedByCityDistinctListOfAddresses(profilesClients);
        addresses.forEach(System.out::println);
    }
}
