/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.Drive.PneumaticsDoNothing;

public class PneumaticsSubsystem extends SubsystemBase {
  /**
   * Creates a new PneumaticsSubsystem.
   */
  public PneumaticsSubsystem() {


  }

  public Solenoid Sol = new Solenoid(0, 0);


  public void highGear(){
    Sol.set(false);
  }

  public void lowGear(){
    Sol.set(true);
  }

  public void doNothing(){
    // do nothing
  }

  @Override
  public void setDefaultCommand(Command defaultCommand) {
    super.setDefaultCommand(new PneumaticsDoNothing(this));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
