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
import frc.robot.subsystems.Shooter.TurretSubsystem;

public class ShootRight extends CommandBase {
  private final TurretSubsystem turretSubsystem;
  private final FlyWheelSubsystem flyWheelSubsystem;
  private final ConveyorSubsystem conveyorSubsystem;
  private final int ballCount;
  /**
   * Creates a new ShootRight.
   */
  public ShootRight(TurretSubsystem subsystem, FlyWheelSubsystem subsystem2, ConveyorSubsystem subsystem3, int BallCount) {
    turretSubsystem = subsystem;
    flyWheelSubsystem = subsystem2;
    conveyorSubsystem = subsystem3;
    ballCount = BallCount;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
    addRequirements(subsystem2);
    addRequirements(subsystem3);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    flyWheelSubsystem.setFlyWheelUP();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    turretSubsystem.ShowData();
    turretSubsystem.AdjustTurretXRight();
    turretSubsystem.TargetAimY();
    if(flyWheelSubsystem.leftOutput() == 60 && flyWheelSubsystem.rightOutput() == -60){
      conveyorSubsystem.setHorizontalConveyorSpeed(0.35);
      conveyorSubsystem.setVerticalConveyorSpeed(0.35);
    }
    flyWheelSubsystem.ballSwitch();
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    flyWheelSubsystem.setFlyWheelOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(flyWheelSubsystem.counter >= ballCount){
      return true;
    }else{
      return false;
    }
  }
}
