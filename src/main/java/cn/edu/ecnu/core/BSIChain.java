package cn.edu.ecnu.core;

import lombok.Getter;

import java.util.ArrayList;

public class BSIChain {

    public static final int DIFFICULTY = 5;
    public static final String INIT_HASH = "0";

    @Getter
    private ArrayList<BSIBlock> blocks;

    public BSIChain() {
        this.blocks = new ArrayList<>();
        this.blocks.add(new BSIBlock("init block.", INIT_HASH));
    }

    public BSIBlock addBlock(String data) {
        String previousHash = blocks.get(blocks.size() - 1).getHash();
        BSIBlock newBlock = new BSIBlock(data, previousHash);
        blocks.add(newBlock);
        return newBlock;
    }

    public boolean isValid() {
        String previousHash = INIT_HASH;
        for (BSIBlock block : blocks) {
            if (!block.isValid()) {
                return false;
            }

            if (!block.getPreviousHash().equals(previousHash)) {
                return false;
            }

            previousHash = block.getHash();
        }
        return true;
    }
}
