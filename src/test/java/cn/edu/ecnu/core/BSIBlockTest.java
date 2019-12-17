package cn.edu.ecnu.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class BSIBlockTest {

    @Test
    void isValid() {
        BSIBlock block = new BSIBlock("test data", "0");
        Assertions.assertTrue(block.isValid());
        block.setData("changed data");
        assertFalse(block.isValid());
    }
}