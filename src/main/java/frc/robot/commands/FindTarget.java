package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.networktables.*;

public class FindTarget extends Command {
    final double desiredTargetArea = 8.0;
    public FindTarget() {
        requires(Robot.m_drivetrain);
    }

    @Override
    protected void execute() {
        
        

    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}