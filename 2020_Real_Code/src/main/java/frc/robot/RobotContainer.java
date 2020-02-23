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
import frc.robot.commands.Intake;
import frc.robot.commands.Conveyor.ConveyorXFolder.ConveyorXIn;
import frc.robot.commands.Conveyor.ConveyorXFolder.ConveyorXNothing;
import frc.robot.commands.Conveyor.ConveyorXFolder.ConveyorXOut;
import frc.robot.commands.Conveyor.ConveyorYFolder.ConveyorYIn;
import frc.robot.commands.Conveyor.ConveyorYFolder.ConveyorYNothing;
import frc.robot.commands.Conveyor.ConveyorYFolder.ConveyorYOut;
import frc.robot.commands.Drive.DriveTrain;
import frc.robot.commands.Drive.HighGear;
import frc.robot.commands.Drive.LowGear;
import frc.robot.commands.Drive.PneumaticsDoNothing;
import frc.robot.commands.Shooter.FlyWheelOff;
import frc.robot.commands.Shooter.FlyWheelOn;
import frc.robot.commands.Shooter.HoodDown;
// import frc.robot.commands.Shooter.HoodStop;
import frc.robot.commands.Shooter.HoodUp;
import frc.robot.commands.Shooter.ShootCenter;
import frc.robot.commands.Shooter.ShootLeft;
import frc.robot.commands.Shooter.ShootRight;
import frc.robot.commands.Shooter.ShooterReset;
import frc.robot.commands.Shooter.TurretReturnHome;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.Climb.ArmSubsystem;
import frc.robot.subsystems.Climb.ClimbAdjustSubsystem;
import frc.robot.subsystems.Climb.WinchSubsystem;
import frc.robot.subsystems.Conveyor.ConveyorXSubsystem;
import frc.robot.subsystems.Conveyor.ConveyorYSubsystem;
import frc.robot.subsystems.Drive.DriveSubsystem;
import frc.robot.subsystems.Drive.PneumaticsSubsystem;
import frc.robot.subsystems.Shooter.FlyWheelSubsystem;
import frc.robot.subsystems.Shooter.TurretEncoderReset;
import frc.robot.subsystems.Shooter.TurretSubsystem;
// import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  public static ArmSubsystem armSubsystem = new ArmSubsystem();
  public static ClimbAdjustSubsystem climbAdjustSubsystem = new ClimbAdjustSubsystem();
  public static WinchSubsystem winchSubsystem = new WinchSubsystem();

  private final ConveyorYSubsystem conveyorYSubsystem = new ConveyorYSubsystem();
  private final ConveyorXSubsystem conveyorXSubsystem = new ConveyorXSubsystem();

  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final PneumaticsSubsystem pneumaticsSubsystem = new PneumaticsSubsystem();

  private final FlyWheelSubsystem flyWheelSubsystem = new FlyWheelSubsystem();
  private final TurretSubsystem turretSubsystem = new TurretSubsystem();

  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

  GenericHID joystick = new XboxController(Constants.DRIVE_CONTROLLER);

  GenericHID opjoystick = new Joystick(Constants.OPERATOR_CONTROLLER);

  GenericHID testing = new XboxController(Constants.TEST_CONTROLLER);

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

  Button A_button = new JoystickButton(testing, 1);
  Button B_button = new JoystickButton(testing, 2);
  Button X_button = new JoystickButton(testing, 3);
  Button Y_button = new JoystickButton(testing, 4);
  Button LB_button = new JoystickButton(testing, 5);
  Button RB_button = new JoystickButton(testing, 6);
  Button Select_button = new JoystickButton(testing, 7);
  Button Start_button = new JoystickButton(testing, 8);
  Button Left_Stick_button = new JoystickButton(testing, 9);
  Button Right_Stick_button = new JoystickButton(testing, 10);

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

  public void setRumbleOp(double rumble) {
    opjoystick.setRumble(RumbleType.kLeftRumble, rumble);
    opjoystick.setRumble(RumbleType.kRightRumble, rumble);
  }

  public GenericHID getjoystick() {
    return joystick;
  }

  public GenericHID getopjoystick() {
    return opjoystick;
  }

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    driveSubsystem
        .setDefaultCommand(new DriveTrain(driveSubsystem, () -> joystick.getRawAxis(Constants.DRIVE_RIGHT_TRIGGER),
            () -> joystick.getRawAxis(Constants.DRIVE_LEFT_TRIGGER),
            () -> joystick.getRawAxis(Constants.DRIVE_LEFT_X_AXIS)));
    conveyorXSubsystem.setDefaultCommand(new ConveyorXNothing(conveyorXSubsystem));
    conveyorYSubsystem.setDefaultCommand(new ConveyorYNothing(conveyorYSubsystem));
    flyWheelSubsystem.setDefaultCommand(new FlyWheelOff(flyWheelSubsystem));
    pneumaticsSubsystem.setDefaultCommand(new PneumaticsDoNothing(pneumaticsSubsystem));
    intakeSubsystem
        .setDefaultCommand(new Intake(intakeSubsystem, () -> opjoystick.getRawAxis(Constants.OPERATOR_Y_AXIS)));
    turretSubsystem.setDefaultCommand(new ShooterReset(turretSubsystem, flyWheelSubsystem));
    flyWheelSubsystem.setDefaultCommand(new ShooterReset(turretSubsystem, flyWheelSubsystem));

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    A_Button.whenPressed(new HighGear(pneumaticsSubsystem));
    B_Button.whenPressed(new LowGear(pneumaticsSubsystem));
    X_button.toggleWhenPressed(new FlyWheelOn(flyWheelSubsystem));
    LB_button.whileHeld(new HoodUp(turretSubsystem));
    RB_button.whileHeld(new HoodDown(turretSubsystem));
    A_button.whileHeld(new TurretEncoderReset(turretSubsystem));
    Trigger.whenPressed(new TurretReturnHome(turretSubsystem));
    Left_Button_Joystick.whileHeld(new ShootLeft(turretSubsystem, flyWheelSubsystem));
    Back_Button_Joystick.whileHeld(new ShootCenter(turretSubsystem, flyWheelSubsystem));
    Right_Button_Joystick.whileHeld(new ShootRight(turretSubsystem, flyWheelSubsystem));
    Left_Top_Right_Button.whileHeld(new ConveyorYOut(conveyorYSubsystem));
    Left_Bottom_Right_Button.whileHeld(new ConveyorYIn(conveyorYSubsystem));
    Left_Top_Middle_Button.whileHeld(new ConveyorXOut(conveyorXSubsystem));
    Left_Bottom_Middle_Button.whileHeld(new ConveyorXIn(conveyorXSubsystem));


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
