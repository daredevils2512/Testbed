/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Drive extends Command {
    public Drive() {
        requires(Robot.m_drivetrain);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Robot.m_drivetrain.arcadeDrive(Robot.m_oi.getMove(), Robot.m_oi.getTurn());
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }
}