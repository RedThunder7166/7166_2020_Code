/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter.HoodSubsystem;
import frc.robot.subsystems.Shooter.TurretSubsystem;

public class ShootCenter extends CommandBase {
  private final TurretSubsystem turretSubsystem;
  private final HoodSubsystem hoodSubsystem;
  /**
   * Creates a new ShootCenter.
   */
  public ShootCenter(TurretSubsystem subsystem, HoodSubsystem subsystem2) {
    turretSubsystem = subsystem;
    hoodSubsystem = subsystem2;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem, subsystem2);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    turretSubsystem.AdjustTurretXCenter();
    // hoodSubsystem.TargetAimY();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
