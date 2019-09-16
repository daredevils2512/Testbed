/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import com.kauailabs.navx.frc.AHRS;

/**
 * NavX
 */
public class NavX {

  AHRS navX;

  public NavX() {
    navX = new AHRS();
  }

  public NavX(SerialPort.Port serialPort) {
    navX = new AHRS(serialPort);
  }

  public double heading() {
    return navX.getAngle();
  }

  public double pitch() {
    return navX.getPitch();
  }

  public double yaw() {
    return navX.getYaw();
  }

  public double roll() {
    return navX.getRoll();
  }
}
