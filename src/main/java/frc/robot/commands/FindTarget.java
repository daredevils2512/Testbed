package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class FindTarget extends Command {

    private double headingError;
    private final double rampCoeff = 0.2; //ramp Coefficient: calibrate this to define how fast it turns. May need to be negative
    private final double minSpeed = 0.0; //minimum accepted speed: calibrate this to define how slowly it can go and still move.
    private final double tolerance = 5.0; //the accepted final range of degrees of the target at the end of the maneuver.
    private final double desiredTa = 1.0; //the accepted final range of degrees of the target at the end of the maneuver.
    final double DRIVE_K = 0.26;                    // how hard to drive fwd toward the target
    final double STEER_K = 0.03;                    // how hard to turn toward the target


    private double turnSpeed = 0.0;
    private double driveSpeed = 0.0;

    public FindTarget() {
        headingError = 0.0;
    }

    @Override
    protected void initialize() {
        Robot.m_limelight.ledOn();
    }

    @Override
    protected void execute() {
        turnSpeed = 0.5;
        driveSpeed = 0.1;
        if (Robot.m_limelight.getTargetValid()) {
            //true when the crosshairs are outside of the tolerance
            //gets the limelight data
            headingError = Robot.m_limelight.getHorizontalOffset();
          //  if (Math.abs(headingError) > tolerance) {
                //calculates the ramped speed between the minimum speed and one using the ramp coefficient
                //turnSpeed = Math.min(Math.max(headingError * rampCoeff, minSpeed), 1); 
                turnSpeed = headingError * STEER_K;
                driveSpeed = (desiredTa - Robot.m_limelight.getTargetArea()) * DRIVE_K;
        //    }
        }
        Robot.m_drivetrain.arcadeDrive(driveSpeed,turnSpeed);
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