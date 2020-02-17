/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.Shooter;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FlyWheelSubsystem extends SubsystemBase {
  /**
   * Creates a new FlyWheelSubsystem.
   */
  public FlyWheelSubsystem() {

  }

  public CANSparkMax flyWheelRight = new CANSparkMax(Constants.FLY_WHEEL_RIGHT_CAN, MotorType.kBrushless);
  public CANSparkMax flyWheelLeft = new CANSparkMax(Constants.FLY_WHEEL_LEFT_CAN, MotorType.kBrushless);

  


  public void setFlyWheelUP(){
    double startUp = 0.01;
    double flyspeed = 0.0;
    flyWheelLeft.setInverted(true);

    while(flyWheelLeft.get() < 1 && flyWheelRight.get() < 1){
      flyspeed += startUp;

      flyWheelLeft.set(flyspeed);
      flyWheelRight.set(flyspeed);

    } if(flyWheelLeft.get() == 1 && flyWheelRight.get() == 1 ){
      flyWheelLeft.set(1);
      flyWheelRight.set(1);
    } else{}
  }

  public void setFlyWheelDOWN(){
    double spinDown = 0.01;
    double motorSpeed = 1;
    flyWheelRight.setInverted(true);

    while(flyWheelLeft.get() != 0 && flyWheelRight.get() != 0){
      motorSpeed -= spinDown;
      flyWheelLeft.set(motorSpeed);
      flyWheelRight.set(motorSpeed);
    }

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
