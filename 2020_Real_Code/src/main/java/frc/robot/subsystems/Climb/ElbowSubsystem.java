/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.Climb;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;


public class ElbowSubsystem extends SubsystemBase {
  /**
   * Creates a new ElbowSubsystem.
   */
  public VictorSPX ElbowMotor = new VictorSPX(Constants.ELBOW_CAN);
  public DigitalInput ElbowSwitch = new DigitalInput(Constants.ELBOW_LIMIT_SWITCH);

  public void moveElbow(double speed){
    ElbowMotor.set(ControlMode.PercentOutput, -speed);
  }

  public boolean getElbowSwitch(){
    return ElbowSwitch.get();
  }

  public void ElbowBrake(){
    ElbowMotor.setNeutralMode(NeutralMode.Brake);
  }

  public ElbowSubsystem() {

  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
