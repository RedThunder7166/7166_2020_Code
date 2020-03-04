/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Conveyor.ConveyorSubsystem;
import frc.robot.subsystems.Shooter.FlyWheelSubsystem;

public class ShooterBackFeed extends CommandBase {
  private final FlyWheelSubsystem flyWheelSubsystem;
  private final ConveyorSubsystem conveyorSubsystem;
  /**
   * Creates a new ShooterBackFeed.
   */
  public ShooterBackFeed(FlyWheelSubsystem subsystem, ConveyorSubsystem subsystem2) {
    // Use addRequirements() here to declare subsystem dependencies.
    flyWheelSubsystem = subsystem;
    conveyorSubsystem = subsystem2;
    addRequirements(subsystem, subsystem2);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    conveyorSubsystem.setVerticalConveyorSpeed(-0.30);
    flyWheelSubsystem.manMove(-0.01);
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
