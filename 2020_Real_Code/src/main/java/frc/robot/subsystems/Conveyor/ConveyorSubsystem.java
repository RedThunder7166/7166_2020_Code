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
import frc.robot.Constants;

public class ConveyorSubsystem extends SubsystemBase {
  /**
   * Creates a new ConveyorYSubsystem.
   */
  public ConveyorSubsystem() {

  }

  public DigitalInput limitSwitch = new DigitalInput(Constants.CONVEYOR_LIMIT_SWITCH);
  public VictorSPX topConveyor = new VictorSPX(Constants.CONVEYOR_FRONT_CAN);

  public void setVerticalConveyorSpeed(double speed){
      
      topConveyor.set(ControlMode.PercentOutput, speed);
  }

  public VictorSPX BottomConveyor = new VictorSPX(Constants.CONVEYOR_BOTTOM_CAN);

  public void setHorizontalConveyorSpeed(double speed){
    BottomConveyor.setInverted(true);
    BottomConveyor.set(ControlMode.PercentOutput, speed);
  }

  public VictorSPX intakeMotor = new VictorSPX(Constants.INTAKE_MOTOR_CAN);


  public void setIntakeSpeed(double speed){
    intakeMotor.set(ControlMode.PercentOutput, speed);
  }

  public void fullIntake(double speed){
    if(speed >= 0.10 || speed <= 0.10){
      if(limitSwitch.get() == true){
        setIntakeSpeed(speed);
        setHorizontalConveyorSpeed(speed);
        setVerticalConveyorSpeed(0);
      }else {
        setIntakeSpeed(speed);
        setHorizontalConveyorSpeed(speed);
        setVerticalConveyorSpeed(speed);
      }
    }
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
