package ru.job4j.template;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GeneratorTest {

    @Test
    void shouldProduceCorrectStringWhenTemplateAndArgsMatch() {
        Generator generator = new GeneratorImpl();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of("name", "Petr Arsentev", "subject", "you");
        String expected = "I am a Petr Arsentev, Who are you?";
        String result = generator.produce(template, args);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void shouldThrowExceptionWhenTemplateHasKeyMissingInArgs() {
        Generator generator = new GeneratorImpl();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of("name", "Petr Arsentev");

        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldThrowExceptionWhenArgsContainKeyNotInTemplate() {
        Generator generator = new GeneratorImpl();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of(
                "name", "Petr Arsentev",
                "subject", "you",
                "extraKey", "extraValue"
        );

        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
