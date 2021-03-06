package com.gxwtech.rtdemo.bluetooth;

/**
 * Created by Fokko on 3-8-15.
 */
public class CRC {

    /**
     * CRC lookup table - values from PYCRC
     **/
    private final static byte[] CRC8_TABLE = {
            (byte) 0,
            (byte) 155,
            (byte) 173,
            (byte) 54,
            (byte) 193,
            (byte) 90,
            (byte) 108,
            (byte) 247,
            (byte) 25,
            (byte) 130,
            (byte) 180,
            (byte) 47,
            (byte) 216,
            (byte) 67,
            (byte) 117,
            (byte) 238,
            (byte) 50,
            (byte) 169,
            (byte) 159,
            (byte) 4,
            (byte) 243,
            (byte) 104,
            (byte) 94,
            (byte) 197,
            (byte) 43,
            (byte) 176,
            (byte) 134,
            (byte) 29,
            (byte) 234,
            (byte) 113,
            (byte) 71,
            (byte) 220,
            (byte) 100,
            (byte) 255,
            (byte) 201,
            (byte) 82,
            (byte) 165,
            (byte) 62,
            (byte) 8,
            (byte) 147,
            (byte) 125,
            (byte) 230,
            (byte) 208,
            (byte) 75,
            (byte) 188,
            (byte) 39,
            (byte) 17,
            (byte) 138,
            (byte) 86,
            (byte) 205,
            (byte) 251,
            (byte) 96,
            (byte) 151,
            (byte) 12,
            (byte) 58,
            (byte) 161,
            (byte) 79,
            (byte) 212,
            (byte) 226,
            (byte) 121,
            (byte) 142,
            (byte) 21,
            (byte) 35,
            (byte) 184,
            (byte) 200,
            (byte) 83,
            (byte) 101,
            (byte) 254,
            (byte) 9,
            (byte) 146,
            (byte) 164,
            (byte) 63,
            (byte) 209,
            (byte) 74,
            (byte) 124,
            (byte) 231,
            (byte) 16,
            (byte) 139,
            (byte) 189,
            (byte) 38,
            (byte) 250,
            (byte) 97,
            (byte) 87,
            (byte) 204,
            (byte) 59,
            (byte) 160,
            (byte) 150,
            (byte) 13,
            (byte) 227,
            (byte) 120,
            (byte) 78,
            (byte) 213,
            (byte) 34,
            (byte) 185,
            (byte) 143,
            (byte) 20,
            (byte) 172,
            (byte) 55,
            (byte) 1,
            (byte) 154,
            (byte) 109,
            (byte) 246,
            (byte) 192,
            (byte) 91,
            (byte) 181,
            (byte) 46,
            (byte) 24,
            (byte) 131,
            (byte) 116,
            (byte) 239,
            (byte) 217,
            (byte) 66,
            (byte) 158,
            (byte) 5,
            (byte) 51,
            (byte) 168,
            (byte) 95,
            (byte) 196,
            (byte) 242,
            (byte) 105,
            (byte) 135,
            (byte) 28,
            (byte) 42,
            (byte) 177,
            (byte) 70,
            (byte) 221,
            (byte) 235,
            (byte) 112,
            (byte) 11,
            (byte) 144,
            (byte) 166,
            (byte) 61,
            (byte) 202,
            (byte) 81,
            (byte) 103,
            (byte) 252,
            (byte) 18,
            (byte) 137,
            (byte) 191,
            (byte) 36,
            (byte) 211,
            (byte) 72,
            (byte) 126,
            (byte) 229,
            (byte) 57,
            (byte) 162,
            (byte) 148,
            (byte) 15,
            (byte) 248,
            (byte) 99,
            (byte) 85,
            (byte) 206,
            (byte) 32,
            (byte) 187,
            (byte) 141,
            (byte) 22,
            (byte) 225,
            (byte) 122,
            (byte) 76,
            (byte) 215,
            (byte) 111,
            (byte) 244,
            (byte) 194,
            (byte) 89,
            (byte) 174,
            (byte) 53,
            (byte) 3,
            (byte) 152,
            (byte) 118,
            (byte) 237,
            (byte) 219,
            (byte) 64,
            (byte) 183,
            (byte) 44,
            (byte) 26,
            (byte) 129,
            (byte) 93,
            (byte) 198,
            (byte) 240,
            (byte) 107,
            (byte) 156,
            (byte) 7,
            (byte) 49,
            (byte) 170,
            (byte) 68,
            (byte) 223,
            (byte) 233,
            (byte) 114,
            (byte) 133,
            (byte) 30,
            (byte) 40,
            (byte) 179,
            (byte) 195,
            (byte) 88,
            (byte) 110,
            (byte) 245,
            (byte) 2,
            (byte) 153,
            (byte) 175,
            (byte) 52,
            (byte) 218,
            (byte) 65,
            (byte) 119,
            (byte) 236,
            (byte) 27,
            (byte) 128,
            (byte) 182,
            (byte) 45,
            (byte) 241,
            (byte) 106,
            (byte) 92,
            (byte) 199,
            (byte) 48,
            (byte) 171,
            (byte) 157,
            (byte) 6,
            (byte) 232,
            (byte) 115,
            (byte) 69,
            (byte) 222,
            (byte) 41,
            (byte) 178,
            (byte) 132,
            (byte) 31,
            (byte) 167,
            (byte) 60,
            (byte) 10,
            (byte) 145,
            (byte) 102,
            (byte) 253,
            (byte) 203,
            (byte) 80,
            (byte) 190,
            (byte) 37,
            (byte) 19,
            (byte) 136,
            (byte) 127,
            (byte) 228,
            (byte) 210,
            (byte) 73,
            (byte) 149,
            (byte) 14,
            (byte) 56,
            (byte) 163,
            (byte) 84,
            (byte) 207,
            (byte) 249,
            (byte) 98,
            (byte) 140,
            (byte) 23,
            (byte) 33,
            (byte) 186,
            (byte) 77,
            (byte) 214,
            (byte) 224,
            (byte) 123
    };

    public static byte computeCRC(final byte[] data) {
        return computeCRC(data, data.length);
    }

    public static byte computeCRC(final byte[] data, final int length) {
        return computeCRC(data, 0, length);
    }

    public static byte computeCRC(final byte[] data, final int start, final int length) {
        byte crc = 0;
        for (int i = start; i < length; i++) {
            crc = CRC8_TABLE[(crc ^ data[i]) & 0xFF];
        }
        return crc;
    }


    public static byte[] appendCRC(final byte[] bytes) {
        final int len = bytes.length;
        final byte[] outputBytes = new byte[len + 1];

        System.arraycopy(bytes, 0, outputBytes, 0, len);
        outputBytes[len] = computeCRC(bytes);

        return outputBytes;
    }


    public static byte[] calculate16CCITT(final byte[] data) {
        int crc = 0xFFFF;
        final int polynomial = 0x1021;

        if (data != null) {
            if (data.length > 0) {
                for (int j = 0; j < data.length; j++) {
                    byte b = data[j];
                    for (int i = 0; i < 8; i++) {
                        boolean bit = ((b >> (7 - i) & 1) == 1);
                        boolean c15 = ((crc >> 15 & 1) == 1);
                        crc <<= 1;
                        if (c15 ^ bit) {
                            crc ^= polynomial;
                        }
                    }
                }
            }
        }

        crc &= 0xffff;
        return new byte[]{(byte) ((crc & 0xFF00) >> 8), (byte) (crc & 0xFF)};
    }
}