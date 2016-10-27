package com.kami.app.key.persistence;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * Base64 encode and decode the String info
 * Created by shidian on 2016/10/26.
 */

public class EncodeHelper {
    private BASE64Encoder encoder;
    private BASE64Decoder decoder;

    public EncodeHelper(BASE64Encoder encoder, BASE64Decoder decoder) {
        this.encoder = encoder;
        this.decoder = decoder;
    }

    public EncodeHelper() {
        this.encoder = new BASE64Encoder();
        this.decoder = new BASE64Decoder();
    }

    public String encode(String plainTextInput){
        return  encoder.encode(plainTextInput.getBytes());
    }

    public String decode(String encodedTextInput){
        String decodedString  = null;
        try {
            decodedString = new String(decoder.decodeBuffer(encodedTextInput));
        } catch (IOException e) {
            //e.printStackTrace();避免打印tracestack到web中
            throw  new RuntimeException("Decoding Error", e);
        }
        return decodedString;
    }


}
