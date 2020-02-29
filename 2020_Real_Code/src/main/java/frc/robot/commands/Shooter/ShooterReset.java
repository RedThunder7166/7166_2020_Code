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

public class ShooterReset extends CommandBase {
  private final TurretSubsystem turretSubsystem;
  private final FlyWheelSubsystem flyWheelSubsystem;
  /**
   * Creates a new ShooterReset.
   */
  public ShooterReset(TurretSubsystem subsystem, FlyWheelSubsystem subsystem2) {
    // Use addRequirements() here to declare subsystem dependencies.
    turretSubsystem = subsystem;
    flyWheelSubsystem = subsystem2;
    addRequirements(subsystem);
    addRequirements(subsystem2);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // TODO: have it set the turret encoder to zero every auton.
    // turretSubsystem.turret_encoder.reset();
    flyWheelSubsystem.counterReset();
    turretSubsystem.setTurretSpeed(0.0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    turretSubsystem.LimelightLightsOff();
    flyWheelSubsystem.setFlyWheelOff();
    turretSubsystem.ShowData();
    flyWheelSubsystem.ballSwitch();
    turretSubsystem.setBrake();
    // turretSubsystem.setTurretHome();
    if(turretSubsystem.getLimitSwitchValue() == false){
      turretSubsystem.setHoodSpeed(0.0);
    }else{
      turretSubsystem.setHoodSpeed(-0.10);
    }
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
