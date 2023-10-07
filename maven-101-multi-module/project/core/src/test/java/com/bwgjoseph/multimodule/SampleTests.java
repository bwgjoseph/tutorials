package com.bwgjoseph.multimodule;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("sample")
class SampleTests {
    @Test
    void test1() {
        Assertions.assertThat(false).isFalse();
    }

    @Test
    void test2() {
        Assertions.assertThat(false).isFalse();
    }
}
