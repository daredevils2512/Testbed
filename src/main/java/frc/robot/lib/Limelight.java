package frc.robot.lib;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public final class Limelight {
    private NetworkTable table;
    private NetworkTableEntry tx;
    private NetworkTableEntry ty;
    private NetworkTableEntry ta;
    private NetworkTableEntry ts;

    public Limelight() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        getEntries();
    }

    public Limelight(String tableName) {
        table = NetworkTableInstance.getDefault().getTable(tableName);
        getEntries();
    }

    private void getEntries() {
        tx = table.getEntry("tx");
        ty = table.getEntry("ty");
        ta = table.getEntry("ta");
        ts = table.getEntry("ts");
    }

    /**
     * Horizontal offset from crosshair to target
     * @return double ranging from -29.8 to 29.8 degrees
     */
    public double getHorizontalOffset() {
        return tx.getDouble(0.0);
    }

    /**
     * Vertical offset from crosshair to target
     * @return double ranging from -24.85 to 24.85 degrees
     */
    public double getVerticalOfffset() {
        return ty.getDouble(0.0);
    }

    public double getTargetArea() {
        return ta.getDouble(0.0);
    }

    public double getSkew() {
        return ts.getDouble(0.0);
    }
}