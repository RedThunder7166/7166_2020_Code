/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter.TurretSubsystem;

public class HoodDown extends CommandBase {
  private final TurretSubsystem hoodSubsystem;
  /**
   * Creates a new HoodDown.
   */
  public HoodDown(TurretSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    hoodSubsystem = subsystem;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    hoodSubsystem.ShowData();
    hoodSubsystem.setBrake();
    if(hoodSubsystem.getLimitSwitchValue() == false){
      hoodSubsystem.setHoodSpeed(0.0);
    }
    if(hoodSubsystem.getLimitSwitchValue() == true){
      hoodSubsystem.setHoodSpeed(-0.10);
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // if(hoodSubsystem.getLimitSwitchValue() == true){
    //   return true;
    // }
    return false;
  }
}
