/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.Shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
// import com.revrobotics.CANSparkMax;
// import com.revrobotics.CANSparkMax.IdleMode;
// import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FlyWheelSubsystem extends SubsystemBase {
  /**
   * Creates a new FlyWheelSubsystem.
   */
  public FlyWheelSubsystem() {

  }

  // public CANSparkMax flyWheelRight = new CANSparkMax(Constants.FLY_WHEEL_RIGHT_CAN, MotorType.kBrushless);
  public TalonFX flyWheelRight = new TalonFX(Constants.FLY_WHEEL_RIGHT_CAN);
  public TalonFX flyWheelLeft = new TalonFX(Constants.FLY_WHEEL_LEFT_CAN);
  // public CANSparkMax flyWheelLeft = new CANSparkMax(Constants.FLY_WHEEL_LEFT_CAN, MotorType.kBrushless);
  public DigitalInput limitSwitch = new DigitalInput(Constants.BALL_LIMIT_SWITCH);
  // public Counter counter = new Counter(limitSwitch);
  public int counter = 0;
  

  
  public void manSpinUp(double speed){
    flyWheelLeft.set(ControlMode.PercentOutput, speed);
    flyWheelRight.set(ControlMode.PercentOutput, speed);
  }

  public void setFlyWheelUP(){
    double startUp = 0.012;
    double flyspeedRight = 0.0;
    double flyspeedLeft = 0.0;

    
    // flyWheelLeft.set(ControlMode.PercentOutput, 0.60);
    // flyWheelRight.set(ControlMode.PercentOutput, -0.60);


    while(flyWheelLeft.getMotorOutputPercent() < 60 && flyWheelRight.getMotorOutputPercent() > -60){
      flyspeedRight -= startUp;
      flyspeedLeft += startUp;

      flyWheelLeft.set(ControlMode.PercentOutput, flyspeedLeft);
      flyWheelRight.set(ControlMode.PercentOutput, flyspeedRight);

    } if(flyWheelLeft.getMotorOutputPercent() == 60 && flyWheelRight.getMotorOutputPercent() == -60){
      // flyspeedLeft = 100;
      // flyspeedRight = -100;
      flyWheelLeft.set(ControlMode.PercentOutput, flyspeedLeft);
      flyWheelRight.set(ControlMode.PercentOutput, flyspeedRight);
    } else{

    }
  }
private boolean prevState = false;
  public void ballSwitch(){ 
    if(!prevState && limitSwitch.get()){
    prevState = true;
    counter += 1;
  }else if(!limitSwitch.get()){
    prevState = false;
  }

    SmartDashboard.putNumber("counter", counter);

  }

  public void counterReset(){
    counter = 0;
  }

  public double leftOutput(){
    return flyWheelLeft.getMotorOutputPercent();
  }
  public double rightOutput(){
    return flyWheelRight.getMotorOutputPercent();
  }

  // public void setFlyWheelDOWN(){
  //   double spinDown = 0.01;
  //   double motorSpeedRight = 1;
  //   double motorSpeedLeft = -1;


  //   while(flyWheelLeft.get() != 0 && flyWheelRight.get() != 0){
  //     motorSpeedRight -= spinDown;
  //     motorSpeedLeft += spinDown;
  //     flyWheelLeft.set(ControlMode.PercentOutput, motorSpeedLeft);
  //     flyWheelRight.set(ControlMode.PercentOutput, motorSpeedRight);
  //   }

  // }
  public void setFlyWheelOff(){
    flyWheelLeft.setNeutralMode(NeutralMode.Coast);
    flyWheelRight.setNeutralMode(NeutralMode.Coast);
    flyWheelLeft.set(ControlMode.PercentOutput, 0);
    flyWheelRight.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
