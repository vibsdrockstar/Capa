package com.example.parker;
import java.nio.DoubleBuffer;
import java.util.HashMap;

import android.util.SparseArray;

public class BLENamesResolver {
    private static HashMap<String, String> mServices = new HashMap<String, String>();
    private static HashMap<String, String> mCharacteristics = new HashMap<String, String>();
    private static SparseArray<String> mValueFormats = new SparseArray<String>();
    private static SparseArray<String> mAppearance = new SparseArray<String>();
    private static SparseArray<String> mCarSensorLocation = new SparseArray<String>();

    static public String resolveServiceName(final String uuid)
    {
        String result = mServices.get(uuid);
        if(result == null) result = "Unknown Service";
        return result;
    }

    static public String resolveValueTypeDescription(final int format)
    {
        Integer tmp = Integer.valueOf(format);
        return mValueFormats.get(tmp, "Unknown Format");
    }

    static public String resolveCharacteristicName(final String uuid)
    {
        String result = mCharacteristics.get(uuid);
        if(result == null) result = "Unknown Characteristic";
        return result;
    }

    static public String resolveUuid(final String uuid) {
        String result = mServices.get(uuid);
        if(result != null) return "Service: " + result;

        result = mCharacteristics.get(uuid);
        if(result != null) return "Characteristic: " + result;

        result = "Unknown UUID";
        return result;
    }

    static public String resolveAppearance(int key) {
        Integer tmp = Integer.valueOf(key);
        return mAppearance.get(tmp, "Unknown Appearance");
    }

    static public String findCarSensorLocation(int key) {
        Integer temp = Integer.valueOf(key);
        return (String) mCarSensorLocation.get(temp,"Other");
    }

    static public boolean isService(final String uuid) {
        return mServices.containsKey(uuid);
    }

    static public boolean isCharacteristic(final String uuid) {
        return mCharacteristics.containsKey(uuid);
    }

