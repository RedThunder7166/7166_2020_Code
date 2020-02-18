/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Drive;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Drive.DriveSubsystem;

public class DriveTrain extends CommandBase {
  private final DriveSubsystem driveSubsystem;
  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain(DriveSubsystem subsystem) {
    driveSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  GenericHID joystick = Robot.robotContainer.getjoystick();

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    double leftTrigger = joystick.getRawAxis(Constants.DRIVE_LEFT_TRIGGER);
    double rightTrigger = joystick.getRawAxis(Constants.DRIVE_RIGHT_TRIGGER);
    double rotation = joystick.getRawAxis(Constants.DRIVE_LEFT_X_AXIS);
    double speed = (rightTrigger - leftTrigger);
    driveSubsystem.RocketLeagueDrive(speed, rotation);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
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
