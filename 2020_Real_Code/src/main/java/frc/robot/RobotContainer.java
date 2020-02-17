/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import frc.robot.commands.Drive.HighGear;
import frc.robot.commands.Drive.LowGear;
import frc.robot.commands.Shooter.TurretReturnHome;
import frc.robot.subsystems.AutonomousSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LimeLightSubsystem;
import frc.robot.subsystems.Climb.ArmSubsystem;
import frc.robot.subsystems.Climb.ClimbAdjustSubsystem;
import frc.robot.subsystems.Climb.WinchSubsystem;
import frc.robot.subsystems.Conveyor.ConveyorXSubsystem;
import frc.robot.subsystems.Conveyor.ConveyorYSubsystem;
import frc.robot.subsystems.Drive.DriveSubsystem;
import frc.robot.subsystems.Drive.GyroSubsystem;
import frc.robot.subsystems.Drive.PneumaticsSubsystem;
import frc.robot.subsystems.Shooter.FlyWheelSubsystem;
import frc.robot.subsystems.Shooter.HoodSubsystem;
import frc.robot.subsystems.Shooter.TurretSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  public static ArmSubsystem armSubsystem = new ArmSubsystem();
  public static ClimbAdjustSubsystem climbAdjustSubsystem = new ClimbAdjustSubsystem();
  public static WinchSubsystem winchSubsystem = new WinchSubsystem();

  public static ConveyorYSubsystem conveyorYSubsystem = new ConveyorYSubsystem();
  public static ConveyorXSubsystem conveyorXSubsystem = new ConveyorXSubsystem();

  public static DriveSubsystem driveSubsystem = new DriveSubsystem();
  public static GyroSubsystem gyroSubsystem = new GyroSubsystem();
  public static PneumaticsSubsystem pneumaticsSubsystem = new PneumaticsSubsystem();

  public static FlyWheelSubsystem flyWheelSubsystem = new FlyWheelSubsystem();
  public static HoodSubsystem hoodSubsystem = new HoodSubsystem(); 
  public static TurretSubsystem turretSubsystem = new TurretSubsystem();

  public static AutonomousSubsystem autonomousSubsystem = new AutonomousSubsystem();

  public static LimeLightSubsystem limelightsubsystem = new LimeLightSubsystem();

  public static IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

  GenericHID joystick = new XboxController(Constants.DRIVE_CONTROLLER);


  GenericHID opjoystick = new Joystick(Constants.OPERATOR_CONTROLLER);


  Button A_Button = new JoystickButton(joystick, 1);
  Button B_Button = new JoystickButton(joystick, 2);
  Button X_Button = new JoystickButton(joystick, 3);
  Button Y_Button = new JoystickButton(joystick, 4);
  Button LB_Button = new JoystickButton(joystick, 5);
  Button RB_Button = new JoystickButton(joystick, 6);
  Button Select_Button = new JoystickButton(joystick, 7);
  Button Start_Button = new JoystickButton(joystick, 8);
  Button Left_Stick_Button = new JoystickButton(joystick, 9);
  Button Right_Stick_Button = new JoystickButton(joystick, 10);

  Button Trigger = new JoystickButton(opjoystick, 1);
  Button Back_Button_Joystick = new JoystickButton(opjoystick, 2);
  Button Left_Button_Joystick = new JoystickButton(opjoystick, 3);
  Button Right_Button_Joystick = new JoystickButton(opjoystick, 4);
  Button Right_Top_Right_Button = new JoystickButton(opjoystick, 5);
  Button Right_Top_Middle_Button = new JoystickButton(opjoystick, 6);
  Button Right_Top_Left_Button = new JoystickButton(opjoystick, 7);
  Button Right_Bottom_Left_Button = new JoystickButton(opjoystick, 8);
  Button Right_Bottom_Middle_Button = new JoystickButton(opjoystick, 9);
  Button Right_Bottom_Right_Buttom = new JoystickButton(opjoystick, 10);
  Button Left_Top_Left_Button = new JoystickButton(opjoystick, 11);
  Button Left_Top_Middle_Button = new JoystickButton(opjoystick, 12);
  Button Left_Top_Right_Button = new JoystickButton(opjoystick, 13);
  Button Left_Bottom_Right_Button = new JoystickButton(opjoystick, 14);
  Button Left_Bottom_Middle_Button = new JoystickButton(opjoystick, 15);
  Button Left_Bottom_Left_Button = new JoystickButton(opjoystick, 16);

  public void setRumbleOp(double rumble){
    opjoystick.setRumble(RumbleType.kLeftRumble, rumble);
    opjoystick.setRumble(RumbleType.kRightRumble, rumble);
  }

  public GenericHID getjoystick(){
    return joystick;
  }
  public GenericHID getopjoystick(){
    return opjoystick;
  }


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    A_Button.whenPressed(new HighGear());
    B_Button.whenPressed(new LowGear());
    Trigger.whenPressed(new TurretReturnHome());

  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand() {
  //   // An ExampleCommand will run in autonomous
  //   return 
  // }
}
