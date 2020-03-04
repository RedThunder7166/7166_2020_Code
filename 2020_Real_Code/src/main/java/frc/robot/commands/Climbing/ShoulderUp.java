/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Climbing;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Climb.ArmSubsystem;

public class ShoulderUp extends CommandBase {
  private final ArmSubsystem armSubsystem;

  /**
   * Creates a new Arm.
   */
  public ShoulderUp(ArmSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    armSubsystem = subsystem;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    armSubsystem.ShoulderBrake();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    armSubsystem.moveShoulder(0.20);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // armSubsystem.moveShoulder(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
