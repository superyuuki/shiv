package shiv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnalyticProviderTest {

    @Test
    public void shivProviderShouldBeAnalyticInTests() {
        Shiv shiv = Shiv.provide(e -> {});

        assertEquals("analytic", shiv.name());
    }

}
