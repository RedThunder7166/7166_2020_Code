/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.Drive;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
public class DriveSubsystem extends SubsystemBase {
  /**
   * Creates a new DriveSubsystem.
   */
  public DriveSubsystem() {

  }

  public CANSparkMax frontLeft = new CANSparkMax(Constants.FRONT_LEFT_MOTOR_CAN, MotorType.kBrushless);
  public CANSparkMax frontRight = new CANSparkMax(Constants.FRONT_RIGHT_MOTOR_CAN, MotorType.kBrushless);
  public CANSparkMax backLeft = new CANSparkMax(Constants.BACK_LEFT_MOTOR_CAN, MotorType.kBrushless);
  public CANSparkMax backRight = new CANSparkMax(Constants.BACK_RIGHT_MOTOR_CAN, MotorType.kBrushless);


  // Declaring the motor groups
  public SpeedControllerGroup leftGroup = new SpeedControllerGroup(frontLeft, backLeft);
  public SpeedControllerGroup rightGroup = new SpeedControllerGroup(frontRight, backRight);

  public DifferentialDrive differentialRocketLeagueDrive = new DifferentialDrive(leftGroup, rightGroup);

  public ADXRS450_Gyro drive_Gyro = new ADXRS450_Gyro(Port.kOnboardCS0);


  // negative speed = right forwards, left backwards
  public void setLeft(double speed){
    leftGroup.set(speed);
  }
  public void setRight(double speed){
    rightGroup.set(-speed);
  }

    // public double Drive_setpoint = 0.0;
    public double Turning_constant = 0.07;
    // public double relativeAngle = 0.0;
    // public double Turningvalue = 0.0;
  

    public double setRelavitveAngle(double angle){
      double relativeAngle = -(drive_Gyro.getAngle() + angle);
      double Turningvalue = (relativeAngle - drive_Gyro.getAngle() *Turning_constant);
      return Turningvalue;
    }

  public void RocketLeagueDrive(double moving, double turning) {
    double turn = 0.0;
    double speed = 0.0;
    double driveSpeed = 0.80;
    double rotateSpeed = 0.60;
    double swivel = .80;

     if(moving >= 0.10 || moving <= 0.10){
       speed = driveSpeed * moving;
       if(Math.abs(turning) > .10){
        turn = rotateSpeed * turning;
      }
     }else if(Math.abs(turning) > .10){
      turn = swivel * Math.pow(turning, 3);
    }

     differentialRocketLeagueDrive.arcadeDrive(speed, turn);
    //  System.out.println("Turn" + turn);
    //  System.out.println("Speed = " + speed);
  }

  public void setBrakeMode(){
    frontLeft.setIdleMode(IdleMode.kBrake);
    backLeft.setIdleMode(IdleMode.kBrake);
    frontRight.setIdleMode(IdleMode.kBrake);
    backRight.setIdleMode(IdleMode.kBrake);
  }

  public void setCoastMode(){
    frontLeft.setIdleMode(IdleMode.kCoast);
    backLeft.setIdleMode(IdleMode.kCoast);
    frontRight.setIdleMode(IdleMode.kCoast);
    backRight.setIdleMode(IdleMode.kCoast);
  }

  public void TargetAimX(){
  //   double tx = RobotContainer.limelightsubsystem.getTX();
  //   double Kp = 0.01f;
  //   double min_Command = 0.0775f;

  //   if(RobotContainer.limelightsubsystem.getTV()){
  //     double heading_error = -tx;
  //     double steering_adjust = 0.0f;

  //     if(tx > 1.0){
  //       steering_adjust = Kp *heading_error - min_Command;

  //     }else if(tx < 1.0){
  //       steering_adjust = Kp *heading_error + min_Command;

  //     }    
  //     System.out.println("Steering:" + steering_adjust);
  //     RobotContainer.driveSubsystem.setLeft(-steering_adjust);
  //     RobotContainer.driveSubsystem.setRight(-steering_adjust);
  //   }
  }

  // negative speed = right forwards, left backwards
  public void TargetAimY(){
  //   double ty = RobotContainer.limelightsubsystem.getTY();
  //   double Kp = 0.01f;
  //   double min_Command = 0.0775f;

  //   if(RobotContainer.limelightsubsystem.getTV()){
  //     double heading_error = -ty;
  //     double steering_adjust = 0.0f;

  //     if(ty > 1.0){
  //       // backwards
  //       steering_adjust = Kp *heading_error - min_Command;

  //     }else if(ty < 1.0){
  //       // forwards
  //       steering_adjust =-(Kp *heading_error + min_Command);

  //     }    
  //     System.out.println("Steering:" + steering_adjust);
  //     RobotContainer.driveSubsystem.setLeft(-steering_adjust);
  //     RobotContainer.driveSubsystem.setRight(steering_adjust);
  //   }
  }

  public CANEncoder leftEncoder = new CANEncoder(frontLeft);
  public CANEncoder rightEncoder = new CANEncoder(frontRight);

  public double getleftEncoder(){

    leftEncoder.setPositionConversionFactor(Constants.ENCODER_CONVERSION);

  return leftEncoder.getPosition();
}

public double getrightEncoder(){

  rightEncoder.setPositionConversionFactor(Constants.ENCODER_CONVERSION);

  return rightEncoder.getPosition();
}

public void leftEncoderReset() {

  leftEncoder.setPosition(0);

}

public void rightEncoderReset(){

  rightEncoder.setPosition(0);

}



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
