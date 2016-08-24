/*
class that implements the object Stop:
stopID: Integer
latit: double --latitude value
longi: double --longitude value
 */
package model;


public class Stop {
    public static int stopID;
    public static double latit;
    public static double longi;

    public Stop(int _stopID, double _lagit, double _longi) {
        stopID = _stopID;
        latit = _lagit;
        longi = _longi;
    }

    public static int getStopID() {
        return stopID;
    }

    public static void setStopID(int stopID) {
        Stop.stopID = stopID;
    }

    public static double getLatit() {
        return latit;
    }

    public static void setLatit(double lagit) {
        Stop.latit = lagit;
    }

    public static double getLongi() {
        return longi;
    }

    public static void setLongi(double longi) {
        Stop.longi = longi;
    }
   
}
