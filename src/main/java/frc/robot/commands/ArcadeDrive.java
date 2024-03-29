/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;

public class ArcadeDrive extends Drive {
    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.m_drivetrain.arcadeDrive(Robot.m_oi.getMove(), Robot.m_oi.getTurn());
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        
    }
}
