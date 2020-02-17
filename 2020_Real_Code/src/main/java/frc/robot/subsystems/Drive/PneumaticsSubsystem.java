/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticsSubsystem extends SubsystemBase {
  /**
   * Creates a new PneumaticsSubsystem.
   */
  public PneumaticsSubsystem() {

  }

  public Solenoid Sol = new Solenoid(0, 0);


  public void invertSolStatus(){

    if(Sol.get() == true){
      Sol.set(false);
    }else if(Sol.get() == false){
      Sol.set(true);
    }else{}

  }

  public void highGear(){
    Sol.set(false);
  }

  public void lowGear(){
    Sol.set(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
