/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.Climb;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {
  /**
   * Creates a new ArmSubsystem.
   */
  public ArmSubsystem() {

  }

  public CANSparkMax ShoulderMotor = new CANSparkMax(Constants.SHOULDER_CAN, MotorType.kBrushless);
public CANSparkMax ElbowMotor = new CANSparkMax(Constants.ELBOW_CAN, MotorType.kBrushless);
public CANEncoder ShoulderEncoder = new CANEncoder(ShoulderMotor);
public CANEncoder ElbowEncoder = new CANEncoder(ElbowMotor);


public void setArmSpeed(double speed){
  ShoulderMotor.set(speed);
  ElbowMotor.set(speed);
}

public void moveShoulder(double speed){
  ShoulderMotor.set(speed);
}


public void brake(){
  ShoulderMotor.setIdleMode(IdleMode.kBrake);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
