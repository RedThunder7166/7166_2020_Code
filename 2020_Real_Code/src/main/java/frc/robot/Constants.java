/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
  // Analog ports
  public static final int TURRET_ENCODER = 0;

  // Digital ports

  public static final int HOOD_LIMIT_SWITCH = 0;
  public static final int BALL_LIMIT_SWITCH = 1;
  public static final int CONVEYOR_LIMIT_SWITCH = 2;
  public static final int ARM_LIMIT_SWITCH = 3;  
  public static final int ELBOW_LIMIT_SWITCH = 4;
  // Conveyor ports
  public static final int CONVEYOR_BOTTOM_CAN = 11; // Bag / VictorSPX

  public static final int CONVEYOR_FRONT_CAN = 12; // Bag / VictorSPX

  // Intake port
  public static final int INTAKE_MOTOR_CAN = 18; // Bag / VictorSPX

  // Drive Motor ports
  public static final int FRONT_LEFT_MOTOR_CAN = 2; // Neo / SparkMax
  public static final int FRONT_RIGHT_MOTOR_CAN = 4; // Neo / SparkMax
  public static final int BACK_LEFT_MOTOR_CAN = 1; // Neo / SparkMax
  public static final int BACK_RIGHT_MOTOR_CAN = 3; // Neo / SparkMax

  //Shooter ports
  public static final int TEMP_HOOD_CAN = 6; // Neo550 / SparkMax
  public static final int TEMP_GEAR_CAN = 13; // 775 / TalonSRX
  public static final int FLY_WHEEL_RIGHT_CAN = 9; // Neo / SparkMax
  public static final int FLY_WHEEL_LEFT_CAN = 5; // Neo / SparkMax

  // Elevator ports
  public static final int WINCH_CAN = 14; // Neo / SparkMax

  // Shoulder ports
  public static final int SHOULDER_CAN = 7; // Neo / SparkMax

  // Elbow ports
  public static final int ELBOW_CAN = 8; // Neo / SparkMax

  // Climb Adjust ports
  public static final int CLIMB_ADJUST_CAN = 10; // Neo550 / SparkMax
  
  // Controller Stuff
  public static final int DRIVE_CONTROLLER = 0;

  public static final int DRIVE_LEFT_X_AXIS = 0;
  public static final int DRIVE_LEFT_Y_AXIS = 1;
  public static final int DRIVE_LEFT_TRIGGER = 2;
  public static final int DRIVE_RIGHT_TRIGGER = 3;
  public static final int DRIVE_RIGHT_X_AXIS = 4;
  public static final int DRIVE_RIGHT_Y_AXIS = 5;

  public static final int OPERATOR_CONTROLLER = 1;

  public static final int OPERATOR_X_AXIS = 0;
  public static final int OPERATOR_Y_AXIS = 1;
  public static final int OPERATOR_Z_AXIS = 2;
  public static final int OPERATOR_SLIDER = 3;

  public static final int TEST_CONTROLLER = 2;

  public static final int TEST_LEFT_X_AXIS = 0;
  public static final int TEST_LEFT_Y_AXIS = 1;
  public static final int TEST_LEFT_TRIGGER = 2;
  public static final int TEST_RIGHT_TRIGGER = 3;
  public static final int TEST_RIGHT_X_AXIS = 4;
  public static final int TEST_RIGHT_Y_AXIS = 5;



    // encoder units to inches.
  public static double ENCODER_CONVERSION = (33.5 / 13.476218);


  // TODO: AUTONOMOUS CONSTANTS

   // These are example values only - DO NOT USE THESE FOR YOUR OWN ROBOT!
    // These characterization values MUST be determined either experimentally or theoretically
    // for *your* robot's drive.
    // The Robot Characterization Toolsuite provides a convenient tool for obtaining these
    // values for your robot.
    public static final double ksVolts = 0.22;
    public static final double kvVoltSecondsPerMeter = 1.98;
    public static final double kaVoltSecondsSquaredPerMeter = 0.2;

    // Example value only - as above, this must be tuned for your drive!
    public static final double kPDriveVel = 8.5;

    public static final double kTrackwidthMeters = 0.69;
    public static final DifferentialDriveKinematics kDriveKinematics =
        new DifferentialDriveKinematics(kTrackwidthMeters);
    public static final double kMaxSpeedMetersPerSecond = 3;
    public static final double kMaxAccelerationMetersPerSecondSquared = 3;

    public static final double kEncoderDistancePerPulse = 0;
    public static final boolean kGyroReversed = false;
    	

    // Reasonable baseline values for a RAMSETE follower in units of meters and seconds
    public static final double kRamseteB = 2;
    public static final double kRamseteZeta = 0.7;



}
