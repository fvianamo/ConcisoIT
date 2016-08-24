/*
Class that implements the object Bus:
busID: Integer
licensePlate: String
routeFK: Integer --Reference to routeID at Routes
 */
package model;

public class Bus {
    public static int busID;
    public static String licensePlate;
    public static int routeFK;

    public Bus(int _busID, String _licensePlate, int _routeFK) {
        busID = _busID;
        licensePlate = _licensePlate;
        routeFK = _routeFK;
    }
    
    public static int getBusID() {
        return busID;
    }

    public static void setBusID(int busID) {
        Bus.busID = busID;
    }

    public static String getLicensePlate() {
        return licensePlate;
    }

    public static void setLicensePlate(String licensePlate) {
        Bus.licensePlate = licensePlate;
    }

    public static int getRouteFK() {
        return routeFK;
    }

    public static void setRouteFK(int routeFK) {
        Bus.routeFK = routeFK;
    }
    
}
