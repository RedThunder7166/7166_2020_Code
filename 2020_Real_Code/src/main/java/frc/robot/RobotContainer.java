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
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.commands.Climbing.ElevatorUp;
import frc.robot.commands.Climbing.ElevatorDoNothing;
import frc.robot.commands.Climbing.ElevatorDown;
import frc.robot.Constants.OIConstants;
import frc.robot.commands.Autononmous.Groups.AutoLine;
// import frc.robot.commands.Autononmous.Groups.EightBallAuton;
// import frc.robot.commands.Autononmous.Groups.FiveBallAuton;
import frc.robot.commands.Conveyor.Intake;
import frc.robot.commands.Conveyor.IntakeConveyorIn;
import frc.robot.commands.Conveyor.IntakeConveyorOut;
import frc.robot.commands.Conveyor.PneumaticIntakeDown;
import frc.robot.commands.Conveyor.PneumaticIntakeNothing;
import frc.robot.commands.Conveyor.ConveyorXFolder.ConveyorXIn;
import frc.robot.commands.Conveyor.ConveyorXFolder.ConveyorXOut;
import frc.robot.commands.Conveyor.ConveyorYFolder.ConveyorYIn;
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
// import frc.robot.commands.Shooter.ShootCenter;
import frc.robot.commands.Shooter.ShootCenterTele;
// import frc.robot.commands.Shooter.ShootLeft;
import frc.robot.commands.Shooter.ShootLeftTele;
// import frc.robot.commands.Shooter.ShootRight;
import frc.robot.commands.Shooter.ShootRightTele;
// import frc.robot.commands.Shooter.ShooterBackFeed;
import frc.robot.commands.Shooter.ShooterReset;
// import frc.robot.commands.Shooter.TurretEncoderReset;
// import frc.robot.commands.Shooter.TurretReturnHome;
// import frc.robot.subsystems.Climb.ClimbAdjustSubsystem;
import frc.robot.subsystems.Climb.ElevatorSubsystem;
import frc.robot.subsystems.Conveyor.ConveyorSubsystem;
import frc.robot.subsystems.Conveyor.PneumaticIntakeSubsystem;
import frc.robot.subsystems.Drive.DriveSubsystem;
import frc.robot.subsystems.Drive.PneumaticsSubsystem;
import frc.robot.subsystems.Shooter.FlyWheelSubsystem;
import frc.robot.subsystems.Shooter.TurretSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
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

  // SUBSYSTEMS

  // private final ClimbAdjustSubsystem climbAdjustSubsystem = new ClimbAdjustSubsystem();
  private final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
  

  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final PneumaticsSubsystem pneumaticsSubsystem = new PneumaticsSubsystem();

  private final FlyWheelSubsystem flyWheelSubsystem = new FlyWheelSubsystem();
  private final TurretSubsystem turretSubsystem = new TurretSubsystem();

  private final ConveyorSubsystem conveyorSubsystem = new ConveyorSubsystem();
  private final PneumaticIntakeSubsystem pneumaticIntakeSubsystem = new PneumaticIntakeSubsystem();


  // AUTONOMOUS COMMANDS
  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  
  //  private final Command simpleMove =  new 
  
  // private final AutoLine autoLine = new AutoLine(driveSubsystem, turretSubsystem, conveyorSubsystem, flyWheelSubsystem);
  // private final FiveBallAuton fiveBallAuton = new FiveBallAuton(driveSubsystem, turretSubsystem, conveyorSubsystem, flyWheelSubsystem);
  // private final EightBallAuton eightBallAuton = new EightBallAuton(driveSubsystem, turretSubsystem, conveyorSubsystem, flyWheelSubsystem);



  GenericHID joystick = new XboxController(OIConstants.DRIVE_CONTROLLER);

  GenericHID opjoystick = new Joystick(OIConstants.OPERATOR_CONTROLLER);

  GenericHID testing = new XboxController(OIConstants.TEST_CONTROLLER);

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

    driveSubsystem.setDefaultCommand(new DriveTrain(driveSubsystem, () -> joystick.getRawAxis(OIConstants.DRIVE_RIGHT_TRIGGER),
                                                          () -> joystick.getRawAxis(OIConstants.DRIVE_LEFT_TRIGGER),
                                                          () -> joystick.getRawAxis(OIConstants.DRIVE_LEFT_X_AXIS)));
    conveyorSubsystem.setDefaultCommand(new Intake(conveyorSubsystem, () -> opjoystick.getRawAxis(OIConstants.OPERATOR_Y_AXIS)));
    flyWheelSubsystem.setDefaultCommand(new FlyWheelOff(flyWheelSubsystem));
    elevatorSubsystem.setDefaultCommand(new ElevatorDoNothing(elevatorSubsystem));
    pneumaticsSubsystem.setDefaultCommand(new PneumaticsDoNothing(pneumaticsSubsystem));
    turretSubsystem.setDefaultCommand(new ShooterReset(turretSubsystem, flyWheelSubsystem));
    flyWheelSubsystem.setDefaultCommand(new ShooterReset(turretSubsystem, flyWheelSubsystem));
    pneumaticIntakeSubsystem.setDefaultCommand(new PneumaticIntakeNothing(pneumaticIntakeSubsystem));

    m_chooser.setDefaultOption("Auto Line", new AutoLine(driveSubsystem, turretSubsystem, conveyorSubsystem, flyWheelSubsystem));
    // m_chooser.addOption("Five Ball Auton", new FiveBallAuton(driveSubsystem, turretSubsystem, conveyorSubsystem, flyWheelSubsystem, armSubsystem));
    // m_chooser.addOption("Eight Ball Auton", new EightBallAuton(driveSubsystem, turretSubsystem, conveyorSubsystem, flyWheelSubsystem, armSubsystem));
    Shuffleboard.getTab("Autonomous").add(m_chooser);
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
    // A_button.whileHeld(new TurretEncoderReset(turretSubsystem));
    B_button.whileHeld(new ElevatorDown(elevatorSubsystem));

    // Trigger.whileHeld(new ShooterBackFeed(flyWheelSubsystem, conveyorSubsystem));
    Trigger.toggleWhenPressed(new PneumaticIntakeDown(pneumaticIntakeSubsystem));
    Left_Button_Joystick.whileHeld(new ShootLeftTele(flyWheelSubsystem, turretSubsystem));
    Back_Button_Joystick.whileHeld(new ShootCenterTele(flyWheelSubsystem, turretSubsystem));
    Right_Button_Joystick.whileHeld(new ShootRightTele(flyWheelSubsystem, turretSubsystem));

    Left_Top_Right_Button.whileHeld(new ConveyorYOut(conveyorSubsystem));
    Left_Bottom_Right_Button.whileHeld(new ConveyorYIn(conveyorSubsystem));
    Left_Top_Middle_Button.whileHeld(new ConveyorXOut(conveyorSubsystem));
    Left_Bottom_Middle_Button.whileHeld(new ConveyorXIn(conveyorSubsystem));
    Left_Top_Left_Button.whileHeld(new IntakeConveyorOut(conveyorSubsystem));
    Left_Bottom_Left_Button.whileHeld(new IntakeConveyorIn(conveyorSubsystem));
    Right_Top_Left_Button.whileHeld(new ElevatorUp(elevatorSubsystem));

    
    


  }




  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autonomousCommand = m_chooser.getSelected();
  }
}
