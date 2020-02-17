/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.Conveyor;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ConveyorXSubsystem extends SubsystemBase {
  /**
   * Creates a new ConveyorXSubsystem.
   */
  public ConveyorXSubsystem() {

  }

  public VictorSPX BottomConveyor = new VictorSPX(Constants.CONVEYOR_BOTTOM_CAN);

  public void setHorizontalConveyorSpeed(double speed){
    BottomConveyor.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
