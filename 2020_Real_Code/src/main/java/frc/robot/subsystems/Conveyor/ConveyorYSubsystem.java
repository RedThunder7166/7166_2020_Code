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

public class ConveyorYSubsystem extends SubsystemBase {
  /**
   * Creates a new ConveyorYSubsystem.
   */
  public ConveyorYSubsystem() {

  }

  protected VictorSPX topConveyor = new VictorSPX(Constants.CONVEYOR_FRONT_CAN);

  public void setVerticalConveyorSpeed(double speed){
      
      topConveyor.set(ControlMode.PercentOutput, speed);
  }




  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
