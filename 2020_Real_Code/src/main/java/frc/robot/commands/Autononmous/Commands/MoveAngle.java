/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Autononmous.Commands;

// import java.util.List;

// import edu.wpi.first.wpilibj.controller.PIDController;
// import edu.wpi.first.wpilibj.controller.RamseteController;
// import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
// import edu.wpi.first.wpilibj.geometry.Pose2d;
// import edu.wpi.first.wpilibj.geometry.Rotation2d;
// import edu.wpi.first.wpilibj.geometry.Translation2d;
// import edu.wpi.first.wpilibj.trajectory.Trajectory;
// import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
// import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;
// import edu.wpi.first.wpilibj.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.wpilibj2.command.CommandBase;
// import edu.wpi.first.wpilibj2.command.RamseteCommand;
// import frc.robot.Constants;
import frc.robot.subsystems.Drive.DriveSubsystem;
// import frc.robot.subsystems.Shooter.TurretSubsystem;
import frc.robot.subsystems.Shooter.TurretSubsystem;

public class MoveAngle extends CommandBase {
  /**
   * Creates a new FiveBallAuton.
   */
  private final DriveSubsystem driveSubsystem;
  private final double angle;

  public MoveAngle(DriveSubsystem subsystem, double Angle) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveSubsystem = subsystem;
    angle = Angle;
    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double turning = driveSubsystem.setRelavitveAngle(angle);
    driveSubsystem.RocketLeagueDrive(0, turning);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveSubsystem.setLeft(0);
    driveSubsystem.setRight(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (((driveSubsystem.drive_Gyro.getAngle() % 360) >= Math.abs(angle)) ){

    }
    return false;
  }
}
