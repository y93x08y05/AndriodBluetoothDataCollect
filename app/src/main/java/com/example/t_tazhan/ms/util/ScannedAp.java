package com.example.t_tazhan.ms.util;

import android.net.wifi.ScanResult;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class ScannedAp {
    private int mPointNum;
    private long mLastUpdatedMs;
    private ScanResult mScanResult;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.JAPAN);

    public ScannedAp(int pointNum, ScanResult scanResult, long now) {
        if (scanResult == null)
            throw new IllegalArgumentException("WifiAP is null");

        mPointNum = pointNum;
        mScanResult = scanResult;
        mLastUpdatedMs = now;
    }

    public String getBssid() {
        return mScanResult.BSSID;
    }

    public String getCapabilities() {
        return mScanResult.capabilities;
    }

    public long getLastUpdatedMs() {
        return mLastUpdatedMs;
    }

    public int getLevel() {
        return mScanResult.level;
    }

    public int getFrequency() {
        return mScanResult.frequency;
    }

    public int getPointNum() {
        return mPointNum;
    }

    public ScanResult getAp() {
        return mScanResult;
    }

    public String getSsid() {
        return mScanResult.SSID;
    }

    public long getTimestamp() {
        return mScanResult.timestamp;
    }

    public String toCsv() {
        StringBuilder sb = new StringBuilder();
        // Position Name,BSSID,RSSI,Last Updated,DisplayName,timestamp,Frequency,Capabilities
        sb.append("#").append(String.format("%1$05d", mPointNum)).append(",");
        try {
            sb.append(mScanResult.BSSID);
        } catch (Exception e) {
            sb.append("NA");
        }
        sb.append(",");
        try {
            sb.append(Integer.toString(mScanResult.level));
        } catch (NoSuchFieldError e) {
            sb.append("NA");
        } catch (Exception e) {
            sb.append("NA");
        }
        sb.append(",");
        try {
            sb.append(simpleDateFormat.format(mLastUpdatedMs));
        } catch (NoSuchFieldError e) {
            sb.append("NA");
        } catch (Exception e) {
            sb.append("NA");
        }
        sb.append(",");
        try {
            sb.append(mScanResult.SSID);
        } catch (Exception e) {
            sb.append("NA");
        }
        sb.append(",");
        try {
            sb.append(simpleDateFormat.format(mScanResult.timestamp));
        } catch (NoSuchFieldError e) {
            sb.append("NA");
        } catch (Exception e) {
            sb.append("NA");
        }
        sb.append(",");
        try {
            sb.append(Integer.toString(mScanResult.frequency) + "M");
        } catch (NoSuchFieldError e) {
            sb.append("NA");
        } catch (Exception e) {
            sb.append("NA");
        }
        sb.append(",");
        try {
            sb.append(mScanResult.capabilities);
        } catch (NoSuchFieldError e) {
            sb.append("NA");
        } catch (Exception e) {
            sb.append("NA");
        }
        return sb.toString();
    }
}
