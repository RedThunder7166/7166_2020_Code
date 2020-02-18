// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package frc.robot.subsystems;

// import com.revrobotics.CANSparkMax;
// import com.revrobotics.CANSparkMax.IdleMode;

// import edu.wpi.first.wpilibj.ADXRS450_Gyro;
// import edu.wpi.first.wpilibj.controller.PIDController;
// import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
// import edu.wpi.first.wpilibj.geometry.Pose2d;
// import edu.wpi.first.wpilibj.geometry.Rotation2d;
// import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
// import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
// import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;
// import edu.wpi.first.wpilibj.util.Units;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.RobotContainer;

// public class AutonomousSubsystem extends SubsystemBase {
//   /**
//    * Creates a new AutonomousSubsystem.
//    */
//   public AutonomousSubsystem() {

//   }

//   public void Brake() {
//     RobotContainer.driveSubsystem.frontLeft.setIdleMode(IdleMode.kBrake);
//     RobotContainer.driveSubsystem.frontRight.setIdleMode(IdleMode.kBrake);
//     RobotContainer.driveSubsystem.backLeft.setIdleMode(IdleMode.kBrake);
//     RobotContainer.driveSubsystem.backRight.setIdleMode(IdleMode.kBrake);
//   }

//   public void setIntake(double speed){
//     RobotContainer.intakeSubsystem.setIntakeSpeed(speed);
//   }

//   public void shootBall(){
//     RobotContainer.turretSubsystem.AdjustTurretXCenter();
//     // ADD SHOOTER CODE HERE

//   }

//   private static final double kGearRatio = 7.95;
//   private static final double kWheelRadiusInches = 3.0;

//   CANSparkMax leftMaster = new CANSparkMax(1, CANSparkMax.MotorType.kBrushless);
//   CANSparkMax rightMaster = new CANSparkMax(3, CANSparkMax.MotorType.kBrushless);

//   CANSparkMax leftSlave = new CANSparkMax(2, CANSparkMax.MotorType.kBrushless);
//   CANSparkMax rightSlave = new CANSparkMax(4, CANSparkMax.MotorType.kBrushless);

//   ADXRS450_Gyro gyro = RobotContainer.gyroSubsystem.drive_Gyro;

//   DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(Units.inchesToMeters(28));
//   DifferentialDriveOdometry odometry = new DifferentialDriveOdometry(getHeading(), getPose());

//   SimpleMotorFeedforward feedforward = new SimpleMotorFeedforward(0.3, 1.96, 0.06); //TODO: Find the FeedForward values

//   PIDController leftPIDController = new PIDController(2.95, 0, 0); //TODO: Find the PID values
//   PIDController rightPIDController = new PIDController(2.95, 0, 0);

//   Pose2d pose = new Pose2d();

//   public void Drivetrain() {
//     leftSlave.follow(leftMaster);
//     rightSlave.follow(rightMaster);

//     leftMaster.setInverted(false);
//     rightMaster.setInverted(true);

//     gyro.reset();
//   }

//   public Rotation2d getHeading() {
//     return Rotation2d.fromDegrees(-gyro.getAngle());
//   }

//   public DifferentialDriveWheelSpeeds getSpeeds() {
//     return new DifferentialDriveWheelSpeeds(
//         leftMaster.getEncoder().getVelocity() / kGearRatio * 2 * Math.PI * Units.inchesToMeters(kWheelRadiusInches) / 60,
//         rightMaster.getEncoder().getVelocity() / kGearRatio * 2 * Math.PI * Units.inchesToMeters(kWheelRadiusInches) / 60
//     );
//   }

//   public DifferentialDriveKinematics getKinematics() {
//     return kinematics;
//   }

//   public Pose2d getPose() {
//     return pose;
//   }

//   public SimpleMotorFeedforward getFeedforward() {
//     return feedforward;
//   }

//   public PIDController getLeftPIDController() {
//     return leftPIDController;
//   }

//   public PIDController getRightPIDController() {
//     return rightPIDController;
//   }

//   public void setOutputVolts(double leftVolts, double rightVolts) {
//     leftMaster.set(leftVolts / 12); //TODO: Find the Voltage values
//     rightMaster.set(rightVolts / 12);
//   }

//   public void reset() {
//     odometry.resetPosition(new Pose2d(), getHeading());
//   }


//   @Override
//   public void periodic() {
//     // This method will be called once per scheduler run
//   }
// }
