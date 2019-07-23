package com.example.parker;
import java.util.UUID;
public class BleDefinedUUIDs {
    public static class Service {
        final static public
        UUID CAR_LOCATION               = UUID.fromString("0000180d-0000-1000-8000-00805f9b34fb");
    };

    public static class Characteristic {
        final static public UUID PARKING_SLOT   = UUID.fromString("00002a37-0000-1000-8000-00805f9b34fb");
        final static public UUID MANUFACTURER_STRING      = UUID.fromString("00002a29-0000-1000-8000-00805f9b34fb");
        final static public UUID MODEL_NUMBER_STRING      = UUID.fromString("00002a24-0000-1000-8000-00805f9b34fb");
        final static public UUID AVAILABLE_SLOTS = UUID.fromString("00002a26-0000-1000-8000-00805f9b34fb");
        final static public UUID APPEARANCE               = UUID.fromString("00002a01-0000-1000-8000-00805f9b34fb");
        final static public UUID CAR_SENSOR_LOCATION     = UUID.fromString("00002a38-0000-1000-8000-00805f9b34fb");
        final static public UUID COST_RATE            = UUID.fromString("00002a19-0000-1000-8000-00805f9b34fb");
    }

    public static class Descriptor {
        final static public UUID CHAR_CLIENT_CONFIG       = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    }

}
