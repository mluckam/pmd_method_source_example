package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class UserTest {

    private User sut;

    private static Stream<Arguments> testGetUsername_noMethodSourceValue() {
        return Stream.of(
                Arguments.of("foo"),
                Arguments.of("bar"),
                Arguments.of("baz")
        );
    }

    @MethodSource
    @ParameterizedTest
    void testGetUsername_noMethodSourceValue(String username) {
        User sut = new User(username);

        Assertions.assertEquals(username, sut.getUsername());
    }

    private static Stream<Arguments> testGetUsername_methodSourceValue() {
        return Stream.of(
                Arguments.of("foo"),
                Arguments.of("bar"),
                Arguments.of("baz")
        );
    }

    @MethodSource("testGetUsername_methodSourceValue")
    @ParameterizedTest
    void testGetUsername_methodSourceValue(String username) {
        sut = new User(username);

        Assertions.assertEquals(username, sut.getUsername());
    }
}
