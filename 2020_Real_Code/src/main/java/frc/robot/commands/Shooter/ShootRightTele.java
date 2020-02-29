/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter.FlyWheelSubsystem;
import frc.robot.subsystems.Shooter.TurretSubsystem;

public class ShootRightTele extends CommandBase {
  private final FlyWheelSubsystem flyWheelSubsystem;
  private final TurretSubsystem turretSubsystem;
  /**
   * Creates a new ShootRightTele.
   */
  public ShootRightTele(FlyWheelSubsystem subsystem, TurretSubsystem subsystem2) {
    // Use addRequirements() here to declare subsystem dependencies.
    flyWheelSubsystem = subsystem;
    turretSubsystem = subsystem2;
    addRequirements(subsystem, subsystem2);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    flyWheelSubsystem.setFlyWheelUP();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    turretSubsystem.LimelightLightsOn();
    turretSubsystem.ShowData();
    turretSubsystem.AdjustTurretXRight();
    turretSubsystem.TargetAimY();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    flyWheelSubsystem.setFlyWheelOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
