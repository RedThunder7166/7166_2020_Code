/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.Conveyor;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SolConstants;

public class PneumaticIntakeSubsystem extends SubsystemBase {
  /**
   * Creates a new PneumaticIntakeSubsystem.
   */
  public PneumaticIntakeSubsystem() {

  }

  public Solenoid intakeSol = new Solenoid(SolConstants.INTAKE_SOL);

  public void setSol(boolean status){
    intakeSol.set(status);
  }
  public boolean getSol(){
    return intakeSol.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
