package com.training.petru;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DummyMainTest {



    @Test
    void test() {
        DummyMain d = new DummyMain("sdv");
        Assertions.assertThat(d.getModel());

    }
}
