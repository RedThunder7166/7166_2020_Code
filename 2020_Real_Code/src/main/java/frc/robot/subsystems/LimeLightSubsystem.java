/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class LimeLightSubsystem extends SubsystemBase {
  /**
   * Creates a new LimeLightSubsystem.
   */
  public LimeLightSubsystem() {

  }

  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

  public void limelightDashboard(){
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");
  
    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);
  
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("LimelightArea", area);
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
  public boolean getTV(){
    NetworkTableEntry tv = table.getEntry("tv");
    return(tv.getBoolean(false));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
