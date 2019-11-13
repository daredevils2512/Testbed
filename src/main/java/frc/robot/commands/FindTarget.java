package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class FindTarget extends Command {

<<<<<<< HEAD
    private final double desiredTa = 5.0; //the accepted final range of degrees of the target at the end of the maneuver.
    final double DRIVE_K = -0.3;                    // how hard to drive fwd toward the target
    final double STEER_K = -0.03;                    // how hard to turn toward the target
=======
    private final double desiredTa = 9.0; //the accepted final range of degrees of the target at the end of the maneuver.
    final double DRIVE_K = 0.26;                    // how hard to drive fwd toward the target
    final double STEER_K = 0.02;                    // how hard to turn toward the target
>>>>>>> 5278b0f090c17fb27553401b39bd0ed79599e4c2


    private double turnSpeed = 0.05;
    private double driveSpeed = 0.0;



    public FindTarget() {
    }

    @Override
    protected void initialize() {
        Robot.m_limelight.ledOn();
    }

    @Override
    protected void execute() {
<<<<<<< HEAD
        turnSpeed = 0.5;
        driveSpeed = 0.0;
=======
>>>>>>> 5278b0f090c17fb27553401b39bd0ed79599e4c2
        if (Robot.m_limelight.getTargetValid()) {
            //true when the crosshairs are outside of the tolerance
            //gets the limelight data
          //  if (Math.abs(headingError) > tolerance) {
                //calculates the ramped speed between the minimum speed and one using the ramp coefficient
                //turnSpeed = Math.min(Math.max(headingError * rampCoeff, minSpeed), 1); 
<<<<<<< HEAD
                turnSpeed = Robot.m_limelight.getHorizontalOffset() * STEER_K;
                driveSpeed = (desiredTa - Robot.m_limelight.getTargetArea()) * DRIVE_K;
=======
                turnSpeed = -(Robot.m_limelight.getHorizontalOffset() * STEER_K);
                driveSpeed = Math.min((desiredTa - Robot.m_limelight.getTargetArea()) * DRIVE_K, 0.7);
>>>>>>> 5278b0f090c17fb27553401b39bd0ed79599e4c2
        //    }
        } else {
            turnSpeed = 0.5;
            driveSpeed = 0.1;
        }
        SmartDashboard.putNumber("turn speed", turnSpeed);
        SmartDashboard.putNumber("drive speed", driveSpeed);
        Robot.m_drivetrain.arcadeDrive(-driveSpeed, turnSpeed);
    }

    @Override
    protected void end() {
        Robot.m_drivetrain.arcadeDrive(0.0, 0.0);
    }

    @Override
    protected void interrupted() {
        Robot.m_drivetrain.arcadeDrive(0.0, 0.0);
    }

    @Override
    protected boolean isFinished() {
        return Robot.m_limelight.getTargetArea() >= desiredTa;
    }
}