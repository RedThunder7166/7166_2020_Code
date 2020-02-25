/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.Shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class TurretSubsystem extends SubsystemBase {
  /**
   * Creates a new TurretSubsystem.
   */
  public TurretSubsystem() {


  }



  public TalonSRX turret = new TalonSRX(Constants.TEMP_GEAR_CAN);
  public AnalogInput RS7_Encoder = new AnalogInput(Constants.TURRET_ENCODER);
  public AnalogEncoder turret_encoder = new AnalogEncoder(RS7_Encoder);
  public CANSparkMax hoodAdjustMotor = new CANSparkMax(Constants.TEMP_HOOD_CAN, MotorType.kBrushless);
  public CANEncoder hoodEncoder = new CANEncoder(hoodAdjustMotor);
  public DigitalInput limitSwitch = new DigitalInput(0);
  public PowerDistributionPanel pdp = new PowerDistributionPanel(0);

  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

  public void limelightDashboard(){
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");
    NetworkTableEntry tv = table.getEntry("tv");
  
    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);
    double target = tv.getDouble(0.0);


    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("LimelightArea", area);
    SmartDashboard.putNumber("Valid Target", target);
  }

  public double getTX(){
    NetworkTableEntry tx = table.getEntry("tx");
    return tx.getDouble(0.0);
  }
  public double getTY(){
    NetworkTableEntry ty = table.getEntry("ty");
    return ty.getDouble(0.0);
  }
  public double getTA(){
    NetworkTableEntry ta = table.getEntry("ta");
    return ta.getDouble(0.0);
  }
  public double getTV(){
    NetworkTableEntry tv = table.getEntry("tv");
    return(tv.getDouble(0.0));
  }

  public void test(){

  }

  public double getTurretEncoder(){
    return turret_encoder.get();
  }

  public void setTurretSpeed(double speed){
    turret.set(ControlMode.PercentOutput, speed);
  }

  // tx is - when to the right of the target.
  // tx is + when to the left of the target.

  public void AdjustTurretXCenter(){
    double tx = getTX();
    double Kp = 0.01f;
    double min_Command = 0.08f;

    
    if(getTV() == 1){
      double heading_error = -tx;
      double Turret_adjust = 0.0f;

      if(tx > -1.10){
        Turret_adjust = Kp *heading_error - min_Command;

      }else if(tx < -1.50){
        Turret_adjust = Kp *heading_error + min_Command;

      }    
      System.out.println("Steering:" + Turret_adjust);
      setTurretSpeed(-Turret_adjust);
    }else{
      setTurretSpeed(0);
    }
    System.out.println("test");
  }

  public void AdjustTurretXRight(){
    double tx = getTX();
    double Kp = 0.01f;
    double min_Command = 0.08f;

    
    if(getTV() == 1){
      double heading_error = -tx;
      double Turret_adjust = 0.0f;

      if(tx > -11.6){
        Turret_adjust = Kp *heading_error - min_Command;

      }else if(tx < -12.0){
        Turret_adjust = Kp *heading_error + min_Command;

      }    
      System.out.println("Steering:" + Turret_adjust);
      setTurretSpeed(-Turret_adjust);
    }else{
      setTurretSpeed(0);
    }
  }

  public void AdjustTurretXLeft(){
    double tx = getTX();
    double Kp = 0.01f;
    double min_Command = 0.0775f;

    
    if(getTV() == 1){
      double heading_error = -tx;
      double Turret_adjust = 0.0f;

      if(tx > 5.0){
        Turret_adjust = Kp *heading_error - min_Command;

      }else if(tx < 5.0){
        Turret_adjust = Kp *heading_error + min_Command;

      }
      System.out.println("Steering:" + Turret_adjust);
      setTurretSpeed(-Turret_adjust);
    }else{
      setTurretSpeed(0);
    }
  }

  // tx is - when to the right of the target.
  // tx is + when to the left of the target.

  public void setTurretHome(){
  if(turret_encoder.get() > 20){
    turret.set(ControlMode.PercentOutput, 0.15);
  }else if(turret_encoder.get() < -20){
    turret.set(ControlMode.PercentOutput,-0.15);
  }

  }

  public void resetTurretEncoder(){
    turret_encoder.reset();
  }

  public Boolean getLimitSwitchValue(){
    return limitSwitch.get();
  }

  public void setHoodSpeed(double speed){
    hoodAdjustMotor.set(speed);

  }

  public void ShowData(){
    SmartDashboard.putNumber("# 14", pdp.getCurrent(14));
    SmartDashboard.putNumber("# 1", pdp.getCurrent(1));
    SmartDashboard.putNumber("# 0 ", pdp.getCurrent(0));

    SmartDashboard.putNumber("Turret Encoder", turret_encoder.get());
    hoodEncoder.setPositionConversionFactor(100);
    SmartDashboard.putNumber("Hood encoder Value", hoodEncoder.getPosition());
    if(limitSwitch.get() == false){
      hoodEncoder.setPosition(0);
    }
  }

  public void setBrake(){
    hoodAdjustMotor.setIdleMode(IdleMode.kBrake);
  }

  public void setCoast(){
    hoodAdjustMotor.setIdleMode(IdleMode.kCoast);
  }

  public void TargetAimY(){


    if(getTV() == 1){

      getTA();
      if(hoodEncoder.getPosition() > ((((-27 * getTA()) + 650)) + 15)){
        setCoast();
        hoodAdjustMotor.set(-0.04);
      }else if(hoodEncoder.getPosition() < ((((-27 * getTA()) + 650)) - 15)){
        setCoast();
        hoodAdjustMotor.set(0.05);
      }else{
        hoodAdjustMotor.set(0);
        setBrake();
      }

  
    }else{
      setBrake();
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
