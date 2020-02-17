/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.Climb;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimbAdjustSubsystem extends SubsystemBase {
  /**
   * Creates a new ClimbAdjustSubsystem.
   */
  public ClimbAdjustSubsystem() {

  }

  public CANSparkMax climbAdjustMotor = new CANSparkMax(Constants.CLIMB_ADJUST_CAN, MotorType.kBrushless);
  public CANEncoder climbEncoder = new CANEncoder(climbAdjustMotor);
  public ColorSensorV3 colorSensor = new ColorSensorV3(I2C.Port.kOnboard);
  public ColorMatch colorMatcher = new ColorMatch();
  public Color blueColor = ColorMatch.makeColor(0, 255, 255);
  public Color redColor = ColorMatch.makeColor(255, 0, 0);
  public Color yellowColor = ColorMatch.makeColor(255, 255, 0);
  public Color greenColor = ColorMatch.makeColor(0, 255, 0);
  public String gameData = DriverStation.getInstance().getGameSpecificMessage();
  
  
  // Red, Green, Blue, Yellow repeat
  public void addColors(){
    colorMatcher.addColorMatch(blueColor);
    colorMatcher.addColorMatch(yellowColor);
    colorMatcher.addColorMatch(redColor);
    colorMatcher.addColorMatch(greenColor);
  }

  public Color findColor(){
    Color detectedColor = colorSensor.getColor();
    return detectedColor;
  }

  public void setMotor(double speed){
    climbAdjustMotor.set(speed);
  }

  public void controlPanelSpin(){

    double targetValueinches = 0.0; //how many inches the wheels have to move to spin the wheel 3.5 rotations.

    climbEncoder.setPositionConversionFactor(1); // the conversion to have the wheel move one inch at a time.

    while(climbEncoder.getPosition() <= targetValueinches){

      climbAdjustMotor.set(.30);

    }

    climbAdjustMotor.setIdleMode(IdleMode.kBrake);

  }

  public void sendableData(){
    String colorString;
    ColorMatchResult match = colorMatcher.matchClosestColor(findColor());

    if(match.color == blueColor){
      colorString = "Blue";
    }else if(match.color == redColor){
      colorString = "Red";
    }else if(match.color == greenColor){
      colorString = "Green";
    }else if(match.color == yellowColor){
      colorString = "Yellow";
    }else{
      colorString = "Unknown";
    }

    SmartDashboard.putNumber("Red", findColor().red);
    SmartDashboard.putNumber("Green", findColor().green);
    SmartDashboard.putNumber("Blue", findColor().blue);
    SmartDashboard.putNumber("Confidence", match.confidence);
    SmartDashboard.putString("Detected Color", colorString);


  }



  public void controlPanelColor(){

    if(gameData.length() > 0 ){
      switch(gameData.charAt(0)){
        case 'B' : 
        do{
          climbAdjustMotor.set(0.30);
        }while(findColor() != redColor);
        break;
        case 'R' : 
        do{
          climbAdjustMotor.set(0.30);
        }while(findColor() != blueColor);
        break;
        case 'Y' : 
        do{
          climbAdjustMotor.set(0.30);
        }while(findColor() != greenColor);
        break;
        case 'G' :
        do{
          climbAdjustMotor.set(0.30);
        }while(findColor() != yellowColor);
        break;
        default:

        break;
      }
    }else{

    }
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
