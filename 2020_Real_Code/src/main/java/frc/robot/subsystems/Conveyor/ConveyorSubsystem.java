/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.Conveyor;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ConveyorConstants;

public class ConveyorSubsystem extends SubsystemBase {
  /**
   * Creates a new ConveyorYSubsystem.
   */
  public ConveyorSubsystem() {

  }

  public DigitalInput limitSwitch = new DigitalInput(ConveyorConstants.CONVEYOR_LIMIT_SWITCH);
  public VictorSPX topConveyor = new VictorSPX(ConveyorConstants.CONVEYOR_TOP_CAN);
  public VictorSPX topConveyorTwo = new VictorSPX(ConveyorConstants.CONVEYOR_SECOND_TOP_CAN);
  public VictorSPX BottomConveyor = new VictorSPX(ConveyorConstants.CONVEYOR_BOTTOM_CAN);
  public VictorSPX intakeMotor = new VictorSPX(ConveyorConstants.INTAKE_MOTOR_CAN);

  public void setVerticalConveyorSpeed(double speed){
      topConveyor.set(ControlMode.PercentOutput, speed);
  }

  public void setSecondVerticalConveyorSpeed(double speed){
    topConveyorTwo.set(ControlMode.PercentOutput, speed);
  }

  public void setHorizontalConveyorSpeed(double speed){
    BottomConveyor.setInverted(true);
    BottomConveyor.set(ControlMode.PercentOutput, speed);
  }



  public void setIntakeSpeed(double speed){
    intakeMotor.set(ControlMode.PercentOutput, speed);
  }

  public void setIntakingSpeed(double speed){
    
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