    static {
        mServices.put("00001811-0000-1000-8000-00805f9b34fb", "Alert Notification Service");
        mServices.put("0000180f-0000-1000-8000-00805f9b34fb", "Vehicle Type");
        mServices.put("00001810-0000-1000-8000-00805f9b34fb", "Parking Area");
        mServices.put("00001805-0000-1000-8000-00805f9b34fb", "User's Address");
        mServices.put("00001818-0000-1000-8000-00805f9b34fb", "Destination");
        mServices.put("00001816-0000-1000-8000-00805f9b34fb", "Arrival Time");
        mServices.put("0000180a-0000-1000-8000-00805f9b34fb", "Departure Time");
        mServices.put("00001800-0000-1000-8000-00805f9b34fb", "Date");
        mServices.put("00001801-0000-1000-8000-00805f9b34fb", "Slot Number");
        mServices.put("00001808-0000-1000-8000-00805f9b34fb", "Slot information");
        mServices.put("00001809-0000-1000-8000-00805f9b34fb", "Car Details");
        mServices.put("0000180d-0000-1000-8000-00805f9b34fb", "User Details");
        mServices.put("00001812-0000-1000-8000-00805f9b34fb", "GPS");
        mServices.put("00001802-0000-1000-8000-00805f9b34fb", "Cost");



        mCharacteristics.put("00002a43-0000-1000-8000-00805f9b34fb", "Access Control");
        mCharacteristics.put("00002a42-0000-1000-8000-00805f9b34fb", "Access Control System");
        mCharacteristics.put("00002a06-0000-1000-8000-00805f9b34fb", "Alert Level");
        mCharacteristics.put("00002a44-0000-1000-8000-00805f9b34fb", "Alarms");
        mCharacteristics.put("00002a3f-0000-1000-8000-00805f9b34fb", "Alert Status");
        mCharacteristics.put("00002a01-0000-1000-8000-00805f9b34fb", "Appearance");
        mCharacteristics.put("00002a19-0000-1000-8000-00805f9b34fb", "Barcode");
        mCharacteristics.put("00002a49-0000-1000-8000-00805f9b34fb", "Bill Stacker");
        mCharacteristics.put("00002a35-0000-1000-8000-00805f9b34fb", "Bill Validator");
        mCharacteristics.put("00002a38-0000-1000-8000-00805f9b34fb", "Bollard");
        mCharacteristics.put("00002a22-0000-1000-8000-00805f9b34fb", "Boot ");
        mCharacteristics.put("00002a32-0000-1000-8000-00805f9b34fb", "Bulk Permits");
        mCharacteristics.put("00002a33-0000-1000-8000-00805f9b34fb", "CISP");
        mCharacteristics.put("00002a5c-0000-1000-8000-00805f9b34fb", "Cark Park Out Management Systems");
        mCharacteristics.put("00002a5b-0000-1000-8000-00805f9b34fb", "Chip Card");
        mCharacteristics.put("00002a2b-0000-1000-8000-00805f9b34fb", "Current Time");
        mCharacteristics.put("00002a66-0000-1000-8000-00805f9b34fb", "Chip and PIN");
        mCharacteristics.put("00002a65-0000-1000-8000-00805f9b34fb", "Chip and Signature");
        mCharacteristics.put("00002a63-0000-1000-8000-00805f9b34fb", "Coin Box");
        mCharacteristics.put("00002a64-0000-1000-8000-00805f9b34fb", "Credentials");
        mCharacteristics.put("00002a08-0000-1000-8000-00805f9b34fb", "Date Time");
        mCharacteristics.put("00002a0a-0000-1000-8000-00805f9b34fb", "Day Date Time");
        mCharacteristics.put("00002a09-0000-1000-8000-00805f9b34fb", "Day of Week");
        mCharacteristics.put("00002a00-0000-1000-8000-00805f9b34fb", "Data Analytics");
        mCharacteristics.put("00002a0d-0000-1000-8000-00805f9b34fb", "Demand Based Pricing");
        mCharacteristics.put("00002a0c-0000-1000-8000-00805f9b34fb", "Entry Lane Station ");
        mCharacteristics.put("00002a26-0000-1000-8000-00805f9b34fb", "Facility Management System");
        mCharacteristics.put("00002a51-0000-1000-8000-00805f9b34fb", "GPS Feature");
        mCharacteristics.put("00002a18-0000-1000-8000-00805f9b34fb", "Geo Fence");
        mCharacteristics.put("00002a34-0000-1000-8000-00805f9b34fb", "General Packet Radio Service");
        mCharacteristics.put("00002a27-0000-1000-8000-00805f9b34fb", "Handheld Ticketwriter");
        mCharacteristics.put("00002a39-0000-1000-8000-00805f9b34fb", "Grace Period");
        mCharacteristics.put("00002a37-0000-1000-8000-00805f9b34fb", "Global System for Mobile Communications (GSMC)");
        mCharacteristics.put("00002a4c-0000-1000-8000-00805f9b34fb", "HID Control Point");
        mCharacteristics.put("00002a4a-0000-1000-8000-00805f9b34fb", "HID Information");
        mCharacteristics.put("00002a2a-0000-1000-8000-00805f9b34fb", "IEEE 11073-20601 Regulatory Certification Data List");
        mCharacteristics.put("00002a36-0000-1000-8000-00805f9b34fb", "Incar meter");
        mCharacteristics.put("00002a1e-0000-1000-8000-00805f9b34fb", "Interface");
        mCharacteristics.put("00002a6b-0000-1000-8000-00805f9b34fb", "Lane Controller");
        mCharacteristics.put("00002a6a-0000-1000-8000-00805f9b34fb", "Lease contract");
        mCharacteristics.put("00002a0f-0000-1000-8000-00805f9b34fb", "Local Time Information");
        mCharacteristics.put("00002a67-0000-1000-8000-00805f9b34fb", "Location and Speed");
        mCharacteristics.put("00002a29-0000-1000-8000-00805f9b34fb", "Manufacturer Name String");
        mCharacteristics.put("00002a21-0000-1000-8000-00805f9b34fb", "Metro Mesh Wifi");
        mCharacteristics.put("00002a24-0000-1000-8000-00805f9b34fb", "Model Number String");
        mCharacteristics.put("00002a68-0000-1000-8000-00805f9b34fb", "Navigation");
        mCharacteristics.put("00002a46-0000-1000-8000-00805f9b34fb", "New Alert");
        mCharacteristics.put("00002a04-0000-1000-8000-00805f9b34fb", "On Street Parking");
        mCharacteristics.put("00002a02-0000-1000-8000-00805f9b34fb", "Peripheral Privacy Flag");
        mCharacteristics.put("00002a50-0000-1000-8000-00805f9b34fb", "Parking ID");
        mCharacteristics.put("00002a69-0000-1000-8000-00805f9b34fb", "Position Quality");
        mCharacteristics.put("00002a4e-0000-1000-8000-00805f9b34fb", "Pay by cell phone");
        mCharacteristics.put("00002a03-0000-1000-8000-00805f9b34fb", "Reconnection Address");
        mCharacteristics.put("00002a52-0000-1000-8000-00805f9b34fb", "Radio-frequency Identification (RFID)");
        mCharacteristics.put("00002a14-0000-1000-8000-00805f9b34fb", "Real Time Information");
        mCharacteristics.put("00002a4d-0000-1000-8000-00805f9b34fb", "Report");
        mCharacteristics.put("00002a4b-0000-1000-8000-00805f9b34fb", "Report Map");
        mCharacteristics.put("00002a40-0000-1000-8000-00805f9b34fb", "Replenishing Coin Changer");
        mCharacteristics.put("00002a41-0000-1000-8000-00805f9b34fb", "Revenue Control");
        mCharacteristics.put("00002a54-0000-1000-8000-00805f9b34fb", "Revenue Control System (RCS)");
        mCharacteristics.put("00002a53-0000-1000-8000-00805f9b34fb", "Short-term Parking");
        mCharacteristics.put("00002a55-0000-1000-8000-00805f9b34fb", "Single-space Smart Meter (SSSM)");
        mCharacteristics.put("00002a4f-0000-1000-8000-00805f9b34fb", "Scan Interval Window");
        mCharacteristics.put("00002a31-0000-1000-8000-00805f9b34fb", "Scan Refresh");
        mCharacteristics.put("00002a5d-0000-1000-8000-00805f9b34fb", "Sensor Location");
        mCharacteristics.put("00002a25-0000-1000-8000-00805f9b34fb", "Serial Number String");
        mCharacteristics.put("00002a05-0000-1000-8000-00805f9b34fb", "Service Changed");
        mCharacteristics.put("00002a28-0000-1000-8000-00805f9b34fb", "Software as a Service (SaaS)");
        mCharacteristics.put("00002a47-0000-1000-8000-00805f9b34fb", "Space Sensor");
        mCharacteristics.put("00002a48-0000-1000-8000-00805f9b34fb", "Supported Unread Alert Category");
        mCharacteristics.put("00002a23-0000-1000-8000-00805f9b34fb", "System ID");
        mCharacteristics.put("00002a1c-0000-1000-8000-00805f9b34fb", "Time Measurement");
        mCharacteristics.put("00002a1d-0000-1000-8000-00805f9b34fb", "Time Type");
        mCharacteristics.put("00002a12-0000-1000-8000-00805f9b34fb", "Time Accuracy");
        mCharacteristics.put("00002a13-0000-1000-8000-00805f9b34fb", "Time Source");
        mCharacteristics.put("00002a16-0000-1000-8000-00805f9b34fb", "Time Update Control Point");
        mCharacteristics.put("00002a17-0000-1000-8000-00805f9b34fb", "Time Update State");
        mCharacteristics.put("00002a11-0000-1000-8000-00805f9b34fb", "Time with DST");
        mCharacteristics.put("00002a0e-0000-1000-8000-00805f9b34fb", "Time Zone");
        mCharacteristics.put("00002a07-0000-1000-8000-00805f9b34fb", "Tx Power Level");
        mCharacteristics.put("00002a45-0000-1000-8000-00805f9b34fb", "Unread Alert Status");

        mValueFormats.put(Integer.valueOf(52), "32bit float");
        mValueFormats.put(Integer.valueOf(50), "16bit float");
        mValueFormats.put(Integer.valueOf(34), "16bit signed int");
        mValueFormats.put(Integer.valueOf(36), "32bit signed int");
        mValueFormats.put(Integer.valueOf(33), "8bit signed int");
        mValueFormats.put(Integer.valueOf(18), "16bit unsigned int");
        mValueFormats.put(Integer.valueOf(20), "32bit unsigned int");
        mValueFormats.put(Integer.valueOf(17), "8bit unsigned int");

        // lets add also couple appearance string description
        // https://developer.bluetooth.org/gatt/characteristics/Pages/CharacteristicViewer.aspx?u=org.bluetooth.characteristic.gap.appearance.xml
        mAppearance.put(Integer.valueOf(833), "Vehicle Location Sensor: Belt");
        mAppearance.put(Integer.valueOf(832), "Automobile Motion Sensor");
        mAppearance.put(Integer.valueOf(0), "Unknown");
        mAppearance.put(Integer.valueOf(64), "Generic Phone");
        mAppearance.put(Integer.valueOf(1157), "Vehicle: Speed and Cadence Sensor");
        mAppearance.put(Integer.valueOf(1152), "General Automobile");
        mAppearance.put(Integer.valueOf(1153), "Vehicle Computer");
        mAppearance.put(Integer.valueOf(1154), "Vehicle: Speed Sensor");
        mAppearance.put(Integer.valueOf(1155), "Vehicle: Cadence Sensor");
        mAppearance.put(Integer.valueOf(1156), "Vehicle: Speed and Cadence Sensor");
        mAppearance.put(Integer.valueOf(1157), "Vehicle: Power Sensor");

        mCarSensorLocation.put(Integer.valueOf(0), "Parking Slot");
        mCarSensorLocation.put(Integer.valueOf(1), "User's vehicle");
        mCarSensorLocation.put(Integer.valueOf(2), "User's Eye");

    }
}


