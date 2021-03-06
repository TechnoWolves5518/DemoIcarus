// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;
//import frc.robot.subsystems.ShooterSubsystem;

public class ShooterLow extends CommandBase {
  double port = RobotMap.bottomPort;

  /** Creates a new ShooterHigh. */
  public ShooterLow() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_shooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    boolean forceStop = RobotContainer.OverrideController.getAButton();
    if (forceStop == true) {
      // run shooter at lower power while X is pressed on the driver controller
      RobotContainer.m_shooterSubsystem.setMotors(-1 * port, 1 * port);
      RobotContainer.m_conveyorSubsystem.setMotors(1);
    } else {
      RobotContainer.m_shooterSubsystem.setMotors(0, 0);
      RobotContainer.m_conveyorSubsystem.setMotors(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_shooterSubsystem.setMotors(0, 0);
    RobotContainer.m_conveyorSubsystem.setMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
