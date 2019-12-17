package cn.edu.ecnu.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BSIChainTest {

    @Test
    void isValid() {
        BSIChain chain = new BSIChain();
        chain.addBlock("test block 1");
        chain.addBlock("test block 2");
        assertTrue(chain.isValid());

        chain.getBlocks().get(1).setData("changed block 1");
        assertFalse(chain.isValid());

        chain.getBlocks().get(1).setData("test block 1");
        assertTrue(chain.isValid());

        chain.getBlocks().get(2).setPreviousHash("changed hash 1");
        assertFalse(chain.isValid());
    }
}