/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.Shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class TurretSubsystem extends SubsystemBase {
  /**
   * Creates a new TurretSubsystem.
   */
  public TurretSubsystem() {

  }

  public TalonSRX turret = new TalonSRX(Constants.TEMP_GEAR_CAN);
  public AnalogInput RS7_Encoder = new AnalogInput(Constants.TURRET_ENCODER);
  public AnalogEncoder turret_encoder = new AnalogEncoder(RS7_Encoder);




  public double getTurretEncoder(){
    return turret_encoder.get();
  }

  public void setTurretSpeed(double speed){
    turret.set(ControlMode.PercentOutput, speed);
  }

  // tx is - when to the right of the target.
  // tx is + when to the left of the target.

  public void AdjustTurretX(){
    double tx = RobotContainer.limelightsubsystem.getTX();
    double Kp = 0.01f;
    double min_Command = 0.0775f;

    
    if(RobotContainer.limelightsubsystem.getTV() == true){
      double heading_error = -tx;
      double Turret_adjust = 0.0f;

      if(tx > 1.0){
        Turret_adjust = Kp *heading_error - min_Command;

      }else if(tx < 1.0){
        Turret_adjust = Kp *heading_error + min_Command;

      }    
      System.out.println("Steering:" + Turret_adjust);
      setTurretSpeed(-Turret_adjust);
    }
  }

  public void setTurretHome(){
  // output = (Kp * error) + (Ki * change in error) + (Kd * derivative of error)
    double Kp = 0.0;
    double Ki = 0.0;
    double Kd = 0.0;
    SmartDashboard.getNumber("Kp", Kp);
    SmartDashboard.getNumber("Ki", Ki);
    SmartDashboard.getNumber("Kd", Kd);

    PIDController turret_Controller = new PIDController(Kp, Ki, Kd);
    double turret_Move = turret_Controller.calculate(getTurretEncoder());

    setTurretSpeed(turret_Move);

    turret_Controller.close();

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
