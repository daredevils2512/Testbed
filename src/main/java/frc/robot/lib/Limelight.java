package frc.robot.lib;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public final class Limelight {
    private final String tableName;
    private NetworkTable table;
    private NetworkTableEntry tv;
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
        tv = table.getEntry("tv");
        tx = table.getEntry("tx");
        ty = table.getEntry("ty");
        ta = table.getEntry("ta");
        ts = table.getEntry("ts");
        ledOn();
    }

    /**
     * docs and list of modes at
     * http://docs.limelightvision.io/en/latest/networktables_api.html
     * @param variable the setting that will be changed. The options are ledMode, camMode, pipeline, stream, and snapshot
     * @param mode the change in the setting; and int between 0 and 9
     */
    private void setMode(String variable, int mode) {
        NetworkTableInstance.getDefault().getTable("limelight").getEntry(variable).setNumber(mode);
    }

    public void ledOn() {
        setMode("ledMode", 0);
    }

    public void ledOff() {
        setMode("ledMode", 1);
    }

    /**
     * weather or not the target is valid, 
     * @return false if variable is null or target isn't found, true if the target is found
     */
    public boolean getTargetValid() {
        return tv.getDouble(1.0) == 1.0;
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