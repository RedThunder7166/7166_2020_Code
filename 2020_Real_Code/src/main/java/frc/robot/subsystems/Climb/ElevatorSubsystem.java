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

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.SolConstants;

public class ElevatorSubsystem extends SubsystemBase {
  /**
   * Creates a new ElevatorSubsystem.
   */
  public ElevatorSubsystem() {

  }

  public CANSparkMax elevator = new CANSparkMax(Constants.ELEVATOR_CAN, MotorType.kBrushless);
  public Solenoid elevatorSol = new Solenoid(SolConstants.ELEVATOR_SOL);

  public void setElevatorSpeed(double speed){
    elevator.set(-speed);
  }

  public void setSol(boolean status){
    elevatorSol.set(status);
  }

  public boolean getSol(){
    return elevatorSol.get();
  }

  public void Brake(){
    elevator.setIdleMode(IdleMode.kBrake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
