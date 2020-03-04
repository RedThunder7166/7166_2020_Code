/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Autononmous.Commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climb.ArmSubsystem;

public class AutoArmUp extends CommandBase {
  private final ArmSubsystem armSubsystem;
  /**
   * Creates a new AutoArmUp.
   */
  public AutoArmUp(ArmSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    armSubsystem = subsystem;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    armSubsystem.shoulderReset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    armSubsystem.moveShoulder(0.50);
    armSubsystem.ShoulderBrake();
    SmartDashboard.putNumber("Shoulder Encoder Value", armSubsystem.moveWithEncoder());



  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    armSubsystem.moveShoulder(-.10);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // return (armSubsystem.moveWithEncoder() >= 550);
    return false;
  }
}
