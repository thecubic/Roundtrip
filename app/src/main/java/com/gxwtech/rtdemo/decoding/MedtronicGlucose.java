package com.gxwtech.rtdemo.decoding;

import android.util.Log;

import com.gxwtech.rtdemo.HexDump;
import com.gxwtech.rtdemo.bluetooth.CRC;
import com.gxwtech.rtdemo.medtronic.MedtronicConstants;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Created by Fokko on 6-8-15.
 */
public class MedtronicGlucose extends DataPackage {
    private static final String TAG = "MedtronicGlucose";

    private int mgdl = -1;

    public int getMgdl() {
        return this.mgdl;
    }

    @Override
    public void decode(final byte[] readData) {

        if(readData.length != packageLength()) {
            Log.w(TAG, "Unknown length of data.");
            return;
        }

        byte crcComputed = CRC.computeCRC(readData,2,8);

        if(crcComputed != readData[readData.length-1]) {
            Log.w(TAG, "Invalid CRC.");
            return;
        }

        mgdl = ByteBuffer.wrap(new byte[]{0x00, 0x00, readData[6], readData[7]}).getInt();
    }

    @Override
    protected int packageLength() {
        return 9;
    }

    @Override
    public String toString() {
        return "Glucose reading " + mgdl + "mg/dl " + Conversion.mgdlToMmol(mgdl);
    }
}