package ru.job4j.tourist;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 12.07.2019
 */

public class ProfilesTest {

    Profiles profiles = new Profiles();
    Address address1 = new Address("Krasnodar", "Krasnaya", 10, 11);
    Address address2 = new Address("Yaroslavl", "Volgogradskaya", 24, 25);
    Address address3 = new Address("Moskva", "Smolenskaya", 56, 86);
    Profile profile1 = new Profile(address1);
    Profile profile2 = new Profile(address2);
    Profile profile3 = new Profile(address3);
    List<Profile> profilesClients = Arrays.asList(profile1, profile2, profile3);
    /**
     * Тест проверяет получение списка адресов клиентов из списка их профилей.
     */
    @Test
    public void whenHaveListOfProfilesThenGetListOfAdresses() {
        List<Address> expected = Arrays.asList(address1, address2, address3);
        List<Address> result = profiles.collect(profilesClients);
        assertThat(expected, is(result));
    }
}
