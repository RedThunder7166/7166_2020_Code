/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.Climb;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {
  /**
   * Creates a new ArmSubsystem.
   */
  public ArmSubsystem() {

  }

  public CANSparkMax ShoulderMotor = new CANSparkMax(Constants.SHOULDER_CAN, MotorType.kBrushless);
public VictorSPX ElbowMotor = new VictorSPX(Constants.ELBOW_CAN);
public CANEncoder ShoulderEncoder = new CANEncoder(ShoulderMotor);
public DigitalInput ShoulderSwitch = new DigitalInput(Constants.ARM_LIMIT_SWITCH);
public DigitalInput ElbowSwitch = new DigitalInput(Constants.ELBOW_LIMIT_SWITCH);


public void moveElbow(double speed){
  ShoulderMotor.set(speed);
  ElbowMotor.set(ControlMode.PercentOutput, speed);
}

public void moveShoulder(double speed){
  ShoulderMotor.set(speed);
}

public boolean getShoulderSwitch(){
  return ShoulderSwitch.get();
}

public boolean getElbowSwitch(){
  return ElbowSwitch.get();
}


public void ShoulderBrake(){
  ShoulderMotor.setIdleMode(IdleMode.kBrake);
}

public void ElbowBrake(){
  ElbowMotor.setNeutralMode(NeutralMode.Brake);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
