package com.damocles.common.security;

import java.io.UnsupportedEncodingException;

import android.util.Base64;

/**
 * Created by zhanglong02 on 16/7/15.
 * <p>
 * Base64编码说明
 * Base64编码要求把3个8位字节（3*8=24）转化为4个6位的字节（4*6=24），之后在6位的前面补两个0，形成8位一个字节的形式。
 * 如果剩下的字符不足3个字节，则用0填充，输出字符使用'='，因此编码后输出的文本末尾可能会出现1或2个'='。
 * 为了保证所输出的编码位可读字符，Base64制定了一个编码表，以便进行统一转换。编码表的大小为2^6=64，这也是Base64名称的由来。
 */
public final class Base64Util {

    private Base64Util() {
    }

    public static String encode(byte[] input) throws UnsupportedEncodingException {
        byte[] output = Base64.encode(input, Base64.DEFAULT);
        return new String(output);
    }

    public static String decode(byte[] input) throws UnsupportedEncodingException {
        byte[] output = Base64.decode(input, Base64.DEFAULT);
        return new String(output);
    }
}
