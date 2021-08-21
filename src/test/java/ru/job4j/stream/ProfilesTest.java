package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenEqual() {
        List<Profile> profiles = new ArrayList<>(List.of(
                new Profile(new Address(
                        "Moscow",
                        "Lenina",
                        8,
                        34
                )),
                new Profile(new Address(
                        "St. Petersburg",
                        "Krasnaya",
                        10,
                        5
                ))
        ));
        List<Address> expectedAddresses = List.of(
                new Address(
                        "Moscow",
                        "Lenina",
                        8,
                        34
                ),
                new Address(
                        "St. Petersburg",
                        "Krasnaya",
                        10,
                        5
                )
        );
        List<Address> actualAddresses = new Profiles().collect(profiles);
        assertEquals(expectedAddresses, actualAddresses);
    }

    @Test
    public void whenNotEqual() {
        List<Profile> profiles = new ArrayList<>(List.of(
                new Profile(new Address(
                        "Moscow",
                        "Lenina",
                        8,
                        34
                ))
        ));
        List<Address> expectedAddresses = List.of(
                new Address(
                        "Moscow",
                        "Lenina",
                        8,
                        34
                ),
                new Address(
                        "St. Petersburg",
                        "Krasnaya",
                        10,
                        5
                )
        );
        List<Address> actualAddresses = new Profiles().collect(profiles);
        assertNotEquals(expectedAddresses, actualAddresses);
    }
}