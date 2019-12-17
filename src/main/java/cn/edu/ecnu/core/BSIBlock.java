package cn.edu.ecnu.core;

import cn.edu.ecnu.util.HashUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import java.util.Date;

@Log4j2
public class BSIBlock {

    @Getter
    @Setter
    private long timeStamp;

    @Getter
    @Setter
    private String previousHash;

    @Getter
    @Setter
    private String data;

    @Getter
    @Setter
    private String hash;

    @Getter
    @Setter
    private int nonce;

    public BSIBlock(String data, String previousHash) {
        this.previousHash = previousHash;
        this.data = data;
        this.timeStamp = new Date().getTime();
        calculateHash();
        log.info("BSI Block created: " + hash);
    }

    public void calculateHash() {
        String target = "0".repeat(BSIChain.DIFFICULTY);
        hash = "";
        while (!hash.startsWith(target)) {
            nonce++;
            String rawString = previousHash + timeStamp + nonce + data;
            hash = HashUtil.getSha256(rawString);
        }
    }

    public boolean isValid() {
        String rawString = previousHash + timeStamp + nonce + data;
        return hash.equals(HashUtil.getSha256(rawString));
    }
}

