package frc.robot.utils;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {
    
    private NetworkTableInstance table = null;


    /**
     * Gets whether a target is detected by the Limelight.
     *
     * @return true if a target is detected, false otherwise.
     */
    public boolean isTarget() {
        return getValue("tv").getDouble(0) == 1;
    }

    /**
     * Horizontal offset from crosshair to target (-27 degrees to 27 degrees).
     *
     * @return tx as reported by the Limelight.
     */
    public double getTx() {
        return getValue("tx").getDouble(0.00);
    }

    /**
     * Vertical offset from crosshair to target (-20.5 degrees to 20.5 degrees).
     *
     * @return ty as reported by the Limelight.
     */
    public double getTy() {
        return getValue("ty").getDouble(0.00);
    }

    /**
     * Area that the detected target takes up in total camera FOV (0% to 100%).
     *
     * @return Area of target.
     */
    public double getTa() {
        return getValue("ta").getDouble(0.00);
    }

    /**
     * Gets target skew or rotation (-90 degrees to 0 degrees).
     *
     * @return Target skew.
     */
    public double getTs() {
        return getValue("ts").getDouble(0.00);
    }

    /**
     * Gets target latency (ms).
     *
     * @return Target latency.
     */
    public double getTl() {
        return getValue("tl").getDouble(0.00);
    }

    /**
     * Sets LED mode of Limelight.
     *
     * @param mode
     *            Light mode for Limelight.
     */

    /**
     * Sets pipeline number (0-9 value).
     *
     * @param number
     *            Pipeline number (0-9).
     */
    public void setPipeline(int number) {
        getValue("pipeline").setNumber(number);
    }

    /**
     * Helper method to get an entry from the Limelight NetworkTable.
     *
     * @param key
     *            Key for entry.
     * @return NetworkTableEntry of given entry.
     */
    private NetworkTableEntry getValue(String key) {
        if (table == null) {
            table = NetworkTableInstance.getDefault();
        }

        return table.getTable("limelight").getEntry(key);
    }
}