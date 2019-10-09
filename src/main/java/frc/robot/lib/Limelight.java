package frc.robot.lib;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public final class Limelight {
    private final String tableName;
    private NetworkTable table;
    private NetworkTableEntry tx;
    private NetworkTableEntry ty;
    private NetworkTableEntry ta;
    private NetworkTableEntry ts;

    public Limelight() {
        tableName = "limelight";
        Init();
    }

    public Limelight(String tableName) {
        this.tableName = tableName;
        Init();
    }

    private void Init() {
        table = NetworkTableInstance.getDefault().getTable(tableName);
        tx = table.getEntry("tx");
        ty = table.getEntry("ty");
        ta = table.getEntry("ta");
        ts = table.getEntry("ts");
    }

    /**
     * Horizontal offset from crosshair to target
     * @return Double ranging from -29.8 to 29.8 degrees
     */
    public double getHorizontalOffset() {
        return tx.getDouble(0.0);
    }

    /**
     * Vertical offset from crosshair to target
     * @return Double ranging from -24.85 to 24.85 degrees
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