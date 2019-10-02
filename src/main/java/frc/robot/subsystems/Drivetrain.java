/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDrive;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
    private static double gearRatio = 1;
    private static double encoderPulsesPerRevolution = 128 * gearRatio; //Pulses per revolution of whatever encoders we use
    private static double encoderRevolutionsPerPulse = 1 / encoderPulsesPerRevolution;
    private static double wheelDiameter = 0; //Don't know this atm
    private static double wheelCircumference = Math.PI * wheelDiameter;
    private static double encoderDistancePerPulse = encoderRevolutionsPerPulse * wheelCircumference;

    private WPI_TalonSRX leftFrontMotor;
    private WPI_TalonSRX leftRearMotor;
    private WPI_TalonSRX rightFrontMotor;
    private WPI_TalonSRX rightRearMotor;
    private static SpeedControllerGroup leftGroup;
    private static SpeedControllerGroup rightGroup;
    private static DifferentialDrive drivetrain;
    private Encoder leftEncoder;
    private Encoder rightEncoder;

    public Drivetrain() {
        leftFrontMotor = new WPI_TalonSRX(RobotMap.leftFrontDriveMotorID);
        leftRearMotor = new WPI_TalonSRX(RobotMap.leftRearDriveMotorID);
        rightFrontMotor = new WPI_TalonSRX(RobotMap.rightFrontDriveMotorID);
        rightRearMotor = new WPI_TalonSRX(RobotMap.rightRearDriveMotorID);
        leftGroup = new SpeedControllerGroup(leftFrontMotor, leftRearMotor);
        rightGroup = new SpeedControllerGroup(rightFrontMotor, rightRearMotor);
        drivetrain = new DifferentialDrive(leftGroup, rightGroup);

        leftEncoder = new Encoder(RobotMap.leftDriveEncoderChannelA, RobotMap.leftDriveEncoderChannelB, false, EncodingType.k4X);
        rightEncoder = new Encoder(RobotMap.rightDriveEncoderChannelA, RobotMap.rightDriveEncoderChannelB, true, EncodingType.k4X);
        leftEncoder.setDistancePerPulse(encoderDistancePerPulse);
        rightEncoder.setDistancePerPulse(encoderDistancePerPulse);
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new ArcadeDrive());
    }

    public void arcadeDrive(double move, double turn) {
        drivetrain.arcadeDrive(move, turn);
    }
}
