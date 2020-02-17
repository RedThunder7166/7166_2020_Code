/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.Shooter;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class HoodSubsystem extends SubsystemBase {
  /**
   * Creates a new HoodSubsystem.
   */
  public HoodSubsystem() {

  }

  public CANSparkMax hoodAdjustMotor = new CANSparkMax(Constants.TEMP_HOOD_CAN, MotorType.kBrushless);
  public CANEncoder hoodEncoder = new CANEncoder(hoodAdjustMotor);

  public void setHoodSpeed(double speed){
    hoodAdjustMotor.set(speed);
  }

  public void TargetAimY(){
    double ty = RobotContainer.limelightsubsystem.getTY();
    double Kp = 0.01f;
    double min_Command = 0.0775f;

    if(RobotContainer.limelightsubsystem.getTV()){
      double heading_error = -ty;
      double adjustY = 0.0f;

      if(ty > 1.0){
        // backwards
        adjustY = Kp *heading_error - min_Command;

      }else if(ty < 1.0){
        // forwards
        adjustY = -(Kp *heading_error + min_Command);

      }    
      System.out.println("Steering:" + adjustY);
      setHoodSpeed(adjustY);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
