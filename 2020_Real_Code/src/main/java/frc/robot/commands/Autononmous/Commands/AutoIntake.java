/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Autononmous.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climb.ArmSubsystem;
import frc.robot.subsystems.Conveyor.ConveyorSubsystem;

public class AutoIntake extends CommandBase {
  private final ConveyorSubsystem conveyorSubsystem;
  private final ArmSubsystem armSubsystem;
  private final double speed;
  /**
   * Creates a new AutoIntake.
   */
  public AutoIntake(ConveyorSubsystem subsystem, ArmSubsystem subsystem2, double intakeSpeed) {
    // Use addRequirements() here to declare subsystem dependencies.
    conveyorSubsystem = subsystem;
    armSubsystem = subsystem2;
    speed = intakeSpeed;
    addRequirements(subsystem, subsystem2);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  
    armSubsystem.moveShoulder(-0.20);  
    if(armSubsystem.getShoulderSwitch() == true){
    conveyorSubsystem.fullIntake(speed);
    }

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
