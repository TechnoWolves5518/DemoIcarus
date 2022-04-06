// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.RobotMap;

public class DriveTrainSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  // define motors
  TalonSRX leftMotorLeader;
  TalonSRX leftMotorFollower;
  TalonSRX rightMotorLeader;
  TalonSRX rightMotorFollower;

  public DriveTrainSubsystem() {
    System.out.println("subsystem enabled");
    // left side motors
    leftMotorLeader = new TalonSRX(RobotMap.leftMotorLeader);
    leftMotorFollower = new TalonSRX(RobotMap.leftMotorFollower);
    // right side motors
    rightMotorFollower = new TalonSRX(RobotMap.leftMotorFollower);
    rightMotorLeader = new TalonSRX(RobotMap.leftMotorLeader);
  }

  public void setMotors(double left, double right) {
    // left motors
    leftMotorLeader.set(RobotMap.controlMode, left);
    leftMotorFollower.set(RobotMap.controlMode, left);
    // right motors
    rightMotorFollower.set(RobotMap.controlMode, right);
    rightMotorLeader.set(RobotMap.controlMode, right);
    System.out.println("subsystem running");
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
