/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Climbing;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climb.ElevatorSubsystem;

public class ElevatorUp extends CommandBase {
    private final ElevatorSubsystem winchSubsystem;
  /**
   * Creates a new ElevatorUp.
   */
  public ElevatorUp(ElevatorSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    winchSubsystem = subsystem;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    winchSubsystem.Brake();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    winchSubsystem.setElevatorSpeed(0.86);

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
