/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Autononmous.Groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Autononmous.Commands.MoveAngle;
import frc.robot.commands.Autononmous.Commands.MoveDistance;
import frc.robot.commands.Shooter.ShootCenter;
import frc.robot.subsystems.Drive.DriveSubsystem;
import frc.robot.subsystems.Shooter.TurretSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class FiveBallMoves extends SequentialCommandGroup {
  /**
   * Creates a new FiveBallMoves.
   */
  public FiveBallMoves(DriveSubsystem driveSubsystem, TurretSubsystem turretSubsystem) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    addCommands(new MoveDistance(driveSubsystem, 0.75, 130.36),
                new MoveAngle(driveSubsystem, 125), 
                new MoveDistance(driveSubsystem, 0.75, 231.6),
                new MoveAngle(driveSubsystem, 55),
                new ShootCenter(turretSubsystem)
                );
  }
}
