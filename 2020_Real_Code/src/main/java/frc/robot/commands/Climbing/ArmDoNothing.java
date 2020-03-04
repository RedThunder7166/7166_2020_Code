/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Climbing;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climb.ArmSubsystem;
import frc.robot.subsystems.Climb.ElbowSubsystem;

public class ArmDoNothing extends CommandBase {
  private final ArmSubsystem armSubsystem;
  private final ElbowSubsystem elbowSubsystem;

  /**
   * Creates a new ArmDoNothing.
   */
  public ArmDoNothing(ArmSubsystem subsystem, ElbowSubsystem subsystem2) {
    // Use addRequirements() here to declare subsystem dependencies.
    armSubsystem = subsystem;
    elbowSubsystem = subsystem2;
    addRequirements(subsystem, subsystem2);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    if(armSubsystem.getShoulderSwitch() == false){
      armSubsystem.moveShoulder(0.0);
    }
    // if(armSubsystem.getShoulderSwitch() == true){
    //   armSubsystem.moveShoulder(0.02);
    // }
    if(elbowSubsystem.getElbowSwitch() == false){
      elbowSubsystem.moveElbow(0.0);
    }
    if(elbowSubsystem.getElbowSwitch() == true){
      elbowSubsystem.moveElbow(0.10);
    }
    armSubsystem.ShoulderBrake();
    elbowSubsystem.ElbowBrake();
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
