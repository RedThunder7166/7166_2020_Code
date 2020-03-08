/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

// import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;

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

  // Elevator ports
  public static final int ELEVATOR_CAN = 14; // Neo / SparkMax
    // encoder units to inches.
  public static double ENCODER_CONVERSION = (33.5 / 13.476218);

  // Turret Ports
public static final class TurretConstants{

  public static final int HOOD_LIMIT_SWITCH = 0; // Digital Limit Switch
  public static final int BALL_LIMIT_SWITCH = 1; // Digital Limit Switch
  public static final int TURRET_ENCODER = 0; // Analog Encoder
  public static final int TEMP_HOOD_CAN = 6; // Neo550 / SparkMax
  public static final int TEMP_GEAR_CAN = 13; // 775 / TalonSRX
  public static final int FLY_WHEEL_RIGHT_CAN = 9; // Neo / SparkMax
  public static final int FLY_WHEEL_LEFT_CAN = 5; // Neo / SparkMax
}

  // Conveyor ports
public static final class ConveyorConstants{

  public static final int CONVEYOR_LIMIT_SWITCH = 2; // Digital Limit Switch
  public static final int CONVEYOR_BOTTOM_CAN = 11; // Bag / VictorSPX
  public static final int CONVEYOR_TOP_CAN = 12; // Bag / VictorSPX
  public static final int CONVEYOR_SECOND_TOP_CAN = 1000;
  public static final int INTAKE_MOTOR_CAN = 18; // Bag / VictorSPX
}

  // Drive Motor ports
public static final class DriveConstants{

  public static final int FRONT_LEFT_MOTOR_CAN = 2; // Neo / SparkMax
  public static final int FRONT_RIGHT_MOTOR_CAN = 4; // Neo / SparkMax
  public static final int BACK_LEFT_MOTOR_CAN = 1; // Neo / SparkMax
  public static final int BACK_RIGHT_MOTOR_CAN = 20; // Neo / SparkMax
}

public static final class DigitalConstants{

}

public static final class SolConstants{

  public static final int DRIVE_SOL = 0;
  public static final int INTAKE_SOL = 1;
  public static final int ELEVATOR_SOL = 2;
}

public static final class OIConstants  {

  public static final int DRIVE_CONTROLLER = 0; // Controller
  public static final int DRIVE_LEFT_X_AXIS = 0;
  public static final int DRIVE_LEFT_Y_AXIS = 1;
  public static final int DRIVE_LEFT_TRIGGER = 2;
  public static final int DRIVE_RIGHT_TRIGGER = 3;
  public static final int DRIVE_RIGHT_X_AXIS = 4;
  public static final int DRIVE_RIGHT_Y_AXIS = 5;

  public static final int OPERATOR_CONTROLLER = 1; // Controller
  public static final int OPERATOR_X_AXIS = 0;
  public static final int OPERATOR_Y_AXIS = 1;
  public static final int OPERATOR_Z_AXIS = 2;
  public static final int OPERATOR_SLIDER = 3;

  public static final int TEST_CONTROLLER = 2; // Controller
  public static final int TEST_LEFT_X_AXIS = 0;
  public static final int TEST_LEFT_Y_AXIS = 1;
  public static final int TEST_LEFT_TRIGGER = 2;
  public static final int TEST_RIGHT_TRIGGER = 3;
  public static final int TEST_RIGHT_X_AXIS = 4;
  public static final int TEST_RIGHT_Y_AXIS = 5;
}


  // // Shoulder ports
  // public static final int SHOULDER_CAN = 7; // Neo / SparkMax

  // // Elbow ports
  // public static final int ELBOW_CAN = 8; // Neo / SparkMax

  // Climb Adjust ports
  public static final int CLIMB_ADJUST_CAN = 10; // Neo550 / SparkMax
}

