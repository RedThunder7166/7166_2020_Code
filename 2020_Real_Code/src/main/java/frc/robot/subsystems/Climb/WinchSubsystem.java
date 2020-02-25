/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.Climb;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class WinchSubsystem extends SubsystemBase {
  /**
   * Creates a new WinchSubsystem.
   */
  public WinchSubsystem() {

  }

  public CANSparkMax winch = new CANSparkMax(Constants.WINCH_CAN, MotorType.kBrushless);

  public void setElevatorUp(double speed){
    winch.set(-speed);
  }


  // public void Brake(){
  //   Winch.setIdleMode(IdleMode.kBrake);
  // }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
