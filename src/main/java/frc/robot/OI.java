/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    private int driverPort = 0;

    public Joystick driver = new Joystick(this.driverPort);

    private double desensitize(double value) {
        return value < 0.15 ? 0.0 : value;
    }

    public double getMove() {
        return desensitize(driver.getRawAxis(1));
    }

    public double getTurn() {
        return desensitize(driver.getRawAxis(4));
    }
}
