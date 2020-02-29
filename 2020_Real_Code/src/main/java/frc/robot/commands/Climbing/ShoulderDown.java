/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Climbing;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climb.ArmSubsystem;

public class ShoulderDown extends CommandBase {
  private final ArmSubsystem armSubsystem;

  /**
   * Creates a new ArmDown.
   */
  public ShoulderDown(ArmSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    armSubsystem = subsystem;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    armSubsystem.moveShoulder(-0.20);
    if(armSubsystem.getShoulderSwitch() == false){
      armSubsystem.ShoulderEncoder.setPosition(0.0);
      armSubsystem.moveShoulder(0.0);
    }
    armSubsystem.ShoulderBrake();
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
