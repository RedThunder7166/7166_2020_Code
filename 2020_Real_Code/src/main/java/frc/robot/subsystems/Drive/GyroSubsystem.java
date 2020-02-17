/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GyroSubsystem extends SubsystemBase {
  /**
   * Creates a new GyroSubsystem.
   */
  public GyroSubsystem() {

  }

  public ADXRS450_Gyro drive_Gyro = new ADXRS450_Gyro(Port.kOnboardCS0);
  // public double Drive_setpoint = 0.0;
  public double Turning_constant = 0.07;
  // public double relativeAngle = 0.0;
  // public double Turningvalue = 0.0;

  public double getTurningValue(double Drive_setpoint){
    double Turningvalue = (Drive_setpoint - drive_Gyro.getAngle() *Turning_constant);
    return Turningvalue;
  }

  public double setRelavitveAngle(double angle){
    double relativeAngle = drive_Gyro.getAngle() + angle;
    return relativeAngle;
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
