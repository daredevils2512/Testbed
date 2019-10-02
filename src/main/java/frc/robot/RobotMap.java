/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    //All placeholder IDs, haven't been programmed into the CAN thingydoodle yet
    public static int leftFrontDriveMotorID = 1;
    public static int leftRearDriveMotorID = 2;
    public static int leftDriveEncoderChannelA = 0;
    public static int leftDriveEncoderChannelB = 1;

    public static int rightFrontDriveMotorID = 3;
    public static int rightRearDriveMotorID = 4;
    public static int rightDriveEncoderChannelA = 2;
    public static int rightDriveEncoderChannelB = 3;
}
