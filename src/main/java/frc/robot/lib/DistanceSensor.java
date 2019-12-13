package frc.robot.lib;

import edu.wpi.first.wpilibj.Ultrasonic;

public class DistanceSensor {
    private Ultrasonic ultrasonic;

    public DistanceSensor() {
        ultrasonic = new Ultrasonic(1, 1);
        ultrasonic.setAutomaticMode(true);
    }

    /**
     * gets disatnce in inches
     * @return distance in inches
     */
    public double getDistance() {
        return ultrasonic.getRangeInches();
    }
}