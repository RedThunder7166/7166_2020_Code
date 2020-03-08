/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Conveyor;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Conveyor.PneumaticIntakeSubsystem;

public class PneumaticIntakeNothing extends CommandBase {
  private final PneumaticIntakeSubsystem IntakeSubsystem;
  /**
   * Creates a new PneumaticIntakeNothing.
   */
  public PneumaticIntakeNothing(PneumaticIntakeSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    IntakeSubsystem = subsystem;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    boolean status = IntakeSubsystem.getSol();
    IntakeSubsystem.setSol(status);

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
